package homework.medicalCenter.model;

import java.util.Objects;

public class Doctor {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String profession;

    public Doctor(String id, String name, String surname, String email, String phoneNumber, String profession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profession = profession;
    }

    public Doctor() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(name, doctor.name) && Objects.equals(surname, doctor.surname) && Objects.equals(email, doctor.email) && Objects.equals(phoneNumber, doctor.phoneNumber) && Objects.equals(profession, doctor.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, phoneNumber, profession);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id = " + id + '\'' +
                ", name = " + name + '\'' +
                ", surname = " + surname + '\'' +
                ", email = " + email + '\'' +
                ", phoneNumber = " + phoneNumber + '\'' +
                ", profession = " + profession + '\'' +
                '}';
    }
}
