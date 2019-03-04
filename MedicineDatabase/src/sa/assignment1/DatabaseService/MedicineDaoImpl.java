package sa.assignment1.DatabaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sa.assignment1.medicineModel.MedicineModel;

public class MedicineDaoImpl implements MedicineDao {
	List<MedicineModel> medicineList = new ArrayList<>();
	Session session = null;

	@Override
	public boolean save(MedicineModel model) {
		try {
			session.save(model);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deduct(int id, int quantity) {
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

	@Override
	public MedicineModel get(int id) {
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

	private static Session config() {

		try {
			Configuration config = new Configuration();
			config.configure();
			config.addAnnotatedClass(MedicineModel.class);
			config.addResource("hibernate.cfg.xml"); //medicine.hbm.xml

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();
			SessionFactory factory = config.buildSessionFactory(serviceRegistry);
			return factory.openSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
