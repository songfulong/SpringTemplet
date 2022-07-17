

public class Test09 {

    public static void main(String[] args)
    {
        /*Scanner sc = new Scanner(System.in);
        String input = null;
        while (sc.hasNext())
        {
            input=sc.nextLine();
        }*/
        long s = test(2,5);
        System.out.println(s);
    }

    public static String getValue(String input) {
        //去除空格
        input = input.replaceAll(" ", "");
        //判断是否存在逻辑运算符号
        if (!input.contains("+") && !input.contains("-")) {
            return input;
        }
        //针对逻辑运算符号进行逻辑处理
        //1.取出逻辑运算符
        String[] symbols = input.replaceAll("\\d", "").split("");
        //2.取出数据
        String[] datas = input.split("[+-]");
        int total = Integer.valueOf(datas[0]);
        for (int i = 0; i < symbols.length; i++) {
            if ("+".equals(symbols[i])) {
                total += Integer.valueOf(datas[i + 1]);
            } else if ("-".equals(symbols[i])) {
                total -= Integer.valueOf(datas[i + 1]);
            } else {
                System.out.println("input error");
                return null;
            }
        }
        return String.valueOf(total);
    }


    private static long test(int a ,int n){
        long s = a;
        long temp = a;
        for (int i = 1 ;i<n;i++){
            temp = (long) (a * Math.pow(10,Double.valueOf(i)) + temp);
            s += temp;
        }
        return s;
    }

    private static String test1(){
        String result = "";
        String[] abc = {"a","b","c"};
        String[] xyz = {"x","y","z"};
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(abc[i].equals("c")){
                    if(xyz[i].equals("x") || xyz[i].equals("z")){
                        continue;
                    }
                }
                if(abc[i].equals("a")){
                    if(xyz[i].equals("x")){
                        continue;
                    }
                }
                result = abc[i] + xyz[j];
            }

        }
        return result;
    }
}
