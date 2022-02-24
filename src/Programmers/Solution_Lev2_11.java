package Programmers;
// 이중 포문을 통해 connected를 false로 처리한 후 dfs를 돌려 연결된 전력망의 수를 구한 후 그 차를 구하여 반환해줬다.
// 반환받은 값을 Math.min을 통해 최소값을 구하도록 진행하여 문제를 풀었다.


public class Solution_Lev2_11 {
    class Solution {
        boolean [][] connected;
        int size;
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            size=n;
            connected = new boolean [n+1][n+1];
            for(int [] wire :wires){
                connected[wire[0]][wire[1]]=true;
                connected[wire[1]][wire[0]]=true;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i!=j){
                        boolean check=false;
                        // System.out.println("asd "+i+" "+j);
                        if(connected[i][j]){
                            connected[i][j]=false;
                            connected[j][i]=false;
                            check=true;
                        }

                        boolean [] visited = new boolean[n+1];
                        int [] temp =new int[2];
                        int c=0;
                        for(int k=1;k<=n;k++){
                            if(!visited[k]){
                                temp[c]=dfs(k,visited,temp[c]+1);
                                c++;
                            }
                        }
                        if(check==true){
                            connected[i][j]=true;
                            connected[j][i]=true;
                        }
                        // System.out.println(temp[0]+" "+temp[1]);
                        answer=Math.min(answer,Math.abs(temp[0]-temp[1]));
                    }
                }
            }
            return answer;
        }
        int dfs(int k,boolean []visited,int num){
            visited[k]=true;
            for(int i=1;i<=size;i++){
                if(!visited[i]&&connected[k][i]&&k!=i){
                    num=Math.max(num,dfs(i,visited,num+1));
                }
            }
            return num;
        }
    }
}
