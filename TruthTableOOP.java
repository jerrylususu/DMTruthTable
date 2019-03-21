import java.util.List;
import java.util.function.Function;

public class TruthTableOOP {

    public static void main(String[] args) {
        TruthTable t = new TruthTable();
        t.addVar("p");
        t.addVar("q");
        t.addVar("r");

        List i;

        Function<List<Word>,Word> expr =
                l -> equ(imp(v(l,"p"),not(v(l,"q"))),imp(v(l,"r"),or(v(l,"p"),v(l,"q"))));
//                l -> equ.apply(imp.apply(v("p",l),not.apply(v("q",l))),
//                        imp.apply(v("r",l),or.apply(v("p",l),not.apply(v("q",l)))));
//        Function<List<Word>,Word> expr2 =
//                l -> or.apply(v("q",l),and.apply(not.apply(v("p",l)),not.apply(v("r",l))));

        t.buildCombinations();

        for (List<Word> li:t.combinations){
            System.out.printf("%s: %s\n",li,eval2(li));
        }
    }

    public static Word eval(List<Word> l){
        Word p = l.get(0);
        Word q = l.get(1);
        Word r = l.get(2);
        return equ(imp(p,not(q)),imp(r,or(p,not(q))));
    }

    // a even better version... much more similar to human style
    public static Word eval2(List<Word> l){
        Word p = l.get(0);
        Word q = l.get(1);
        Word r = l.get(2);
        return p.imp(not(q)).equ(r.imp(p.or(not(q))));
    }

    public static Word v(List<Word> l,String s){
        return l.get(TruthTable.hm.get(s));
    }

    public static Word and(Word i,Word j){
        return new Word("("+i.c+"∧"+j.c+")",i.b&&j.b);
    }

    public static Word or(Word i,Word j){
        return new Word("("+i.c+"∨"+j.c+")",i.b||j.b);
    }

    public static Word not(Word i){
        return new Word("("+"¬"+i.c+")",!i.b);
    }

    public static Word xor(Word i,Word j){
        return new Word("("+i.c+"⊕"+j.c+")",(i.b&&!j.b)||(!i.b&&j.b));
    }

    public static Word imp(Word i,Word j){
        return new Word("("+i.c+"→"+j.c+")",!(i.b&&!j.b));
    }

    public static Word equ(Word i,Word j){
        return new Word("("+i.c+"↔"+j.c+")",(i.b&&j.b)||(!i.b&&!j.b));
    }

}
