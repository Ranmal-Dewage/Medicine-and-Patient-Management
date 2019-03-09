/**
 * 
 */
package sa.assignment1.DatabaseService;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

/**
 * @author vimukthi_r
 * @Date Mar 7, 2019
 * @Description
 * @Version
 */
public interface MedicineDao {

	public MongoClient getMongoClient();

	public MongoCollection<Document> getMongoCollection();

	public boolean save(HashMap<String, String> data);

	public boolean update(String medicineId, HashMap<String, String> data);

	public Document findById(String medicineId);

	public boolean deleteById(String medicineId);
}
