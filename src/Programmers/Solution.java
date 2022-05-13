package Programmers;

import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList <Integer> ans=new ArrayList<>();
        ArrayList <String> al=new ArrayList<>();
        for(int i=0;i<26;i++){
            char a=65;
            a+=i;
            String temp=String.valueOf(a);
            al.add(temp);
        }
        Queue<String> queue=new LinkedList<>();
        for(int i=0;i<msg.length();i++){
            queue.add(Character.toString(msg.charAt(i)));
        }
        
        while(!queue.isEmpty()){
            String s=queue.poll();
            if(queue.peek()!=null){
                s+=queue.peek();
                while(al.contains(s)){
                    queue.poll();

                    if(queue.peek()!=null){
                        s+=queue.peek();

                    }
                    else{
                        break;
                    }


                }
            }
            al.add(s);

            if(queue.peek()!=null){
                s=s.substring(0,s.length()-1);
            }
            // System.out.println(s);
            // System.out.println(queue);

            ans.add(al.indexOf(s)+1);
            // System.out.println(ans);
        }
        answer=new int[ans.size()];
        int i=0;
        for(int t:ans){
            answer[i]=t;
            i++;
        }
        return answer;
    }
}