package online_shop.entity.products;

public class Shoes extends Product implements Measurable {
    private String color;
    private float size;

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
    @Override
    public String toString() {
        return name +
                " | type: " + type +
                " | producer: " + producer +
                " | color: '" + color +
                " | size: " + size +
                " | price: " + price;
    }
}