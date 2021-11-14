package demo_coffee.model;

public class Drinks {
    private String id ;
    private String name ;
    private int quantity ;
    private int price ;
    private boolean status ;
    private String description;
    private boolean statusOder = false ;
    private String image;

    public Drinks(){} ;

    public Drinks(String id, String name, int quantity, int price, boolean status, String description, boolean statusOder, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.description = description;
        this.statusOder = statusOder;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatusOder() {
        return statusOder;
    }

    public void setStatusOder(boolean statusOder) {
        this.statusOder = statusOder;
    }
}
