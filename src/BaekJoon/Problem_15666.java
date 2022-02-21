package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_15666 {
    static int n,m;
    static int [] arr;
    static boolean []visited;
    static ArrayList<String> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr = new int[n];
        hs=new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> al =new ArrayList<>();
            visited = new boolean[n];
            dfs(i,al);
        }
        for(String s : hs){
            System.out.println(s);
        }
    }
    static void dfs(int idx, ArrayList<Integer> al){
        visited[idx]=true;
        al.add(arr[idx]);
//        System.out.println(al);
        if(al.size() ==m){
//            for(int i:al){
//                System.out.print(i+" ");
//            }
            String t = intToString(al);
            if(!hs.contains(t))
                hs.add(t);
            return;
        }
        for(int i=0;i<n;i++){
            if(al.get(al.size()-1)<=arr[i]){
                dfs(i,al);
                al.remove(al.size()-1);
                visited[i]=false;
            }
        }
    }
    static String intToString(ArrayList<Integer> al){
        String temp = "";
        for(int i:al){
            temp+=i;
            temp+=" ";
        }
        return temp;
    }

}
