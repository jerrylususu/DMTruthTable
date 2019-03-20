public class Word {
    public String c;
    public boolean b;

    public Word(String c, boolean b) {
        this.c = c;
        this.b = b;
    }

    @Override
    public String toString() {
        return c+"="+(b?"T":"F");
    }
}
