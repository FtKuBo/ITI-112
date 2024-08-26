public class Book {

    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {

        this.author = author;
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return author + ": " + title + "(" + year + ")";
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }

        if (o.getClass() != Book.class || o == null) {
            return false;
        }

        Book myObj = (Book) o;

        if ((this.author == null)
                || (this.title == null)
                || (myObj.author == null)
                || (myObj.title == null)) {
            return this.author == myObj.author && this.title == myObj.title;
        }

        return this.author.equals(myObj.getAuthor())
                && this.title.equals(myObj.getTitle())
                && this.year == myObj.getYear();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

}