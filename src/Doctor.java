import java.util.Scanner;

public class Doctor extends Person {

    static Scanner input = new Scanner(System.in);
    private String designation;
    private double experience;
    private String[] specialization;
    private Appointment[] appointments;

    public Doctor() {
    }

    static Doctor empty = new Doctor();

    public Doctor(String designation, double experience, String[] specialization, Appointment[] appointments) {
        this.designation = designation;
        this.experience = experience;
        this.specialization = specialization;
        this.appointments = appointments;
    }

    public Doctor(String id, String name, double age, String gender, String designation, double experience,
            String[] specialization,                              
            Appointment[] appointments) {
        super(id, name, age, gender);
        this.specialization = specialization;
        this.experience = experience;
        this.designation = designation;
        this.appointments = appointments;
    }

    public static int seeAllAppointmentsDoc(boolean showOnlyPending) {
        boolean hasAppointment = false;

        int docIndex = -1;
        while (docIndex == -1) {
            System.out.print("Please enter your doctor id (Press \"N\" for Main Menu): ");
            String docId = input.next();
            if (docId.equalsIgnoreCase("N")) {
                return -1;
            }
            docIndex = searchDoctorById(docId);

            if (docIndex >= 0) {
                Doctor doc = Runner.doctors[docIndex];
                Appointment[] appointments = doc.getAppointments();
                System.out.println("\n--> Appointments <--");

                for (int i = 0; i < appointments.length; i++) {
                    if (appointments[i] != null) {
                        if (showOnlyPending && !appointments[i].isStatus()) {
                            System.out
                                    .println("App. ID: " + (i + 1) + "\nDoctor index: "
                                            + appointments[i].getDoctorIndex()
                                            + "\n"
                                            + "Patient index: "
                                            + appointments[i].getPatientIndex() + "\n" + "Time: "
                                            + appointments[i].getTime() + "\n"
                                            + "Status: " + appointments[i].isStatus() + "\n");
                        } else if (!showOnlyPending) {
                            System.out
                                    .println("App. ID: " + (i + 1) + "\nDoctor index: "
                                            + appointments[i].getDoctorIndex()
                                            + "\n"
                                            + "Patient index: "
                                            + appointments[i].getPatientIndex() + "\n" + "Time: "
                                            + appointments[i].getTime() + "\n"
                                            + "Status: " + appointments[i].isStatus() + "\n");
                        }

                        hasAppointment = true;

                    }
                }
                if (!hasAppointment) {
                    System.out.println("No appointment found!!\n");
                    return -1;
                }

            } else {
                System.out.println("Invalid ID, please try again!!");
            }

        }

        return docIndex;
    }

    public static int searchDoctorById(String docId) {
        for (int i = 0; i < Runner.doctors.length; i++) {
            Doctor doc = Runner.doctors[i];
            if (doc != null) {
                String id = doc.getId();
                if (docId.toLowerCase().equals(id.toLowerCase())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void acceptAppointment() {
        int docIndex = seeAllAppointmentsDoc(true);
        if (docIndex == -1) {
            return;
        }
        int appId = 0;
        while (appId < 1 || appId > 3) {
            System.out.println("Please enter App ID of appointment you want to accept: ");
            appId = input.nextInt();
            int index = appId - 1;
            updateAppointmentStatus(index, docIndex);
        }

    }

    public static void updateAppointmentStatus(int appointmentIndex, int doctorIndex) {
        Doctor doc = Runner.doctors[doctorIndex];
        Appointment[] appointments = doc.getAppointments();
        boolean status = appointments[appointmentIndex].isStatus();
        if (status == false) {
            appointments[appointmentIndex].setStatus(true);

            System.out.println("App. ID: " + (appointmentIndex + 1) + "\nDoctor index: "
                    + appointments[appointmentIndex].getDoctorIndex()
                    + "\n"
                    + "Patient index: "
                    + appointments[appointmentIndex].getPatientIndex() + "\n" + "Time: "
                    + appointments[appointmentIndex].getTime()
                    + "\n"
                    + "Status: " + appointments[appointmentIndex].isStatus() + "\n");
            System.out.println("--> Appointment Accepted <--");
        }

    }

    public static void rejectAppointment() {
        int docIndex = seeAllAppointmentsDoc(true);
        if (docIndex == -1) {
            return;
        }
        int appId = 0;
        while (appId < 1 || appId > 3) {
            System.out.println("Please enter App ID of appointment you want to reject: ");
            appId = input.nextInt();
            int index = appId - 1;
            rejectStatus(index, docIndex);

        }

    }

    public static void rejectStatus(int appointmentIndex, int doctorIndex) {
        Doctor doc = Runner.doctors[doctorIndex];
        Appointment[] appointments = doc.getAppointments();
        boolean status = appointments[appointmentIndex].isStatus();
        if (status == false) {
            appointments[appointmentIndex] = null;
            System.out.println("App. ID: " + appointments[appointmentIndex] + "\nDoctor index: "
                    + appointments[appointmentIndex]
                    + "\n"
                    + "Patient index: "
                    + appointments[appointmentIndex] + "\n" + "Time: "
                    + appointments[appointmentIndex]
                    + "\n"
                    + "Status: " + appointments[appointmentIndex] + "\n");
            System.out.println("--> Appointment Rejected Successfully <--");
        }

    }

    public static void deleteAppointment() {
        int docIndex = seeAllAppointmentsDoc(false);
        if (docIndex == -1) {
            return;
        }
        int appId = 0;
        while (appId < 1 || appId > 3) {
            System.out.println("Please enter App ID of appointment you want to delete: ");
            appId = input.nextInt();
            int index = appId - 1;
            deleteStatus(index, docIndex);

        }

    }

    public static void deleteStatus(int appointmentIndex, int doctorIndex) {
        Doctor doc = Runner.doctors[doctorIndex];
        Appointment[] appointments = doc.getAppointments();
        appointments[appointmentIndex] = null;
        System.out.println("App. ID: " + appointments[appointmentIndex] + "\nDoctor index: "
                + appointments[appointmentIndex]
                + "\n"
                + "Patient index: "
                + appointments[appointmentIndex] + "\n" + "Time: "
                + appointments[appointmentIndex]
                + "\n"
                + "Status: " + appointments[appointmentIndex] + "\n");
        System.out.println("--> Appointment Deleted Successfully <--");

    }

    public String[] getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String[] specialization) {
        this.specialization = specialization;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }
}