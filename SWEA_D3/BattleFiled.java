// 1873 D3 상호의 배틀필드
// 구현문제, 4방탐색 문제
import java.io.*;
import java.util.*;

public class BattleFiled {
    static int N, M;
    static int num;
    static String cmd;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int x = 0, y = 0, dir = 0;
        
        for (int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];

            for (int i = 0; i < N; i++){
                String str = br.readLine();
                for (int j = 0; j < M; j++){
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v'){
                        x = i;
                        y = j;
                        if (map[i][j] == '^')
                            dir = 0;
                        else if (map[i][j] == '>')
                            dir = 1;
                        else if (map[i][j] == 'v')
                            dir = 2;
                        else if (map[i][j] == '<')
                            dir = 3;
                    }
                }
            }
            num = Integer.parseInt(br.readLine());
            cmd = br.readLine();
            solveMap(x, y, dir);
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++)
                    System.out.print(map[i][j]);
                System.out.println();
            }
        }
    }

    public static boolean isValidation(int nx, int ny){
        return (nx >= 0 && ny >= 0 && nx < N && ny < M);
    }

    public static void solveMap(int i, int j, int dirNum){
        int x = i;
        int y = j;
        int dir = dirNum;
        for (int loop = 0; loop < num; loop++){
            char c = cmd.charAt(loop);
            int nx, ny;
            if (c == 'U'){
                dir = 0;
                map[x][y] = '^';
                nx = x + dx[0];
                ny = y + dy[0];
                if (isValidation(nx, ny) && map[nx][ny] == '.'){
                    map[x][y] = '.';
                    map[nx][ny] = '^';
                    x = nx;
                    y = ny;
                }
            }else if (c == 'D'){
                dir = 2;
                map[x][y] = 'v';
                nx = x + dx[2];
                ny = y + dy[2];
                if (isValidation(nx, ny) && map[nx][ny] == '.'){
                    map[x][y] = '.';
                    map[nx][ny] = 'v';
                    x = nx;
                    y = ny;
                }
            }else if (c == 'L'){
                dir = 3;
                map[x][y] = '<';
                nx = x + dx[3];
                ny = y + dy[3];
                if (isValidation(nx, ny) && map[nx][ny] == '.'){
                    map[x][y] = '.';
                    map[nx][ny] = '<';
                    x = nx;
                    y = ny;
                }
            }else if (c == 'R'){
                dir = 1;
                map[x][y] = '>';
                nx = x + dx[1];
                ny = y + dy[1];
                if (isValidation(nx, ny) && map[nx][ny] == '.'){
                    map[x][y] = '.';
                    map[nx][ny] = '>';
                    x = nx;
                    y = ny;
                }
            }else if (c == 'S'){
                nx = x;
                ny = y;
                while (isValidation(nx, ny)){
                    nx += dx[dir];
                    ny += dy[dir];
                    if (isValidation(nx, ny) && map[nx][ny] == '*'){
                        map[nx][ny] = '.';
                        break ;
                    }else if (isValidation(nx, ny) && map[nx][ny] == '#')
                        break ;
                }
            }
        }
    } 
}