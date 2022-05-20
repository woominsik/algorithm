package Programmers;
/**
 *  먼저 악보에 있는 #이 들어간 음들을 각각 다른 알파벳으로 치환한다. 치환한 후
 *  makeWhole함수를 통해 악보를 실제 재생된 음악으로 바꿔준다, 해당 음악을 compare함수를 통해 m문자열이 있는지 확인한다.
 *  m 문자열이 있을 경우 maxLen과 비교하여 클경우 해당 노래의 제목을 최신화한다.
 *  끝까지 돌린후 해당되는 노래제목이 없을 경우 (None)을 return 해준다.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_Lev2_40 {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            m=m.replace("C#","I");
            m=m.replace("D#","J");
            m=m.replace("F#","K");
            m=m.replace("G#","L");
            m=m.replace("A#","M");
            int maxLen = Integer.MIN_VALUE;
            String songname="(None)";
            // System.out.println("asd "+m);
            for(String info : musicinfos){
                String [] temp = info.split(",");
                temp[3]=temp[3].replace("C#","I");
                temp[3]=temp[3].replace("D#","J");
                temp[3]=temp[3].replace("F#","K");
                temp[3]=temp[3].replace("G#","L");
                temp[3]=temp[3].replace("A#","M");
                // System.out.println("azxc "+temp[3]);
                String wholeSong = makeWhole(temp[3], temp[0],temp[1]);
                if(compare(m,wholeSong)){
                    if(maxLen<wholeSong.length()){
                        maxLen = wholeSong.length();
                        songname = temp[2];
                    }
                }
            }
            return songname;
        }
        boolean compare(String m, String wholeSong){
            return wholeSong.contains(m);
        }
        String makeWhole(String song, String start, String end){
            int sh, sm;
            int eh,em;
            String []temp = start.split(":");
            sh=Integer.parseInt(temp[0]);
            sm=Integer.parseInt(temp[1]);
            temp = end.split(":");
            eh=Integer.parseInt(temp[0]);
            em=Integer.parseInt(temp[1]);
            int difm, difh;
            if(em>=sm){
                difm=em-sm;
                difh=eh-sh;
            }
            else{
                difm=60-(sm-em);
                difh=eh-sh-1;
            }
            int dif = difm+difh*60;
            int songLen = song.length();
            String wholeSong="";
            for(int i=0;i<dif/songLen;i++){
                wholeSong+=song;
            }
            for(int i=0;i<dif%songLen;i++){
                wholeSong+=song.charAt(i);
            }
            return wholeSong;
        }
    }
}
