# DMTruthTable
An Expression Evaluator, created for Discrete Math Homework.

`TruthTable.java`: Functional Style.

`TruthTableOOP.java`: Traditional OOP Style.

## Example Input and output
```Java
public static Word eval2(List<Word> l){
    Word p = l.get(0);
    Word q = l.get(1);
    Word r = l.get(2);
    return p.imp(not(q)).equ(r.imp(p.or(not(q))));
}
```
```
[p=T, q=T, r=T]: ((p→(¬q))↔(r→(p∨(¬q))))=F
[p=T, q=T, r=F]: ((p→(¬q))↔(r→(p∨(¬q))))=F
[p=T, q=F, r=T]: ((p→(¬q))↔(r→(p∨(¬q))))=T
[p=T, q=F, r=F]: ((p→(¬q))↔(r→(p∨(¬q))))=T
[p=F, q=T, r=T]: ((p→(¬q))↔(r→(p∨(¬q))))=F
[p=F, q=T, r=F]: ((p→(¬q))↔(r→(p∨(¬q))))=T
[p=F, q=F, r=T]: ((p→(¬q))↔(r→(p∨(¬q))))=T
[p=F, q=F, r=F]: ((p→(¬q))↔(r→(p∨(¬q))))=T
```

## Usage
1. Put `TruthTable.java`, `TruthTableOOP.java` in the same path.
2. Open `TruthTableOOP.java`
3. First add variables, see main() method
4. Then change logical expressions, see eval2() method
5. Run and enjoy!

## TODO
- [x] make it usable.
- [ ] find a more elegent way of inputting expressions (maybe text parsing?)
- [ ] find a more efficient way of creating combinations (maybe iterator?)
