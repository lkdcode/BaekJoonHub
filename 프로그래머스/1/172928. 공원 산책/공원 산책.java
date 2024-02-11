class Solution {
    public int[] solution(String[] park, String[] routes) {
       
        int xSize = park.length;
        int ySize = park[0].length();

        int xIndex = 0;
        int yIndex = 0;

        String[][] map = new String[xSize][ySize];

        for (int i = 0; i < park.length; i++) {
            String location = park[i];
            int size = location.length();

            for (int j = 0; j < size; j++) {
                char ch = location.charAt(j);
                if (ch == 'S') {
                    xIndex = i;
                    yIndex = j;
                }
                map[i][j] = String.valueOf(ch);
            }
        }


        for (String route : routes) {
            String[] split = route.split(" ");

            String operation = split[0];
            int point = Integer.parseInt(split[1]);
            boolean isAbleToGo = true;

            if (operation.equals("N")) {
//                [--][]
                int newXIndex = 0;

                for (int i = 1; i <= point; i++) {
                    newXIndex = xIndex - i;

                    if (!(newXIndex >= 0)
                            || map[newXIndex][yIndex].equals("X")) {
                        isAbleToGo = false;
                        break;
                    }
                }

                if (isAbleToGo) {
                    xIndex = newXIndex;
                }
            }

            if (operation.equals("S")) {
//                [++][]
                int newXIndex = 0;

                for (int i = 1; i <= point; i++) {
                    newXIndex = xIndex + i;

                    if (!(newXIndex < xSize)
                            || map[newXIndex][yIndex].equals("X")) {
                        isAbleToGo = false;
                        break;
                    }
                }

                if (isAbleToGo) {
                    xIndex = newXIndex;
                }
            }

            if (operation.equals("W")) {
//                [][--]
                int newYindex = 0;

                for (int i = 1; i <= point; i++) {
                    newYindex = yIndex - i;
                    if (!(newYindex >= 0)
                            || map[xIndex][newYindex].equals("X")) {
                        isAbleToGo = false;
                        break;
                    }
                }

                if (isAbleToGo) {
                    yIndex = newYindex;
                }
            }

            if (operation.equals("E")) {
//                [][++]
                int newYindex = 0;

                for (int i = 1; i <= point; i++) {
                    newYindex = yIndex + i;
                    if (!(newYindex < ySize)
                            || map[xIndex][newYindex].equals("X")) {
                        isAbleToGo = false;
                        break;
                    }
                }

                if (isAbleToGo) {
                    yIndex = newYindex;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = xIndex;
        answer[1] = yIndex;
        return answer;
    }
}