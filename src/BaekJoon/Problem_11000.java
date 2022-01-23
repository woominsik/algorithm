package BaekJoon;
// 처음에는 누적합으로 풀으려고 했으나 t값이 10의 9승 까지 크므로 메모리초과가 발생하여 틀리게 되었다.
// 2차원 배열로 해결하였다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11000 {

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
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N= sc.nextInt();
//        ArrayList<Integer> al =new ArrayList<>();
//        int []prefix=new int[1000000000+1];
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<N;i++){
//            int s=sc.nextInt();
//            int t=sc.nextInt();
//            if(max>0&&s>max){
//                int a = s-max;
//                s-=a;
//                t-=a;
//            }
//            if(t>max){
//                max=t;
//            }
////            System.out.println(s+" "+t+" "+max);
//            prefix[s-1]+=1;
//            prefix[t-1]-=1;
//        }
//        for(int i=1;i<max+1;i++){
//
//            if(prefix[i-1]!=0){
//                prefix[i]+=prefix[i-1];
//            }
////            System.out.println(i+" "+prefix[i-1]+" "+prefix[i]);
//        }
////        System.out.println("max : "+max);
//        int answer=Integer.MIN_VALUE;
//        for(int i=0;i<max+1;i++){
//            if(answer<prefix[i]){
//                answer=prefix[i];
//            }
//        }
//
////        for(int i=0;i<max+1;i++){
////            System.out.print(prefix[i]+" ");
////        }
//        System.out.println(answer);
//    }
}
