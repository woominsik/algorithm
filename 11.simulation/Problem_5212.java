package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_5212 {
    static int[] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int H;
    static int W;
    static char [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        W = temp[1];
        H = temp[0];

        board = new char[H+2][W+2];

        for(int i=0;i<H+2;i++){
            Arrays.fill(board[i],'.');
        }

        for(int i=1;i<H+1;i++){  // 겉에 .을 추가
            String s = '.'+br.readLine()+'.';
            board[i] = s.toCharArray();
        }

        change();

        int startY = 0;
        int endY =0;

        int startX = 0;
        int endX =0;

        for(int i=1;i<H+1;i++){
            boolean check = false;
            for(int j=1;j<W+1;j++){
                if(Arrays.asList(board[i][j]).contains('X')){
                    startY = i;
                    check=true;
                    break;
                }
            }
            if(check)
                break;
        }

        for(int i=H;i>=1;i--){
            boolean check = false;
            for(int j=1;j<W+1;j++){
                if(Arrays.asList(board[i][j]).contains('X')){
                    endY = i;
                    check=true;
                    break;
                }
            }
            if(check)
                break;
        }

        for(int i=1;i<W+1;i++){
            boolean check = false;
            for(int j=1;j<H+1;j++){
                if(Arrays.asList(board[j][i]).contains('X')){
                    startX = i;
                    check=true;
                    break;
                }
            }
            if(check)
                break;
        }

        for(int i=W;i>=1;i--){
            boolean check = false;
            for(int j=1;j<H+1;j++){
                if(Arrays.asList(board[j][i]).contains('X')){
                    endX = i;
                    check=true;
                    break;
                }
            }
            if(check)
                break;
        }

        for(int i=startY;i<=endY;i++){
            for(int j=startX;j<=endX;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    static void change(){
        char [][] boardCopy = new char[H+2][W+2];

        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[i].length;j++){
                boardCopy[i][j] = board[i][j];
            }
        }

        for(int i=1;i<H+1;i++){
            for(int j=1;j<W+1;j++){
                if(board[i][j]=='X'){
                    int count = 0;
                    for(int k=0;k<4;k++){
                        int nx = j+dx[k];
                        int ny = i+dy[k];
                        if(board[ny][nx]=='.')
                            count++;
                    }
                    if(count>=3){
                        boardCopy[i][j]='.';
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[i].length;j++){
                board[i][j] = boardCopy[i][j];
            }
        }
    }
}
