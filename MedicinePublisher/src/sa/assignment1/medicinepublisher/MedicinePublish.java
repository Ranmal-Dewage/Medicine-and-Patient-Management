package sa.assignment1.medicinepublisher;

import java.util.List;

import sa.assignment1.medicineModel.MedicineModel;

public interface MedicinePublish {

	public String publishService();

	public boolean add(MedicineModel medicineModel);

	public boolean deduct(int id, int quantity);

	public MedicineModel get(int id);

	public List<MedicineModel> getAll();

}
