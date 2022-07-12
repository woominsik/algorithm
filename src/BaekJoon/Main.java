package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static ArrayList<int []> timeList;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        timeList = new ArrayList<>();
        for(int i=0;i<N;i++){
            int [] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            timeList.add(arr);
        }
        Collections.sort(timeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });
        int end=0;
        int cnt =0;
        for(int i=0;i< timeList.size();i++){
            if(timeList.get(i)[0]>=end){
                cnt++;
                end = timeList.get(i)[1];
            }
        }

        System.out.println(cnt);

    }
}


//class Main {
//    public static void main(String[] args) {
//        저장소.저장(10);
//        저장소.저장("안녕");
//        저장소.저장(new 사람());
//        저장소.저장(new 사과());
//        저장소.저장(5.5);
//        저장소.저장(false);
//        저장소.저장('a');
//
//        // 정수 계열
//        byte b = 0; // 1바이트
//        char c = 1; // 2바이트
//        short s = 2; // 2바이트
//        int i = 3; // 4바이트
//        long l = 4; // 8바이트
//
//        // 실수 계열
//        // 4.1f => float 형 실수를 의미
//        float f = 3.14f; // 4바이트
//        // 3.141592 => double 형 실수를 의미
//        double d = 3.141592; // 8 바이트
//
//        // 논리 계열
//        boolean bl = false; // 1/8 바이트, 1비트
//
//        저장소.저장(b);
//        저장소.저장(s);
//        저장소.저장(c);
//        저장소.저장(i);
//        저장소.저장(l);
//        저장소.저장(f);
//        저장소.저장(d);
//        저장소.저장(bl);
//    }
//
//}
//class 저장소{
////    static void 저장(int t){ //모두 double로 받을 수 있다.
////
////    }
////    static void 저장(byte t){
////
////    }
////    static void 저장(char t){
////
////    }
////    static void 저장(short t){
////
////    }
////    static void 저장(long t){
////
////    }
////    static void 저장(float t){
////
////    }
//    static void 저장(double t){
//
//    }
//    static void 저장(boolean t){
//
//    }
////    static void 저장(String t){ //Object를 통해 String과 사람을 받을 수 있다.
////
////    }
////    static void 저장(사과 t){ //상속을 통해 사람으로 받을 수 있다.
////
////    }
//    static void 저장(Object t){
//
//    }
//}
//
//class 사람{
//
//}
//class 사과 extends 사람{
//
//}

//class Main {
//    public static void main(String[] args) {
//        int i = 10;
//        저장소 a = new 저장소();
//
//        // 구현 시작
//        a.저장(i);
////        a.저장(new Integer(i)); // 오토 언박싱 사용 X
//        i = (int) a.주세요();
//        // 구현 끝
//
//        System.out.println(i);
//        // 출력 : 10
//    }
//}
//class 저장소 {
//    Object data;
//
//    void 저장(Object o) {
//        data = o;
//    }
//    Object 주세요() {
//        return data;
//    }
//}