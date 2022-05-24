package Programmers;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 * 신고된 횟수를 저장하는 hm과 내가 신고한 사람을 저장하는 reported와 ban당한 사람의 Arraylist인 banned를 만들어 준다
 * 다음으로 report를 foreach문을 돌려준다. 각각의 String들을 " "을 통해 분리하여 신고된 사람과 신고한 사람을 나누어 저장한다.
 * 만약 같은 사람이 같은 사람을 여러번 신고해도 1번만으로 취급하여 진행한다.
 * 그 후 신고된 횟수가 k보다 큰 경우를 확인하여 banned에 넣어준다.
 * 그 후 find 함수를 통해 내가 신고한 사람중 몇명이 정지당했는지 보여줬는 지를 값을 저장하여 반환한다.
 */

import java.util.ArrayList;
import java.util.HashMap;

class Solution_Kakao_2022_Lev1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, Integer> hm =new HashMap<>();
        HashMap<String, ArrayList<String>> reported =new HashMap<>();
        for(String s : id_list){
            hm.put(s,0);
        }
        ArrayList<String> banned = new ArrayList<>();
        for(int i=0;i<report.length;i++){
            String []temp= report[i].split(" ");
            if(reported.containsKey(temp[0])){
                if(reported.get(temp[0]).contains(temp[1]))
                    ;
                else{
                    reported.get(temp[0]).add(temp[1]);
                    hm.put(temp[1],hm.get(temp[1])+1);
                }
            }
            else{
                ArrayList<String> a =new ArrayList<>();
                a.add(temp[1]);
                reported.put(temp[0],a);
                hm.put(temp[1],hm.get(temp[1])+1);
            }
        }
        for(String s : hm.keySet()){
            if(hm.get(s)>=k)
                banned.add(s);
        }
        answer = new int[id_list.length];
        int a=0;
        for(String s:id_list){
            answer[a]=find(reported.get(s),banned);
            a++;
        }
        // System.out.println(hm);
        // System.out.println(reported);
        // System.out.println(banned);
        return answer;
    }
    int find(ArrayList<String> a , ArrayList<String> b){
        if(a==null || b==null){
            // System.out.println(a);
            // System.out.println(b);
            return 0;
        }
        int count =0;
        for(String s:a){
            if(b.contains(s)){
                count++;
            }
        }
        return count;
    }
}
