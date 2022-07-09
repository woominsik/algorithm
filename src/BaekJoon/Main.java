package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;





class Main{
    public static void main(String[] args) throws IOException{
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
        void findNode(int n,Node node){
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


//code.oa.gg/java8/940
// 문제 : 아래 코드의 잘 못된 점을 고쳐보세요.

//class Main {
//    public static void main(String[] args) {
//        자동차 자동차 = new 자동차();
//        자동차.달리다();
//    }
//}
//
//class 자동차 {
//    void 달리다() {
//        System.out.println("자동차가 달립니다.");
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        사람 a사람1 = new 사람();
//        a사람1.이름 = "홍길동";
//        a사람1.나이 = 22;
//
//        a사람1.자기소개();
//        // 출력 : 저는 22살 홍길동 입니다.
//
//        사람 a사람2 = new 사람();
//        a사람2.이름 = "홍길순";
//        a사람2.나이 = 25;
//
//        a사람2.자기소개();
//        // 출력 : 저는 25살 홍길순 입니다.
//
//        a사람1.자기소개();
//        // 출력 : 저는 22살 홍길동 입니다.
//    }
//}
//
//class 사람 {
//    int 나이;
//    String 이름;
//
//    void 자기소개() {
//        System.out.println("저는 " + 나이 + "살 " + 이름 + " 입니다.");
//    }
//}