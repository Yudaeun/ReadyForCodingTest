import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n];
            answer = new int[m];

            permutation(0, m);

        }
        public static void permutation(int depth, int m) {
            if (depth >= m) {

                for (int n : answer) {
                    System.out.print(n + " ");
                } System.out.println();

                return;
            }
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[depth] = i + 1;
                    permutation(depth + 1, m);
                    visited[i] = false;
                }
            }
        }
    }
