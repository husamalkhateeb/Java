package exam;

import java.util.Scanner;
import java.util.Arrays;

public class Exam {

    public static void main(String[] args) {
        System.out.println(Menu.getNumOfMenusCreated());
        Menu menu1 = new Menu();
        Menu menu2 = new Menu(menu1);
        for (int i = 0; i < menu2.getPrices().length; i++) {
            menu1.setPrice(0.5 + (Math.random() * 9.5), i);
        }
        makeAnOrder(menu1);
        makeAnOrder(menu2);
    }

    public static int[] addElement(int[] newArr, int num) {
        int[] newString = new int[newArr.length + 1];

        for (int i = 0; i < newArr.length; i++) {
            newString[i] = newArr[i];
        }
        newString[newArr.length] = num;
        return newArr;
    }

    public static void makeAnOrder(Menu a1) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[1];
        a1.printMenu();
        System.out.print("please enter the index of the meal you want: ");
        int ind = in.nextInt();
        a1.incrementTimesOrdered(ind);
        arr[0] = ind;
        System.out.println("you want more meals? (true/ false)");
        boolean boo = in.nextBoolean();
        while (boo) {
            System.out.print("please enter the index of the meal you want: ");
            ind = in.nextInt();
            arr = addElement(arr, ind);
            a1.incrementTimesOrdered(ind);
            System.out.println("you want more meals? (true/ false)");
            boo = in.nextBoolean();
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += a1.getPrices()[arr[i]];
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(a1.getMeals()[arr[j]] + " - " + a1.getMeals()[arr[j]]);
        }
        System.out.println("sum is: " + sum);
    }

    public static boolean isMealOrdered(int[] zeft, int c) {
        Arrays.sort(zeft);
        int x = 0;
        for (int i = 0; i < zeft.length; i++) {
            if (zeft[i] == c) {
                x++;
            }
        }
        return x > 0;
    }
}
