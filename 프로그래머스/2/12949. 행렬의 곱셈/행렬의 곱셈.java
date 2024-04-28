class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        final int rowSize = arr1.length;
        final int columnSize = arr2[0].length;
        final int[][] result = new int[rowSize][columnSize];

        int rowIndex = 0;
        int columnIndex = 0;

        int arrRowIndex = 0;
        int arrColumnIndex = 0;

        for (int i = 0; i < rowSize * columnSize; i++) {
            int number = 0;

            for (int j = 0; j < arr1[0].length; j++) {
                final int arr1Number = arr1[arrRowIndex][j];
                final int arr2Number = arr2[j][arrColumnIndex];
                number += (arr1Number * arr2Number);
            }

            arrColumnIndex++;

            if (arrColumnIndex >= columnSize) {
                arrRowIndex++;
                arrColumnIndex = 0;
            }

            result[rowIndex][columnIndex++] = number;
            if (columnIndex >= result[0].length) {
                rowIndex++;
                columnIndex = 0;
            }
        }

        
        return result;
    }
}