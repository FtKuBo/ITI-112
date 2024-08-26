//Don't forget to add the exceptions

public class ITIStringBuffer {

    SinglyLinkedList<String> SLL;
    String res;
    boolean changed;
    int lgth;

    public ITIStringBuffer() {
        SLL = new SinglyLinkedList<>();
        changed = true;
        lgth = 0;
    }

    public ITIStringBuffer(String firstString) {

        if (firstString == null) {
            throw new NullPointerException();
        }
        SLL = new SinglyLinkedList<>();
        SLL.addFirst(firstString);
        lgth = firstString.length();
        changed = true;
    }

    public void append(String nextString) {

        if (nextString == null) {
            throw new NullPointerException();
        }
        this.SLL.add(nextString);
        lgth += nextString.length();
        changed = true;
    }

    public String toString() {

        if (!changed) {
            return res;
        }
        char[] cArray = new char[lgth];
        int i = 0;
        for (String s : SLL) {
            char[] newCArr = s.toCharArray();
            for (char c : newCArr) {
                cArray[i++] = c;
            }
        }
        res = new String(cArray);
        changed = false;
        return res;

    }

}
