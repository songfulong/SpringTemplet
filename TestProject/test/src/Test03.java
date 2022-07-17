import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {



    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String a = scanner.nextLine();
            list.add(a.split(" "));
        }
        list.remove(list.size()-1);
        for (String [] a: list) {

            System.out.println(Integer.valueOf(a[0]) + Integer.valueOf(a[1]));
        }

    }




}
