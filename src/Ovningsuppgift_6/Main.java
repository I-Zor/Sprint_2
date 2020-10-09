package Ovningsuppgift_6;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Ivona Zoricic
 * Date: 2020-10-07
 * Time: 16:39
 * Project: Sprint_2
 * Copywrite: MIT
 */
public class Main {

    public static void main(String[] args) {

        ChangeCounter c = new ChangeCounter();
        Scanner sc;
        int[] listOfDenominations = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        boolean match = true;
        int price = 0;
        int payed = 0;
        while(match) {
            try {
                System.out.println("Ange pris: ");
                price = sc.nextInt();
                match = false;
                System.out.println("Ange belopp: ");
                payed = sc.nextInt();
                match = false;
            } catch (InputMismatchException e) {
                System.out.println("Ange tal!");
                sc.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Input saknas!");
                sc.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ospecifierat fel inträffade, försök igen!");
                sc.nextLine();
            }
        }
        int change = c.getChange(payed, price);
        if (change <=0) {
            System.out.println(c.errorHandling(change));
            System.exit(0);
        }
        System.out.println("Du får tillbaka: ");
        for (int listOfDenomination : listOfDenominations) {
            int amountOfDenominations = c.countAmountOfDenomination(change, listOfDenomination);
            System.out.println(c.printSingleAmountOfDenominations(amountOfDenominations, listOfDenomination));
            change = c.countNewChange(change, listOfDenomination, amountOfDenominations);
        }
    }
}
