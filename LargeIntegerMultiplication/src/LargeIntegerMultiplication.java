public class LargeIntegerMultiplication {
    public static void main(String[] args) {
        String number1 = "212";
        String number2 = "651";
        String answer = "";
//        System.out.println(number1.substring(0, number1.length()/2) + " " + number1.substring(number1.length()/2) + " *Testing*");
        answer = multiplyLarge(number1, number2);
        System.out.println("**********************************");
        System.out.println(answer);
    }

    public static String concat0AtBack(String num, int num_Zero) { //Multiply by 10^x
        for (int i = 0; i < num_Zero; i++) {
            num += "0";
        }
        return num;
    }

    public static String multiplyLarge(String A, String B) {
        if (A.length() == 1 && B.length() == 1) {
            return Long.parseLong(A) * Long.parseLong(B) + "";
        }
        else if (A.length() == 1) {
            A = "0" + A;
        }
        else if (B.length() == 1) {
            B = "0" + B;
        }
        int maxLength = Math.max(A.length(), B.length());
        int totalLength = 2;
        for ( ; totalLength < maxLength ; totalLength *= 2); //totalLength will 2^i
        for (int i = A.length(); i < totalLength; i++) {
            A = "0" + A;
        }
        for (int i = B.length(); i < totalLength; i++) {
            B = "0" + B;
        }

        String A1, A0, B1, B0; //a = a1a0  b = b1b0
        A1 = A.substring(0, A.length()/2);
        A0 = A.substring(A.length()/2);
        B1 = B.substring(0, B.length()/2);
        B0 = B.substring(B.length()/2);
        System.out.println("----------------------------------");
        System.out.println(A1 + " " + A0 + " | " + B1 + " " + B0);

        String C, C0, C11, C1, C2;
        C2 = multiplyLarge(A1, B1);
        C0 = multiplyLarge(A0, B0);
        C11 = multiplyLarge(Long.parseLong(A1) + Long.parseLong(A0) + "" ,
                           Long.parseLong(B1) + Long.parseLong(B0) + "");
        C1 = (Long.parseLong(C11) - Long.parseLong(C2) - Long.parseLong(C0)) + "";
        C = Long.parseLong(concat0AtBack(C2, A.length()))
                + Long.parseLong(concat0AtBack(C1, A.length()/2))
                + Long.parseLong(C0) + "";

        return C;
    }



}