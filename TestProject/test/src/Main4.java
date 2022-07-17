import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        List<String[]> input = new ArrayList<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            input.add(in.nextLine().split(" "));
        }
        int remove = Integer.valueOf(input.remove(input.size()-1)[0]);
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        Set <Integer> removeSet = new HashSet<>();
        for (String [] relation : input) {
            resultMap.computeIfAbsent(Integer.valueOf(relation[0]),
                    key -> new ArrayList<>()).add(Integer.valueOf(relation[1]));
            removeSet.add(Integer.valueOf(relation[0]));
            removeSet.add(Integer.valueOf(relation[1]));
        }
        dfs(resultMap, remove, removeSet);
        ArrayList<Integer> result = new ArrayList<>(removeSet);
        result.sort(Comparator.naturalOrder());
        System.out.print(result);
    }
    public static void dfs( Map<Integer, List<Integer>> resultMap, int remove, Set <Integer> removeSet){
        if (!resultMap.containsKey(remove)){
            return;
        }
        List<Integer> integers = resultMap.remove(remove);
        removeSet.remove(remove);
        for (int i = 0; i < integers.size(); i++) {
            dfs(resultMap, integers.get(i), removeSet);
        }
    }
}
