public class Main {

    public static void main(String[] args)
    {
        //Задание №1
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length ; i++)
        {
               if (arr[i] == 0)
               {
                    arr[i] = 1;

               }
               else {
                   arr[i] = 0;
               }
            System.out.print(arr[i]);
        }

        System.out.println();// исключительно для красоты.

        //Задание №2
        int c = 0;

        int[] arr1 = new int[8];

        for (int i = 0; i < 8; i++)
        {
            arr1[i] = c;
            System.out.print(arr1[i]+" ");
            c = c + 3;

        }

        System.out.println();

        //Задание №3
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr2.length; i++)
        {
            if(arr2[i] < 6)
            {
                arr2[i] = arr2[i] * 2;
            }
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        //Задание №4
        int[][] arr3 = new int[9][9];
        for (int i = 0; i < arr3.length; i++)
        {
            for (int j = 0; j < arr3[i].length; j++)
            {
                if (i == j)
                {
                    arr3[i][j] = 1;
                    System.out.print(arr3[i][j]);
                }
                else if(j == arr3.length - 1 - i)
                {
                    arr3[i][j] = 1;
                    System.out.print(arr3[i][j]);
                }
                else
                {
                    arr3[i][j] = 0;
                    System.out.print(arr3[i][j]);
                }
                if(j == arr3[i].length - 1)
                {
                    System.out.println();
                }
            }

        }

        //Задание №5
        int[] arr4 = { 1, 5, -3, 2, 11, 4, 5, 142, 4, 8, 9, 1 };
        int max = arr4[0];
        int min = arr4[0];
        for (int i = 0; i < arr4.length; i++)
        {
            if(arr4[i] > max)
            {
                max = arr4[i];
            }
            if(arr4[i] < min)
            {
                min = arr4[i];
            }
        }
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);

        //Проверки методов
        int[] arr5 ={1, 2, 3, 4, 5, 6};
        System.out.println(checkBalance(arr5));
        moveAray(arr5,-2);
        for (int i = 0; i < arr5.length; i++)
        {
            System.out.print(arr5[i]+" ");

        }

    }
    //Задание №6
    public static boolean checkBalance(int[] arr)
    {
        int summ1 = arr[0];
        int summ2 = 0;
        boolean check = false;
        for (int i = 0; i < arr.length; i++)
        {
            check = (i == arr.length - 1 & summ1 == arr[i]);
            if(i == arr.length - 1) break;
            for (int j = i + 1; j < arr.length; j++)
            {
                summ2 = summ2 + arr[j];
            }
            check = (summ1 == summ2);
            if (check) break;
            summ2 = 0;
            summ1 = summ1 + arr[i + 1];
        }
       return check;
    }
    //Задание №7
    public static void moveAray(int[] arr, int n)
    {
        int cache1 = 0;
        int cache2;
        if (n > 0)
        {
                do {

                    cache2 = arr[arr.length-1];

                    for (int i = 0; i < arr.length; i++) {
                        cache1 = arr[i];
                        arr[i] = cache2;
                        cache2 = cache1;
                    }
                    n--;
                }
                while (n>0);

        }
        else
        {
            do {
                cache2 = arr[0];
                for (int i = arr.length - 1; i >= 0; i--) {
                    cache1 = arr[i];
                    arr[i] = cache2;
                    cache2 = cache1;
                }
                n++;
            }
            while (n < 0);
        }

    }
}



