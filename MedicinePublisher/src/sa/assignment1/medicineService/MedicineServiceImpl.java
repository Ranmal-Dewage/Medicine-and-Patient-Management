/**
 * 
 */
package sa.assignment1.medicineService;

import java.util.List;

import org.hibernate.Session;

import sa.assignment1.medicineDao.MedicineDao;
import sa.assignment1.medicineModel.MedicineModel;

/**
 * @author it16169036
 *
 */
public class MedicineServiceImpl implements MedicineService {

	MedicineDao medicineDao = new MedicineDao();
	Session session = medicineDao.config();

	@Override
	public boolean add(MedicineModel medicineModel) {
		return (medicineDao.save(session, medicineModel)) ? true : false;
	}

	@Override
	public boolean deduct(int id, int quantity) {
		return medicineDao.deduct(session, id, quantity);
	}

	@Override
	public MedicineModel get(int id) {
		return medicineDao.get(session, id);
	}

	@Override
	public List<MedicineModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
