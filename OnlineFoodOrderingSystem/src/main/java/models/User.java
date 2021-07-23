package models;

public class User {
    String name, id;
    User.Gender gender;
    String phNo;
    String pinCode;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender=" + gender +
                ", phNo='" + phNo + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    public static enum Gender{
        MALE, FEMALE
    }

    public User(String name, Gender gender, String phNo, String pinCode) {
        this.name = name;
        this.gender = gender;
        this.phNo = phNo;
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
