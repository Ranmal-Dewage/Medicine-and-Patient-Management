package sa.assignment1.medicineconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import sa.assignment1.medicinepublisher.MedicinePublish;
import sa.assignment1.patientpublisher.PatientPublish;

public class ConsumerActivator implements BundleActivator {

	ServiceReference<?> medicineServiceReference;
	ServiceReference<?> patientServiceReference;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Medicine Consumer Started !!!");
		
		medicineServiceReference = context.getServiceReference(MedicinePublish.class.getName());
		MedicinePublish medicinePublish = (MedicinePublish) context.getService(medicineServiceReference);
		
		patientServiceReference = context.getServiceReference(PatientPublish.class.getName());
		PatientPublish patientPublish = (PatientPublish) context.getService(patientServiceReference);
		
		MedicineConsumer medicineConsumer = new MedicineConsumerImpl(medicinePublish, patientPublish);
		medicineConsumer.init();
		stop(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!");
		context.ungetService(medicineServiceReference);
		context.ungetService(patientServiceReference);
	}

}
