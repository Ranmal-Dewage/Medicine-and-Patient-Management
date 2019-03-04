/**
 * 
 */
package sa.assignment1.medicineService;

import java.util.List;

import sa.assignment1.medicineModel.MedicineModel;

/**
 * @author it16169036
 *
 */
public interface MedicineService {
	public boolean add(MedicineModel medicineModel);

	public boolean deduct(int id, int quantity);

	public MedicineModel get(int id);

	public List<MedicineModel> getAll();
}
