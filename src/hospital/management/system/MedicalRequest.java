package hospital.management.system.lab;

/**
 * MedicalRequest is an abstract base class for
 * all medical service requests such as Lab and Radiology.
 *
 * Demonstrates:
 * - Abstraction
 * - Inheritance
 * - Polymorphism
 */
public abstract class MedicalRequest {

    protected int patientId;
    protected String doctorName;
    protected String status;

    /**
     * Constructs a medical request with default PENDING status.
     *
     * @param patientId  Patient ID
     * @param doctorName Doctor Name
     */
    public MedicalRequest(int patientId, String doctorName) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.status = "PENDING";
    }

    /**
     * Generates a report for the medical request.
     * Implemented by child classes.
     *
     * @return formatted report
     */
    public abstract String generateReport();

    /**
     * Marks the medical request as completed.
     */
    protected void complete() {
        this.status = "COMPLETED";
    }

    /**
     * Returns patient ID.
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Returns doctor name.
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Returns current status of request.
     */
    public String getStatus() {
        return status;
    }
}
