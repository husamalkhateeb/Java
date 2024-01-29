package exam;

import java.util.*;

public class Menu {

    private String[] meals;
    private double[] prices;
    private int[] timesOrdered;
    private static int numOfMenusCreated;
    Scanner in = new Scanner(System.in);
    

    public Menu() {
        int input = 0;
        System.out.print("Enter the number of meals you want: ");
        input = in.nextInt();
        meals = new String[input];
        prices = new double[input];
        timesOrdered = new int[input];
        for (int i = 0; i < meals.length; i++) {
            System.out.println("please enter meal: ");
            meals[i] = in.next();
            System.out.println("please enter the price of this meal :");
            prices[i] = in.nextDouble();
            timesOrdered[i] = 0;
        }
        numOfMenusCreated++;
    }

    public Menu(Menu m) {
        meals = new String[m.meals.length];
        prices = new double[m.prices.length];
        timesOrdered = new int[m.timesOrdered.length];
        for (int i = 0; i < meals.length; i++) {
            meals[i] = m.meals[i];
            prices[i] = m.prices[i];
            timesOrdered[i] = 0;
        }
        numOfMenusCreated++;
    }

    public String[] getMeals() {
        return meals;
    }

    public void setPrice(double p, int index) {
        if (p > 0) {
            prices[index] = p;
        }
    }

    public double[] getPrices() {
        double[] newPrices = new double[prices.length];
        for (int i = 0; i < newPrices.length; i++) {
            newPrices[i] = prices[i];
        }
        return newPrices;
    }

    public void incrementTimesOrdered(int index) {
        timesOrdered[index]++;
    }

    public int getTimesOrdered(int index) {
        return timesOrdered[index];
    }

    public static int getNumOfMenusCreated() {
        return numOfMenusCreated;
    }

    public void suggestAMeal() {
        int x = (int) (Math.random() * meals.length);
        System.out.println(meals[x] + " - " + prices[x]);

    }

    public String getMostOrderedMeal() {
        int max = 0;
        for (int i = 0; i < timesOrdered.length; i++) {
            if (timesOrdered[i] > max) {
                max = i;
            }
        }
        return meals[max];
    }

    public void printMenu() {
        for (int i = 0; i < meals.length; i++) {
            System.out.println(i + " - " + meals[i] + " - " + prices[i]);
        }
        System.out.println("Most ordered meal: " + getMostOrderedMeal());
    }
}
