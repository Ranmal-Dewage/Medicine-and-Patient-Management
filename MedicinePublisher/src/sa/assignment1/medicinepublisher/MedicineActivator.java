package sa.assignment1.medicinepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class MedicineActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistration;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Medicine Publisher Started !!!");
		MedicinePublish publisherService = new MedicinePublishImpl();
		publishServiceRegistration = context.registerService(MedicinePublish.class.getName(), publisherService, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Medicine Publisher Stoped !!!");
		publishServiceRegistration.unregister();
	}

}
