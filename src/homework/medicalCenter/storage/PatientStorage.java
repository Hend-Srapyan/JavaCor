package homework.medicalCenter.storage;


import homework.medicalCenter.model.Patient;

public class PatientStorage {

    private Patient[] patients = new Patient[10];
    private int size;

    public void add(Patient patient) {
        if (patients.length == size) {
            extendStorage();
        }
        patients[size++] = patient;
    }

    private void extendStorage() {
        Patient[] tmp = new Patient[size + 10];
        System.arraycopy(patients, 0, tmp, 0, size);
        patients = tmp;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i]);
        }
    }

    public Patient getPatientByIdCard(String id) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getIdCard().equals(id)) {
                return patients[i];
            }
        }
        return null;
    }

//    public void printAllPatientsByDoctor(String id) {
//        for (int i = 0; i < size; i++) {
//
//        }
//
//    }
}
