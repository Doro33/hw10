package online_shop.entity.products;

public class ElectricDevice extends Product implements Measurable{
    private float size;

    @Override
    public float getSize() {
        return size;
    }

    @Override
    public void setSize(float size) {
    this.size=size;
    }

    @Override
    public String toString() {
        return  name +
                " | type: " + type +
                " | producer: " + producer +
                " | size: " + size +"inch"+
                " | price: " + price;
    }
}