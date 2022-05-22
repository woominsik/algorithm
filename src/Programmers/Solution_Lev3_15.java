package Programmers;

import java.util.ArrayList;

/**
 * 먼저 각 선수당 이긴선수와 진선수를 저장하는 Map을 두개 선언한 후 저장을 한다. 저장을 마친 뒤
 * 해당 선수들끼리 포함되는 이긴 선수와 진 선수를 모두 tSet에 넣어 새로 addAll을 해주어 완전히 만든다.
 * 그리고 진선수 set과 이긴 선수 set의 합이 n-1과 같을 경우 answer에 1을 더해준다.
 */
import java.util.*;
public class Solution_Lev3_15 {
    public static void main(String[] args) {
        class Solution {
            Map<Integer,HashSet<Integer>> win; // 선수번호, 이긴사람
            Map<Integer,HashSet<Integer>> lose; // 선수번호, 진 사람
            HashSet<Integer> player;
            public int solution(int n, int[][] results) {
                int answer = 0;
                win= new HashMap<>();
                lose= new HashMap<>();
                player= new HashSet<>();
                for(int [] result : results){
                    player.add(result[0]);
                    player.add(result[1]);
                    if(win.containsKey(result[0])){
                        win.get(result[0]).add(result[1]);
                    }
                    else{
                        HashSet<Integer> temp = new HashSet<>();
                        temp.add(result[1]);
                        win.put(result[0],temp);
                    }
                    if(lose.containsKey(result[1])){
                        lose.get(result[1]).add(result[0]);
                    }
                    else{
                        HashSet<Integer> temp = new HashSet<>();
                        temp.add(result[0]);
                        lose.put(result[1],temp);
                    }
                }
                // System.out.println(win);
                // System.out.println(lose);
                for(int i=0;i<n;i++){
                    for(Integer key : win.keySet()){
                        HashSet<Integer> tSet = new HashSet<>();
                        for(int asd : win.get(key)){
                            if(win.get(asd)!=null)
                                tSet.addAll(win.get(asd));
                        }
                        if(!tSet.isEmpty())
                            win.get(key).addAll(tSet);
                    }
                    for(Integer key : lose.keySet()){
                        HashSet<Integer> tSet = new HashSet<>();
                        for(int asd : lose.get(key)){
                            if(lose.get(asd)!=null)
                                tSet.addAll(lose.get(asd));
                        }
                        if(!tSet.isEmpty())
                            lose.get(key).addAll(tSet);
                    }

                }
                for(int a:player){
                    int winNum=0;
                    int loseNum=0;
                    if(win.get(a)!=null){
                        winNum=win.get(a).size();
                    }
                    if(lose.get(a)!=null){
                        loseNum = lose.get(a).size();
                    }
                    int num=winNum+loseNum;
                    if(num==n-1){
                        answer++;
                    }
                }
                return answer;
            }
        }
    }
}
