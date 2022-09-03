package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_16234 {
    static int [] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int [][] board;
    static int N;
    static int L;
    static int R;
    static boolean[][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        L = temp[1];
        R = temp[2];

        board = new int[N][N];

        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        int count = 0;
        while (true){
            visited = new boolean[N][N];
            int check = 0;
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(!visited[y][x]){
                        check = Math.max(check,bfs(x,y));
                    }
                }
            }
            if(check==0){
                break;
            }
            else{
                count++;
            }

        }
        System.out.println(count);

    }

    static int bfs(int x,int y){
        Queue<City> q= new LinkedList<>();
        q.add(new City(x,y,board[y][x]));
        int sum =0;
        visited[y][x] = true;

        ArrayList<int[]> al =new ArrayList<>();
        al.add(new int[]{x,y});
        sum += board[y][x];

        while(!q.isEmpty()){
            City n = q.poll();
            for(int i=0;i<4;i++){
                int nx = n.x+dx[i];
                int ny= n.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[ny][nx]){
                    int diff = Math.abs(board[n.y][n.x] - board[ny][nx]);
                    if(diff>=L && diff<=R){
                        visited[ny][nx] = true;
                        q.add(new City(nx,ny,board[ny][nx]));
                        al.add(new int[]{nx,ny});
                        sum += board[ny][nx];
                    }
                }
            }
        }
        if(al.size()>1){
            change(al,sum);
        }
        return al.size()-1;
    }

    static void change(ArrayList<int []> al, int sum){
        int num = sum/al.size();

        for(int [] arr : al){
            board[arr[1]][arr[0]] = num;
        }
    }

    static class City{
        @Override
        public String toString() {
            return "City{" +
                    "x=" + x +
                    ", y=" + y +
                    ", pnum=" + pnum +
                    '}';
        }

        int x;
        int y;
        int pnum;

        public City(int x, int y, int pnum) {
            this.x = x;
            this.y = y;
            this.pnum = pnum;
        }
    }
}
