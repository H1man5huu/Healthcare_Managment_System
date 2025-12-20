package hospital.management.system.lab;

import hospital.management.system.exception.InvalidMedicalRequestException;

/**
 * LabRequest represents a laboratory test request
 * placed by a doctor for a patient.
 *
 * Demonstrates:
 * - Inheritance (extends MedicalRequest)
 * - Custom Exception Handling
 * - Polymorphism (overridden generateReport method)
 */
public class LabRequest extends MedicalRequest {

    private String testType;
    private String result;

    /**
     * Creates a LabRequest after validating inputs.
     *
     * @param patientId  Patient ID
     * @param doctorName Doctor Name
     * @param testType   Type of lab test
     * @throws InvalidMedicalRequestException if test type is invalid
     */
    public LabRequest(int patientId, String doctorName, String testType)
            throws InvalidMedicalRequestException {

        super(patientId, doctorName);

        if (testType == null || testType.trim().isEmpty()) {
            throw new InvalidMedicalRequestException(
                    "Lab test type cannot be empty");
        }

        this.testType = testType.trim();
        this.result = "Pending";
    }

    /**
     * Sets the lab result and marks the request as completed.
     *
     * @param result Lab test result
     */
    public void setResult(String result) {
        this.result = (result == null || result.trim().isEmpty())
                ? "Not Provided"
                : result.trim();
        complete();
    }

    /**
     * Returns the lab test type.
     */
    public String getTestType() {
        return testType;
    }

    /**
     * Returns the lab result.
     */
    public String getResult() {
        return result;
    }

    /**
     * Generates a formatted lab report.
     *
     * @return Lab report string
     */
    @Override
    public String generateReport() {
        return "Lab Test: " + testType +
               " | Result: " + result +
               " | Status: " + status;
    }
}
