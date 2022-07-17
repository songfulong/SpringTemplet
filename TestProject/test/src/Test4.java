import java.util.*;
import java.util.stream.Stream;

public class Test4 {



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(11);
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(32);
        list.add(67);
        list.add(40);
        list.add(20);
        list.add(89);
        list.add(300);
        list.add(400);
        list.add(15);


        /*Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String a = scanner.nextLine();
            list.add(a);
        }*/
        List<TreeSet<Integer>> a = new ArrayList<>();
        int t = 0;
        int k = 0;
        TreeSet<Integer> tmpArray = null;
        for(int i =0;i<list.size();i++) {
            if(i == t)
            {
                tmpArray= new TreeSet<>();
                t += list.get(i) +1;
                a.add(tmpArray);
            }else{
                tmpArray.add(list.get(i));
            }
        }
        // 排序
        for(TreeSet<Integer> tmp:a)
        {
            tmp.stream().forEach(System.out::println);
        }

    }

}
