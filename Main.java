public class Main
{
    public static void main(String[] args)
    {
        byte b = 127;
        short s = 32767;
        int i = 4;
        long l = 5;

        float f = 2.5f;
        double d = 2.6;

        char c = 'c';

        boolean isTrue = true;
        System.out.println(exp(1,2,2,2));
        System.out.println(check(5, 16));
        check2(0);
        hello("Илья");
        chYear(204);
    }
    // метод возвращает  a * (b + (c / d))
    public static float exp (float a, float b, float c, float d)
    {
        return a * (b + c / d);
    }
    //проверка что сумма лежит в пределах от 10 до 20
    public static boolean check (int a, int b)
    {
        if(a + b < 10)
        {
            return false;
        }
        else if(a + b > 20)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //проверка что число положительное
    public static void check2 (int a)
    {
        if (a < 0)
        {
            System.out.println("Число a отрицательное");
        }
        else
        {
            System.out.println("Число a положительное");
        }
    }
    //метод Привет.
    public static void hello(String a)
    {
        System.out.println("Привет " + a +"!");
    }
    //проверка года
    public static void chYear(int a)
    {
        if(a % 400 == 0)
        {
            System.out.println("Год високосный");
        }
        else if(a % 100 == 0)
        {
           System.out.println("Год не високосный");
        }
        else if(a % 4 ==0)
        {
            System.out.println("Год високосный");
        }
        else
        {
            System.out.println("Год не високосный");
        }
    }
}
