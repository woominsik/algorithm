package BaekJoon;

/**
 * 입력받은 값과 인접한 2의 제곱수를 구한뒤 뺸 값을 반환해주는 findNear함수를 만들고 반환값이 2보다 작을 경우
 * while문을 돈 횟수가 짝수고 나온 값이 짝수일 경우 1을 반환해주고 아닐 경우 0을 반환해준다.
 * 그리고 반복문을 돈 횟수가 홀수고 나온 값이 홀수일경우 0을 반환 아닐 경우 1을 반환하여 푼다.
 */


import java.util.Scanner;


public class Problem_18222 {
    public static void main(String[] args) {
//        while(true){
//
//        }
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long num=n;
        int count=0;
        if(n==1){
            System.out.println(0);
            return;
        }
        else if(n==2){
            System.out.println(1);
            return;
        }
        while(num>2){
            long []temp=findNear(num);
            count++;
            num=temp[1];
        }
        if(count%2==0){
            System.out.println(num%2==0?1:0);
        }
        else{
            System.out.println(num%2==0?0:1);
        }


    }
    static long[] findNear(long n){
        long temp=1;
        long [] out = new long [2];
        long count=0;
        while(n>temp){
            temp*=2;
            count++;
        }
        out[1]=n-(long)Math.pow(2,count-1);
        out[0]=count;
//        System.out.println(n+" "+out[1]);
        return out;
    }
}
