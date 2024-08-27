package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode73 {
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };
//        setZeroes(matrix);
//
//        System.out.println(Arrays.deepToString(matrix));
//    }

    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        //
        for(Integer row: rows){
            setZerosToRow(matrix,row);
        }

        for(Integer col: cols){
            setZerosToColumn(matrix,col);
        }
    }
    
    public static void setZerosToColumn(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void setZerosToRow(int[][] matrix, int row){
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
}
