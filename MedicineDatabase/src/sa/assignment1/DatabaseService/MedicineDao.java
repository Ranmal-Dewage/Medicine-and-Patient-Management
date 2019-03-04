/**
 * 
 */
package sa.assignment1.DatabaseService;

import sa.assignment1.medicineModel.MedicineModel;

/**
 * @author it16169036
 *
 */
public interface MedicineDao {

	public boolean save( MedicineModel model);

	public boolean deduct( int id, int quantity);

	public MedicineModel get( int id);
}
