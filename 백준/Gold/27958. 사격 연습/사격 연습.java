import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // <-- 사격 --> //
    private static int size;
    private static int bulletSize;
    private static int[] input;
    private static int[] bulletDamage;
    private static final Queue<int[]> shootOrder = new LinkedList<>();

    // <-- 표적 --> //
    private static int[][] targetList;
    private static int[][] targetListCopy;
    private static int[][] pointList;

    private static int[] DX = {1, -1, 0, 0};
    private static int[] DY = {0, 0, 1, -1};

    private static int point = 0;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());
        bulletSize = Integer.parseInt(br.readLine());
        bulletDamage = new int[bulletSize];
        input = new int[bulletSize];
        targetList = new int[size][size];
        targetListCopy = new int[size][size];
        pointList = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                targetList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < bulletSize; i++) {
            bulletDamage[i] = Integer.parseInt(st.nextToken());
        }

        // <-- input --> //
        makeShootingOrder(size, bulletSize, 0);

        // <-- 모든 경우의 수 탐색 --> //
        while (!shootOrder.isEmpty()) {
            int[] order = shootOrder.poll();

            // <-- targetListCopy --> //
            targetListCopy = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    targetListCopy[i][j] = targetList[i][j];
                    pointList[i][j] = targetList[i][j];
                }
            }

// view
//            System.out.println(" <<<<< 슛 리스트 >>>>> ");
//            for (int i : order) {
//                System.out.print(i + "    ");
//            }
//            System.out.print(">> 점수  >>" + result);
//            System.out.println();
//            System.out.println("------------------------------");

            // <-- shoot --> //


            for (int i = 0; i < order.length; i++) {


                shoot(targetListCopy[order[i]], order[i], bulletDamage[i]);
//                view
//                for (int j = 0; j < targetListCopy.length; j++) {
//                    for (int k = 0; k < targetListCopy[j].length; k++) {
//                        System.out.print(targetListCopy[j][k] + "   ");
//                    }
//                    System.out.println();
//                }
//
//                System.out.println("총알 딜 > " + bulletDamage[i] + " ....    위치 > " + order[i] + "......... 획득한 최종 점수 point " + point);
//                System.out.println("=========================");
//                view

            }
//
//
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
            result = Math.max(result, point);
            point = 0;
        }

        System.out.println(result);
    }


    /**
     * 사격 순서를 생성하는 메서드
     *
     * @param size       : 표적의 사이즈
     * @param bulletSize : 총알의 수량
     * @param depth      : index
     */
    private static void makeShootingOrder(int size, int bulletSize, int depth) {
        if (bulletSize == depth) {
            int[] temp = new int[input.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = input[i];
            }

            shootOrder.offer(temp);
            return;
        }

        for (int i = 0; i < size; i++) {
            input[depth] = i;
            makeShootingOrder(size, bulletSize, depth + 1);
        }

    }


    /**
     * 사격!
     *
     * @param line         : 표적
     * @param row          : 열
     * @param bulletDamage : 데미지
     */
    private static void shoot(int[] line, int row, int bulletDamage) {

        // <-- shoot --> //
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 0) continue;

            int hp = line[i];

            if (hp >= 10) {
                // 보너스 표적인 경우
                targetListCopy[row][i] = 0;

                // 점수 추가
                point += pointList[row][i];

                // 해당 위치에 새로운 표적이 생길수도 있으니 점수 초기화
                pointList[row][i] = 0;

                break;
            } else if (hp <= bulletDamage) {
                // 총알 데미지가 더 쎄거나 같은 경우 (넘어뜨리는 경우)
                targetListCopy[row][i] = 0;

                // 점수 추가
                point += pointList[row][i];

                // 해당 위치에 새로운 표적이 생길수도 있으니 점수 초기화
                pointList[row][i] = 0;

                // 주변에 1/4 표적을 세워야 함.
                makeNewTarget(row, i, targetList[row][i]);
                break;
            } else {

                // 총알 데미지가 부족한 경우
                targetListCopy[row][i] -= bulletDamage;
                break;
            }

        }

    }


    /**
     * 새로운 표적을 생성하는 메서드
     *
     * @param row    : 열
     * @param column : 행
     * @param hp     : 초기 체력
     */
    private static void makeNewTarget(int row, int column, int hp) {
        for (int i = 0; i < 4; i++) {
            int xIndex = row + DX[i];
            int yIndex = column + DY[i];

            if (xIndex >= 0 && xIndex < size
                    && yIndex >= 0 && yIndex < size
                    && pointList[xIndex][yIndex] == 0
                    && targetListCopy[xIndex][yIndex] == 0) {
                pointList[xIndex][yIndex] = hp / 4;
                targetListCopy[xIndex][yIndex] = hp / 4;
            }
        }
    }

}