package org.mickey.homework.week4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 2020/9/16 21:13
 */
public class _200_NumberOfIslands {

    // dfs solution
    public int numIslands(char[][] grid) {
        // 边界条件检查
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        // 遍历二维数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    // dfs
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // terminator
        // 超出范围，或者为水
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return;

        // process current level logic
        grid[i][j] = '0';

        // drill down
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        // reverse state
    }


    // bfs solution
    public int bfs(char[][] grid) {
        // boundary check
        if (grid == null || grid.length == 0) return 0;
        // traversal the grid
        int height = grid.length;
        int width = grid[0].length;
        int ans = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    Deque<Integer> neighbors = new LinkedList<>();
                    neighbors.offer(i * width + j);

                    while (!neighbors.isEmpty()) {
                        int id = neighbors.poll();
                        int row = id / width;
                        int col = id % width;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.offer((row - 1) * width + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < height && grid[row + 1][col] == '1') {
                            neighbors.offer((row + 1) * width + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.offer(row * width + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < width && grid[row][col + 1] == '1') {
                            neighbors.offer(row * width + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }

}
