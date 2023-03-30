import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] copyMap;
    public static void main(String[] args) throws IOException {
        //3중 루프를 이용해서 벽 3개를 세운 좌표를 리스트에 저장
        //리스트 길이만큼 루프 돌면서 벽 세 개 자리를 1로 채운뒤,
        //2중 루프 돌면서 바이러스=2가 발견되면 BFS를 돈다.
        //BFS가 전부 끝난 뒤의 안전 영역=0의 갯수를 세고 answer를 갱신한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> zero = new ArrayList<>();
        int[][] map = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0)
                    zero.add(new int[]{i, j});
            }
        } //입력

        for (int i = 0; i < zero.size(); i++) {
            for (int j = i + 1; j < zero.size(); j++) {
                for (int k = j + 1; k < zero.size(); k++) {
                    map[zero.get(i)[0]][zero.get(i)[1]] = 1;
                    map[zero.get(j)[0]][zero.get(j)[1]] = 1;
                    map[zero.get(k)[0]][zero.get(k)[1]] = 1;
                    int tempResult = 0;
                    copyMap=copyMap(map);
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            if (copyMap[x][y] == 2)
                               bfs(x, y);
                        }
                    }
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            if (copyMap[x][y] == 0) tempResult++;
                        }
                    }
                    map[zero.get(i)[0]][zero.get(i)[1]] = 0;
                    map[zero.get(j)[0]][zero.get(j)[1]] = 0;
                    map[zero.get(k)[0]][zero.get(k)[1]] = 0;
                    answer = Math.max(answer, tempResult);
                }
            }
        }
        System.out.println(answer);
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copy=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j]=map[i][j];
            }
        }
        return copy;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || ny >= m || nx >= n) continue;
                if (copyMap[nx][ny]==0) {
                    copyMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}