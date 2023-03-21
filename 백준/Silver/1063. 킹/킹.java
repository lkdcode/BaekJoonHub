import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int END = 8;
    private static final int START = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int size = Integer.parseInt(st.nextToken());

        int kingX = king.charAt(0) - 64;
        int kingY = Integer.parseInt(String.valueOf(king.charAt(1)));

        int stoneX = stone.charAt(0) - 64;
        int stoneY = Integer.parseInt(String.valueOf(stone.charAt(1)));

        for (int i = 0; i < size; i++) {
            String input = br.readLine();

            int moveKingR = kingX + 1;
            int moveKingL = kingX - 1;
            int moveKingB = kingY - 1;
            int moveKingT = kingY + 1;

            switch (input) {
                case "R":
//             * R 한 칸 왼쪽으로 가로 +1
                    if (moveKingR == stoneX && kingY == stoneY) {
                        int moveStone = stoneX + 1;
                        if (moveStone >= START && moveStone <= 8 && moveKingR >= START && moveKingR <= END) {
                            kingX++;
                            stoneX++;
                        }
                    } else {
                        if (moveKingR >= START && moveKingR <= END) {
                            kingX++;
                        }
                    }
                    break;
                case "L":
//             * L 한 칸 왼쪽으로 가로 -1
                    if (moveKingL == stoneX && kingY == stoneY) {
                        int moveStone = stoneX - 1;
                        if (moveStone >= START && moveStone <= END && moveKingL >= START && moveKingL <= END) {
                            kingX--;
                            stoneX--;
                        }
                    } else {
                        if (moveKingL >= START && moveKingL <= END) {
                            kingX--;
                        }
                    }
                    break;
                case "B":
//             * B 한 칸 아래로 세로 -1
                    if (moveKingB == stoneY && kingX == stoneX) {
                        int moveStone = stoneY - 1;
                        if (moveStone >= START && moveStone <= END && moveKingB >= START && moveKingB <= END) {
                            kingY--;
                            stoneY--;
                        }
                    } else {
                        if (moveKingB >= START && moveKingB <= END) {
                            kingY--;
                        }
                    }
                    break;
                case "T":
//             * T 한 칸 위로 세로 +1

                    if (moveKingT == stoneY && kingX == stoneX) {
                        int moveStone = stoneY + 1;
                        if (moveStone >= START && moveStone <= END && moveKingT >= START && moveKingT <= END) {
                            kingY++;
                            stoneY++;
                        }
                    } else {
                        if (moveKingT >= START && moveKingT <= END) {
                            kingY++;
                        }
                    }

                    break;
                case "RT":
//             * RT 오른쪽 위 대각선 세로 +1 가로 +1
                    if (moveKingR == stoneX && moveKingT == stoneY) {
                        int moveStoneY = stoneY + 1;
                        int moveStoneX = stoneX + 1;
                        if (moveKingR >= START && moveKingR <= END && moveKingT >= START && moveKingT <= END
                                && moveStoneX >= START && moveStoneX <= END && moveStoneY >= START && moveStoneY <= END) {
                            kingX++;
                            kingY++;
                            stoneX++;
                            stoneY++;
                        }
                    } else {
                        if (moveKingR >= START && moveKingR <= END && moveKingT >= START && moveKingT <= END) {
                            kingX++;
                            kingY++;
                        }
                    }
                    break;
                case "LT":
//             * LT 왼쪽 위 대각선 가로 -1 세로 +1
                    if (moveKingL == stoneX && moveKingT == stoneY) {
                        int moveStoneX = stoneX - 1;
                        int moveStoneY = stoneY + 1;
                        if (moveKingL >= START && moveKingL <= END && moveKingT >= START && moveKingT <= END
                                && moveStoneX >= START && moveStoneX <= END && moveStoneY >= START && moveStoneY <= END) {
                            kingX--;
                            kingY++;
                            stoneX--;
                            stoneY++;
                        }
                    } else {
                        if (moveKingL >= START && moveKingL <= END && moveKingT >= START && moveKingT <= END) {
                            kingX--;
                            kingY++;
                        }
                    }
                    break;
                case "RB":
//             * RB 오른쪽 아래 대각선 가로 +1 세로 -1
                    if (moveKingR == stoneX && moveKingB == stoneY) {
                        int moveStoneX = stoneX + 1;
                        int moveStoneY = stoneY - 1;
                        if (moveKingR >= START && moveKingR <= END && moveKingB >= START && moveKingB <= END
                                && moveStoneX >= START && moveStoneX <= END && moveStoneY >= START && moveStoneY <= END) {
                            kingX++;
                            kingY--;
                            stoneX++;
                            stoneY--;
                        }
                    } else {
                        if (moveKingR >= START && moveKingR <= END && moveKingB >= START && moveKingB <= END) {
                            kingX++;
                            kingY--;
                        }
                    }
                    break;
                case "LB":
//             * LB 왼쪽 아래 대각선 가로 -1 세로 -1
                    if (moveKingL == stoneX && moveKingB == stoneY) {
                        int moveStoneX = stoneX - 1;
                        int moveStoneY = stoneY - 1;
                        if (moveKingL >= START && moveKingL <= END && moveKingB >= START && moveKingB <= END
                                && moveStoneX >= START && moveStoneX <= END && moveStoneY >= START && moveStoneY <= END) {
                            kingX--;
                            kingY--;
                            stoneX--;
                            stoneY--;
                        }
                    } else {
                        if (moveKingL >= START && moveKingL <= END && moveKingB >= START && moveKingB <= END) {
                            kingX--;
                            kingY--;
                        }
                    }
                    break;
            }

        }

        System.out.println((char) (kingX + 64) + "" + (kingY));
        System.out.println((char) (stoneX + 64) + "" + (stoneY));
    }

}
