/**
 * 
 */
package sa.assignment1.DatabaseService;

import java.util.HashMap;
import java.util.Objects;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;

/**
 * @author vimukthi_r
 * @Date Mar 7, 2019
 * @Description
 * @Version
 */
public class MedicineDaoImpl implements MedicineDao {

	private static MongoClient mongoClient = null;
	private static final String MEDICINEID = "medicineId";

	@Override
	public synchronized MongoClient getMongoClient() {
		if (Objects.nonNull(mongoClient)) {
			mongoClient = new MongoClient("localhost", 27017);
		}
		return mongoClient;
	}

	@Override
	public MongoCollection<Document> getMongoCollection(String dbName, String collectionName, MongoClient mongoClient) {
		MongoCollection<Document> mongoCollection = null;
		try {
			MongoDatabase database = mongoClient.getDatabase(dbName);
			mongoCollection = database.getCollection(collectionName);
			mongoCollection.createIndex(Indexes.ascending(MEDICINEID));
		} catch (Exception e) {
			System.err.println(e);
		}
		return mongoCollection;
	}

	@Override
	public boolean save(HashMap<String, String> data, MongoCollection<Document> mongoCollection) {
		try {
			// create new document
			Document newDocument = new Document();
			// insert new data into the document
			data.forEach(newDocument::append);
			// insert into collection
			mongoCollection.insertOne(newDocument);

			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public boolean update(String medicineId, HashMap<String, String> data, MongoCollection<Document> mongoCollection) {
		try {
			Document setData = new Document();
			data.forEach(setData::append);
			// To update single Document
			mongoCollection.updateOne(Filters.eq(MEDICINEID, medicineId), new Document("$set", setData));

			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public Document findById(String medicineId, MongoCollection<Document> mongoCollection) {
		Document doc = null;
		try {
			doc = mongoCollection.find(Filters.eq(MEDICINEID, medicineId)).first();
		} catch (Exception e) {
			System.err.println(e);
		}
		return doc;
	}

	@Override
	public boolean deleteById(String medicineId, MongoCollection<Document> mongoCollection) {
		try {
			mongoCollection.deleteOne(Filters.eq(MEDICINEID, medicineId));
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
}
