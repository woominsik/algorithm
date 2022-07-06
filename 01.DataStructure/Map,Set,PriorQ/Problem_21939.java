package BaekJoon;
/**
 * treeset을 통해 problem을 순서대로 저장한다. 그리고 현재 문제의 번호와 레벨을 저장하는 map을 만든다.
 * 그리고 add 명령어가 들어오게 되면 map에 저장된 레벨을 가져와 treeset에서 해당 problem을 지우고
 * map을 통해 현재 레벨을 최신화시켜준다. 그리고  recommend를 통해 1일 경우 treeset의 last를 -1일때는 first로 반환해준다.
 * 그리고 solved또한 번호를 받아 map에서 level을 찾은 후 해당 problem을 삭제하여 풀었다.
 */
import java.util.*;

public class Problem_21939 {

    public static class Problem implements Comparable<Problem> {
        int idx;
        int level;

        public Problem(int idx, int level) {
            this.idx = idx;
            this.level = level;
        }

        //난이도 순으로 정렬 -> 문제 번호로 정렬
        public int compareTo(Problem o) {

            if (level - o.level == 0) {
                return idx - o.idx;
            } else {
                return level - o.level;
            }
        }

        public String toString(){
            return "idx : "+idx+" level : "+level;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TreeSet<Problem> ts = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nowidx = sc.nextInt();
            int nowlevel = sc.nextInt();
            ts.add(new Problem(nowidx, nowlevel));
            map.put(nowidx,nowlevel);
        }
//        System.out.println(ts.toString());
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next(   );
            if (command.equals("add")) {
                int nowidx = sc.nextInt();
                int nowlevel = sc.nextInt();
                ts.add(new Problem(nowidx, nowlevel));
                map.put(nowidx,nowlevel);
            }
            else {
                if (command.equals("recommend")) {
                    if (sc.nextInt() == 1) {
                        System.out.println(ts.last().idx);
                    } else {
                        System.out.println(ts.first().idx);
                    }
                } else {
                    int nowidx = sc.nextInt();
                    ts.remove(new Problem(nowidx,map.get(nowidx)));
                    map.remove(nowidx);
                }
            }
        }
    }
}
