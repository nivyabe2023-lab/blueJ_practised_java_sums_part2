import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;

class patient{
    public int patient_id;
    public String patient_name;
    public int patient_age;
    public String patient_gender;
    public String patient_medicalrecords;
    
    public patient(int patient_id,String patient_name,int patient_age,String patient_gender,String patient_medicalrecords){
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_gender =  patient_gender;
        this.patient_medicalrecords = patient_medicalrecords;           
    }
}

class doctor{
    public int doctor_id;
    public String doctor_name;
    public String doctor_specialization;
    
    public doctor(int doctor_id,String doctor_name,String doctor_specialization){
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_specialization = doctor_specialization;
    }
}

class appointment{
    public int appointment_id;
    public patient patient_details; 
    public doctor doctor_details; 
    
    public appointment(int appointment_id,patient patient_details,doctor doctor_details){
        this.appointment_id = appointment_id;
        this.patient_details = patient_details;
        this.doctor_details = doctor_details;
    }
}

public class Hospitalsystem{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        ArrayList<patient> patients = new ArrayList<>();

        System.out.println("Enter patient details:");

        int patient_id = sc.nextInt();
        sc.nextLine();

        String patient_name = sc.nextLine();

        int patient_age = sc.nextInt();
        sc.nextLine();

        String patient_gender = sc.nextLine();
        String patient_medicalrecords = sc.nextLine();

        patient p1 = new patient(patient_id,patient_name,patient_age,patient_gender,patient_medicalrecords);

        patients.add(p1);

        // ✅ JDBC CODE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dummy", "root", "");

            System.out.println("Connected to database!");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO patients VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, p1.patient_id);
            ps.setString(2, p1.patient_name);
            ps.setInt(3, p1.patient_age);
            ps.setString(4, p1.patient_gender);
            ps.setString(5, p1.patient_medicalrecords);

            int rows = ps.executeUpdate();

            System.out.println(rows + " row inserted!");

            con.close();

        } catch(Exception e) {
            e.printStackTrace();   // ✅ FIXED ERROR PRINTING
        }

        // Display patients
        System.out.println("Patient List:");
        for(patient p : patients){
            System.out.println(p.patient_name);
        }

        // Doctor
        ArrayList<doctor> doctors = new ArrayList<>();

        System.out.println("Enter doctor details:");

        int doctor_id = sc.nextInt();
        sc.nextLine();

        String doctor_name = sc.nextLine();
        String doctor_specialization = sc.nextLine();

        doctor d1 = new doctor(doctor_id,doctor_name,doctor_specialization);

        doctors.add(d1);

        System.out.println("Doctor details:");
        for(doctor d:doctors){
            System.out.println(d.doctor_name);
        }

        // Appointment
        ArrayList<appointment> appointments = new ArrayList<>();

        System.out.println("Enter appointment id:");
        int appointment_id = sc.nextInt();

        appointment a1 = new appointment(appointment_id,p1,d1);

        appointments.add(a1);

        System.out.println("Appointment details:");
        for(appointment a:appointments){
            System.out.println("Appointment ID: " + a.appointment_id);
            System.out.println("Patient Name: " + a.patient_details.patient_name);
            System.out.println("Doctor Name: " + a.doctor_details.doctor_name);
        }
    }
}