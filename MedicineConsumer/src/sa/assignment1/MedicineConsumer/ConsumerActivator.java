package sa.assignment1.medicineconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import sa.assignment1.medicinepublisher.MedicinePublish;
import sa.assignment1.medicinepublisher.MedicinePublishImpl;

public class ConsumerActivator implements BundleActivator {

	ServiceReference<?> serviceReference;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Database Subscriber Service");
		serviceReference = context.getServiceReference(MedicinePublish.class.getName());
		MedicinePublish medicinePublish = (MedicinePublish) context.getService(serviceReference);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {

	}

}
