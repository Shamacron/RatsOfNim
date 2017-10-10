package edu.neumont.csc130.EMB;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest
{
    @Test
    public void isValidHeapChoice() throws Exception
    {
        Board b = new Board(3);
        assertTrue(b.isValidHeapChoice("A"));
        assertFalse(b.isValidHeapChoice("Q"));
    }

    @Test
    public void isValidTokenChoice() throws Exception
    {
        Board b = new Board(3);
        assertTrue(b.isValidTokenChoice(1, "A"));
        assertFalse(b.isValidTokenChoice(0, "A"));
    }

    @Test
    public void checkForLoss() throws Exception
    {
        Board b = new Board(3);
        assertFalse(b.checkForLoss());
    }

    @Test
    public void getTokensInHeap() throws Exception
    {
        Board b = new Board(3);
        assertEquals(2, b.getTokensInHeap("A"));
    }


}