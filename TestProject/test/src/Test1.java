import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List datas = new ArrayList();
        datas.add("Jerry");
        datas.add(1);
        for (Object data : datas){
            System.out.println((String)data);
        }
    }
}
