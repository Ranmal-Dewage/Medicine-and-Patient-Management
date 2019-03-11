package sa.assignment1.medicinepublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import sa.assignment1.DatabaseService.MedicineDao;

public class MedicinePublishImpl implements MedicinePublish {

	MedicineDao medicineDao = null;
	Scanner scanner = new Scanner(System.in);
	HashMap<String, String> medicineModel = new HashMap<>();

	public MedicinePublishImpl(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}

	@Override
	public void add() {
		try {
			System.out.println("Enter medicine id: ");
			medicineModel.put("medicineId", scanner.nextLine());
			System.out.println("Enter medicine name: ");
			medicineModel.put("medicineName", scanner.nextLine());
			System.out.println("Enter medicine quantity: ");
			medicineModel.put("medicineQuantity", Integer.toString(scanner.nextInt()));
			System.out.println("Enter medicine unit price: ");
			medicineModel.put("unitPrice", Double.toString(scanner.nextDouble()));
		} catch (Exception e) {
			System.out.println("ERROR : Invalid input value !!!");
			add();
		}
		medicineDao.save(medicineModel);
	}

	@Override
	public void deduct() {
		Map<String, String> data = new HashMap<>();
		int currentQuantity = 0;
		int newQuantity = 0;
		
		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();
		System.out.println("Enter medicine quantity to reduce: ");
		int quantity = scanner.nextInt();
		
		try {
			data = medicineDao.findById(id);
			currentQuantity = Integer.parseInt(data.get("medicineQuantity"));
			if (currentQuantity >= quantity) {
				newQuantity = currentQuantity - quantity;
			}
			data.put("medicineQuantity", Integer.toString(newQuantity));
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(medicineDao.save(data)){
			System.out.println("New deduced sucessfully !");
		}
	}

	@Override
	public void get() {
		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();
		try {
			Map<String, String> data = medicineDao.findById(id);
			data.forEach((key, value) -> System.out.println(key + ":" + value));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteById() {
		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();
		
		if (medicineDao.deleteById(id)) {
			System.out.println("Medicine id:" + id + " removed sucessfully !");
		}
	}

	@Override
	public void increase() {
		Map<String, String> data = new HashMap<>();
		int currentQuantity = 0;
		int newQuantity = 0;
		
		System.out.println("Enter medicine id: ");
		String id = scanner.nextLine();
		System.out.println("Enter medicine quantity to increase: ");
		int quantity = scanner.nextInt();
		
		try {
			data = medicineDao.findById(id);
			currentQuantity = Integer.parseInt(data.get("medicineQuantity"));
			newQuantity = currentQuantity + quantity;
			data.put("medicineQuantity", Integer.toString(newQuantity));
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(medicineDao.save(data)){
			System.out.println("New increased sucessfully !");
		}
	}
}
