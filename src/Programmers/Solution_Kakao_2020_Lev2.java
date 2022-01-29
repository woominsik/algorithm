package Programmers;
import java.util.*;
public class Solution_Kakao_2020_Lev2 {

    // import java.util.*;
// class Solution {
//     public int solution(String s) {

//         if(s.length() == 1) return 1;
//         int answer = 0;
//         ArrayList<Integer> ans =new ArrayList<Integer>();

//         for(int i =1;i<s.length();i++){
//             ArrayList<String> temp = new ArrayList<String>();

//             for(int j=0;j<s.length();j+=i){
//                 if(j+i>s.length()){
//                     temp.add(s.substring(j));
//                 }
//                 else{
//                     temp.add(s.substring(j,j+i));
//                 }
//             }

//             int tempAns=0;
//             int check=1;
//             if(!(temp.get(0).equals(temp.get(1)))){
//                 tempAns+=i;
//             }
//             for(int j=1;j<temp.size()-1;j++){
//                 if(temp.get(j).equals(temp.get(j-1))){
//                     check++;

//                 }
//                 else{
//                     if(check!=1){
//                         check++;
//                         int n= Integer.toString(check).length();
//                         tempAns+=n+i;
//                         check=1;
//                     }
//                     if(!(temp.get(j).equals(temp.get(j+1)))){
//                         tempAns+=i;
//                     }

//                 }
//             }

//             if(temp.get(temp.size()-1).equals(temp.get(temp.size()-2))){
//                 check++;
//                 int n= Integer.toString(check).length();
//                 tempAns+=n+i;
//                 check=1;
//             }
//             else{
//                 if(check!=1){
//                     check++;

//                     int n= Integer.toString(check).length();
//                     tempAns+=n+i;
//                     check=1;
//                 }
//                 tempAns+=temp.get(temp.size()-1).length();
//             }
//             ans.add(tempAns);
//         }
//         answer=Collections.min(ans);
//         return answer;
//     }
// }

    class Solution {
        public int solution(String s) {
            int answer;
            if(s.length()==1){
                return 1;
            }
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=1;i<s.length();i++){
                arr.add(calc(s,i));
            }
            answer=Collections.min(arr);
            return answer;
        }
        int calc(String s,int len){
            Queue<String> queue=new LinkedList<>();
            String sb="";
            for(int j=0;j<s.length();j+=len){
                if(j+len>s.length()){
                    queue.add(s.substring(j));
                }
                else{
                    queue.add(s.substring(j,j+len));
                }
            }
            String check=queue.poll();
            int i=1;
            while(!(queue.isEmpty())){
                if(check.equals(queue.peek())){
                    i++;
                    queue.poll();
                }
                else{
                    if(i>1){
                        sb+=Integer.toString(i);
                    }
                    sb+=check;
                    i=1;
                    check=queue.poll();
                }
            }
            if(i!=0){
                if(i>1){
                    sb+=Integer.toString(i);
                }
                sb+=check;
            }
            return sb.length();
        }
    }
}
