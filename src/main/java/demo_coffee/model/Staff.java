package demo_coffee.model;


public class Staff {
    private int id;
    private String full_name;
    private String gender;
    private String date_of_birth; //dang ngay "2021-2-21"
    private String id_card;
    private String email;
    private String phone;
    private String address;
    private String image;
    private String position;
    private long pay;
    private boolean status ;
    private String description;
    private boolean status_account =false;


    public Staff(){}

    public Staff(String full_name, String gender, String date_of_birth, String id_card, String email, String phone, String address, String image, String position, long pay, boolean status, String description) {
        this.full_name = full_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.position = position;
        this.pay = pay;
        this.status = status;
        this.description = description;
    }

    public Staff(int id, String full_name, String gender, String date_of_birth, String id_card, String email, String phone, String address, String image, String position, long pay, boolean status, String description) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.position = position;
        this.pay = pay;
        this.status = status;
        this.description = description;
    }
    public Staff(int id,String full_name, String gender, String date_of_birth, String id_card, String email, String phone, String address, String image, String position, long pay, boolean status, String description,Boolean status_account) {
        this.id=id;
        this.full_name = full_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.position = position;
        this.pay = pay;
        this.status = status;
        this.description = description;
        this.status_account = status_account;
    }

    public boolean isStatusAccount() {
        return status_account;
    }
    public void setStatusAccount(boolean status_account) {
        this.status_account = status_account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getIdCard() {
        return id_card;
    }

    public void setIdCard(String id_card) {
        this.id_card = id_card;
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

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
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
