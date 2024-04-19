import java.util.*;

class Solution {
	/* 상,하,좌,우 탐색 조건 */
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    
    /* 재탐색 금지를 위한 조건문 */
    private static boolean[][] isVisitedByBfs;

	/* 주어진 2차원 배열의 최대 사이즈 */
    private static int maxRowSize;
    private static int maxColumnSize;
    
    public int solution(int[][] maps) {
	    /* 주어지는 2차원 배열의 최대 사이즈로 할당한다. */
        int answer = 0;
        maxRowSize = maps.length;
        maxColumnSize = maps[0].length;
	    
	    /* 재탐색 금지 배열 초기화 */
        isVisitedByBfs = new boolean[maxRowSize][maxColumnSize];

		/* BFS 탐색 메서드 */
        bfs(maps);

		/* 
			도착지점이 0 이면 -1을, 아니라면 maps의 값을 리턴한다.
			이렇게 하는 이유는 bfs(); 메서드를 보면 알 수 있다.
		 */
        return maps[maxRowSize - 1][maxColumnSize - 1] > 1 ? maps[maxRowSize - 1][maxColumnSize - 1] : -1;
    }
    
    private static void bfs(final int[][] maps) {
	    /* 
		    Queue 자료구조를 선언한다.
		    int[] 로 선언하는 이유는 2차원 배열의 인덱스를 그대로 담기 위함이다.
		    탐색 시작 위치는 항상 0, 0 이다.
	    */
        final Queue<int[]> queue = new LinkedList<>();
        final int[] startPosition = {0, 0};
        queue.add(startPosition);

		/* Queue 가 비어있을 때까지 반복문을 수행한다. */
        while (!queue.isEmpty()) {
	        /* 
		        queue 에서 값을 꺼낸다.
		        꺼낸 값에서 rowIndex 와 columnIndex 를 변수로 선언한다.
	        */
            final int[] position = queue.poll();
            final int rowIndex = position[0];
            final int columnIndex = position[1];
			
			/* 해당 위치를 방문처리 한다. */
            isVisitedByBfs[rowIndex][columnIndex] = true;

			/* 상,하,좌,우 탐색을 시작할 반복문이다. */
            for (int i = 0; i < DX.length; i++) {
	            /* 새로운 rowIndex와 columnIndex 를 선언한다. */
                final int newRowIndex = DX[i] + rowIndex;
                final int newColumnIndex = DY[i] + columnIndex;

                /* 1. 새로운 위치가 주어진 2차원 배열에서 유효한 위치인가? */
                if (newRowIndex >= 0 && newRowIndex < maxRowSize
                        && newColumnIndex >= 0 && newColumnIndex < maxColumnSize
                        	
						/* 2. 아직 방문한 곳이 아닌가? */
                        && !isVisitedByBfs[newRowIndex][newColumnIndex]
						
						/* 3. 갈 수 있는 곳인가? */
                        && maps[newRowIndex][newColumnIndex] != 0) {
                    
                    /* 2차원 배열을 기존 위치에서 +1 시켜준다. */
                    maps[newRowIndex][newColumnIndex] = maps[rowIndex][columnIndex] + 1;
                    
                    /* queue 에 새로운 위치를 추가시켜준다. */
                    queue.add(new int[]{newRowIndex, newColumnIndex});
                    
                    /* 방문 처리 해준다. */
                    isVisitedByBfs[newRowIndex][newColumnIndex] = true;
                }
            }
        }
    }
}