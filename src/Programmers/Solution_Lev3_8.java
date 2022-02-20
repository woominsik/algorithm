package Programmers;


import java.util.*;
public class Solution_Lev3_8 {

    class Solution {
        public int[] solution(String[] gems) {
            Queue<String> q = new LinkedList<>();
            HashSet<String> hs = new HashSet<>();
            HashMap<String, Integer> hm = new HashMap<>();
            int start = 0;
            int end = Integer.MAX_VALUE;

            for(String s : gems) {        //보석종류
                hs.add(s);
            }
            int startPoint = 0;
            for(int i = 0; i < gems.length; i++) {
                hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1);

                q.add(gems[i]);

                while(true) {
                    String temp = q.peek();                //구간 내 보석이 1이상 있으면 start++
                    if(hm.get(temp) > 1) {
                        q.poll();
                        start++;
                        hm.put(temp, hm.get(temp) -1);
                    }else {
                        break;
                    }
                }
                if(hm.size() == hs.size() && end > q.size()) {
                    end = q.size();
                    startPoint = start;
                }


            }
            return new int[] {startPoint+1, startPoint+ end };
        }
    }

//  HashSet<String> gemSet;
//     public int[] solution(String[] gems) {
//         int[] answer = new int [2];

//         ArrayList<int []> ansList = new ArrayList<>();
//         HashMap <Integer, int[]> ansMap = new HashMap<>();
//         gemSet = new HashSet<>();
//         HashSet<String> temp= new HashSet<>();
//         ArrayList<String> now = new ArrayList<>();
//         for(String gem : gems){
//             gemSet.add(gem);
//         }
//         int start =1;
//         int end=0;
//         for(int i=0;i<gems.length;i++){
//             end=i+1;
//             temp.add(gems[i]);
//             now.add(gems[i]);
//             while(true){
//                 if(now.size()<gemSet.size()){
//                     break;
//                 }
//                 String t = now.remove(0);
//                 // if(t.equals(gems[i])||now.contains(t)){
//                 //     start++;
//                 // }
//                 if(now.contains(t)){
//                     start++;
//                 }
//                 else{
//                     now.add(0,t);
//                     break;
//                 }
//             }
//             // temp.add(gems[i]);
//             // now.add(gems[i]);
//             if(temp.size()==gemSet.size()){
//                 int[] input = new int [2];
//                 input[0]=end-start;
//                 input[1]=start;
//                 ansList.add(input);
//             }
//         }
//         Collections.sort(ansList,new Comparator<int []>(){
//            public int compare(int [] o1, int[]o2){
//                if(o1[0]==o2[0]){
//                    return o1[1]-o2[1];
//                }
//                else
//                    return o1[0]-o2[0];
//            }
//         });

//         answer[0]=ansList.get(0)[1];
//         answer[1]=answer[0]+ansList.get(0)[0];
//         return answer;
//     }
}

