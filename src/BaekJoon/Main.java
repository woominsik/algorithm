package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count=1;
        StringBuilder output = new StringBuilder();
        Stack<Integer>stack = new Stack<>();

        for(int j=0;j<n;j++){
            int tmp = Integer.parseInt(br.readLine());
//            System.out.println(tmp);
            if(count<=tmp){
                for(int i=count;i<=tmp;i++){
                    stack.push(i);
                    output.append("+\n");
//                    System.out.println("+");
                    count++;
                }
            }
//            System.out.println(stack);
            if(stack.peek()==tmp){
                stack.pop();
//                System.out.println("-");
                output.append("-\n");
            }
        }
        if(stack.isEmpty()){
            System.out.println(output);
        }
        else{
            System.out.println("NO");
        }


    }
}
