package sa.assignment1.patientpublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import sa.assignment1.DatabaseService.PatientDao;

public class PatientPublishImpl implements PatientPublish {

	PatientDao patientDao = null;
	HashMap<String, String> patientModel = new HashMap<>();

	public PatientPublishImpl(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@Override
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter patient id: ");
		patientModel.put("patientId", scanner.nextLine());
		System.out.println("Enter patient name: ");
		patientModel.put("patientName", scanner.nextLine());
		System.out.println("Enter patient age: ");
		patientModel.put("patientAge", scanner.nextLine());
		System.out.println("Enter patient illness: ");
		patientModel.put("patientIllness", scanner.nextLine());
		System.out.println("");
		patientDao.save(patientModel);
	}

	@Override
	public void get() {
		System.out.println("Enter patient id: ");
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = patientDao.findById(id);

		if (Objects.nonNull(data)) {
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
		} else {
			System.out.println("No patient record found !!!");
			System.out.println("");
		}
	}

	@Override
	public void deleteById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter patient id: ");
		String id = scanner.nextLine();

		if (patientDao.deleteById(id)) {
			System.out.println("Patient id:" + id + " removed sucessfully !");
			System.out.println("");
		} else {
			System.out.println("Patient id:" + id + " not found !");
			System.out.println("");
		}
	}

}
