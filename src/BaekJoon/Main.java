package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        List<Long> al = new ArrayList<>();
        al.add(arr[0]);
        boolean check=false;
        Long cnt=1L;
        while(true){
            cnt++;
            al=compute(al);
            if(al.contains(arr[1])){
                break;
            }
            al = al.stream()
                    .filter(t->t<arr[1])
                    .collect(Collectors.toList());
//            System.out.prLongln(al);
            if(al.size()==0){
                check=true;
                break;
            }
        }
        if(check)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }
    static ArrayList<Long> compute(List<Long>al){
        ArrayList<Long> temp = new ArrayList<>();
        for(Long i : al){
            temp.add(i*2);
            temp.add(i*10+1);
        }
        return temp;
    }
}

//class Main{
//    public static void main(String[] args) {
//        학생 a학생1 = new 학생(1, 23, "홍길동");
//        학생 a학생2 = new 학생(1, 23, "홍길동");
//
//        System.out.println(a학생1.equals(a학생2)); // true
//    }
//}
//class 학생{
//    int id;
//    int 나이;
//    String 이름;
//
//    public 학생(int id, int 나이, String 이름) {
//        this.id = id;
//        this.나이 = 나이;
//        this.이름 = 이름;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        학생 학생 = (학생) o;
//        return id == 학생.id && 나이 == 학생.나이 && 이름.equals(학생.이름);
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        생물 a생물 = new 사람();
//        System.out.println(a생물 instanceof Object);
//        System.out.println(a생물 instanceof 생물);
//        System.out.println(a생물 instanceof 동물);
//        System.out.println(a생물 instanceof 사람);
//        System.out.println(a생물 instanceof 원숭이);
//    }
//}
//class 생물 extends Object {
//}
//class 동물 extends 생물 {
//}
//class 사람 extends 동물 {
//}
//class 원숭이 extends 동물 {
//}