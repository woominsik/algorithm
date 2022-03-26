package Programmers;
/**
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_Lev2_25 {

    class Solution {
        static int numberOfArea;
        static int maxSizeOfOneArea;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};
        static int size=0;
        public int[] solution(int m, int n, int[][] picture) {
            numberOfArea = 0;
            maxSizeOfOneArea = 0;
            int [][]visited=new int [m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if((picture[i][j]!=0)&&(visited[i][j]==0)){
                        numberOfArea++;
                        dfs(i,j,visited,picture);
                    }
                    if(size>maxSizeOfOneArea)
                        maxSizeOfOneArea=size;
                    size=0;
                }
            }
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;

        }
        public static void dfs(int m,int n, int [][]visited,int [][]picture){
            if(visited[m][n]!=0){
                return;
            }
            visited[m][n]=1;
            size++;
            int mx,ny;
            for(int i=0;i<4;i++){
                mx=m+dx[i];
                ny=n+dy[i];
                if(mx<0||mx>=picture.length||ny<0||ny>=picture[0].length)
                    continue;
                if(picture[m][n]==picture[mx][ny]&&visited[mx][ny]!=1){
                    dfs(mx,ny,visited,picture);
                }
            }
        }
    }
}
