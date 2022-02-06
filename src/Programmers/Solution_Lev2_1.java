package Programmers;

public class Solution_Lev2_1 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i=1; i<=n; i++) {
                int sum = 0;
                for(int j=i; j<=n; j++) {
                    sum += j;

                    if(sum==n) {
                        answer++;
                        break;
                    } else if(sum>n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
// class Solution {
//     public int solution(int n) {
//         int answer = 1;
//         int k = (int)Math.ceil((double)n/2);
//         int []arr=new int [k+1];
//         arr[0]=0;
//         // ArrayList<Integer> [] alArr = new ArrayList<>[k];
//         for(int i=1;i<k+1;i++){
//             arr[i]=arr[i-1]+i;
//             if(arr[i]==n)
//                 answer+=1;
//             if(arr[i]>n){
//                 for(int j=1;j<=i-1;j++){
//                     // System.out.println("asd "+(arr[i]-arr[j]));
//                     if(arr[i]-arr[j]==n)
//                         answer+=1;
//                     else if(arr[i]-arr[j]<n)
//                         break;
//                 }
//             }
//             System.out.println(arr[i]);
//         }
//         // for(int i=k;i>0;i--){
//         //     for(int j=k-1;j>0;j--){
//         //         if(arr[i]-arr[j]==n)
//         //             answer+=1;
//         //     }
//         // }
//         return answer;
//     }
// }
}
