package sa.assignment1.medicinepublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import sa.assignment1.DatabaseService.MedicineDao;

public class MedicinePublishImpl implements MedicinePublish {

	MedicineDao medicineDao = null;
	HashMap<String, String> medicineModel = new HashMap<>();

	public MedicinePublishImpl(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}

	@Override
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter medicine id: ");
		medicineModel.put("medicineId", scanner.nextLine());
		System.out.println("Enter medicine name: ");
		medicineModel.put("medicineName", scanner.nextLine());
		System.out.println("Enter medicine quantity: ");
		medicineModel.put("medicineQuantity", Integer.toString(scanner.nextInt()));
		System.out.println("Enter medicine unit price: ");
		medicineModel.put("unitPrice", Double.toString(scanner.nextDouble()));
		System.out.println("");
		medicineDao.save(medicineModel);
	}

	@Override
	public void deduct() {
		Map<String, String> data = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int currentQuantity = 0;
		int newQuantity = 0;

		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();
		System.out.println("Enter medicine quantity to reduce: ");
		int quantity = scanner.nextInt();

		data = medicineDao.findById(id);

		if (Objects.nonNull(data)) {
			currentQuantity = Integer.parseInt(data.get("medicineQuantity"));
			if (currentQuantity >= quantity) {
				newQuantity = currentQuantity - quantity;
			}
			data.put("medicineQuantity", Integer.toString(newQuantity));

			if (medicineDao.save(data)) {
				System.out.println("New deduced sucessfully !");
				System.out.println("");
			}
		} else {
			System.out.println("No medicine record found !!!");
			System.out.println("");
		}

	}

	@Override
	public void get() {
		System.out.println("Enter medicine id: ");
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = medicineDao.findById(id);

		if (Objects.nonNull(data)) {
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
		} else {
			System.out.println("No medicine record found !!!");
			System.out.println("");
		}
	}

	@Override
	public void deleteById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();

		if (medicineDao.deleteById(id)) {
			System.out.println("Medicine id:" + id + " removed sucessfully !");
			System.out.println("");
		} else {
			System.out.println("Medicine id:" + id + " not found !");
			System.out.println("");
		}
	}

	@Override
	public void increase() {
		Scanner scanner = new Scanner(System.in);
		Map<String, String> data = new HashMap<>();
		int currentQuantity = 0;
		int newQuantity = 0;

		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();
		System.out.println("Enter medicine quantity to increase: ");
		int quantity = scanner.nextInt();

		data = medicineDao.findById(id);

		if (medicineDao.deleteById(id)) {
			currentQuantity = Integer.parseInt(data.get("medicineQuantity"));
			newQuantity = currentQuantity + quantity;
			data.put("medicineQuantity", Integer.toString(newQuantity));

			if (medicineDao.save(data)) {
				System.out.println("New increased sucessfully !");
				System.out.println("");
			}
		} else {
			System.out.println("Medicine id:" + id + " not found !");
			System.out.println("");
		}
	}
}
