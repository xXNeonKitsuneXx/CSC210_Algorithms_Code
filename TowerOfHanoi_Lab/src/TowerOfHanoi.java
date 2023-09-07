import java.util.Stack;

public class TowerOfHanoi {
    Stack<Integer> pegA;
    Stack<Integer> pegB;
    Stack<Integer> pegC;
    int amountOfDisks;
    int ithMove;

    public TowerOfHanoi (int disks){
        pegA = new Stack<Integer>();
        pegB = new Stack<Integer>();
        pegC = new Stack<Integer>();
        amountOfDisks = disks;
        ithMove = 0;

        for (int i = amountOfDisks; i > 0; i--) {
            pegA.push(i);
        }

    }

    public void play(){
        for (int i = amountOfDisks-1; i >= 0; i--) {
            System.out.println(pegA.elementAt(i));
        }
        System.out.println("---------------");
        move(pegA.size(), pegA, pegC, pegB);
    }

    public void move(int n, Stack fromPeg, Stack toPeg, Stack availablePeg){
        if (n == 1){
            toPeg.push(fromPeg.pop());
            ithMove++;
            showTowerOfHanoi();
            return;
        }
        move(n-1, fromPeg, availablePeg, toPeg);
        move(1, fromPeg, toPeg, availablePeg);
        move(n-1, availablePeg, toPeg, fromPeg);

    }

    public void showTowerOfHanoi(){
        int maxLine;
        if (pegA.size() >= pegB.size() && pegA.size() >= pegC.size()){
            maxLine = pegA.size() - 1;
        }
        else if (pegB.size() >= pegA.size() && pegB.size() >= pegC.size()) {
            maxLine = pegB.size() - 1;
        }
//        else if (pegC.size() >= pegA.size() && pegC.size() >= pegB.size()) {
//            maxLine = pegC.size() - 1;
//        }
        else {
            maxLine = pegC.size() - 1;
        }


        for (int i = maxLine; i >= 0; i--) {
            if (pegA.size() - 1 >= i){
                System.out.print(pegA.elementAt(i) + "   ");
            }
            else {
                System.out.print("    ");
            }

            if (pegB.size() - 1 >= i){
                System.out.print(pegB.elementAt(i) + "   ");
            }
            else {
                System.out.print("    ");
            }

            if (pegC.size() - 1 >= i){
                System.out.print(pegC.elementAt(i) + "   ");
            }
            else {
                System.out.print("    ");
            }
            System.out.println();

        }
        System.out.println("Move" + ithMove + "-----------");
    }

    //
    // 2
    // 3        1
    //----------------
    // 3    2   1
    //----------------
    //      1
    // 3
    //----------------
    //      1
    //      2   3
    //----------------
    //
    //
    // ...
    //----------------
    //          1
    //          2
    //          3
    //








}
