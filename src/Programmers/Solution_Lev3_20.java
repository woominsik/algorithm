package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 * 두가지 방법을 통해 해결하였다.
 * 1. bfs를 사용하고 visited배열을 사용해서 각 노드들은 항상 lev이 최소일때 bfs를 통과한다는 것을 이용하여 해결하였다.
 * 2. visited배열에 대한 생각을 하지 못하여 Node라는 클래스를 생성하여 각각의 lev를 저장한후 Node arraylist를 정렬하여
 *    최댓값을 찾아 해당 최댓값을 가지는 모든 노드의 개수를 구해 답을 해결하였다.
 */

import java.util.*;
public class Solution_Lev3_20 {


    class Solution {
        static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        static boolean[] visited;

        public int solution(int n, int[][] edge) {
            visited = new boolean[n + 1];
            int answer;

            for (int i = 0; i <= n; i++) {
                graph.add(i, new ArrayList<>());
            }

            for (int i = 0; i < edge.length; i++) {
                graph.get(edge[i][0]).add(edge[i][1]);
                graph.get(edge[i][1]).add(edge[i][0]);
            }
            answer = bfs();
            return answer;
        }

        public static int bfs() {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;

            int cnt = 0;
            while (true) {
                Queue<Integer> temp = new LinkedList<>();

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int adj : graph.get(cur)) {
                        if (!visited[adj]) {
                            temp.add(adj);
                            visited[adj] = true;
                        }
                    }
                }

                if (temp.isEmpty()) break;
                queue.addAll(temp);
                cnt = temp.size();
            }

            return cnt;
        }
    }

//
// class Solution {
//     public int solution(int n, int[][] edge) {
//         int answer = 0;
//         boolean [][]connected=new boolean[n+1][n+1];
//         for(int []a:edge){
//             connected[a[0]][a[1]]=true;
//             connected[a[1]][a[0]]=true;
//         }
//         answer=bfs(connected,n);
//         return answer;
//     }
//     // Map<edge, depth>
//     int bfs(boolean[][]connected,int n){
//         Queue<Node> q=new LinkedList<>();
//         ArrayList<Node>al=new ArrayList<>();
//         boolean [] visited=new boolean[n+1];
//         q.add(new Node(1,0));
//         visited[1]=true;
//         while(!q.isEmpty()){
//             Node tempNode=q.poll();
//             al.add(tempNode);
//             int tempEdge=tempNode.edge;
//             int tempDepth=tempNode.depth;

//             for(int i=1;i<=n;i++){
//                 if(connected[tempEdge][i]==true&&visited[i]==false){
//                     q.add(new Node(i,tempDepth+1));
//                     visited[i]=true;
//                 }
//             }
//         }

//         Collections.sort(al, new NodeComparator());

//         int maxDepth=al.get(0).depth;
//         int num=0;
//         for(Node a:al){
//             if(a.depth==maxDepth){
//                 num++;
//             }
//             else{
//                 break;
//             }
//         }
//         return num;
//     }
//     class Node{
//         int edge;
//         int depth;
//         Node(int edge,int depth){
//             this.edge=edge;
//             this.depth=depth;
//         }
//         @Override
//         public String toString(){
//             // return Integer.toString(edge)+"번 노드 : "+Integer.toString(depth);
//             return edge+"번 노드 : "+depth;
//         }
//     }
//     class NodeComparator implements Comparator<Node>{
//         @Override
//         public int compare(Node a, Node b){
//             if(a.depth>b.depth){
//                 return -1;
//             }
//             if(b.depth>a.depth){
//                 return 1;
//             }
//             return 0;
//         }
//     }

// }
}
