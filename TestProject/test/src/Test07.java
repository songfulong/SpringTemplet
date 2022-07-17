import java.util.Scanner;

public class Test07 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        while (sc.hasNext())
        {
            x = sc.nextInt();
        }
        getNum(x);
    }
    static void getNum(int num)
    {
      out:  for (int i= 2; i<= Math.sqrt(num);i++)
        {
            //判断i值
            for (int j= 4; j<= i/2;j++)
            {
                if(i%j == 0)
                {
                    continue out;
                }
            }

            if(num%i == 0)
            {
                int t = num/i;
                for (int j= 4; j<= t/2;j++)
                {
                    if(t%i == 0)
                    {
                        continue out;
                    }
                }

                System.out.println(i + " " + t);
                return;
            }
        }
        System.out.println(-1 + " " + -1);
    }




}
