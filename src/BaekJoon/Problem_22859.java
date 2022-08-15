package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_22859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String HTML = br.readLine();
        HTML = HTML.replaceAll("<main>","\n");
        HTML = HTML.replaceAll("</div>","\n");
        HTML = HTML.replaceAll("<p>","\n");
        HTML = HTML.replaceAll("<div","");

//        System.out.println(HTML);
        String [] temp = HTML.split("\n");

        ArrayList<String> al = new ArrayList<>();
        for(String s : temp){
            s = s.trim();
            al.add(s);
            System.out.println(s);
        }

        for(String s : al){

        }
    }
    static String remove(String s){
        ArrayList<int []> a = new ArrayList<>();

        int start=0;
        int end=0;
        boolean check = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='<'){
                start = i;
                check = true;
            }
            else if(s.charAt(i)=='>'){
                end = i;
                int [] t = new int[2];
                t[0] = start;
                t[1] = end;
            }
        }
        return null;
    }
}
