package BaekJoon;



import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problem_21608 {
    static int sNum;
    static int N;
    static ArrayList<Seat> empty;
    static Seat [][] seats;

    static Map<Integer, ArrayList<Integer>> map;

    static ArrayList<int[]> input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int sNum = N*N;

        seats = new Seat[N+1][N+1];
        empty = new ArrayList<>();
        map = new HashMap<>();
        input = new ArrayList<>();


        for(int y=1;y<=N;y++){
            for(int x=1;x<=N;x++){
                Seat seat = new Seat(x,y,0,new ArrayList<>());
                empty.add(seat);
                seats[y][x] = seat;
            }
        }

        for(int i=0;i< empty.size();i++){ // 인접 Seat 추가
            addNear(empty.get(i));
        }

        for(int i=0;i<sNum;i++){ // 입력값 저장
            ArrayList<Integer> temp = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            int t = temp.remove(0);
            map.put(t,temp);
            sit(t);
        }
//        for(int i=0;i<sNum;i++){ // 입력값 저장
//            input.add(Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray());
//        }

//        for(int [] a : input){
//            sit(a);
//        }

//        for(int i =1;i<=N;i++){
//            for(int j=1;j<=N;j++){
//                System.out.print(seats[i][j].student+" ");
//            }
//            System.out.println();
//        }
//
//        for(int i =1;i<=N;i++){
//            for(int j=1;j<=N;j++){
//                System.out.println(seats[i][j].student+" "+seats[i][j].nearSeat);
//            }
//        }

        int answer = compute();
        System.out.println(answer);
    }

    static int compute(){
        int answer=0;
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                int st = seats[i][j].student;
                int n = countNum(map.get(st),seats[i][j].nearSeat);
                answer+=n;
            }
        }
        return answer;
    }

    static int countNum(ArrayList<Integer> likes, ArrayList<Seat> nearSeat){
        int count =0;
        for(Seat s : nearSeat){
            if(likes.contains(s.student))
                count++;
        }

        if(count==0){
            return 0;
        }
        else if(count==1){
            return 1;
        }
        else if(count==2){
            return 10;
        }
        else if (count==3) {
            return 100;
        } else if (count==4) {
            return 1000;
        }
        return 0;
    }



    static void sit(int a){
        int studNum = a;
        ArrayList<Integer> like = map.get(a);

        ArrayList<Integer> candidate = new ArrayList<>();

        int maxLike = 0;

        for(int i=0;i< empty.size();i++){ // 조건 1
            int count =0;
            Seat s = empty.get(i);
            for(Seat near : s.nearSeat){
                if(like.contains(near.student))
                    count++;
            }

            if(maxLike<count){
                maxLike = count;
            }
        }

        for(int i=0;i< empty.size();i++){ // 조건 1
            int count =0;
            Seat s = empty.get(i);
            for(Seat near : s.nearSeat){
                if(like.contains(near.student))
                    count++;
            }

            if(maxLike==count){
                candidate.add(i);
            }
        }


        if(candidate.size()==1){  //조건 1 끝
            int idx = candidate.get(0);
            Seat seat = empty.get(idx);
            seat.student = studNum;

            empty.remove(seat);
            return;
        }


        int maxCount = 0;
        ArrayList<Integer> removed = new ArrayList<>();

        for(int idx : candidate){  // 조건 2
            Seat seat = empty.get(idx);
            int count = 0;
            for(Seat near : seat.nearSeat){
                if(near.student==0){
                    count++;
                }
            }
            if(maxCount<count){
                maxCount = count;
            }
        }

        for(int idx : candidate){
            Seat seat = empty.get(idx);
            int count = 0;
            for(Seat near : seat.nearSeat){
                if(near.student==0){
                    count++;
                }
            }
            if(count<maxCount){
                removed.add(idx);
            }
        }


        candidate.removeAll(removed);



        if(candidate.size()==1){  //조건 2 끝
            int idx = candidate.get(0);
            Seat seat = empty.get(idx);
            seat.student = studNum;

            empty.remove(seat);
            return;
        }

        int idx = Collections.min(candidate); // 조건 3
        Seat seat = empty.get(idx);
        seat.student = studNum;

        empty.remove(seat);
        return;
    }


    static void addNear(Seat seat){
        if(seat.x-1>0){ // 좌측 seat 추가
            seat.nearSeat.add(empty.stream()
                    .filter(s -> s.x == seat.x-1 && s.y == seat.y)
                    .findAny()
                    .get());
        }

        if(seat.x+1<=N){ // 우측 seat 추가
            seat.nearSeat.add(empty.stream()
                    .filter(s -> s.x == seat.x+1 && s.y == seat.y)
                    .findAny()
                    .get());
        }

        if(seat.y-1>0){ // 위쪽 seat 추가
            seat.nearSeat.add(empty.stream()
                    .filter(s -> s.x == seat.x && s.y == seat.y-1)
                    .findAny()
                    .get());
        }

        if(seat.y+1<=N){ // 아래쪽 seat 추가
            seat.nearSeat.add(empty.stream()
                    .filter(s -> s.x == seat.x && s.y == seat.y+1)
                    .findAny()
                    .get());
        }
    }
}

class Seat{
    int x; // 자릿값
    int y; // 자릿값

    int student; // 학생번호 없을땐 0
    ArrayList<Seat> nearSeat; //인접 자리

    public Seat(int x, int y, int student, ArrayList<Seat> nearSeat) {
        this.x = x;
        this.y = y;
        this.student = student;
        this.nearSeat = nearSeat;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "x=" + x +
                ", y=" + y +
                ", student=" + student +
                '}';
    }
}