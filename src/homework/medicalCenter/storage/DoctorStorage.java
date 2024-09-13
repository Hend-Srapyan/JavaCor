package homework.medicalCenter.storage;


import homework.medicalCenter.model.Doctor;

public class DoctorStorage {

    private Doctor[] doctors = new Doctor[10];
    private int size;

    public void add(Doctor doctor) {
        if (doctors.length == size) {
            extendStorage();
        }
        doctors[size++] = doctor;
    }

    private void extendStorage() {
        Doctor[] tmp = new Doctor[size + 10];
        System.arraycopy(doctors, 0, tmp, 0, size);
        doctors = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public Doctor getDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void searchDoctorByProfession(String keyword) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().contains(keyword)) {
                System.out.println(doctors[i]);
            }
        }
    }
    private int getDoctorIndexById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteDoctorById(String id) {
       int index = getDoctorIndexById(id);
       if (index != -1 ){
           for (int i = index + 1; i < size; i++) {
                doctors[i-1] = doctors[i];
           }
           size--;
       }
    }


}
