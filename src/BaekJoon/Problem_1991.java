package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for(int i=0;i<N;i++){
            String [] temp = br.readLine().split(" ");
            tree.createNode(temp[1],temp[0],temp[2]);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        Tree t = new Tree();
    }
    static class Node{
        String s;
        Node left;
        Node right;

        public Node(String s) {
            this.s = s;
        }
    }
    static class Tree{
        Node root;
        public void createNode(String left,String s, String right) {
            if(root ==null){

                root= new Node(s);
                if(!left.equals(".")){
                    Node lNode = new Node(left);
                    root.left=lNode;
                }
                if(!right.equals(".")){
                    Node rNode = new Node(right);
                    root.right=rNode;
                }
            }
            else{

                searchNode(root,s,left,right);
            }
        }
        public void searchNode(Node now, String s, String left, String right){
            if(now == null){
                return;
            }
            else if(now.s.equals(s)){
                if(!left.equals(".")){
                    Node lNode = new Node(left);
                    now.left=lNode;
                }
                if(!right.equals(".")){
                    Node rNode = new Node(right);
                    now.right=rNode;
                }
            }
            else{
                searchNode(now.left,s,left,right);
                searchNode(now.right,s,left,right);
            }
        }
        public void inOrder(Node node){
            if(node.left!=null) inOrder(node.left); //왼쪽 먼저
            System.out.print(node.s); //그 다음 중앙 출력
            if(node.right!=null) inOrder(node.right); //마지막으로 오른쪽
        }
        public void preOrder(Node node){
            if(node!=null){
                System.out.print(node.s);
                preOrder(node.left);
                preOrder(node.right);
            }
        }
        public void postOrder(Node node){
            if(node!=null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.s);
            }
        }
    }
}
