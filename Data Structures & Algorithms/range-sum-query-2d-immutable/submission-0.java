class NumMatrix {
    int[][] matrix;
    int[][] pre_matrix;
        public void PrefixSumMatrix(int matrix[][]){
            pre_matrix[0][0] = matrix[0][0];

            for(int col=1;col<matrix[0].length;col++){
                pre_matrix[0][col] = pre_matrix[0][col-1] + matrix[0][col];
            }
            for(int row=1;row<matrix.length;row++){
                pre_matrix[row][0] = pre_matrix[row-1][0] + matrix[row][0];
            }
            for(int i=1;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    pre_matrix[i][j] = pre_matrix[i-1][j] + pre_matrix[i][j-1] 
                                       - pre_matrix[i-1][j-1] + matrix[i][j];
                }
            }
        }
    
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int row = matrix.length;
        int col = matrix[0].length;
        pre_matrix = new int[row][col];
        PrefixSumMatrix(matrix);
    }
    
    public int getValue(int row, int col){
        if(row<0 || col<0) return 0;
        return pre_matrix[row][col];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = getValue(row2,col2);
        int left = getValue(row2,col1-1);
        int top = getValue(row1-1,col2);
        int overlap = getValue(row1-1,col1-1);

        return total-left-top+overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */