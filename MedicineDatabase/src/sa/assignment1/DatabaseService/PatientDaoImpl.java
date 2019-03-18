/**
 * 
 */
package sa.assignment1.DatabaseService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author vimukthi_r
 * @Date Mar 7, 2019
 * @Description
 * @Version
 */
public class PatientDaoImpl implements PatientDao {

	private static Map<String, Map<String, String>> dataList = new HashMap<>();

	@Override
	public boolean save(Map<String, String> data) {
		String patientId = data.get("patientId");
		try {
			dataList.put(patientId, new HashMap<String, String>(data));
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
	public Map<String, String> findById(String patientId) {
		Map<String, String> data = new HashMap<>();
		try {
			data = dataList.get(patientId);
			if(Objects.isNull(data)){
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return data;
	}

	@Override
	public boolean deleteById(String patientId) {
		try {
			if(Objects.nonNull(dataList.get(patientId))){				
				dataList.remove(patientId);
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
}
