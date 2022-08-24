package online_shop.entity.products;

public abstract class Product {
    int id;
    String name;
    String type;
    String producer;
    float price;

    public Product() {
    }

    public Product(int id, String name, String type, String producer, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.producer = producer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
