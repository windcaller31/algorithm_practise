package leetcode;

/**
 * @author limengtong
 * @date 2019/11/5 7:34 下午
 */
public class leetcode832 {
    public static void main(String args[]) {
        int A[][] = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] B = flipAndInvertImage(A);
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] B = A[i];
            for (int j = 0; j < B.length / 2; j++) {
                int temp = B[j];
                B[j] = B[B.length - 1 - j];
                B[B.length - 1 - j] = temp;
            }
            for (int j = 0; j < B.length; j++) {
                B[j] = B[j] == 0 ? 1 : 0;
            }
        }
        return A;
    }
}
