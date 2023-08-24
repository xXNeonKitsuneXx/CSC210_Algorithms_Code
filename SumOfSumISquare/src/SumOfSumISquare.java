public class SumOfSumISquare {
    public static void main(String[] args) {
        double answer;
        long n = 500;

        long start, end;

        start = System.currentTimeMillis();
        answer = sumOfSumISquare(n); //O(n^2)
        end = System.currentTimeMillis();
        System.out.println(answer + " for " + (end-start) + " milliseconds");

        start = System.currentTimeMillis();
        answer = sumOfSumISquareUseFormula(n); //O(n)
        end = System.currentTimeMillis();
        System.out.println(answer + " for " + (end-start) + " milliseconds");

        start = System.currentTimeMillis();
        answer = sumOfSumISquareByAddition(n); //O(n^3)
        end = System.currentTimeMillis();
        System.out.println(answer + " for " + (end-start) + " milliseconds");

        start = System.currentTimeMillis();
        answer = sumOfSumISquareReuse(n); //O(n)
        end = System.currentTimeMillis();
        System.out.println(answer + " (reuse sum of i^2) for " + (end-start) + " milliseconds");


        double [][]timeArray = new double [5][4];
        int count = 0;

        for (n = 50 , count = 0 ; n < 5000 ; n*=10, count++) { //500000
            start = System.currentTimeMillis();
            answer = sumOfSumISquare(n); //O(n^2)
            end = System.currentTimeMillis();
            timeArray[count][0] = end-start;

            start = System.currentTimeMillis();
            answer = sumOfSumISquareUseFormula(n); //O(n)
            end = System.currentTimeMillis();
            timeArray[count][1] = end-start;

            start = System.currentTimeMillis();
            answer = sumOfSumISquareByAddition(n); //O(n^3)
            end = System.currentTimeMillis();
            timeArray[count][2] = end-start;

            start = System.currentTimeMillis();
            answer = sumOfSumISquareReuse(n); //O(n)
            end = System.currentTimeMillis();
            timeArray[count][3] = end-start;
        }

        for (int i = 0 ; i < timeArray.length ; i++) {
            for (int j = 0 ; j < timeArray[0].length ; j++) {
                System.out.print(timeArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double sumOfSumISquare(long n){ //O(n^2)
        double sumOfSum = 0;
        for (double j = 1 ; j <= n ; j++){
            double sumISquare = 0;
            for (double i = 1 ; i <= j  ; i++) {
                sumISquare += i*i;
            }
            sumOfSum += sumISquare;
        }
        return sumOfSum;
    }

    public static double sumOfSumISquareUseFormula(long n){ //O(n)
        double sumOfSum = 0;
        for (double j = 1 ; j <= n ; j++) {
            double sumISquare = (j*(j+1)*(2*j+1))/6;
            sumOfSum += sumISquare;
        }
        return sumOfSum;
    }

    public static double sumOfSumISquareByAddition(long n){ //O(n^3)
        double sumOfSum = 0;
        for (double j = 1 ; j <= n ; j++){
            double sumISquare = 0;
            for (double i = 1 ; i <= j  ; i++) {
                double iSquare = 0;
                for (double k = 1 ; k <= i ; k++) {
                    iSquare += i;
                }
                sumISquare += iSquare;
            }
            sumOfSum += sumISquare;
        }
        return sumOfSum;
    }

    public static double sumOfSumISquareReuse(long n){ //O(n)
        double sumOfSum = 0;
        double sumISquare = 0;
        for (double j = 1 ; j <= n ; j++){
            sumISquare += j*j;
            sumOfSum += sumISquare;
        }
        return sumOfSum;



    }
}