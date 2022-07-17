import java.util.*;

public class TestCommond {


    public static void main(String[] args) {
        Map<String, String> commandMap = new HashMap<>();
        commandMap.put("reset", "reset what");
        commandMap.put("reset board", "board fault");
        commandMap.put("board add", "where to add");
        commandMap.put("board delete", "no board at all");
        commandMap.put("reboot backplane", "impossible");
        commandMap.put("backplane abort", "install first");
        List<HashMap[]> pattern = new ArrayList<>();
        pattern.add(new HashMap[]{splits("reset"), splits("board")});
        pattern.add(new HashMap[]{splits("board"), splits("add")});
        pattern.add(new HashMap[]{splits("board"), splits("delete")});
        pattern.add(new HashMap[]{splits("reboot"), splits("backplane")});
        pattern.add(new HashMap[]{splits("backplane"), splits("abort")});

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String commond = in.nextLine();
            String[] coms = commond.split(" ");
            if (commandMap.containsKey(commond)) {
                System.out.println(commandMap.get(commond));
                continue;
            } else if (coms.length == 1 && "reset".startsWith(coms[0])) {
                System.out.println(commandMap.get("reset"));
                continue;
            } else if (coms.length == 2) {
                List<String> matchs = new ArrayList<>();
                for (HashMap[] e : pattern) {
                    if (e[0].containsKey(coms[0]) && e[1].containsKey(coms[1])) {
                        String s = e[0].get(coms[0]) + " " + e[1].get(coms[1]);
                        matchs.add(s);
                    }
                }
                if (matchs.size() == 1) {
                    System.out.println(commandMap.get(matchs.get(0)));
                    continue;
                }
            }
            System.out.println("unknown command");
        }
    }

    public static HashMap<String, String> splits(String key) {
        HashMap<String, String> res = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            res.put(sb.toString(), key);
        }
        return res;
    }
}
