package BaekJoon;
// 이분 탐색 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String []temp = s.split(" ");
        int [] num=new int [2];
        num[0]=Integer.parseInt(temp[0]);
        num[1]=Integer.parseInt(temp[1]);
        String s2 = br.readLine();
        String[] t2=s2.split(" ");
        int [] trees= new int[t2.length];
        for(int i =0;i<t2.length;i++){
            trees[i]=Integer.parseInt(t2[i]);
        }
        Arrays.sort(trees);
        int min=0;
        int max=trees[trees.length-1];
        int mid;
        int ans=0;
        while(min<=max){
//            System.out.println(min+" "+max);
            mid=(min+max)/2;
            long count=0;
            for(int i=0;i<trees.length;i++){
                if(trees[i]-mid>0){
                    count+=trees[i]-mid;
                }
            }
//            System.out.println(count+" "+num[1]);

            if(count>=num[1]){
                min=mid+1;
                ans=mid;
            }
            else{
                max=mid-1;
            }
        }

        System.out.println(ans);
    }
}
