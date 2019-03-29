/**
 * 
 */
package sa.assignment1.DatabaseService;

import java.util.HashMap;
import java.util.Map;

public interface PatientDao {

	public boolean save(Map<String, String> data);

	public boolean update(String medicineId, HashMap<String, String> data);

	public Map<String, String> findById(String medicineId);

	public boolean deleteById(String medicineId);
}
