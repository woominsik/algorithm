package BaekJoon;

//Solution2_10과 마찬가지로 div를 통해 분할하여 풀었다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int [][]board;
    static String ans="";
    static StringBuilder sb;
    static ArrayList<Integer>[] list ;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        board =new int[len][len];
        sb=new StringBuilder();
        list = new ArrayList [len];
        for(int i=0;i<len;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<len;i++){
            String[] temp = br.readLine().split("");
            int count=0;
            for (String s : temp) {
                board[i][count]=Integer.parseInt(s);
                count++;
            }
        }
        div(0,0,len);
//        System.out.println(ans);
//        for(int i=0;i<len;i++){
//            if(!list[i].isEmpty())
//                System.out.println(list[i]);
//        }
//        System.out.println(ans);
        System.out.println(sb);
    }
    static void div(int x,int y,int len){
//        System.out.println(x+" "+y+" "+len);
        boolean isZero =true;
        boolean isOne = true;

        for (int i = x; i < x+len  ; i++) {
            for (int j = y; j <y+len; j++) {
                if(board[i][j] == 1) isZero = false;
                if(board[i][j] == 0) isOne= false;
            }
        }

        if(isOne){
            list[len-1].add(1);
            sb.append(1);
            ans+="1";
            return;
        }
        if(isZero){
            list[len-1].add(0);
            sb.append(0);
            ans+="0";
            return;
        }

        sb.append('(');

        div(x,y,len/2);
        div(x,y+len/2,len/2);
        div(x+len/2,y,len/2);
        div(x+len/2,y+len/2,len/2);

        sb.append(')');
    }
}
