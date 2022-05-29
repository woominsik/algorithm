package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77886
 *
 */

import java.util.*;

public class Solution_Lev3_21 {

    class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];
            StringBuilder sb;

            for(int i=0; i<s.length; i++) {
                String str = s[i];
                Stack<Character> stack = new Stack<>();
                int cnt = 0;

                for(int j=0; j<str.length(); j++) {
                    char z = str.charAt(j);

                    if(stack.size()>=2) {
                        //110을 계속해서 뽑아줌, 먼제 110을 다 뽑아놓으면 어떻게 배치를 해도 110 더 나오진 않음
                        char y = stack.pop();
                        char x = stack.pop();

                        if(x=='1' && y=='1' && z=='0') {
                            cnt++;
                            continue;
                        }

                        else {
                            stack.push(x);
                            stack.push(y);
                            stack.push(z);
                        }
                    }

                    else
                        stack.push(z);
                }

                int idx = stack.size();
                boolean flag = false;
                sb = new StringBuilder();

                while(!stack.isEmpty()) {
                    //남은 문자열 중에서 제일 마지막 글자부터 1이 이어지는 부분 idx을 찾음
                    if(!flag && stack.peek()=='1')
                        idx--;
                    if(!flag && stack.peek()=='0')
                        flag = true;
                    sb.insert(0, stack.pop());
                }

                if(cnt>0) {
                    while(cnt>0) {
                        sb.insert(idx, "110");
                        //1이 존재하면 idx에 110을 갯수만큼 추가하고 0이 아예 없다면 문자열 끝에 추가
                        idx += 3;
                        cnt--;
                    }


                    answer[i] = sb.toString();
                }

                else
                    answer[i] = s[i];
                //110이 존재하지 않다면 문자열은 변하지
            }

            return answer;
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
