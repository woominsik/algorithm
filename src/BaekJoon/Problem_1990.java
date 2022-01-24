package BaekJoon;

// 에라토스테네스의 체 : 원하는 크기만큼의 boolean 배열 생성후 2부터 시작해서
// 각 숫자의 배수에 해당하는 boolean값을 false로 둔다. -> 소수는 모두 boolean값이 true가 되도록한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1990 {
    public static boolean[] isPrime = new boolean[100_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        eratosthenes();

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (!isPrime[i] && isPalindrome(i)) {
                sb.append(i).append("\n");
            }
        }
        sb.append(-1);

        System.out.println(sb);
    }

    public static boolean isPalindrome(int n) {
        String t = String.valueOf(n);

        for (int i = 0; i < t.length() / 2; i++) {
            if (t.charAt(i) != t.charAt(t.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void eratosthenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 100_000_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 100_000_000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}

//import java.util.Scanner;
//
//public class Problem_1990 {
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        int a =sc.nextInt();
//        int b= sc.nextInt();
//        for(int i=a;i<b;i++){
//            if(check(i)){
//                System.out.println(i);
//            }
//        }
//        System.out.println("-1");
//    }
//    static boolean check(int num) {
//        String s = Integer.toString(num);
//        for(int i=0;i<s.length()/2;i++){
//            if(s.charAt(i)==s.charAt(s.length()-1-i))
//                ;
//            else
//                return false;
//        }
//        for (int i = 2; i<=(int)Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
