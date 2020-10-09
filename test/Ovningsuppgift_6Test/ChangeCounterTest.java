package Ovningsuppgift_6Test;

import Ovningsuppgift_6.ChangeCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ivona Zoricic
 * Date: 2020-10-07
 * Time: 13:44
 * Project: Sprint_2
 * Copywrite: MIT
 */
class ChangeCounterTest {

    ChangeCounter c = new ChangeCounter();

    @Test
    public void changeTest() {
        int price = 564;
        int payed = 1000;
        assertEquals(c.getChange(payed, price), 436);
        assertNotEquals(c.getChange(payed, price), 460);
    }

    @Test
    public void countAmountOfDenominationTest() {
        int change = 53;
        int denom = 20;
        assertTrue(c.countAmountOfDenomination(change, denom)==2);
        assertFalse(c.countAmountOfDenomination(change, denom)==3);
    }
    @Test
    public void countNewChange(){
        int change = 53;
        int denom = 20;
        int amountOfDenominations = 2;
        assertTrue(c.countNewChange(change, denom, amountOfDenominations)==13);
        assertFalse(c.countNewChange(change, denom, amountOfDenominations)==14);
    }
    @Test
    public void printSingleAmountOfDenominations(){
        int change = 53;
        int denom20 = 20;
        assertEquals(c.printSingleAmountOfDenominations(c.countAmountOfDenomination(change, denom20), denom20),"Antal 20-kronor: 2");
        assertNotEquals(c.printSingleAmountOfDenominations(c.countAmountOfDenomination(change, denom20), denom20),"Antal 50-kronor: 2");
    }
    @Test
    public void setNamesToDenominationsTest() {
        int test = 20;
        assertTrue(c.setNameToDenomination(test).equals("kronor"));
    }
    @Test
    public void errorHandlingTest(){
        int change1 = 0;
        int change2 = -10;
        int change3 = 10;
        assertEquals(c.errorHandling(change1), "Det blev ingen växel");
        assertEquals(c.errorHandling(change2), "Du lämnade för lite pengar");
        assertEquals(c.errorHandling(change3), null);
    }
    @Test
    public final void readInputDataTest(){
        c.test = true;
        String ok = "55";
        assertTrue(c.readInputData(ok)==55);
        assertFalse(c.readInputData(ok)==56);
    }


}


