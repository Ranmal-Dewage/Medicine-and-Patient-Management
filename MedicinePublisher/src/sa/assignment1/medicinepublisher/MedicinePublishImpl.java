package sa.assignment1.medicinepublisher;

import java.util.HashMap;
import java.util.Scanner;

import org.bson.Document;

import sa.assignment1.DatabaseService.MedicineDao;

public class MedicinePublishImpl implements MedicinePublish {

	MedicineDao medicineDao = null;
	Scanner scanner = new Scanner(System.in);
	HashMap<String, String> medicineModel = new HashMap<>();
	
	@Override
	public String publishService() {
		return "Execute the service publish of ServicePublish";
	}

	public MedicinePublishImpl(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}

	@Override
	public boolean add() {
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
		return (medicineDao.save(medicineModel)) ? true : false;
	}

	@Override
	public boolean deduct(int id, int quantity) {
		//return medicineDao.update(medicineId, data)
		return false;
	}

	@Override
	public Document get(int id) {
		return medicineDao.findById(Integer.toString(id));
	}

	@Override
	public boolean deleteById(String id) {
		return medicineDao.deleteById(id);
	}

}
