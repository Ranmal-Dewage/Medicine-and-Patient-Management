package sa.assignment1.medicineconsumer;

import java.util.Scanner;

import sa.assignment1.medicinepublisher.MedicinePublish;

public class MedicineConsumerImpl implements MedicineConsumer {

	MedicinePublish medicinePublish;

	public MedicineConsumerImpl(MedicinePublish medicinePublish) {
		this.medicinePublish = medicinePublish;
	}

	@Override
	public void init() {

		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("--------------Welcome--------------");
		System.out.println("What do you need to do?");
		System.out.println("  1 - Add new medicine");
		System.out.println("  2 - Display medicine");
		System.out.println("  3 - Withdraw medicine quantity");
		System.out.println("  4 - Add medicine quantity");
		System.out.println("  5 - Delete an existing medicine");
		System.out.println("  6 - Exit");
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
}
