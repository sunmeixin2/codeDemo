package code.ArrayTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunmeixin
 * @description 01矩阵
 * @date 2021-05-06
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();

        int m = mat.length, n = mat[0].length;
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        for (int i = 0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i ,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] {-1,1,0,0};
        int[] dy = new int[] {0,0,-1,1};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i=0; i<4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.offer(new int[] {newX,newY});
                }
            }
        }
        return mat;
    }
}

/**
 * 题目描述：给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *          两个相邻元素间的距离为 1 。
 *
 *  思路：首先把每个源点 0 入队，然后从各个 0 同时开始一圈一圈的向 1 扩散（每个 1 都是被离它最近的 0 扩散到的 ），
 *      扩散的时候可以设置 int[][] dist 来记录距离（即扩散的层次）并同时标志是否访问过。
 *      对于本题是可以直接修改原数组 int[][] matrix 来记录距离和标志是否访问的，
 *      这里要注意先把 matrix 数组中 1 的位置设置成 -1 （设成Integer.MAX_VALUE啦，m * n啦，10000啦都行，只要是个无效的距离值来标志这个位置的 1 没有被访问过就行）
 *
 */
