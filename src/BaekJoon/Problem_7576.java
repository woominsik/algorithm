package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_7576 {

    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int [][] box;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        M = temp[0];
        N = temp[1];

        box = new int[N][M];

        for(int i=0;i<N;i++){
            box[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j]==1){
                    q.add(new Node(j,i));
                }
            }
        }

        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i=0;i<4;i++){
                int x = n.x+dx[i];
                int y = n.y+dy[i];
                if(x>=0 && x<M && y>=0 && y<N){

                    if(box[y][x]==0){
                        q.add(new Node(x,y));
                        box[y][x] = box[n.y][n.x]+1;
                    }
                }
            }
        }


        int answer = 0;
        boolean check = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(answer<box[i][j]){
                    answer = box[i][j];
                }
                if(box[i][j]==0){
                    check = true;
                }
            }
        }
        if(check){
            System.out.println(-1);
        }
        else
            System.out.println(answer-1);
    }
    static void print(){
        System.out.println();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(box[i][j]+ " ");
            }
            System.out.println();
        }
    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
