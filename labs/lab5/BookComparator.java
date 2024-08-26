import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public boolean equals(Object o1, Object o2) {
        return o1.equals(o2);
    }

    public int compare(Book b, Book b2) {
        if (b.getAuthor().equals(b2.getAuthor())) {
            if (b.getTitle().equals(b2.getTitle())) {
                if (b.getYear() == b2.getYear()) {
                    return 0;
                } else {
                    return (byte) ((b.getYear() > b2.getYear()) ? 1 : -1);
                }
            } else {
                return b.getTitle().compareTo(b2.getTitle());
            }

        } else {
            return b.getAuthor().compareTo(b2.getAuthor());
        }
    }

}
