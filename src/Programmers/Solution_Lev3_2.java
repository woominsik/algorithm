package Programmers;

import java.util.*;

public class Solution_Lev3_2 {

    class Solution {
        boolean visited[];
        String[][] input;
        ArrayList<String>al;
        public String[] solution(String[][] tickets) {
            String[] answer = new String[tickets.length+1];
            al=new ArrayList<>();
            visited = new boolean [tickets.length];
            Arrays.sort(tickets, new Comparator<String []>(){
                public int compare(String [] t1,String []t2){
                    if(t1[1].compareTo(t2[1])>0)
                        return 1;
                    else
                        return -1;
                }
            });
            input=tickets;
            int startIdx=0;
            for(int i=0;i<input.length;i++){
                if(input[i][0].equals("ICN")){
                    startIdx=i;
                    break;
                }
            }
            dfs(input[startIdx],startIdx);
            // System.out.println(al);
            int count=0;
            for(String s : al){
                answer[count]=s;
                count++;
            }
            return answer;
        }
        void dfs(String []ticket,int idx){
            visited[idx]=true;
            String start=ticket[0],end=ticket[1];
            al.add(start);
            if(al.size()==input.length){
                al.add(end);
                // System.out.println("end "+ al);
                return;
            }

            // System.out.println(start + " "+end);
            for(int i=0;i<input.length;i++){
                if(visited[i]==false && input[i][0].equals(end)){
                    dfs(input[i],i);
                    if(al.size()<=input.length){
                        al.remove(al.size()-1);
                        visited[i]=false;
                    }
                }
            }

        }
    }
}

