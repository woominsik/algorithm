package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;





//class Main{
//    static Map<Integer, Integer>map; //num이랑 총 자식 수
//    static ArrayList<Integer>[] alArr; // 자식을 담은 배열
//    public static void main(String[] args)throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        map = new HashMap<>();
//        alArr = new ArrayList[N];
//        for(int i=0;i<N;i++){
//            alArr[i]=new ArrayList<>();
//        }
//        String [] temp = br.readLine().split(" ");
//        int[] arr = new int[temp.length];
//        int cnt=0;
//        for(String s:temp){
//            arr[cnt]=Integer.parseInt(s);
//            cnt++;
//        }
//        int deleted = Integer.parseInt(br.readLine());
//        cnt=0;
//        for(int i:arr){
//            if(i!=-1){
//                alArr[i].add(cnt);
//            }
//            cnt++;
//        }
//
//        for(int i=N-1;i>=0;i--){
//            if(arr[i]!=-1)
//                alArr[arr[i]].addAll(alArr[i]);
//        }
//        for(int i=0;i<N;i++){
//            if(alArr[deleted].contains(i)||i==deleted){
//               map.put(i,-1);
//            }
//            else{
//                map.put(i,alArr[i].size());
//            }
//        }
//        int answer=0;
//        for(int i=0;i<N;i++){
//            if(map.get(i)==0){
//                answer++;
//            }
//
//        }
//        System.out.println(answer);
//    }
//}


