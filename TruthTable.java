import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TruthTable {

    LinkedList<String> vars;
    LinkedList<LinkedList<Word>> combinations;
    static HashMap<String, Integer> hm;
    int counter = 0;
    static Boolean[] booleans = new Boolean[]{true, false};

    static BinaryOperator<Word> and = (i,j)->new Word(i.c+"∧"+j.c,i.b&&j.b);
    static BinaryOperator<Word> or = (i,j)->new Word(i.c+"∨"+j.c,i.b||j.b);
    static UnaryOperator<Word> not = i -> new Word("¬"+i.c,!i.b);
    static BinaryOperator<Word> xor = (i,j) -> new Word(i.c+"⊕"+j.c,(i.b&&!j.b)||(!i.b&&j.b));
    static BinaryOperator<Word> imp = (i,j) -> new Word(i.c+"→"+j.c,!(i.b&&!j.b));
    static BinaryOperator<Word> equ = (i,j) -> new Word(i.c+"↔"+j.c,(i.b&&j.b)||(!i.b&&!j.b));

    public TruthTable() {
        vars = new LinkedList<>();
        combinations = new LinkedList<>();
        combinations.add(new LinkedList<>());
        hm = new HashMap<>();
        counter = 0;
    }

    public void buildCombinations(){

        Iterator<String> itor = vars.descendingIterator();
        while(itor.hasNext()){
            String s = itor.next();
            LinkedList<LinkedList<Word>> falseSet = new LinkedList<>();
            for(List<Word> li:combinations){
                LinkedList<Word> newli = new LinkedList<>();
                for(Word w:li){
                    newli.add(w);
                }
                newli.addFirst(new Word(s,false));
                falseSet.addLast(newli);
            }
            for(LinkedList<Word> li:combinations){
                li.addFirst(new Word(s,true));
            }
//            for(List<Word> li:falseSet){
//                combinations.addLast(li);
//            }
            combinations.addAll(falseSet);
        }
    }

    public void addVar(String s){
        vars.add(s);
        hm.put(s,counter++);
    }

    public static Word v(String s, List<Word> l){
        return l.get(hm.get(s));
    }

    public static void main(String[] args) {
        TruthTable t = new TruthTable();
        t.addVar("p");
        t.addVar("q");
        t.addVar("r");

        Function<List<Word>,Word> expr =
                l -> equ.apply(imp.apply(v("p",l),not.apply(v("q",l))),
                        imp.apply(v("r",l),or.apply(v("p",l),not.apply(v("q",l)))));
        Function<List<Word>,Word> expr2 =
                l -> or.apply(v("q",l),and.apply(not.apply(v("p",l)),not.apply(v("r",l))));

        t.buildCombinations();

        for (List<Word> li:t.combinations){
            System.out.printf("%s: %s,%s\n",li,expr.apply(li),expr2.apply(li));
        }
    }


}


