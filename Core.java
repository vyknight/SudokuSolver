import java.util.*;

public class Core {
    private final int[][] board = new int[9][9];
    private final List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private void writeToBoard(int row, int col, int val){
        if(board[row][col] == 0) {
            board[row][col] = val;
        }
    }

    // the onus of seeing if each block is complete (remain is empty) falls onto the caller

    // check row
    private Set<Integer> checkRow(int rowNum) throws IllegalBlockException{
        // return the set of missing values
        Set<Integer> remain = new HashSet<>(digits);

        for(int j = 0; j < 9; j++){
            if (board[rowNum][j] == 0) continue;
            boolean removed = remain.remove(board[rowNum][j]);
            if(!removed) throw new IllegalBlockException("row has repeats!");
        }

        return remain;
    }

    // check column
    private Set<Integer> checkCol(int colNum) throws IllegalBlockException{
        Set<Integer> remain =  new HashSet<>(digits);

        for(int i = 0; i < 9; i++){
            if(board[i][colNum] == 0) continue;
            boolean removed = remain.remove(board[i][colNum]);
            if(!removed) throw new IllegalBlockException("column has repeats!");
        }

        return remain;
    }
    private Set<Integer> checkBox(int boxX, int boxY) throws IllegalBlockException {
        // true if box is complete
        // box 0-1-2 0-1-2 grid
        Set<Integer> remain = new HashSet<>(digits);

        for(int i = boxX; i < boxX + 3; i++){
            for(int j = boxY; j < boxY + 3; j++){
                if (board[i][j] == 0) continue;
                boolean removed = remain.remove(board[i][j]);
                if(!removed){
                    // the value has already been removed, there must be an error!
                    throw new IllegalBlockException("box has repeats!");
                }
            }
        }
        return remain;
    }
    private boolean victoryScan(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0) return false;
            }
        }
        return true;
    }
}
