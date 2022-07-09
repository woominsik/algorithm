package BaekJoon;

/**
 * 직접 이진 검색 트리를 구현하여 문제를 해결하였다.
 * Tree클래스 내부 inputNode에서는 root가 널인지 판별하고 null일 경우 root에 노드를 넣어주고 아닐 경우 findNode함수를 통해
 * 해당 위치를 찾아 값을 넣어주었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Tree tree = new Tree();
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            tree.inputNode(Integer.parseInt(input));
        }
//        tree.preOrder(tree.root);
//        System.out.println();
        tree.postOrder(tree.root);
    }
    static class Node{
        int num;
        Node left;
        Node right;
    }
    static class Tree{
        Node root;
        void inputNode(int n){
            if(root ==null){
                root = new Node();
                root.num = n;
            }
            else{
                findNode(n, this.root);
            }
        }
        void findNode(int n, Node node){
            if(n<node.num){
                if(node.left==null){
                    node.left = new Node();
                    node.left.num=n;
                    return;
                }
                else{
                    findNode(n, node.left);
                }
            }
            else{
                if(node.right==null){
                    node.right = new Node();
                    node.right.num=n;
                    return;
                }
                else{
                    findNode(n, node.right);
                }
            }
        }
        void preOrder(Node node){
            if(node!=null){
                System.out.println(node.num);
                preOrder(node.left);
                preOrder(node.right);
            }
        }
        void postOrder(Node node){
            if(node!=null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.num);
            }
        }
    }
}
