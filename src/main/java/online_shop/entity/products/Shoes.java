package online_shop.entity.products;

public class Shoes extends Product{
    String color;
    float size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Shoes() {
    }

    public Shoes(int id, String name, String type, String producer, float price, String color, float size) {
        super(id, name, type, producer, price);
        this.color = color;
        this.size = size;
    }
}