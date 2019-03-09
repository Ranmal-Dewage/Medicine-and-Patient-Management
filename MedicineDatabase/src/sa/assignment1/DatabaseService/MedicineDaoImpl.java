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
	public MongoCollection<Document> getMongoCollection() {
		MongoCollection<Document> mongoCollection = null;
		try {
			MongoDatabase database = getMongoClient().getDatabase("Pharmacy");
			mongoCollection = database.getCollection("Medicine");
			mongoCollection.createIndex(Indexes.ascending(MEDICINEID));
		} catch (Exception e) {
			System.err.println(e);
		}
		return mongoCollection;
	}

	@Override
	public boolean save(HashMap<String, String> data) {
		try {
			// create new document
			Document newDocument = new Document();
			// insert new data into the document
			data.forEach(newDocument::append);
			// insert into collection
			getMongoCollection().insertOne(newDocument);

			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public boolean update(String medicineId, HashMap<String, String> data) {
		try {
			Document setData = new Document();
			data.forEach(setData::append);
			// To update single Document
			getMongoCollection().updateOne(Filters.eq(MEDICINEID, medicineId), new Document("$set", setData));

			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public Document findById(String medicineId) {
		Document doc = null;
		try {
			doc = getMongoCollection().find(Filters.eq(MEDICINEID, medicineId)).first();
		} catch (Exception e) {
			System.err.println(e);
		}
		return doc;
	}

	@Override
	public boolean deleteById(String medicineId) {
		try {
			getMongoCollection().deleteOne(Filters.eq(MEDICINEID, medicineId));
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
}
