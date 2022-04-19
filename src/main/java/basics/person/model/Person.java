package basics.person.model;

import java.util.Arrays;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String sport;
    private String gender;
    private String residency;
    private boolean over21;
    private String[] carModels;
    private String email;
    private String phoneNumber;
    private Integer age;

    public Person(int id, String firstName, String lastName, String sport, String gender, String residency, boolean over21, String[] carModels, String email, String phoneNumber, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.gender = gender;
        this.residency = residency;
        this.over21 = over21;
        this.carModels = carModels;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Person(String firstName, String lastName, String sport, String gender, String residency, boolean over21, String[] carModels, String email, String phoneNumber, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.gender = gender;
        this.residency = residency;
        this.over21 = over21;
        this.carModels = carModels;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getSport() {
        return sport;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public String getResidency() {
        return residency;
    }

    public void setOver21(boolean over21) {
        this.over21 = over21;
    }

    public boolean isOver21() {
        return over21;
    }

    public void setCarModels(String[] carModels) {
        this.carModels = carModels;
    }

    public String[] getCarModels() {
        return carModels;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sport='" + sport + '\'' +
                ", gender='" + gender + '\'' +
                ", residency='" + residency + '\'' +
                ", over21=" + over21 +
                ", carModels=" + Arrays.toString(carModels) +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}