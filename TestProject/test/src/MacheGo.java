import java.util.*;

public class MacheGo {
    public static int[][] moveUp = {{-1, 0}, {0, 1}};
    public static int[][] moveDown = {{1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            input.add(in.nextLine());
        }
        String[] size = input.get(0).split(" ");
        int sizeX = Integer.valueOf(size[1]);
        int sizeY = Integer.valueOf(size[0]);
        int[][] room = new int[sizeX][sizeY];
        // 墙壁设置 1 ,正常是 0  使用 2   返向设置 3,
        if ("".equals(input.get(1))){
            System.out.print(0 + " " + 0);
            return;
        }
        for (int i = 2; i < input.size(); i++) {
            String[] door = input.get(i).split(" ");
            int doorX = Integer.valueOf(door[0]);
            int doorY = Integer.valueOf(door[1]);
            room[sizeX - doorY  - 1][doorX] = 1;
        }
        int[] start = new int[]{room.length - 1, 0};
        bfs(room, 0, 2, start);
        start = new int[]{0, room[0].length - 1};
        bfs(room, 1, 3, start);
        int noArrage = 0;
        int dangerous = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
               // System.out.print(room[i][j] + ",");
                if (room[i][j] == 3 || room[i][j]== 0){
                    noArrage ++;
                }else if (room[i][j] == 2 ){
                    dangerous ++;
                }
            }
           // System.out.println();
        }
            System.out.print(dangerous + " " + noArrage);
    }

    public static void bfs(int[][] room, int dirtcon, int used, int[] start) {
        int[][] move = dirtcon == 0 ? moveUp : moveDown;
        Queue<int[]> pos = new ArrayDeque<>();
        pos.offer(start);
        Set<String> ispoll = new HashSet<>();
        ispoll.add(start[0] + "," + start[1]);
        while (!pos.isEmpty()) {
            //是否在范围内
            int[] index = pos.poll();
            int x = index[0];
            int y = index[1];
            room[x][y] += used;
            for (int i = 0; i < move.length; i++) {
                int tempX = x + move[i][0];
                int tempY = y + move[i][1];
                if (tempX >= 0 && tempX < room.length && tempY >= 0 && tempY < room[0].length
                        && room[tempX][tempY] < used && room[tempX][tempY] != 1 && !ispoll.contains(tempX + "," + tempY)
                ) {
                    pos.offer(new int[]{tempX, tempY});
                    ispoll.add(tempX + "," + tempY);
                }
            }
        }
    }


}
