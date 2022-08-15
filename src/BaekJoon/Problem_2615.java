package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2615 {
    static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int [19][19];

        for(int i=0;i<19;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int h=0;h<19;h++){
            int[] arr = checkHorizontal(h);

            if(arr[0]!=-1&&arr[1]!=-1){
                System.out.println(arr[1]);
                int y = h+1;  // 0,0부터 배열이 시작이므로 1씩 더해줌
                int x = arr[0]-4+1;// 0,0부터 배열이 시작이므로 1씩 더해줌
                System.out.println(y+" "+x);
                return;
            }
        }

        for(int w=0;w<19;w++){
            int [] arr = checkVertical(w);

            if(arr[0]!=-1&&arr[1]!=-1){
                System.out.println(arr[1]);
                int x = w+1;  // 0,0부터 배열이 시작이므로 1씩 더해줌
                int y = arr[0]-4+1;// 0,0부터 배열이 시작이므로 1씩 더해줌
                System.out.println(y+" "+x);
                return;
            }
        }

        for(int i=0;i<19;i++){ //가로 줄
            int [] arr = checkDiagonal1(0,i);
            if(arr[2]!=-1){
                System.out.println(arr[2]);
                int x = arr[1]-4+1;  // 0,0부터 배열이 시작이므로 1씩 더해줌
                int y = arr[0]-4+1;// 0,0부터 배열이 시작이므로 1씩 더해줌
                System.out.println(y+" "+x);
                return;
            }
        }

        for(int i=0;i<19;i++){ //세로 줄
            int [] arr = checkDiagonal1(i,0);
            if(arr[2]!=-1){
                System.out.println(arr[2]);
                int x = arr[1]-4+1;  // 0,0부터 배열이 시작이므로 1씩 더해줌
                int y = arr[0]-4+1;// 0,0부터 배열이 시작이므로 1씩 더해줌
                System.out.println(y+" "+x);
                return;
            }
        }

        for(int i=0;i<19;i++){ //가로 줄
            int [] arr = checkDiagonal2(0,i);
            if(arr[2]!=-1){
                System.out.println(arr[2]);
                int x = arr[1]+1;  // 0,0부터 배열이 시작이므로 1씩 더해줌
                int y = arr[0]+1;// 0,0부터 배열이 시작이므로 1씩 더해줌
                System.out.println(y+" "+x);
                return;
            }
        }

        for(int i=0;i<19;i++){ //세로 줄
            int [] arr = checkDiagonal2(i,18);
            if(arr[2]!=-1){
                System.out.println(arr[2]);
                int x = arr[1]+1;  // 0,0부터 배열이 시작이므로 1씩 더해줌
                int y = arr[0]+1;// 0,0부터 배열이 시작이므로 1씩 더해줌
                System.out.println(y+" "+x);
                return;
            }
        }

        System.out.println(0);
    }
    static int[] checkHorizontal(int h){
        int count = 1;
        int temp =-1;
        int [] arr = new int[2];
        arr[1] = -1;

        int end = -1;
        for(int i=1;i<19;i++){
            if(board[h][i-1]==board[h][i] && board[h][i]!=0){
                count ++;
            }
            else{
                if(count == 5){
                    break;
                }

                count = 1;
            }
            if(count == 5){
                temp = board[h][i];
                end = i;
            }
        }

        if(count == 5){
            arr[0] = end;  // 끝 자리
            arr[1] = temp; // 이긴사람 번호
        }

        return arr;
    }

    static int[] checkVertical(int w){
        int count = 1;
        int temp =-1;
        int [] arr = new int[2];
        arr[1] = -1;

        int end = -1;
        for(int i=1;i<19;i++){
            if(board[i-1][w]==board[i][w]&& board[i][w]!=0){
                count ++;
            }
            else{
                if(count == 5){
                    break;
                }

                count = 1;
            }
            if(count == 5){
                temp = board[i][w];
                end = i;
            }
        }
        if(count == 5){
            arr[0] = end;  // 끝 자리
            arr[1] = temp; // 이긴사람 번호
        }


        return arr;
    }

    static int[] checkDiagonal1(int h, int w){ // \방식의 대각선 처리 (좌측에서 우측, 상에서 하 방향)
        int count = 1;
        int temp =-1;

        int [] arr = new int[3];
        arr[2] = -1;
        for(int i=1;(h+i)<19 && (w+i)<19;i++){ // 시작점이 [h][w] 에서 대각선 방향으로 커짐
            if(board[h+i-1][w+i-1] == board[h+i][w+i] && board[h+i][w+i]!=0){
                count ++;
            }
            else{
                if(count == 5){
                    break;
                }

                count = 1;
            }
            if(count == 5){
                temp = board[h+i][w+i];
                arr[0] = h+i;
                arr[1] = w+i;
            }
        }
        if(count ==5){
            arr[2] = temp;
        }

        return arr;
    }

    static int[] checkDiagonal2(int h, int w){ // /방식의 대각선 처리(우측에서 좌측, 상에서 하 방향)
        int count = 1;
        int temp =-1;

        int [] arr = new int[3];
        arr[2] = -1;
        for(int i=1;(h+i)<19 && (w-i)>=0;i++){ // 시작점이 [h][w] 에서 대각선 방향으로 커짐
            if(board[h+i-1][w-i+1] == board[h+i][w-i] && board[h+i][w-i]!=0){
                count ++;
            }
            else{
                if(count == 5){
                    break;
                }

                count = 1;
            }
            if(count == 5){
                temp = board[h+i][w-i];

                arr[0] = h+i;
                arr[1] = w-i;
            }
        }

        if(count ==5){
            arr[2] = temp;
        }
        return arr;
    }
}
