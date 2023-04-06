import java.util.Scanner;

// Appointment class with doctor, patient, and date attributes

public class Appointment {

    static Scanner input = new Scanner(System.in);

    private int doctorID;
    private int patientID;
    private String date;
    private boolean status;

    public Appointment() {

    }

    public Appointment(int doctorID, int patientID, String time, boolean status) {
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.date = time;
        this.status = status;
    }

    public void submitAppointment(int doctorAppointmentID, int patientAppointmentID) {
        Appointment[] docsAppointments = Runner.doctors[this.doctorID].getAppointments();
        Appointment[] patAppointments = Runner.patients[this.patientID].getAppointments();
        docsAppointments[doctorAppointmentID] = Appointment.this;
        patAppointments[patientAppointmentID] = Appointment.this;
        System.out.println("Your appointment has been submitted!!");
    }

    public int getDoctorIndex() {
        return doctorID;
    }

    public void setDoctorIndex(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPatientIndex() {
        return patientID;
    }

    public void setPatientIndex(int patientID) {
        this.patientID = patientID;
    }

    public String getTime() {
        return date;
    }

    public void setTime(String time) {
        this.date = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
