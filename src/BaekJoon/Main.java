package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Main{
    static TreeMap<Integer, ArrayList<Integer>> absNum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        absNum = new TreeMap<>();
        for(int i=0;i<N;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0){
                if(absNum.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                ArrayList<Integer> temp = absNum.firstEntry().getValue();
                int key = absNum.firstEntry().getKey();
                if(temp.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                int minNum = Collections.min(temp);
                System.out.println(minNum);
                temp.remove(Integer.valueOf(minNum));
                if(temp.isEmpty()){
                    absNum.remove(Integer.valueOf(key));
                }
            }
            else{
                int abs = Math.abs(x);
                if(absNum.containsKey(abs)){
                    absNum.get(abs).add(x);
                }
                else{
                    ArrayList<Integer> temp= new ArrayList<>();
                    temp.add(x);
                    absNum.put(abs,temp);
                }
            }
        }
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