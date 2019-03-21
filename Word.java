import java.util.List;

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

    public  Word and(Word j){
        return new Word("("+this.c+"∧"+j.c+")",this.b&&j.b);
    }

    public  Word or(Word j){
        return new Word("("+this.c+"∨"+j.c+")",this.b||j.b);
    }

    public  Word not(){
        return new Word("("+"¬"+this.c+")",!this.b);
    }

    public  Word xor(Word j){
        return new Word("("+this.c+"⊕"+j.c+")",(this.b&&!j.b)||(!this.b&&j.b));
    }

    public  Word imp(Word j){
        return new Word("("+this.c+"→"+j.c+")",!(this.b&&!j.b));
    }

    public  Word equ(Word j){
        return new Word("("+this.c+"↔"+j.c+")",(this.b&&j.b)||(!this.b&&!j.b));
    }
}
