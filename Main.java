import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Задание №1
        int chislo;
        int inpChislo;
        Random rand = new Random();
        chislo = rand.nextInt(10);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите число от 1 до 9");
            inpChislo = readChislo();
            if (inpChislo == chislo){
                System.out.println("Вы угадали это " + chislo);
                break;
            }
            else if(inpChislo > chislo){
                System.out.println("Промах! Ваше число больше загаданного.");
            }
            else {
                System.out.println("Промах! Ваше число меньше загаданного.");
            }
            if(i == 2){
                System.out.println("Попытки кончились вы проиграли");
            }
        }
        //Задание №2
        String[] allwords = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = allwords[rand.nextInt(allwords.length)];
        String tempWord = "###############";
        do{
            System.out.println("Введите слово");
            Scanner sc = new Scanner(System.in);
            String inpWord = sc.nextLine();

            if (word.equals(inpWord)){
                System.out.println("Ура это слово " + inpWord);
                break;
            }
            for (int i = 0; i < word.length(); i++) {

                if(i == inpWord.length())break;

                if(inpWord.charAt(i) == word.charAt(i)){
                    char[] tempCharString = tempWord.toCharArray();
                    tempCharString[i] = word.charAt(i);
                    tempWord = new String(tempCharString);
                }
            }
            System.out.println("Вы угадали буквы: " +tempWord);

        }while (true);

    }

    static int readChislo(){
        Scanner sc = new Scanner(System.in);
        do{
            if(sc.hasNextInt())
            {
                return sc.nextInt();
            }
            sc.nextLine();
            System.out.println("Введите число от 1 до 9");
        }while(true);
    }

}