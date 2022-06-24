package Programmers;
/**
 *  https://programmers.co.kr/learn/courses/30/lessons/92341
 *  각 차가 들어오고 나갈때를 저장하는 recMap을 두고 진행하였다. 먼저 for문을 통해 저장한 후
 *  compute를 통해 시간차를 구하였다. recMap의 value값의 size가 홀수일 경우 23:59를 넣어 연산하였다.
 *  return받은 시간차를 통해 charge로 answer를 구하였다.
 *
 */

import java.util.*;

public class Solution_Lev2_44 {
    class Solution {
        int [] fee;
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            Map<String, ArrayList<String>> recMap=new HashMap<>();
            fee=fees;
            for(String rec : records){
                String []tempInfo = rec.split(" ");
                if(recMap.get(tempInfo[1])==null){
                    ArrayList<String> temp =new ArrayList<>();
                    temp.add(tempInfo[0]);
                    recMap.put(tempInfo[1],temp);
                }
                else{
                    recMap.get(tempInfo[1]).add(tempInfo[0]);
                }
            }

            List<String> keyList = new ArrayList<>(recMap.keySet());

            Map<String, Integer> carTime =new HashMap<>();
            for(String t : keyList){
                // System.out.println(t+" compute시작");
                int temp =compute(recMap.get(t));
                carTime.put(t,temp);
                // System.out.println("compute 결과 "+temp);
            }
            answer = new int[keyList.size()];
            Collections.sort(keyList);
            int cnt=0;
            for(String t : keyList){
                int temp = carTime.get(t);
                answer[cnt]=charge(temp);
                cnt++;
            }
            return answer;
        }
        int charge(int min){
            if(min>fee[0]){
                double div = (double)(min-fee[0])/fee[2];
                return fee[1]+(int)Math.ceil(div)*fee[3];
            }
            else{
                return fee[1];
            }
        }
        int compute(ArrayList<String>times){
            int res=0;
            if(times.size()%2==1){
                times.add("23:59");
            }
            for(int i=1;i<times.size();i+=2){
                String []t1 = times.get(i-1).split(":");
                String []t2 = times.get(i).split(":");
                // System.out.println(times.get(i-1)+" "+times.get(i));
                int tm1 = Integer.parseInt(t2[0])*60+Integer.parseInt(t2[1]);
                int tm2 = Integer.parseInt(t1[0])*60+Integer.parseInt(t1[1]);
                res+=(tm1-tm2);
            }
            return res;
        }
    }

}
