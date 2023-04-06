import java.util.Scanner;

public class Patient extends Person {
    static Scanner input = new Scanner(System.in);

    private String dateOfBirth;
    private String martialStatus;
    private String[] pastDiseases;
    private Appointment[] appointments;

    public Patient() {
    }

    public Patient(String dateOfBirth, String martialStatus, String[] pastDiseases, Appointment[] appointments) {
        this.dateOfBirth = dateOfBirth;
        this.martialStatus = martialStatus;
        this.pastDiseases = pastDiseases;
        this.appointments = appointments;
    }

    public Patient(String id, String name, double age, String gender, String dateOfBirth, String martialStatus,
            String[] pastDiseases, Appointment[] appointments) {
        super(id, name, age, gender);
        this.dateOfBirth = dateOfBirth;
        this.martialStatus = martialStatus;
        this.pastDiseases = pastDiseases;
        this.appointments = appointments;
    }

    public static void bookAppointment() {
        System.out.print("Please enter your name: ");
        String patientName = input.nextLine();
        int patientID = searchPatient(patientName);
        while (patientID == -1) {
            System.out.println("Patient not found! Please try again");
            System.out.print("Please enter the name of the patient: ");
            patientName = input.nextLine();
            patientID = searchPatient(patientName);
        }

        System.out.print("Please enter the name of the doctor: ");
        String doctorName = input.nextLine();
        int doctorID = searchDoctor(doctorName);
        while (doctorID == -1) {
            System.out.println("Doctor not found! Please try again");
            System.out.print("Please enter the name of the doctor: ");
            doctorName = input.nextLine();
            doctorID = searchDoctor(doctorName);
        }

        System.out.println("Enter time (HH:MM:a): ");
        String time = input.next();

        int patientAppointmentID = checkPatientBandwidth(patientID);

        if (patientAppointmentID == -1) {
            System.out.println("You do not have enought bandwidth!");
            return;
        }

        int doctorAppointmentID = checkDoctorBandwidth(doctorID);

        if (doctorAppointmentID == -1) {
            System.out.println("Doctor do not have enought bandwidth!");
            return;
        }

        // submit appointment
        Appointment newAppointment = new Appointment(doctorID, patientID, time, false);
        newAppointment.submitAppointment(doctorAppointmentID, patientAppointmentID);
    }

    public static int checkDoctorBandwidth(int docIndex) {
        Doctor doctor = Runner.doctors[docIndex];

        Appointment[] appointments = doctor.getAppointments();
        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int checkPatientBandwidth(int patIndex) {
        Patient pat = Runner.patients[patIndex];
        Appointment[] appointments = pat.getAppointments();
        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] == null) {
                return i;
            }
        }

        return -1;
    }

    public static int searchDoctor(String name) {
        for (int i = 0; i < Runner.doctors.length; i++) {
            Doctor doctor = Runner.doctors[i];
            if (doctor != null) {
                String doctorName = doctor.getName();
                if (name.toLowerCase().equals(doctorName.toLowerCase())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void seeAllAppointmentsPat() {
        boolean ifNull = true;

        System.out.print("Please enter your name: ");
        String name = input.next();
        int patientID = searchPatient(name);
        while (patientID == -1) {
            System.out.println("Patient not found! Please try again");
            System.out.print("Please enter the name of the patient (Press \"N\" for Main Menu): ");
            String newName = input.next();
            if (newName.equalsIgnoreCase("N")) {
                return;
            }
            patientID = searchPatient(newName);

        }
        Patient pat = Runner.patients[patientID];
        Appointment[] appointments = pat.getAppointments();
        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] != null) {
                int docIndex = appointments[i].getDoctorIndex();
                Doctor doctor = Runner.doctors[docIndex];
                String doctorName = doctor.getName();

                System.out.println("-->Here are your appointments<--");
                System.out.println("Doctor name: " + doctorName
                        + "\n" + "Patient name: "
                        + Runner.patients[patientID].getName() + "\n" + "Time: " + appointments[i].getTime() + "\n"
                        + "Status: " + appointments[i].isStatus());
                ifNull = false;
            }
        }
        if (ifNull) {
            System.out.println("Appointment not found!!");
        }
    }

    public static int searchPatient(String name) {
        for (int i = 0; i < Runner.patients.length; i++) {
            Patient patient = Runner.patients[i];
            if (patient != null) {
                String patientName = patient.getName();
                if (name.toLowerCase().equals(patientName.toLowerCase())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String[] getPastDiseases() {
        return pastDiseases;
    }

    public void setPastDiseases(String[] pastDiseases) {
        this.pastDiseases = pastDiseases;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }
}
