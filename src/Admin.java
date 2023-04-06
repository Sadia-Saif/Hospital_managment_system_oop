import java.util.Scanner;

public class Admin extends Person {
    static Scanner input = new Scanner(System.in);

    private String designation;
    private String department;

    public Admin(String designation, String department) {
        this.designation = designation;
        this.department = department;
    }

    public Admin(String id, String name, double age, String gender, String designation, String department) {
        super(id, name, age, gender);
        this.designation = designation;
        this.department = department;
    }

    public static void addDoctor() {
        System.out.println("Enter doctor ID: ");
        String id = input.next();
        System.out.println("Enter name of doctor: ");
        String docName = input.next();
        System.out.println("Enter doctor gender: ");
        String gender = input.next();
        System.out.println("Enter doctor age: ");
        double docAge = input.nextDouble();
        System.out.println("Enter doctor designation: ");
        String docDesignation = input.next();
        System.out.println("Enter doctor experience: ");
        double experience = input.nextDouble();
        String[] specializations = new String[3];
        System.out.println("Enter doctor specializations: ");
        for (int i = 0; i < 3; i++) {
            String spec = input.nextLine();
            specializations[i] = spec;
        }

        for (int i = 0; i < Runner.doctors.length; i++) {
            if (Runner.doctors[i] == null) {
                Doctor doc = new Doctor(id, docName, docAge, gender, docDesignation, experience, specializations,
                        new Appointment[3]);
                Runner.doctors[i] = doc;
                System.out.println("--> Doctor Details <--");
                System.out.println("doctor ID: " + id + "\ndoctor name:" + docName + "\ndoctor age: " + docAge
                        + "\ndoctor gender: "
                        + gender + "\ndoctor designation:" + docDesignation + "\ndoctor experience: " + experience
                        + "\ndoctor specializations: ");
                for (i = 0; i < 3; i++) {
                    System.out.println(specializations[i]);
                }
                System.out.println("Doctor Added Successfully!!");
                break;
            }
        }

    }

    public static void editDoctor() {
        System.out.print("Please enter the name of doctor: ");
        String name = input.next();
        int docIndex = searchDoctor(name);
        if (docIndex == -1) {
            System.out.println("Doctor not found, try again");
            return;
        }
        System.out.println("---> Editing doctor <---");
        System.out.println("Enter doctor ID: ");
        String id = input.next();
        System.out.println("Enter name of doctor: ");
        String docName = input.next();
        System.out.println("Enter doctor gender: ");
        String gender = input.next();
        System.out.println("Enter doctor age: ");
        double docAge = input.nextDouble();
        System.out.println("Enter doctor designation: ");
        String docDesignation = input.next();
        System.out.println("Enter doctor experience: ");
        double experience = input.nextDouble();
        String[] specializations = new String[3];
        System.out.println("Enter doctor specializations: ");
        for (int i = 0; i < 3; i++) {
            String spec = input.nextLine();

            specializations[i] = spec;
        }
        Doctor doc = new Doctor(id, docName, docAge, gender, docDesignation, experience, specializations,
                new Appointment[3]);
        Runner.doctors[docIndex] = doc;
        System.out.println("--> Doctor Details <--");
        System.out.print("doctor ID: " + id + "\ndoctor name: " + docName + "\ndoctor age: " + docAge
                + "\ndoctor gender: "
                + gender + "\ndoctor designation: " + docDesignation + "\ndoctor experience: " + experience
                + "\ndoctor specializations: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(specializations[i] + "\n");
        }
        System.out.println("Doctor Edited Successfully!!");

    }

    public static int searchDoctor(String name) {

        for (int i = 0; i < Runner.doctors.length; i++) {
            Doctor doc = Runner.doctors[i];
            if (doc != null) {
                String docName = doc.getName();
                if (name.toLowerCase().equals(docName.toLowerCase())) {
                    return i;
                }

            }

        }
        return -1;
    }

    public static void deleteDoctor() {
        System.out.print("Please enter the name of doctor: ");
        String name = input.next();
        int docIndex = searchDoctor(name);
        if (docIndex == -1) {
            System.out.println("Doctor not found, try again");
            System.out.print("Please enter the name of the patient (Press \"N\" for Main Menu): ");
            name = input.next();
            if (name.equalsIgnoreCase("N")) {
                return;
            }
            docIndex = searchDoctor(name);

        }

        Doctor doc = Runner.doctors[docIndex];
        System.out.println("This doctor is being deleted");
        System.out.println("--> Doctor Details <--");
        System.out.print("doctor ID: " + doc.getId() + "\ndoctor name: " + doc.getName()
                + "\ndoctor age: " + doc.getAge()
                + "\ndoctor gender: "
                + doc.getGender() + "\ndoctor designation: " + doc.getDesignation()
                + "\ndoctor experience: " + doc.getExperience()
                + "\ndoctor specializations: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(Runner.doctors[docIndex].getSpecialization() + "\n");
        }
        System.out.println();
        Runner.doctors[docIndex] = null;
        System.out.println("--> Deleted Doctor Details <--");
        System.out.print("doctor ID: " + Runner.doctors[docIndex] + "\ndoctor name: " + Runner.doctors[docIndex]
                + "\ndoctor age: " + Runner.doctors[docIndex]
                + "\ndoctor gender: "
                + Runner.doctors[docIndex] + "\ndoctor designation: " + Runner.doctors[docIndex]
                + "\ndoctor experience: " + Runner.doctors[docIndex]
                + "\ndoctor specializations: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(Runner.doctors[docIndex] + "\n");
        }

        System.out.println("Doctor Deleted Successfully!!");

    }

    public static void addPatient() {
        System.out.println("Enter patient ID: ");
        String id = input.next();
        System.out.println("Enter name of patient: ");
        String patName = input.next();
        System.out.println("Enter patient age: ");
        double patAge = input.nextDouble();
        System.out.println("Enter patient gender: ");
        String gender = input.next();

        System.out.println("Enter patient's dateOfBirth: ");
        String dateOfBirth = input.next();
        System.out.println("Enter patient martialStatus: ");
        String martialStatus = input.next();
        System.out.println("Enter patient pastDiseases: ");
        String[] pastDiseases = new String[3];

        for (int i = 0; i < 3; i++) {
            String spec = input.nextLine();
            pastDiseases[i] = spec;
        }

        for (int i = 0; i < Runner.patients.length; i++) {
            if (Runner.patients[i] == null) {
                Patient pat = new Patient(id, patName, patAge, gender, dateOfBirth, martialStatus, pastDiseases, null);
                Runner.patients[i] = pat;
                System.out.println("--> patient Details <--");
                System.out.println("patient ID: " + id + "\npatient name:" + patName + "\npatient age: " + patAge
                        + "\npatient gender: "
                        + gender + "\npatient's dateOfBirth:" + dateOfBirth + "\npatient's martialStatus: "
                        + martialStatus
                        + "\npatient's pastDiseases: ");
                for (i = 0; i < 3; i++) {
                    System.out.println(pastDiseases[i]);
                }
                System.out.println("patient Added Successfully!!");
                break;
            }
        }
    }

    public static void editPatient() {
        System.out.print("Please enter the name of patient: ");
        String name = input.next();
        int docIndex = searchPatient(name);
        if (docIndex == -1) {
            System.out.println("patient not found, try again");
            return;
        }
        System.out.println("---> Editing patient <---");
        System.out.println("Enter patients's ID: ");
        String id = input.next();
        System.out.println("Enter name of patient: ");
        String docName = input.next();
        System.out.println("Enter patients's gender: ");
        String gender = input.next();
        System.out.println("Enter patients's age: ");
        double docAge = input.nextDouble();
        System.out.println("Enter patients's's date of birth: ");
        String dateOfBirth = input.next();
        System.out.println("Enter patients's martial status: ");
        String martialStatus = input.next();
        System.out.println("Enter patients's past diseases: ");
        String[] pastDiseases = new String[3];
        for (int i = 0; i < 3; i++) {
            String spec = input.nextLine();

            pastDiseases[i] = spec;
        }
        Patient doc = new Patient(id, docName, docAge, gender, dateOfBirth, martialStatus, pastDiseases,
                new Appointment[3]);
        Runner.patients[docIndex] = doc;
        System.out.println("--> patient Details <--");
        System.out.print("patient's ID: " + id + "\npatient's name: " + docName + "\npatient's age: " + docAge
                + "\npatient's gender: "
                + gender + "\npatient's dateOfBirth: " + dateOfBirth + "\npatient's martialStatus: " + martialStatus
                + "\npatient's pastDiseases: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(pastDiseases[i] + "\n");
        }
        System.out.println("patient Edited Successfully!!");

    }

    public static int searchPatient(String name) {

        for (int i = 0; i < Runner.patients.length; i++) {
            Patient pat = Runner.patients[i];
            if (pat != null) {
                String patName = pat.getName();
                if (name.toLowerCase().equals(patName.toLowerCase())) {
                    return i;
                }

            }

        }
        return -1;
    }

    public static void deletePatient() {
        System.out.print("Please enter the name of patient: ");
        String name = input.next();
        int patIndex = searchPatient(name);
        if (patIndex == -1) {
            System.out.println("patient not found, try again");
            System.out.print("Please enter the name of the patient (Press \"N\" for Main Menu): ");
            name = input.next();
            if (name.equalsIgnoreCase("N")) {
                return;
            }
            patIndex = searchPatient(name);
        }
        Patient doc = Runner.patients[patIndex];
        System.out.println("This Patient is being deleted");
        System.out.println("--> Patient Details <--");
        System.out.print("Patient ID: " + doc.getId() + "\nPatient name: " + doc.getName()
                + "\nPatient age: " + doc.getAge()
                + "\nPatient gender: "
                + doc.getGender() + "\nPatient dateOfBirth: " + doc.getDateOfBirth()
                + "\nPatient martialStatus: " + doc.getMartialStatus()
                + "\nPatient pastDiseases: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(Runner.patients[patIndex].getPastDiseases() + "\n");
        }
        System.out.println();
        Runner.patients[patIndex] = null;
        System.out.println("--> Deleted Patient Details <--");
        System.out.print("patient's ID: " + Runner.patients[patIndex] + "\npatient's name: " + Runner.patients[patIndex]
                + "\npatient's age: " + Runner.patients[patIndex]
                + "\npatient gender: "
                + Runner.patients[patIndex] + "\npatient's designation: " + Runner.patients[patIndex]
                + "\npatient's experience: " + Runner.patients[patIndex]
                + "\npatient's specializations: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(Runner.patients[patIndex] + "\n");
        }

        System.out.println("Patient Deleted Successfully!!");

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
