package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;





class Main{
    static Map<Integer, Integer>map; //num이랑 총 자식 수
    static HashSet<Integer>[] alSet; // 자식을 담은 배열
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        alSet = new HashSet[N];
        for(int i=0;i<N;i++){
            alSet[i]=new HashSet<>();
        }
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int i=0;i<N;i++){
            if(arr[i]!=-1)
                alSet[arr[i]].add(i);
        }
        for(int i=0;i<N;i++){
            if(alSet[i].size()==0){
                dfs(i);
            }
        }
//        for(HashSet<Integer>s : alSet){
//            System.out.println(s);
//        }
        int deleted = Integer.parseInt(br.readLine());
        int answer=0;
        for(int i=0;i<N;i++){
            if(i!=deleted&&!alSet[deleted].contains(i)){
                alSet[i].remove(deleted);
                alSet[i].removeAll(alSet[deleted]);
                if(alSet[i].size()==0){
//                    System.out.println(i+" "+alSet[i]);
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }
    static void dfs(int i){
       if(arr[i]==-1){
           return;
       }
       else{
           alSet[arr[i]].addAll(alSet[i]);
           dfs(arr[i]);
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