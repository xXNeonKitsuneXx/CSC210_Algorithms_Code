import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Start time: " + currentTime());
        System.out.println(primeList(100));
        System.out.println("Finish time: " + currentTime());

        System.out.println();

        System.out.println("Sieve of Eratosthenes Start time: " + currentTime());
        System.out.println(sieveOfEratosthenes(100));
        System.out.println("Finish time: " + currentTime());
    }

    public static String sieveOfEratosthenes(int n){
        String result = "";
        int [] set = new int [n+1];
        for (int i = 2 ; i < n+1 ; i++){
            set[i] = i; //a= [2,3,4,5,6,...,n]
        }

        int j;
        for (int p = 2 ; p <= Math.floor(Math.sqrt(n)) ; p++){
            if (set[p] != 0) { //p is a prime
                j = p*p;
                while (j <= n){
                    set[j] = 0; //sieve
                    j += p;
                }
            }
        }

        for (int i = 2 ; i < n+1 ; i++){
            if (set[i] != 0){
                result += set[i] + ", ";
            }
        }
        return result;
    }

    public static String currentTime(){
        Calendar now = new GregorianCalendar();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millisecond = now.get(Calendar.MILLISECOND);
        int ampm = now.get(Calendar.AM_PM);

        return hour + (ampm > 0?"PM":"AM") + ":" + minute + ":" + second + ":" + millisecond;
    }

    public static String primeList(int n){
        //Brute force
        String result = "";
        int j;
        for (int i = 2 ; i <= n ; i++){
//            int j;
            for (j = 2 ; j < i ; j++){
                if (i%j == 0){ // i is divisible by j?
                    break; //not a prime
                }
            }
            if (j == i){
                result += j + ", ";
            }
        }
        result = result.substring(0, result.length()-2);
        return result;
    }

}
