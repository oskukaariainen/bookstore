package classes;

public class Book {
    private String title;
    private String author;
    private int pulicationYear;
    private String isbn;
    private double price;

    public Book() {
    }

    public Book(String title, String author, int pulicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.pulicationYear = pulicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPulicationYear() {
        return pulicationYear;
    }

    public void setPulicationYear(int pulicationYear) {
        this.pulicationYear = pulicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", pulicationYear=" + pulicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }

}
