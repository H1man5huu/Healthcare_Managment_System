package hospital.management.system.dao;

import hospital.management.system.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Handles database operations for Radiology module.
 */
public class RadiologyDAO {

    public static void addRadiologyRequest(int patientId, String doctor, String scanType) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO radiology_requests(patient_id, doctor, scan_type, status) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, patientId);
            ps.setString(2, doctor);
            ps.setString(3, scanType);
            ps.setString(4, "PENDING");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
