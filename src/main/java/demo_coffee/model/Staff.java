package demo_coffee.model;

public class Staff {
    private int id;
    private String full_name;
    private String gender;
    private String date_of_birth;
    private String id_car;
    private String email;
    private String phone;
    private String address;
    private String image;
    private String pay;
    private String position;
    private boolean status ;
    private String description;


    public Staff(){}

    public Staff(String full_name, String gender, String date_of_birth, String id_car, String email, String phone, String address, String image, String pay, String position, boolean status, String description) {
        this.full_name = full_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_car = id_car;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.pay = pay;
        this.position = position;
        this.status = status;
        this.description = description;
    }

    public Staff(int id, String full_name, String gender, String date_of_birth, String id_car, String email, String phone, String address, String image, String pay, String position, boolean status, String description) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_car = id_car;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.pay = pay;
        this.position = position;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getId_car() {
        return id_car;
    }

    public void setId_car(String id_car) {
        this.id_car = id_car;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
