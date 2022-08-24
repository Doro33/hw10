package online_shop.entity.products;

public class Readable extends Product{
    private String writer;
    private String subject;

    public Readable() {
    }

    public Readable(int id, String name, String type, String producer, int quantity, float price, String writer, String subject) {
        super(id, name, type, producer, quantity, price);
        this.writer = writer;
        this.subject = subject;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return  name +
                " | type: " + type +
                " | writer: " + writer +
                " | subject: " + subject +
                " | publisher: " + producer +
                " | price:" + price ;
    }
}