/**
 * 
 */
package sa.assignment1.medicineDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sa.assignment1.medicineModel.MedicineModel;

/**
 * @author it16169036
 *
 */
public class MedicineDao {
	List<MedicineModel> medicineList = new ArrayList<>();

	public boolean save(Session session, MedicineModel model) {
		try {
			session.save(model);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean deduct(Session session, int id, int quantity) {
		MedicineModel medicineModel = null;
		try {
			medicineModel = session.get(MedicineModel.class, id);
			if (Objects.nonNull(medicineModel) && medicineModel.getQuantity() >= quantity) {
				medicineModel.setQuantity(medicineModel.getQuantity() - quantity);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public MedicineModel get(Session session, int id) {
		MedicineModel medicineModel = null;
		try {
			medicineModel = session.get(MedicineModel.class, id);
			if (Objects.nonNull(medicineModel)) {
				return medicineModel;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Session config() {
		Session session = null;
		try {
			Configuration config = new Configuration();
			config.configure();
			config.addAnnotatedClass(MedicineModel.class);
			config.addResource("medicine.hbm.xml");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();
			SessionFactory factory = config.buildSessionFactory(serviceRegistry);
			session = factory.openSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return session;
	}
}
