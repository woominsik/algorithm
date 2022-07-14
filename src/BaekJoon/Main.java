package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.*;
import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int size = s.length();
        System.out.println(findMax(s, size, 0));
        System.out.println(findMin(s, size, 0));

    }

    private static String findMin(String str, int size, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'M') {
                k = i;
                while (k < str.length() && str.charAt(k) == 'M') {
                    k++;
                }
                sb.append(1);
                for(;i+1<k; i++){
                    sb.append(0);
                }
                i = k - 1;
            } else {
                sb.append(5);
            }
        }
        return sb.toString();
    }

    private static String findMax(String str, int size, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'M') {
                k = i;
                while(k<size && str.charAt(k)=='M'){
                    k++;
                }
                if(k==size){
                    for(;i<k; i++){
                        sb.append(1);
                    }
                }
                else{
                    sb.append(5);
                    for(;i<k; i++){
                        sb.append(0);
                    }
                }
                i=k;

            } else {
                sb.append(5);
            }
        }
        return sb.toString();
    }
}

//
//
//class Main {
//    public static void main(String[] args) {
//        ArrayList ar = new ArrayList();
//        ar.add(100);
//        ar.add(200);
//        ar.add(300);
//        ar.add(400);
//
//        int value = ar.get(0);
//        System.out.println(value);
//        // 출력 : 100
//
//        value = ar.get(1);
//        System.out.println(value);
//        // 출력 : 200
//
//        value = ar.get(2);
//        System.out.println(value);
//        // 출력 : 300
//
//        value = ar.get(3);
//        System.out.println(value);
//        // 출력 : 400
//    }
//}
//
//class ArrayList {
//    int[] datas;
//    int lastIndex;
//
//    ArrayList() {
//        datas = new int[3];
//        lastIndex = -1;
//    }
//
//    void add(int value) {
//        lastIndex++;
//        datas[lastIndex] = value;
//    }
//
//    int get(int index) {
//        return datas[index];
//    }
//}
//
//class ArrayList {
//    int[] datas;
//    int lastIndex;
//
//    ArrayList() {
//        datas = new int[1];
//        lastIndex = -1;
//    }
//
//    void add(int value) {
//        lastIndex++;
//        datas = Arrays.copyOf(datas, datas.length + 1);
//        datas[lastIndex] = value;
//    }
//
//    int get(int index) {
//        return datas[index];
//    }
//
//    int size(){
//        return lastIndex+1;
//    }
//}