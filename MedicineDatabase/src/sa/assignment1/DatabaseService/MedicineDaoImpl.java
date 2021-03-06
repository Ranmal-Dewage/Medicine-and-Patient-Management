/**
 * 
 */
package sa.assignment1.DatabaseService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MedicineDaoImpl implements MedicineDao {

	private static Map<String, Map<String, String>> dataList = new HashMap<>();

	@Override
	public boolean save(Map<String, String> data) {
		String medicineId = data.get("medicineId");
		try {
			dataList.put(medicineId, new HashMap<String, String>(data));
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public boolean update(String medicineId, HashMap<String, String> data) {
		return save(data);
	}

	@Override
	public Map<String, String> findById(String medicineId) {
		Map<String, String> data = new HashMap<>();
		try {
			data = dataList.get(medicineId);
			if(Objects.isNull(data)){
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return data;
	}

	@Override
	public boolean deleteById(String medicineId) {
		try {
			if(Objects.nonNull(dataList.get(medicineId))){				
				dataList.remove(medicineId);
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
}
