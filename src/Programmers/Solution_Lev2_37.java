package Programmers;
/**
 *
 */

import java.util.*;

public class Solution_Lev2_37 {

    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            s=s.substring(1);
            s=s.substring(0,s.length()-1);
            s=s.replace("},","}");
            String[] tmp=s.split("}");
            ArrayList<Integer> ans=new ArrayList<>();
            ArrayList<int[]> tmpInt=new ArrayList<>();
            for(int i=0;i<tmp.length;i++){
                tmp[i]=tmp[i].replace("{","");
                tmp[i]=tmp[i].replace(","," ");
            }
            for(int i=0;i<tmp.length;i++){
                ArrayList<Integer> al=new ArrayList<>();
//             for(int j=0;j<tmp[i].length();j++){
//                 if(tmp[i].charAt(j)!=' '){
//                     al.add(Character.getNumericValue(tmp[i].charAt(j)));

//                 }
//             }
                int tmpNum=0;
                for(int j=0;j<tmp[i].length();j++){
                    if(tmp[i].charAt(j)!=' '){
                        tmpNum=tmpNum*10+Character.getNumericValue(tmp[i].charAt(j));

                    }
                    else{
                        al.add(tmpNum);
                        tmpNum=0;
                    }
                }
                if(tmpNum!=0){
                    al.add(tmpNum);
                    tmpNum=0;
                }
                int []asd=new int[al.size()];
                int y=0;
                for(int x:al){
                    asd[y]=x;
                    y++;
                }
                tmpInt.add(asd);
            }
            Collections.sort(tmpInt,new Comparator<int[]>(){
                @Override
                public int compare(int []o1,int []o2){
                    if(o1.length>o2.length){
                        return 1;
                    }
                    else if(o1.length==o2.length){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            });

            for(int [] a:tmpInt){
                for(int i=0;i<a.length;i++){
                    if(!(ans.contains(a[i]))){
                        ans.add(a[i]);
                    }
                }
            }
            answer=new int [ans.size()];
            int b=0;
            for(int a:ans){
                answer[b]=a;
                b++;
            }

            // System.out.println(s);
            return answer;
        }
    }
}
