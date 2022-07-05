package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;





class Main{
    static int [] parents;
    static boolean [] visited;
    static ArrayList<Integer> [] alArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        parents = new int [N+1];
        visited=new boolean[N+1];
        alArr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            alArr[i]=new ArrayList<>();
        }
        parents[1] =-1; //1번 노드는 루트

        for(int i=0;i<N-1;i++){
            String [] temp = br.readLine().split(" ");
            int [] arr = new int[2];
            arr[0]=Integer.parseInt(temp[0]);
            arr[1] = Integer.parseInt(temp[1]);
            alArr[arr[0]].add(arr[1]);
            alArr[arr[1]].add(arr[0]);
        }
        dfs(1);
        for(int i=2;i<=N;i++){
            System.out.println(parents[i]);
        }
    }
    static void dfs(int now){
        ArrayList<Integer> temp = alArr[now];
        visited[now]=true;
        for(int n : temp){
            if(!visited[n]){
                parents[n]=now;
                dfs(n);
            }
        }
    }
}

