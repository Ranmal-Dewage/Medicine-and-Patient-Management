/**
 * 
 */
package sa.assignment1.medicineModel;

/**
 * @author it16169036
 *
 */
public class MedicineModel {
	private int id;
	private String name;
	private int quantity;

	/**
	 * 
	 */
	public MedicineModel() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param quantity
	 */
	public MedicineModel(int id, String name, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
