package BaekJoon;
// 처음에는 누적합으로 풀으려고 했으나 t값이 10의 9승 까지 크므로 메모리초과가 발생하여 틀리게 되었다.
// 2차원 배열로 해결하였다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class  Problem_11000 {

    static int N;
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        room= new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            room[i][0]=Integer.parseInt(st.nextToken());
            room[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(room[0][1]);
        for(int i=1;i<N;i++){
            if(pq.peek()<=room[i][0]){
                pq.poll();
            }
            pq.offer(room[i][1]);
        }
        System.out.println(pq.size());
    }
}
