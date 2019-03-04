package sa.assignment1.medicinepublisher;

import java.util.List;

import sa.assignment1.DatabaseService.MedicineDao;
import sa.assignment1.medicineModel.MedicineModel;

public class MedicinePublishImpl implements MedicinePublish {

	@Override
	public String publishService() {
		return "Execute the service publish of ServicePublish";
	}
	
	MedicineDao medicineDao;
	
	public MedicinePublishImpl(MedicineDao medicineDao){
		this.medicineDao = medicineDao;
	}
	
	@Override
	public boolean add(MedicineModel medicineModel) {
		return (medicineDao.save( medicineModel)) ? true : false;
	}

	@Override
	public boolean deduct(int id, int quantity) {
		return medicineDao.deduct(id, quantity);
	}

	@Override
	public MedicineModel get(int id) {
		return medicineDao.get(id);
	}

	@Override
	public List<MedicineModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
