package online_shop.entity.products;

public class Readable extends Product {
    private String writer;
    private String subject;

    public Readable() {
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
        return name +
                " | type: " + type +
                " | writer: " + writer +
                " | subject: " + subject +
                " | publisher: " + producer +
                " | price:" + price;
    }
}