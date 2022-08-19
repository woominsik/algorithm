package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Problem_22859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String HTML = br.readLine();
        HTML = HTML.replaceAll("<main>","<main>\n");
        HTML = HTML.replaceAll("</div>","</div>\n");
        HTML = HTML.replaceAll("<p>","<p>\n");
        HTML = HTML.replaceAll("</p>","</p>\n");


//        System.out.println(HTML);
        String [] temp = HTML.split("\n");

        ArrayList<String> al = new ArrayList<>();
        for(String s : temp){
            s = s.trim();
            if(!s.equals("</div>"))
                al.add(s);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(String s : al){
            if(s.contains("div ")){
                s= changeStr(s);
            }
            s=remove(s).replaceAll("\\s+", " ");
            if(s.length()==0){
                al.remove(s);
            }
            if(s.length()!=0){
                ans.add(s);
            }
        }

        for(String s : ans){
            System.out.println(s);
        }
    }

    static String changeStr(String str){
        int sIdx = str.indexOf('t');
        int lIdx = str.lastIndexOf("\"");
        String t = str.substring(sIdx,lIdx+1);
        str = str.replace(t,"");

//        System.out.println("before "+str);
        str += t;

        str = str.replaceAll("="," : ");
        str = str.replaceAll("\"","");
        return str;
    }

    static String remove(String str){
        Stack<Character> stack = new Stack<>();
        String answer= "";

        for(char ch : str.toCharArray()){

            if(stack.isEmpty()){
                if(ch == '>'){
                    continue;
                }
            }
            if(ch == '<'){
                stack.push(ch);
            }else if(ch == '>'){
                stack.pop();
            }else{
                if(stack.isEmpty()){
                    answer += ch;
                }
            }
        }
        return answer;
    }
}
