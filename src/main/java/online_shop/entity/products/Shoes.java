package online_shop.entity.products;

public class Shoes extends Product implements Measurable{
    String color;
    float size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public float getSize() {
        return size;
    }
    @Override
    public void setSize(float size) {
        this.size = size;
    }

    public Shoes() {
    }

    public Shoes(int id, String name, String type, String producer,int quantity, float price, String color, float size) {
        super(id, name, type, producer, quantity, price);
        this.color = color;
        this.size = size;
    }
}