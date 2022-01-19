package Programmers;

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
