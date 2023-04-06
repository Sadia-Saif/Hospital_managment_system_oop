
import java.util.Scanner;

public class Runner {
    static Scanner input = new Scanner(System.in);
    static Doctor[] doctors = new Doctor[5];
    static Patient[] patients = new Patient[5];
    static Admin[] admin = new Admin[5];

    public static void main(String[] args) {

        // Doctors
        String[] specializations = new String[3];
        doctors[0] = new Doctor("d-01", "Abdullah", 29, "M", "ChildSpecialist", 5, specializations, new Appointment[3]);
        doctors[1] = new Doctor("d-02", "Hadia", 25, "F", "HeartSpecialist", 7, specializations, new Appointment[3]);
        doctors[2] = new Doctor("d-03", "Dua", 21, "F", "Dentist", 8, specializations, new Appointment[3]);

        // Patient
        String[] pastDisease = new String[3];
        patients[0] = new Patient("p-01", "Sadia", 25, "female", "6/06/1998", "single", pastDisease,
                new Appointment[3]);
        patients[1] = new Patient("p-02", "Mariyam", 23, "female", "1/03/1991", "Married", pastDisease,
                new Appointment[3]);

        // Admins
        Admin[] admin = new Admin[5];
        admin[0] = new Admin("a-01", "Fatima", 50, "female", "manager", "Admin Branch");
        admin[0] = new Admin("a-02", "Saif", 57, "male", "director", "Admin Branch");

        int value = 0;
        while (value != 4) {
            System.out.println("*****Welcome to Hospital Management System*****");
            System.out.println("Please select your user type");
            System.out.println("1. Doctor\n2. Patient\n3. Admin\n4. Exit");

            System.out.print("Enter from 1-4: ");
            value = input.nextInt();

            if (value == 1) {
                doctorMenu();
            } else if (value == 2) {
                patientMenu();
            } else if (value == 3) {
                adminMenu();
            } else if (value != 4) {
                System.out.println("Value out of range, please enter from (1-4)");

            }
        }

        System.out.println("Good bye!");
    }

    public static void patientMenu() {

        int p = 0;
        while (p != 3) {
            System.out.println("\n---->Patient's Menu<----");
            System.out.println("Please select from the following menu");
            System.out.println("1. Book an appointment\n2. See all appointments\n3. Exit");
            System.out.print("Choose the opetion from 1-3: ");
            p = input.nextInt();
            if (p == 1) {
                Patient.bookAppointment();
            } else if (p == 2) {
                Patient.seeAllAppointmentsPat();
            } else if (p != 3) {
                System.out.println("Value out of range, please enter from (1-3)");
            }

        }
        System.out.println("Exiting patient's menu!!\n1");

    }

    public static void doctorMenu() {

        int d = 0;
        while (d != 5) {
            System.out.println("---->Doctor's Menu<----");
            System.out.println("Please select from the following menu");
            System.out.println(
                    "1. See all appointments\n2. Accept appointments\n3. Reject appointments\n4. Delete appointments\n5. Exit");
            System.out.print("Enter from 1-5: ");
            d = input.nextInt();
            if (d == 1) {
                int index = Doctor.seeAllAppointmentsDoc(false);
                if (index == -1) {
                    return;
                }

            } else if (d == 2) {
                Doctor.acceptAppointment();
            } else if (d == 3) {
                Doctor.rejectAppointment();
            } else if (d == 4) {
                Doctor.deleteAppointment();
            } else if (d != 5) {
                System.out.println("Value out of range, please enter from (1-5)");
            }
        }
        System.out.println("Exiting Doctor's menu!!\n");
    }

    public static void adminMenu() {

        int a = 0;
        while (a != 7) {
            System.out.println("\n---->Admin's Menu<----");
            System.out.println("Please select from the following menu");
            System.out.println(
                    "1. Add doctor\n2. Add patient\n3. Edit doctor\n4. Edit patient\n5. Delete doctor\n6. Delete patient\n7. Exit");
            System.out.print("Enter from 1-7: ");
            a = input.nextInt();
            if (a == 1) {
                Admin.addDoctor();
            } else if (a == 2) {
                Admin.addPatient();
            } else if (a == 3) {
                Admin.editDoctor();
            } else if (a == 4) {
                Admin.editPatient();
            } else if (a == 5) {
                Admin.deleteDoctor();
            } else if (a == 6) {
                Admin.deletePatient();
            } else if (a != 7) {

                System.out.println("Choose the operation you want to perform, please enter from (1-7)");

            }
        }
        System.out.println("Exiting admin's menu!!\n");
    }
}
