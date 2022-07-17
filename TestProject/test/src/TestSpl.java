import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSpl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> params = new ArrayList<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            params.add(in.nextLine());
        }
        System.out.println(test(params.get(0), params.get(1)));
    }
    public static boolean test(String a, String b) {
        a = a.toLowerCase().replaceAll("\\*", "[\\\\w]*")
                .replaceAll("\\?", "[\\\\w]?")
                .replaceAll("\\.", "[.]{1}");
        return b.toLowerCase().matches("^" + a + "$");
    }
}
