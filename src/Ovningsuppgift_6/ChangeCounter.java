package Ovningsuppgift_6;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Ivona Zoricic
 * Date: 2020-10-07
 * Time: 13:43
 * Project: Sprint_2
 * Copywrite: MIT
 */
public class ChangeCounter {

    protected int price;
    protected int payed;
    public int[] listOfDenominations = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    public Boolean test = false;
    protected Scanner sc;

    public ChangeCounter() {}


    public int getChange(int payed, int price) {
        return payed - price;
    }
    public int countAmountOfDenomination(int change, int denom){
        return change/denom;
    }
    public int countNewChange(int change, int denom, int amountOfDenominations){
        return change-(amountOfDenominations*denom);
    }
    public String setNameToDenomination(int denom){
        String name = "";
            if (denom>=50)
                name = "lappar";
            else
                name = "kronor";

        return name;
    }

    public String printSingleAmountOfDenominations(int amountOfDenominations, int denom){
    //    return "Antal "+denom+"-"+ setNameToDenomination(denom)+": "+amountOfDenominations;
        StringBuilder sb = new StringBuilder("Antal ");
        sb.append(denom).append("-").append(setNameToDenomination(denom)).append(": ").append(amountOfDenominations);
        return sb.toString();
    }

    public String errorHandling(int change){
        if(change==0)
            return "Det blev ingen växel";
        else if(change<0)
            return "Du lämnade för lite pengar";
        else
            return null;
    }
    public int readInputData(String prompt, String optionalTestParameter){

        if(test){
            sc = new Scanner(optionalTestParameter);
        }
        else {
            sc = new Scanner(System.in);
    }
        while (true){
            try{
                System.out.println(prompt);
                return sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Ange tal!");
                sc.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Input saknas!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ospecifierat fel inträffade, försök igen!");
                sc.nextLine();
                e.printStackTrace();
            }
        }






}

