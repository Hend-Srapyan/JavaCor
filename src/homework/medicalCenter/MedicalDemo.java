package homework.medicalCenter;


import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.DoctorStorage;
import homework.medicalCenter.storage.PatientStorage;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Scanner;

public class MedicalDemo implements MedicalCommands {

    private static Scanner scanner = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static PatientStorage patientStorage = new PatientStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            MedicalCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctor();
                    break;
                case PRINT_ALL_PATIENTS:
                    patientStorage.print();
                    break;
                case PRINT_ALL_DOCTORS:
                    doctorStorage.print();
                    break;
            }
        }


    }

    private static void printAllPatientsByDoctor() {
        doctorStorage.print();
        System.out.println("Please input doctor ID");
        String doctorId = scanner.nextLine();
        Doctor doctor = doctorStorage.getDoctorById(doctorId);
        if (doctor != null) {
            patientStorage.printAllPatientsByDoctor(doctor);
        }
    }

    private static void addPatient() {

        doctorStorage.print();
        System.out.println("Please input doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctor = doctorStorage.getDoctorById(doctorId);
        if (doctor != null) {
            System.out.println("Please input patient idCard, name, surname, phone, registerDataTime(01.01.2000)");
            String patientStr = scanner.nextLine();
            String[] patientArr = patientStr.split(",");
            if (patientArr.length == 5) {
                String id = patientArr[0];
                if (patientStorage.getPatientByIdCard(id) == null) {
                    try {
                        Patient patient = new Patient();
                        patient.setIdCard(id);
                        patient.setName(patientArr[1]);
                        patient.setSurname(patientArr[2]);
                        patient.setPhone(patientArr[3]);
                        patient.setRegisterDataTime(DateUtil.fromStringToDate(patientArr[4]));
                        patientStorage.add(patient);
                        System.err.println("Patient added");
                    } catch (ParseException e) {
                        System.err.println("REGISTER DATA TIME IS INCORRECT!");
                    }
                } else {
                    System.err.println("Patient with id " + id + " already exist.");
                }
            }
        }
    }


    private static void deleteDoctorById() {
        doctorStorage.print();
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        Doctor doctorById = doctorStorage.getDoctorById(id);
        if (doctorById == null) {
            System.err.println("Doctor with " + id + " id doesn't exists!!!");
            return;
        }
        doctorStorage.deleteDoctorById(id);
        System.err.println("Doctor was deleted!!");
    }


    private static void addDoctor() {
        System.out.println("Please input id, name, surname, email, phoneNumber, profession");
        String doctorStr = scanner.nextLine();
        String[] doctorArr = doctorStr.split(",");
        if (doctorArr.length == 6) {
            String id = doctorArr[0];

            if (doctorStorage.getDoctorById(id) == null) {
                Doctor doctor = new Doctor();
                doctor.setId(id);
                doctor.setName(doctorArr[1]);
                doctor.setSurname(doctorArr[2]);
                doctor.setEmail(doctorArr[3]);
                doctor.setPhoneNumber(doctorArr[4]);
                doctor.setProfession(doctorArr[5]);
                doctorStorage.add(doctor);
                System.err.println("Doctor added!!!");
            } else {
                System.out.println("Doctor with id " + id + " already exist.");
            }
        }
    }

    public static void searchDoctorByProfession() {
        doctorStorage.print();
        System.out.println("Please input doctor keyword");
        String keyword = scanner.nextLine();
        doctorStorage.searchDoctorByProfession(keyword);
    }

    private static void changeDoctorById() {
        doctorStorage.print();
        System.out.println("Please input doctor ID");
        String doctorId = scanner.nextLine();
        Doctor doctorById = doctorStorage.getDoctorById(doctorId);
        if (doctorById != null) {
            System.out.println("Please input doctor's new name");
            String doctorName = scanner.nextLine();
            System.out.println("Please input doctor's new surname");
            String doctorSurname = scanner.nextLine();
            System.out.println("Please input new email");
            String email = scanner.nextLine();
            System.out.println("Please input new phone number");
            String phoneNumber = scanner.nextLine();
            System.out.println("Please input new profession");
            String profession = scanner.nextLine();

            if (doctorName != null && !doctorName.isEmpty()) {
                doctorById.setName(doctorName);
            }
            if (doctorSurname != null && !doctorSurname.isEmpty()) {
                doctorById.setSurname(doctorSurname);
            }
            if (email != null && !email.isEmpty()) {
                doctorById.setEmail(email);
            }
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                doctorById.setPhoneNumber(phoneNumber);
            }
            if (profession != null && !profession.isEmpty()) {
                doctorById.setProfession(profession);
            }

            System.err.println("Change was successfully");
        }
    }
}



