package Programmers;
import java.util.*;
public class Solution_Kakao_2022_Lev2_2 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int lastTime = getMin("23:59");
            // 현재 파킹 중인 차들
            Map<String, Integer> parking = new HashMap<>();
            // 차들의 누적 파킹시간
            Map<String, Integer> times = new HashMap<>();
            // 차들 list
            List<String> cars = new ArrayList<>();

            for(String record : records) {
                String[] rc = record.split(" ");
                int time = getMin(rc[0]);
                String car = rc[1];

                // 새로운차 등장
                if(!cars.contains(car)) {
                    cars.add(car);
                    times.put(car, 0);
                }

                if(parking.containsKey(car)) {
                    // 현재 파킹이 되어 있다면 출차다
                    times.put( car, times.get(car)+(time-parking.get(car)) );
                    parking.remove(car);
                } else {
                    // 파킹이 안되어 있다면 입차다.
                    parking.put(car, time);
                }

            }

            int[] ret = new int[cars.size()];
            // 차번 순으로 정렬
            Collections.sort(cars);

            for(int i=0 ; i<cars.size() ; i++) {
                // 기본요금
                ret[i] = fees[1];
                String car = cars.get(i);
                // 누적시간중 기본요금 시간 제외
                int time = times.get(car)-fees[0];
                // 아직 출차가 안되었다면 마지막시간으로 정산
                if(parking.containsKey(car)) time += (lastTime-parking.get(car));
                // 요금 정산
                if(time>0) ret[i] += (Math.ceil(time/(fees[2]*1.0))*fees[3]);
            }

            return ret;
        }

        // Convert time String to Integer
        public int getMin(String time) {
            String[] t = time.split(":");
            return Integer.valueOf(t[0])*60+Integer.valueOf(t[1]);
        }

    }

// import java.util.*;
// class Solution {
//     public int[] solution(int[] fees, String[] records) {
//         int[] answer = {};
//         PriorityQueue<Integer> pq =new PriorityQueue();
//         HashMap<Integer,Integer> stay =new HashMap<>();
//         HashMap<Integer,ArrayList<String>> inout =new HashMap<>();
//         for(String s : records){
//             String []temp=s.split(" ");
//             if(inout.containsKey(Integer.parseInt(temp[1]))){
//                 inout.get(Integer.parseInt(temp[1])).add(temp[0]);
//             }
//             else{
//                 ArrayList<String> al = new ArrayList<>();
//                 al.add(temp[0]);
//                 inout.put(Integer.parseInt(temp[1]),al);
//             }
//         }
//         for(int j:inout.keySet()){
//             pq.add(j);
//             ArrayList<String> temp = inout.get(j);
//             int tempMin=0;
//             if(temp.size()%2==0){
//                 for(int i=0;i<temp.size();i+=2){
//                     tempMin+=computeTime(temp.get(i),temp.get(i+1));
//                 }
//             }
//             else{
//                 for(int i=0;i<temp.size()-1;i+=2){
//                     tempMin+=computeTime(temp.get(i),temp.get(i+1));
//                 }
//                 tempMin+=computeTime(temp.get(temp.size()-1));
//             }
//             stay.put(j,tempMin);
//         }
//         answer=new int[stay.size()];
//         int count=0;
//         for(int i: pq){
//             int min = stay.get(i);
//             if(min>fees[0]){
//                 answer[count]=fees[1]+(int)Math.ceil((min-fees[0])/(double)fees[2])*fees[3];
//             }
//             else{
//                 answer[count]=fees[1];
//             }

//             count++;
//         }
//         // System.out.println(inout);
//         // System.out.println(stay);
//         return answer;
//     }
//     int computeTime(String s1,String s2){
//         String [] time1 = s1.split(":");
//         String [] time2 = s2.split(":");
//         int hour=0,min=0;
//         hour = Integer.parseInt(time2[0])-Integer.parseInt(time1[0]);
//         if(Integer.parseInt(time2[1])>=Integer.parseInt(time1[1])){
//             min=Integer.parseInt(time2[1])-Integer.parseInt(time1[1]);
//         }
//         else{
//             hour-=1;
//             min=Integer.parseInt(time2[1])-Integer.parseInt(time1[1])+60;
//         }
//         return hour*60+min;
//     }
//     int computeTime(String s1){
//         String s2 = "23:59";
//         String [] time1 = s1.split(":");
//         String [] time2 = s2.split(":");
//         int hour=0,min=0;
//         hour = Integer.parseInt(time2[0])-Integer.parseInt(time1[0]);
//         if(Integer.parseInt(time2[1])>=Integer.parseInt(time1[1])){
//             min=Integer.parseInt(time2[1])-Integer.parseInt(time1[1]);
//         }
//         else{
//             hour-=1;
//             min=Integer.parseInt(time2[1])-Integer.parseInt(time1[1])+60;
//         }
//         return hour*60+min;
//     }
// }
}
