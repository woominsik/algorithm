package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            String temp = sc.next();
            System.out.println(compute(temp));
        }
    }
    static int compute(String s){
//        StringBuilder right = new StringBuilder();
//        StringBuilder left = new StringBuilder();
        String right="";
        String left="";
        if(s.length()%2==1){
            right=s.substring(0,s.length()/2+1);
            left=s.substring(s.length()/2+1);
        }
        else{
            right=s.substring(0,s.length()/2);
            left=s.substring(s.length()/2);
        }

//        for(int i=0;i<s.length();i++){
//            int front=i;
//            int back = s.length()-1-i;
//            if(front>=back){
//                break;
//            }
//            right.append(s.charAt(front));
//            left.append(s.charAt(back));
//        }
//        if(s.length()%2==1){
//            right.append(s.charAt(s.length()/2+1));
//        }
        return check(right,left);
    }
    static int check(String right, String left){
        System.out.println(right+" "+left);
        int count=0;
        int ri=0;
        int li=0;
        while(true){
//            System.out.println(ri+" "+li);
            if(ri>=right.length()||li>=left.length()){
                break;
            }
            if(right.charAt(ri)==left.charAt(li)){
                ri++;
                li++;
            }
            else{
                if(right.length()-ri>left.length()-li){
                    ri++;
                    count++;
                }
                else{
                    li++;
                    count++;
                }
            }
        }
        if(count==0){
            return 0;
        }
        else if(count==1){
            return 1;
        }
        else{
            return 2;
        }
    }
}
