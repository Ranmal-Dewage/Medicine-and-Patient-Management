package sa.assignment1.medicinepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import sa.assignment1.DatabaseService.MedicineDao;
import sa.assignment1.DatabaseService.MedicineDaoImpl;

public class MedicineActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistration;
	
	ServiceReference<?> serviceReference;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(MedicineDao.class.getName());
		MedicineDao medicineDao = (MedicineDaoImpl) context.getService(serviceReference);
		
		System.out.println("Medicine Publisher Started !!!");
		MedicinePublish publisherService = new MedicinePublishImpl(medicineDao);
		publishServiceRegistration = context.registerService(MedicinePublish.class.getName(), publisherService, null);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Medicine Publisher Stopped !!!");
		publishServiceRegistration.unregister();
		context.ungetService(serviceReference);
	}

}
