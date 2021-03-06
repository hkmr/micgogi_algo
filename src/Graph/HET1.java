package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Micgogi
 * on 8/21/2020  2:23 PM
 * Rahul Gogyani
 */
public class HET1 {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt(), q = sc.nextInt();
        int index, rindex;
        int[] map = new int[100001], set = new int[100001], rset = new int[100001], rmap = new int[100001];
        Arrays.fill(set, -1);
        Arrays.fill(rset, -1);
        map[1] = set[1] = rmap[1] = rset[1] = 1;
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            char d = sc.next().charAt(0);
            if (d == 'R') {
                index = map[a] << 1 | 1;
                rindex = rmap[a] << 1;

            } else {
                index = map[a] << 1;
                rindex = rmap[a] << 1 | 1;
            }
            set[index] = b;
            rset[rindex] = b;
            map[b] = index;
            rmap[b] = rindex;

        }
        while(q--!=0){
            int a = sc.nextInt();
            System.out.println(rset[map[a]]);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[][] read2DArray(int n) {
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

        int[][] read2DArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }
    }

}

