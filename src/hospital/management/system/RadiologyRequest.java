package hospital.management.system.radiology;

import hospital.management.system.lab.MedicalRequest;
import hospital.management.system.exception.InvalidMedicalRequestException;

/**
 * RadiologyRequest represents an imaging test request
 * such as X-Ray, MRI, or CT Scan for a patient.
 *
 * Demonstrates:
 * - Inheritance (extends MedicalRequest)
 * - Custom Exception Handling
 * - Polymorphism (overridden generateReport method)
 */
public class RadiologyRequest extends MedicalRequest {

    private String scanType;
    private String findings;

    /**
     * Creates a RadiologyRequest after validating inputs.
     *
     * @param patientId  Patient ID
     * @param doctorName Doctor Name
     * @param scanType   Type of radiology scan
     * @throws InvalidMedicalRequestException if scan type is invalid
     */
    public RadiologyRequest(int patientId, String doctorName, String scanType)
            throws InvalidMedicalRequestException {

        super(patientId, doctorName);

        if (scanType == null || scanType.trim().isEmpty()) {
            throw new InvalidMedicalRequestException(
                    "Radiology scan type cannot be empty");
        }

        this.scanType = scanType.trim();
        this.findings = "Pending";
    }

    /**
     * Sets the radiology findings and marks the request as completed.
     *
     * @param findings Radiology interpretation or report
     */
    public void setFindings(String findings) {
        this.findings = (findings == null || findings.trim().isEmpty())
                ? "Not Provided"
                : findings.trim();
        complete();
    }

    /**
     * Returns the scan type.
     */
    public String getScanType() {
        return scanType;
    }

    /**
     * Returns the radiology findings.
     */
    public String getFindings() {
        return findings;
    }

    /**
     * Generates a formatted radiology report.
     *
     * @return Radiology report string
     */
    @Override
    public String generateReport() {
        return "Scan Type: " + scanType +
               " | Findings: " + findings +
               " | Status: " + status;
    }
}
