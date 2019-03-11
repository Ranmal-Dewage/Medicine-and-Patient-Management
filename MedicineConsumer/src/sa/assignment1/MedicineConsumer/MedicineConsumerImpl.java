package sa.assignment1.medicineconsumer;

import java.util.Scanner;

import sa.assignment1.medicinepublisher.MedicinePublish;

public class MedicineConsumerImpl implements MedicineConsumer {

	MedicinePublish medicinePublish;

	public MedicineConsumerImpl(MedicinePublish medicinePublish) {
		this.medicinePublish = medicinePublish;
		init();
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

	private void init() {
		
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("--------------Welcome--------------");
			System.out.println("What do you need to do?");
			System.out.println("  1 - Add new medicine");
			System.out.println("  2 - Display medicine");
			System.out.println("  3 - Withdraw medicine quantity");
			System.out.println("  4 - Add medicine quantity");
			System.out.println("  5 - Delete an existing medicine");
			System.out.println("  6 - Exit");
			
			while (true) {				
				System.out.println("Please enter a number : ");

				int input = in.nextInt();

				switch (input) {
				case 1:
					add();
					continue;
				case 2:
					get();
					continue;
				case 3:
					deduct();
					continue;
				case 4:
					increase();
					continue;
				case 5:
					deleteById();
					continue;
				case 6:
					break;
				default:
					System.out.println("Invalid input!!!");
					continue;
				}

			}
		} catch (Exception e) {
			System.out.println("Error in MedicineConsumer : " + e);
		}

	}

}
