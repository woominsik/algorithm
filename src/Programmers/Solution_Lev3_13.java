package Programmers;
import java.util.*;

/**
 * genre이름과 각 노래들을 저장해놓은 genreSong과 genre와 총 plays횟수를 저장한 genrePlays를 선언한 후
 * for문을 통해 모두 저장을 한 후 glist를 만들어 총 plays횟수를 내림차순으로 정렬시켜준다.
 * 정렬된 glist를 통해 for문을 돌려 song Arraylist를 가져와 내림차순으로 정렬시켜주고 상위 2개를 뺴주어 값을 구한다.
 */

public class Solution_Lev3_13 {
    public static void main(String[] args) {
        class Solution {
            Map<String,ArrayList<Song>> genreSong;
            Map<String,Integer> genrePlays;
            public int[] solution(String[] genres, int[] plays) {
                int[] answer = {};
                ArrayList<Integer> ans = new ArrayList<>();
                ArrayList<String> glist = new ArrayList<>();
                genreSong = new HashMap<>();
                genrePlays = new HashMap<>();
                for(int i=0;i<genres.length;i++){
                    Song tmpSong = new Song(i,plays[i],genres[i]);
                    if(genreSong.containsKey(genres[i])){
                        ArrayList temp=new ArrayList<>();
                        int num=genrePlays.get(genres[i])+plays[i];
                        genrePlays.put(genres[i],num);
                        temp=genreSong.get(genres[i]);
                        temp.add(tmpSong);
                    }
                    else{
                        glist.add(genres[i]);
                        ArrayList temp=new ArrayList<>();
                        int num=plays[i];
                        genrePlays.put(genres[i],num);
                        temp.add(tmpSong);
                        genreSong.put(genres[i],temp);
                    }
                }

                Collections.sort(glist, new Comparator<String>(){
                    @Override
                    public int compare(String s1, String s2){
                        return genrePlays.get(s2)-genrePlays.get(s1);
                    }
                });


                // System.out.println(genrePlays);
                for(String s : glist){
                    ArrayList<Song> temp = genreSong.get(s);
                    if(temp.size()>1){
                        Collections.sort(temp, new Comparator<Song>(){
                            @Override
                            public int compare(Song t1,Song t2){
                                if(t1.plays>t2.plays){
                                    return -1;
                                }
                                else{
                                    return 1;
                                }
                            }
                        });
                        ans.add(temp.get(0).idx);
                        ans.add(temp.get(1).idx);
                    }
                    else{
                        ans.add(temp.get(0).idx);
                    }
                }
                answer=new int[ans.size()];
                int c=0;
                for(int a:ans){
                    answer[c]=a;
                    c++;
                }
                // System.out.println(ans);
                return answer;
            }

            class Song{
                int idx;
                int plays;
                String genre;
                Song(int idx,int plays, String genre){
                    this.idx=idx;
                    this.plays=plays;
                    this.genre=genre;
                }
                public String toString(){
                    return idx+" "+plays+" "+genre;
                }
            }
            class Genre{
                int plays;
                String name;
                Genre(int plays,String name){
                    this.name=name;
                    this.plays=plays;
                }
            }
        }
    }
}
