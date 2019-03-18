package sa.assignment1.medicineconsumer;

import java.util.Scanner;

import sa.assignment1.medicinepublisher.MedicinePublish;
import sa.assignment1.patientpublisher.PatientPublish;

public class MedicineConsumerImpl implements MedicineConsumer {

	MedicinePublish medicinePublish;
	PatientPublish patientPublish;

	public MedicineConsumerImpl(MedicinePublish medicinePublish, PatientPublish patientPublish) {
		this.medicinePublish = medicinePublish;
		this.patientPublish = patientPublish;
	}

	@Override
	public void init() {

		Scanner in = new Scanner(System.in);
		System.out.println("--------------Welcome--------------");
		welcomePrompt();
		int input = in.nextInt();
		while (input != 3) {

			switch (input) {
			case 1:
				medicine();
				break;
			case 2:
				patient();
				break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			welcomePrompt();
			input = in.nextInt();
		}

	}

	private void welcomePrompt() {
		System.out.println("");
		System.out.println("What do you need to do?");
		System.out.println("  1 - Medicine Management");
		System.out.println("  2 - Patient Management");
		System.out.println("  3 - Exit");
		System.out.println("");
		System.out.print("Please enter a number : ");
	}

	@Override
	public void add() {
		medicinePublish.add();
	}

	@Override
	public void deduct() {
		medicinePublish.deduct();
	}

	@Override
	public void increase() {
		medicinePublish.increase();
	}

	@Override
	public void get() {
		medicinePublish.get();
	}

	@Override
	public void deleteById() {
		medicinePublish.deleteById();
	}

	@Override
	public void medicine() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("--------------Medicine Management--------------");
		System.out.println("What do you need to do?");
		System.out.println("  1 - Add new medicine");
		System.out.println("  2 - Display medicine");
		System.out.println("  3 - Withdraw medicine quantity");
		System.out.println("  4 - Add medicine quantity");
		System.out.println("  5 - Delete an existing medicine");
		System.out.println("  6 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 6) {

			switch (input) {
			case 1:
				add();
				break;
			case 2:
				get();
				break;
			case 3:
				deduct();
				break;
			case 4:
				increase();
				break;
			case 5:
				deleteById();
				break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
	}

	@Override
	public void patient() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("--------------Patient Management--------------");
		System.out.println("What do you need to do?");
		System.out.println("  1 - Add new patient details");
		System.out.println("  2 - Display patient details");
		System.out.println("  3 - Delete an existing patient");
		System.out.println("  4 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 4) {

			switch (input) {
			case 1:
				patientPublish.add();
				break;
			case 2:
				patientPublish.get();
				break;
			case 3:
				patientPublish.deleteById();
				break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
	}

}
