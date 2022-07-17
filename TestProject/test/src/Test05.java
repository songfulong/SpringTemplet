import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Test05 {



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String a = scanner.nextLine();
            list.add(Integer.valueOf(a.replace("0x",""),16));
        }
        list.stream().forEach(System.out::println);

    }

}
