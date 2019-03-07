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

	public MongoCollection<Document> getMongoCollection(String dbName, String collectionName, MongoClient mongoClient);

	public boolean save(HashMap<String, String> data, MongoCollection<Document> mongoCollection);

	public boolean update(String medicineId, HashMap<String, String> data, MongoCollection<Document> mongoCollection);

	public Document findById(String medicineId, MongoCollection<Document> mongoCollection);

	public boolean deleteById(String medicineId, MongoCollection<Document> mongoCollection);
}
