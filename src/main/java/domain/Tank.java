package domain;

public class Tank {
    private long id;
    private String title;
    private double price;
    private boolean isActive;


    public Tank() {
    }

    public Tank(String title, double price) {
        this.title = title;
        this.price = price;
        this.isActive = true;
    }

    public Tank(long id, String title, double price, boolean isActive) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isActive = isActive;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.format(
                "Tank Information:\n" +
                        "-----------------\n" +
                        "ID      : %d\n" +
                        "Title   : %s\n" +
                        "Price   : %.2f\n" +
                        "Active  : %s\n",
                id, title, price, isActive ? "Yes" : "No");
    }
}
