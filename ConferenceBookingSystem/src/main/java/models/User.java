package models;

public class User {
    String id, userName;
    String country, city;
    int floorNo, number;



    public User(String id, String userName, String country, String city, int floorNo, int number) {
        this.id = id;
        this.userName = userName;
        this.country = country;
        this.city = city;
        this.floorNo = floorNo;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", floorNo=" + floorNo +
                ", number=" + number +
                '}';
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
