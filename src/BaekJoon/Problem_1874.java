package BaekJoon;

/**
 * 총 n번 for문을 돌게 하여 n번만큼 숫자를 입력받는다.
 * 현재 count와 tmp를 비교하여 작거나 같을 경우 count부터 tmp까지 수를 모두 stack에 저장하고 output에 +를 저장한다.
 * 그리고 스택 가장 상단에 있는 값이 tmp와 같을 경우 pop을 하고 output에 -를 저장한다.
 * for문을 모두 돌린 후 해당 stack이 비어있으면 output을 출력시키고 아닐 경우 NO를 출력하여 문제를 풀었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count=1;
        StringBuilder output = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int j=0;j<n;j++){
            int tmp = Integer.parseInt(br.readLine());

            if(count<=tmp){
                for(int i=count;i<=tmp;i++){
                    stack.push(i);
                    output.append("+\n");

                    count++;
                }
            }

            if(stack.peek()==tmp){
                stack.pop();
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
