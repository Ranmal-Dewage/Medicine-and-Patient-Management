package sa.assignment1.patientpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import sa.assignment1.DatabaseService.PatientDao;
import sa.assignment1.DatabaseService.PatientDaoImpl;

public class PatientActivator implements BundleActivator {
	ServiceRegistration<?> publishServiceRegistration;

	ServiceReference<?> serviceReference;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		serviceReference = context.getServiceReference(PatientDao.class.getName());
		PatientDao patientDao = (PatientDaoImpl) context.getService(serviceReference);

		System.out.println("Patient Publisher Started !!!");
		PatientPublish publisherService = new PatientPublishImpl(patientDao);
		publishServiceRegistration = context.registerService(PatientPublish.class.getName(), publisherService, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Patient Publisher Stoped !!!");
		publishServiceRegistration.unregister();
		context.ungetService(serviceReference);
	}

}
