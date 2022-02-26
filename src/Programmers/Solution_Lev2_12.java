package Programmers;
// 처음에는 bfs로 풀려 했으나 효율성 부분에서 시간을 초과하여 틀리게 되어 답을 참고했다.
// 먼저 입력된 board의 가로길이와 세로길이 모두 1씩 큰 배열을 생성한 후 1,1지역 부터 board의 0,0값을 넣기 시작한다.
// 그리고 1,1부터 값을 확인하여 1일 경우, 왼쪽, 위쪽, 왼쪽 대각선 위를 모두 확인한 후 그 3개의 값들 중 최솟값으로 변경한다.
// 이 과정을 계속 진행하면서 각각의 값끼리 크기 비교를 하여 큰 값의 제곱을 answer에 저장한다.



public class Solution_Lev2_12 {
    class Solution
    {
        public int solution(int [][]board)
        {
            int answer = 0;
            int[][] newBoard = new int[board.length+1][board[0].length+1];
            // 새로운 배열 생성
            for(int i=0; i<board.length; i++)
                for(int j=0; j<board[i].length; j++)
                    newBoard[i+1][j+1] = board[i][j];

            int max = 0;

            // 만들 수 있는 정사각형 검사
            for(int i=1; i<newBoard.length; i++){
                for(int j=1; j<newBoard[i].length; j++){
                    /* 2x2 사각형의 우측하단 꼭짓점을 기준으로 정사각형이 되는지 체크한다.
                     * 현재 값이 1인경우 좌←, 상↑, 좌상↖ 체크
                     * ←, ↑, ↖ 값이 모두 1인경우 정사각형을 만들 수 있음
                     */
                    if(newBoard[i][j] == 1){
                        int left = newBoard[i-1][j];    // 좌측 값
                        int up = newBoard[i][j-1];      // 상단 값
                        int leftUp = newBoard[i-1][j-1];// 좌측상단(대각선) 값
                        int min = Math.min(left, Math.min(up, leftUp));
                        newBoard[i][j] = min+1;
                        max = Math.max(max, min+1);
                    }
                }
            }
            answer = max * max;
            return answer;
        }
    }
}
