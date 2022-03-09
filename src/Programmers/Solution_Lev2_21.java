package Programmers;
/* **
    minRotate를 통해 query배열과 table을 입력받아 Arraylist에 rotate할 배열을 집어넣고 Collections.min을 통해 최솟값을 구함
    Rotate함수는 query와 table을 입력받아 table을 시계방향으로 rotate시키는 함수로 진행하여 해결하였다.
 */

import java.util.*;

public class Solution_Lev2_21 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = {};
            answer=new int [queries.length];
            ArrayList<Integer> ans =new ArrayList();
            int [][] table=new int [rows][columns];
            int a=1;

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    table[i][j]=a;
                    a++;
                }
            }
            int size=0;
            for(int [] query : queries){
                rotate(table,query);
                answer[size]=minRotate(table,query);
                size++;
            }


            return answer;
        }
        public int minRotate(int [][]table,int [] query){
            ArrayList<Integer> arr=new ArrayList<Integer>();
            int x1=query[0]-1;
            int y1=query[1]-1;
            int x2=query[2]-1;
            int y2=query[3]-1;
            for(int i=y1;i<=y2;i++){
                arr.add(table[x1][i]);
                arr.add(table[x2][i]);
            }
            for(int i=x1+1;i<=x2-1;i++){
                arr.add(table[i][y1]);
                arr.add(table[i][y2]);
            }
            int a=Collections.min(arr);
            return a;
        }
        public int [][] rotate(int [][]table,int [] query){
            int x1=query[0]-1;
            int y1=query[1]-1;
            int x2=query[2]-1;
            int y2=query[3]-1;
            int [] top= new int [y2-y1+1];
            int []down=new int [y2-y1+1];
            int [] right=new int[x2-x1+1];
            int [] left =new int[x2-x1+1];
            top[0]=table[x1+1][y1];
            int degit=1;
            for(int i=y1;i<y2;i++){
                top[degit]=table[x1][i];
                degit++;
            }
            down[0]=table[x2-1][y2];
            degit=1;
            for(int i=y2;i>y1;i--){
                down[degit]=table[x2][i];
                degit++;
            }
            right[0]=table[x1][y2];
            degit=1;
            for(int i=x1+1;i<x2-1;i++){
                right[degit]=table[i][y2];
                degit++;
            }
            left[0]=table[x2][y1];
            degit=1;
            for(int i=x2-1;i>x1+1;i--){
                left[degit]=table[i][y1];
                degit++;
            }
            degit=0;
            for(int i=y1;i<=y2;i++){
                table[x1][i]=top[degit];
                degit++;
            }
            degit=0;
            for(int i=y2;i>=y1;i--){
                table[x2][i]=down[degit];
                degit++;
            }
            degit=0;
            for(int i=x1+1;i<=x2-1;i++){
                table[i][y2]=right[degit];
                degit++;
            }
            degit=0;
            for(int i=x2-1;i>=x1+1;i--){
                table[i][y1]=left[degit];
                degit++;
            }
            // for(int i=0;i<table.length;i++){
            //     for(int j=0;j<table[i].length;j++){
            //         System.out.print(table[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            return table;
        }
    }
}
