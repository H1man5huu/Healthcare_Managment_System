package hospital.management.system.dao;

import hospital.management.system.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Handles database operations for Lab module.
 */
public class LabDAO {

    public static void addLabRequest(int patientId, String doctor, String testType) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO lab_requests(patient_id, doctor, test_type, status) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, patientId);
            ps.setString(2, doctor);
            ps.setString(3, testType);
            ps.setString(4, "PENDING");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
