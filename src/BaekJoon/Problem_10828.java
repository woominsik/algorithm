package BaekJoon;

/**
 *
 * https://www.acmicpc.net/problem/10828
 * BufferedReader를 통해 n을 받아온 후 n값에 대해서
 * for문을 돌리고 String문자열 배열 temp에 저장한다.
 * 그리고 push의 경우 뒤에 숫자가 나올 수 있으므로 split(" ")으로 진행하였다.
 * 그리고 temp[0]을 통해 switch문으로 돌려 각 기능을 하는 케이스들을 만들어 진행하였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer>stack = new Stack<>();

        for(int i=0;i<n;i++){
            String[] temp = br.readLine().split(" ");
            switch(temp[0]){
                case "push":
                    stack.push(Integer.parseInt(temp[1]));
                    break;
                case "top":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(stack.peek());
                    }
                    break;

                case "pop":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(stack.pop());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;
            }
        }

    }
}
