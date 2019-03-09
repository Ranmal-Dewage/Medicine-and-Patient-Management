package sa.assignment1.medicinepublisher;

import org.bson.Document;

public interface MedicinePublish {

	public String publishService();

	public boolean add();

	public boolean deduct(int id, int quantity);

	public Document get(int id);

	public boolean deleteById(String id);

}
