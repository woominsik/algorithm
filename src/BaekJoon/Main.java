package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Main{
    static TreeSet<Integer> ts;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ts = new TreeSet<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(ts.isEmpty()||temp>ts.first()){
                    ts.add(temp);
                }
                if(ts.size()>N){
                    ts.remove(Integer.valueOf(ts.first()));
                }
            }
        }
        System.out.println(ts.first());
    }
}


















//
//class Main {
//    public static void main(String[] args) {
//        전사 a전사 = new 전사();
//
//        a전사.공격(/* 수정가능지역 시작 */"브라이언","칼"/* 수정가능지역 끝 */);
//        // 브라이언이(가) 칼(으)로 공격합니다.
//
//        a전사.공격(/* 수정가능지역 시작 */"필립","창" /* 수정가능지역 끝 */);
//        // 필립이(가) 창(으)로 공격합니다.
//
//        a전사.공격(/* 수정가능지역 시작 */"마크","지팡이" /* 수정가능지역 끝 */);
//        // 마크(가) 지팡이(으)로 공격합니다.
//    }
//}
//class 전사{
//    String name;
//    String 무기;
//
//    void 공격(String name,String 무기){
//        this.name =name;
//        this.무기 = 무기;
//        System.out.println(this.name+"이(가) "+this.무기+"(으)로 공격합니다.");
//    }
//    void 재공격(){
//        System.out.println(this.name+"이(가) "+this.무기+"(으)로 공격합니다.");
//    }
//}