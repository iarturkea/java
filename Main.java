import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] inpObjects = new String[4][4];
        for (int i = 0; i < inpObjects.length; i++) {
            for (int j = 0; j < inpObjects[i].length; j++) {
                Scanner scr = new Scanner(System.in);
                System.out.println("Введите число");
                inpObjects[i][j] = scr.nextLine();

            }

        }
        try {
            try{
                System.out.println("Сумма масива равна " + myArray(inpObjects));
            }catch (MyArraySizeException e){
                System.out.println("Матрица только 4x4");
            }
        }catch (MyArrayDataException e){
            System.out.println("Элимент [" + e.getColumNum()+"][" + e.getLineNum()+ "] не может быть преобразоан в число");
        }
    }

    static int myArray(String[][] inpObj) throws MyArraySizeException, MyArrayDataException {


        if (inpObj.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < 4; i++) {
            if (inpObj[i].length != 4) throw new MyArraySizeException();
        }
        int summ = 0;
        int iter;
        for (int i = 0; i < inpObj.length; i++) {
            for (int j = 0; j < inpObj.length; j++) {
                try {
                    iter = Integer.parseInt(inpObj[i][j]);
                } catch (NumberFormatException e){
                    throw new  MyArrayDataException(i,j);
                }

                summ = summ + iter;

            }

        }
        return summ;


    }
}
