public class ChampagneTower {

    // 香檳塔 - 貪心算法
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] ca = new double[100][100];
        ca[0][0] = poured;
        for (int r = 0; r < query_row; r++) {
            for (int l = 0; l <= r; l++) {
                double d = (ca[r][l] - 1.0) / 2;
                if (d > 0) {
                    ca[r+1][l] += d;
                    ca[r+1][l+1] += d;
                }
            }
        }
        return Math.min(1, ca[query_row][query_glass]);
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(5,2,2));
    }
}
