class Solution {
    int N;
    int cf, mainf, secf;
    List<List<String>> res = new ArrayList<>();

    private boolean backtrack(char[][] board, int row, int col) {
        if(row == N) {
            List<String> way = new ArrayList<>();
            for(int i=0;i<N;i++) {
                way.add(new String(board[i]));
            }
            res.add(way);
            return true;
        }

        int i = row;
        for(int j=0;j<N;j++) {
            int mi = 1 << (N - 1 + i - j);
            int si = 1 << (i + j);
            int ji = 1 << j;

            if((cf&ji) > 0 || (mainf&mi) > 0 || (secf&si) > 0) {
                continue;
            }

            board[i][j] = 'Q';
            cf |= ji;
            mainf |= mi;
            secf |= si;
            backtrack(board, i + 1, j);
            board[i][j] = '.';
            cf ^= ji;
            mainf ^= mi;
            secf ^= si;
        }

        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        cf = mainf = secf = 0;

        char[][] board = new char[N][N];

        for(int i=0;i<n;i++) Arrays.fill(board[i], '.');

        backtrack(board, 0, 0);

        return res;
    }
}