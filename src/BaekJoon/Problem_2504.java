package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        String [] tmpArr = temp.split("");
        Stack<String> stack = new Stack<>();
        int answer=0;
        int mulnum=1;
        if(tmpArr[0].equals("(")){
            mulnum*=2;
        }
        else if(tmpArr[0].equals("[")){
            mulnum*=3;
        }
        else{
            System.out.println(0);
            return;
        }
        stack.push(tmpArr[0]);
        for(int i=1;i< tmpArr.length;i++){
            String tmp = tmpArr[i];
            if(tmp.equals("(")){
                mulnum*=2;
                stack.push("(");
            }
            else if(tmp.equals("[")){
                mulnum*=3;
                stack.push("[");
            }
            else if(tmp.equals(")")){

                if(stack.isEmpty()||!stack.peek().equals("(")){
                    System.out.println(0);
                    return;
                }
                if(tmpArr[i-1].equals("(")){
                    answer+=mulnum;
                }
                stack.pop();
                mulnum/=2;
            }
            else if(tmp.equals("]")){
                if(stack.isEmpty()||!stack.peek().equals("[")){
                    System.out.println(0);
                    return;
                }
                if(tmpArr[i-1].equals("[")){
                    answer+=mulnum;
                }
                stack.pop();
                mulnum/=3;
            }
        }
        if(stack.isEmpty()){
            System.out.println(answer);
        }
        else{
            System.out.println(0);
        }
    }
}
