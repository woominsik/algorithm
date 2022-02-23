package Programmers;
// 못풀었음
// div함수를 통해 arr을 절반으로 나눈 뒤 모두 0이거나 1인지 확인한 후 맞을 경우 0이나 1의 개수에 하나를 더해주거나
// 아닐 경우 그대로 div를 4분할로 나누어 재귀적으로 호출해준다.
//


public class Solution_Lev2_10 {
    public class Solution {

        public int[] solution(int[][] arr){
            ans = new int[2];
            div(0,0,arr.length,arr);
            return ans;
        }

        private static int[] ans;

        public void div(int x, int y, int len,int[][] arr){

            boolean isZero = true;
            boolean isOne = true;


            for (int i = x; i < x+len  ; i++) {
                for (int j = y; j <y+len; j++) {
                    if(arr[i][j] == 1) isZero = false;
                    if(arr[i][j] == 0) isOne= false;
                }
            }


            if(isOne){
                ans[1]++;
                return;
            }

            if(isZero){
                ans[0]++;
                return;
            }


            div(x,y,len/2,arr);
            div(x+len/2,y,len/2,arr);
            div(x,y+len/2,len/2,arr);
            div(x+len/2,y+len/2,len/2,arr);
        }

    }
}
