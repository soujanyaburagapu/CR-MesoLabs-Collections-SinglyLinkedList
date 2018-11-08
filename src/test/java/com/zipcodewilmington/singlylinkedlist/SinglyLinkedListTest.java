package com.zipcodewilmington.singlylinkedlist;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest
{
    @Test
    public void SinglyLinkedListTest() {
        //Given
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add("Zip ");
        linkedList.add("Code");
        String test = "";
        //When
        for (int i = 0; i <= linkedList.size(); i++) {
            String string = (String) linkedList.remove();
            test = test.concat(string);
        }
        System.out.println(test);
    }

    @Test
    public void SinglyLinkedListTest1() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add("Zip ");
        linkedList.add(" Code ");
        int expected = 2;
        int actual = linkedList.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest2() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add("Z");
        linkedList.add("i");
        linkedList.add("p");
        linkedList.add("");
        linkedList.add("C");
        linkedList.add("o");
        linkedList.add("d");
        linkedList.add("e");

        int expected = 8;
        int actual = linkedList.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest3() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add(" C ");
        linkedList.add(" O ");
        linkedList.add(" D ");
        linkedList.add(" E ");

        linkedList.insert("Zip", 1);

        int expected = 5;
        int actual = linkedList.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest4() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add("C");
        linkedList.add("O");
        linkedList.add("D");
        linkedList.add("E");

        String actual = (String) linkedList.removeAt(2);
        String expected = "O";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest5() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add("C");
        linkedList.add("O");
        linkedList.add("D");
        linkedList.add("E");

        int actual = linkedList.find("D");
        int expected = 3;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest6() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add("list");
        linkedList.add("linked");
        linkedList.add("array");
        int actual = linkedList.find("string");
        int expected = -1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest7() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add("Zip ");
        linkedList.add("Code");


        boolean actual = linkedList.contains("Wilmington");
        boolean expected = false;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void SinglyLinkedListTest8() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add("Zip ");
        linkedList.add("Code ");
        linkedList.add("Wilmington");

        SinglyLinkedList actual = linkedList;
        SinglyLinkedList expected = linkedList.copy();

        for (int i = 1; i <= expected.size(); i++) {
            System.out.println(expected.get(i));
        }
        expected.remove();
        for (int i = 1; i <= expected.size(); i++) {
            System.out.println(expected.get(i));
        }
        for (int i = 1; i < linkedList.size()+1; i++) {
            System.out.println(linkedList.get(i));
        }
    }
}



