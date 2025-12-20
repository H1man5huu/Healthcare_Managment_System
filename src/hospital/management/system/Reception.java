package hospital.management.system;

import javax.swing.*;
import java.awt.*;

// ===== GUVI REQUIRED IMPORTS =====
import hospital.management.system.lab.LabRequest;
import hospital.management.system.radiology.RadiologyRequest;
import hospital.management.system.dao.LabDAO;
import hospital.management.system.dao.RadiologyDAO;
import hospital.management.system.telemedicine.TelemedicineSession;
import hospital.management.system.exception.InvalidMedicalRequestException;

public class Reception extends JFrame {

    public Reception() {

        // ================= MAIN PANELS =================
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        // ================= IMAGES =================
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(1300, 0, 250, 250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(image1));
        label1.setBounds(1000, 50, 300, 100);
        panel1.add(label1);

        // ================= EXISTING BUTTONS =================
        JButton btn1 = createButton("Add New Patient", 30, 15, panel1);
        btn1.addActionListener(e -> new NEW_PATIENT());

        JButton btn2 = createButton("Room", 30, 58, panel1);
        btn2.addActionListener(e -> new Room());

        JButton btn3 = createButton("Department", 30, 100, panel1);
        btn3.addActionListener(e -> new Department());

        JButton btn4 = createButton("All Employee Info", 270, 15, panel1);
        btn4.addActionListener(e -> new Employee_info());

        JButton btn5 = createButton("Patient Info", 270, 58, panel1);
        btn5.addActionListener(e -> new ALL_Patient_Info());

        JButton btn6 = createButton("Patient Discharge", 270, 100, panel1);
        btn6.addActionListener(e -> new patient_discharge());

        JButton btn7 = createButton("Update Patient Details", 510, 15, panel1);
        btn7.addActionListener(e -> new update_patient_details());

        JButton btn8 = createButton("Hospital Ambulance", 510, 58, panel1);
        btn8.addActionListener(e -> new Ambulance());

        JButton btn9 = createButton("Search Room", 510, 100, panel1);
        btn9.addActionListener(e -> new SearchRoom());

        // ================= LAB REQUEST =================
        JButton btnLab = createButton("Place Lab Request", 750, 58, panel1);
        btnLab.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter Patient ID"));
                String doctor = JOptionPane.showInputDialog("Doctor Name");
                String test = JOptionPane.showInputDialog("Lab Test Type");

                // OOP + Exception Handling
                LabRequest request = new LabRequest(patientId, doctor, test);
                LabDAO.addLabRequest(patientId, doctor, test);

                JOptionPane.showMessageDialog(null,
                        "Lab Request Added Successfully");
            } catch (InvalidMedicalRequestException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Invalid Input. Please try again.");
            }
        });

        // ================= RADIOLOGY REQUEST =================
        JButton btnRadio = createButton("Place Radiology Request", 750, 100, panel1);
        btnRadio.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter Patient ID"));
                String doctor = JOptionPane.showInputDialog("Doctor Name");
                String scan = JOptionPane.showInputDialog("Scan Type (X-Ray / MRI)");

                RadiologyRequest request =
                        new RadiologyRequest(patientId, doctor, scan);
                RadiologyDAO.addRadiologyRequest(patientId, doctor, scan);

                JOptionPane.showMessageDialog(null,
                        "Radiology Request Added Successfully");
            } catch (InvalidMedicalRequestException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Invalid Input. Please try again.");
            }
        });

        // ================= TELEMEDICINE (MULTITHREADING) =================
        JButton btnTele = createButton("Start Telemedicine", 990, 15, panel1);
        btnTele.addActionListener(e -> {
            String doctor = JOptionPane.showInputDialog("Doctor Name");
            String patient = JOptionPane.showInputDialog("Patient Name");

            TelemedicineSession session =
                    new TelemedicineSession(doctor, patient);

            // Thread creation & execution
            Thread t = new Thread(session);
            t.start();

            JOptionPane.showMessageDialog(null,
                    "Telemedicine Session Started");
        });

        // ================= LOGOUT =================
        JButton btn10 = createButton("Logout", 990, 58, panel1);
        btn10.addActionListener(e -> {
            setVisible(false);
            new Login();
        });

        // ================= FRAME SETTINGS =================
        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    // ================= COMMON BUTTON METHOD =================
    private JButton createButton(String text, int x, int y, JPanel panel) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 200, 30);
        btn.setBackground(new Color(246, 215, 118));
        panel.add(btn);
        return btn;
    }

    public static void main(String[] args) {
        new Reception();
    }
}
