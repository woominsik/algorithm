package Programmers;
/* **
    list를 만든 후 인접한 4개의 블록이 모두 같을 경우 좌측 위 좌표를 point라는 객체로 바꾸어 list에 저장하였고
    list에 저장되는 값이 존재할때 까지 while문을 돌렸다
    그리고 list의 값을 빼서 인접한 4개를 모두 " "으로 바꿔주었고 " "를 dropBlock을 통해 없애주며 문제를 풀었다.
 */
import java.util.*;
public class Solution_Lev2_19 {


    class Solution {
        String [][] arr;
        ArrayList<Point> list;
        int answer=0;
        int m;
        int n;
        int [] dx ={1,1,0};
        int [] dy ={0,1,1};
        public int solution(int mnum, int nnum, String[] board) {
            answer = 0;
            m=mnum;
            n=nnum;
            arr = new String [m][n];
            for(int i=0;i<board.length;i++){
                String [] temp = board[i].split("");
                arr[i]=temp;
            }
            // for(int i=0;i<m;i++){
            //         for(int j=0;j<n;j++){
            //             System.out.print(arr[i][j]);
            //         }
            //         System.out.println();
            // }
            list =new ArrayList<>();
            while(isRight()){

                System.out.println();
                // int [] minus = new int [arr.length];
                // int [] topNum = new int [arr.length];
                for(Point p : list){
                    change(p);
                }

                dropBlock();
                // for(int i=0;i<m;i++){
                //     for(int j=0;j<n;j++){
                //         System.out.print(arr[i][j]);
                //     }
                //     System.out.println();
                // }
                list.clear();
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j].equals(" ")){
                        answer++;
                    }
                }
            }

            return answer;
        }

        void dropBlock() {
            for(int c = 0 ; c < n ; ++c) {
                for(int r = m - 1 ; r >= 0 ; --r) {
                    if(arr[r][c] == " ") {
                        for(int nr = r - 1 ; nr >= 0 ; --nr) {
                            if(arr[nr][c] != " ") {
                                arr[r][c] = arr[nr][c];
                                arr[nr][c] = " ";
                                break;
                            }
                        }
                    }
                }
            }
        }

        void change(Point p){

            int x=p.x;
            int y=p.y;
            // System.out.println(x+" "+y);
            arr[x][y]=" ";
            for(int i=0;i<3;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n){
                    arr[nx][ny]=" ";
                }

            }
        }

        boolean check(int x,int y){
            String s = arr[x][y];
            for(int i=0;i<3;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(!(nx>=0&&nx<m&&ny>=0&&ny<n)){
                    return false;
                }
                if(!arr[nx][ny].equals(s)){
                    return false;
                }
            }
            return true;
        }

        boolean isRight(){
            boolean ans=false;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n;j++){
                    boolean temp=true;
                    if(!arr[i][j].equals(" ")){
                        temp = check(i,j);
                        if(temp){
                            list.add(new Point(i,j,arr[i][j]));
                            ans=true;
                        }

                    }
                    // else{
                    //     System.out.println("aaaa");
                    // }
                }
            }
            return ans;
        }
        class Point{
            int x;
            int y;
            String s;
            Point(int x, int y, String s){
                this.x=x;
                this.y=y;
                this.s=s;
            }
        }
    }
}
