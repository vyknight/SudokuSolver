public class SimpleScanner {
    private final int[][] ColBlock = new int[9][9];
    private final int[][] RowBlock = new int[9][9];

    // scans a row for whether the specified val. Return true if the row is already occupied by that val
    private boolean scanRow(int row, int val){
        for(int i: RowBlock[row - 1]){
            if(i == val){return true;}
        }
        return false;
    }

    // same as above but scans a column
    private boolean scanCol(int col, int val){
        for(int i: ColBlock[col - 1]){
            if(i == val){return true;}
        }
        return false;
    }

    // return whether that square is available for the value
    public boolean scan(int col, int row, int val){
        return scanRow(row, val) && scanCol(col, val);
    }

    // loads a value into a RowBlock, meaning that that row is already occupied by a value
    // need to check whether a initialized and declare array have the same length with empty elements
    public void loadRow(int row, int val){
        RowBlock[row - 1][RowBlock[row - 1].length] = val;
    }
}
