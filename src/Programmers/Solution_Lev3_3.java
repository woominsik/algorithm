package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_Lev3_3 {
    class Solution {
        int answer;
        public int solution(String begin, String target, String[] words) {
            answer=51;
            if(!Arrays.asList(words).contains(target)){
                return 0;
            }
            else{
                boolean [] visited=new boolean[words.length+1];
                // System.out.println();
                dfs(begin,target,begin,words,visited,0);
                if(answer==51){
                    return 0;
                }
                return answer;
            }

        }
        void dfs(String begin, String target, String temp, String[] words,boolean[] visited,int level){
            if(temp.equals(begin)){
                visited[0]=true;
            }
            else if(temp.equals(target)){
                if(answer>level){
                    answer= level;
                }
                return;
            }
            else{
                for(int i=0;i<words.length;i++){
                    if(words[i].equals(temp)){
                        visited[i+1]=true;
                    }
                }
            }
            for(int i=0;i<words.length;i++){
                if(!visited[i+1]&&compare(temp,words[i])){
                    int tmpLevel=level+1;
                    if(compare(temp,target)){
                        dfs(begin,target,target,words,visited,tmpLevel);
                    }
                    else{
                        dfs(begin,target,words[i],words,visited,tmpLevel);
                    }
                }
            }
        }
        boolean compare(String begin, String compared){
            int check=0;
            for(int i=0;i<begin.length();i++){
                if(begin.charAt(i)!=compared.charAt(i)){
                    check++;
                }
            }
            if(check==1){
                return true;
            }
            else
                return false;
        }
    }
}

