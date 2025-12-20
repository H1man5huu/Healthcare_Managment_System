package hospital.management.system.telemedicine;

/**
 * TelemedicineService interface defines
 * basic operations for telemedicine sessions.
 *
 * Demonstrates:
 * - Interface usage
 * - OOP abstraction
 */
public interface TelemedicineService {

    /**
     * Starts the telemedicine session.
     */
    void startSession();

    /**
     * Ends the telemedicine session.
     */
    void endSession();
}


/**
 * TelemedicineSession simulates a virtual doctor–patient
 * consultation using multithreading.
 *
 * Demonstrates:
 * - Runnable (Thread)
 * - Synchronization
 * - Interface implementation
 */
public class TelemedicineSession implements Runnable, TelemedicineService {

    private String doctorName;
    private String patientName;

    public TelemedicineSession(String doctorName, String patientName) {
        this.doctorName = doctorName;
        this.patientName = patientName;
    }

    /**
     * Starts the telemedicine session.
     * Synchronized to avoid concurrent conflicts.
     */
    @Override
    public synchronized void startSession() {
        System.out.println(
            "Telemedicine session started between Dr. "
            + doctorName + " and Patient " + patientName
        );
    }

    /**
     * Ends the telemedicine session.
     */
    @Override
    public synchronized void endSession() {
        System.out.println("Telemedicine session ended");
    }

    /**
     * Thread execution logic.
     */
    @Override
    public void run() {
        startSession();
        try {
            // Simulate consultation time
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endSession();
    }
}
