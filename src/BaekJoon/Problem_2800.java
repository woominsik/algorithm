package BaekJoon;
/**
 * 못 풀었음...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem_2800 {
    static ArrayList<String> ans;
    static int maxDepth;
    static ArrayList<Integer []>map;
    static String input;
    static boolean []visited;
    static ArrayList<Integer> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        input=temp;
        ans = new ArrayList<>();
        String [] tmpArr = temp.split("");
        map = new ArrayList<>();
        int count=0;

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< tmpArr.length;i++){
            if(tmpArr[i].equals("(")){
                stack.push(i);
            }
            else if(tmpArr[i].equals(")")){
                Integer [] arr = new Integer[2];
                arr[0]=stack.pop();
                arr[1]=i;
                map.add(arr);
            }
        }
        maxDepth = map.size();
        Collections.reverse(map);
        al=new ArrayList<>();
        for(int i=1;i<map.size();i++){
            visited = new boolean[map.size()];
            al.clear();
            dfs(i,0);
        }
        StringBuilder t = new StringBuilder();
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)=='('||temp.charAt(i)==')'){
                ;
            }
            else{
                t.append(temp.charAt(i));
            }
        }
        ans.add(t.toString());
        Collections.sort(ans);
        for(String s : ans){
            System.out.println(s);
        }
    }


    public static void dfs(int len, int now){
        if(now>=len){
            save(al);
            return;
        }
        for(int i=0;i<maxDepth;i++){
            if(!visited[i]){
                al.add(i);
                visited[i]=true;
                dfs(len,now+1);
                visited[i]=false;
                al.remove(Integer.valueOf(i));
            }
        }
    }
    public static void save(ArrayList<Integer> al){
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i : al){
            temp.addAll(List.of(map.get(i)));
        }
        for(int i=0;i<input.length();i++){
            if(!temp.contains(i)){
                sb.append(input.charAt(i));
            }
        }
        if(!ans.contains(sb.toString())){
            ans.add(sb.toString());
        }

    }
}
