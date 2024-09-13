package homework.medicalCenter.model;

import homework.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Patient {

    private String idCard;
    private String name;
    private String surname;
    private String phone;
    private Doctor doctor;
    private Date registerDataTime;

    public Patient(String idCard, String name, String surname, String phone, Doctor doctor, Date registerDataTime) {
        this.idCard = idCard;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.doctor = doctor;
        this.registerDataTime = registerDataTime;
    }

    public Patient() {

    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDataTime() {
        return registerDataTime;
    }

    public void setRegisterDataTime(Date registerDataTime) {
        this.registerDataTime = registerDataTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(idCard, patient.idCard) && Objects.equals(name, patient.name) && Objects.equals(surname, patient.surname) && Objects.equals(phone, patient.phone) && Objects.equals(doctor, patient.doctor) && Objects.equals(registerDataTime, patient.registerDataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCard, name, surname, phone, doctor, registerDataTime);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idCard = " + idCard + '\'' +
                ", name = " + name + '\'' +
                ", surname = " + surname + '\'' +
                ", phone = " + phone + '\'' +
                ", doctor = " + doctor +
                ", registerDataTime = " + DateUtil.fromDateToString(registerDataTime) +
                '}';
    }
}
