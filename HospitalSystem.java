import java.util.Scanner;
import java.util.ArrayList;

class Patient {
    public String name;
    public int age;
    public String patientdiseases;

    // Constructor
    public Patient(String name, int age, String patientdiseases) {
        this.name = name;
        this.age = age;
        this.patientdiseases = patientdiseases;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Disease: " + patientdiseases);
    }
}

class HospitalStaff extends Patient {
    public HospitalStaff(String name, int age, String patientdiseases) {
        super(name, age, patientdiseases);
    }
}

class Doctor {
}

class Appointment {
}

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Patient> patients = new ArrayList<>();

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter your age:");
        int age = sc.nextInt();
        sc.nextLine(); // FIX

        System.out.println("Enter your disease:");
        String patientdiseases = sc.nextLine();

        Patient p = new Patient(name, age, patientdiseases);

        patients.add(p);

        System.out.println("\nPatient List:");
        for (Patient pt : patients) {
            pt.display();
        }
    }
}