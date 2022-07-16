package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.*;
import java.io.*;
import java.util.Arrays;


//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        ArrayList<int []> cities = new ArrayList<>();
//        for(int i=0;i<N;i++){
//            int [] temp = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//            cities.add(temp);
//        }
//        int answer =0;
//        long dist=0;
//
//        Collections.sort(cities, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1]!=o2[1]){
//                    return o2[1]-o1[1];
//                }
//                else{
//                    return o1[0]-o2[0];
//                }
//            }
//        });
//        for(int [] t : cities){
//            System.out.println(t[0]+" "+t[1]);
//        }
//
//    }
//}


class Main{
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

//
//
//class Main {
//    public static void main(String[] args) {
//        ArrayList ar = new ArrayList();
//        ar.add(100);
//        ar.add(200);
//        ar.add(300);
//        ar.add(400);
//
//        int value = ar.get(0);
//        System.out.println(value);
//        // 출력 : 100
//
//        value = ar.get(1);
//        System.out.println(value);
//        // 출력 : 200
//
//        value = ar.get(2);
//        System.out.println(value);
//        // 출력 : 300
//
//        value = ar.get(3);
//        System.out.println(value);
//        // 출력 : 400
//    }
//}
//
//class ArrayList {
//    int[] datas;
//    int lastIndex;
//
//    ArrayList() {
//        datas = new int[3];
//        lastIndex = -1;
//    }
//
//    void add(int value) {
//        lastIndex++;
//        datas[lastIndex] = value;
//    }
//
//    int get(int index) {
//        return datas[index];
//    }
//}
//
//class ArrayList {
//    int[] datas;
//    int lastIndex;
//
//    ArrayList() {
//        datas = new int[1];
//        lastIndex = -1;
//    }
//
//    void add(int value) {
//        lastIndex++;
//        datas = Arrays.copyOf(datas, datas.length + 1);
//        datas[lastIndex] = value;
//    }
//
//    int get(int index) {
//        return datas[index];
//    }
//
//    int size(){
//        return lastIndex+1;
//    }
//}