package edu.neumont.csc130.EMB;

import java.util.HashMap;
import java.util.Map;

public class Board
{
    /**
     * heaps is the hashmap that acts as the game board
     */
    private Map<String, Integer> heaps = new HashMap<String, Integer>();

    /**
     * Creates the board based on difficulty
     * @param difficulty
     */
    public Board(int difficulty)
    {
        if (difficulty == 1)
        {
            //If the selected difficulty is 1 (easy)
            //Create 2 heaps with 2 and 2 tokens respectively
            heaps.put("A", 2);
            heaps.put("B", 2);
        } else if (difficulty == 2)
        {
            //If the selected difficulty is 2 (medium)
            //Create 3 heaps with 2, 5, and 7 tokens respectively
            heaps.put("A", 2);
            heaps.put("B", 5);
            heaps.put("C", 7);
        } else
        {
            //If the selected difficulty is 3 (hard)
            //Create 4 heaps with 2, 3, 8, and 9 tokens respectively
            heaps.put("A", 2);
            heaps.put("B", 3);
            heaps.put("C", 8);
            heaps.put("D", 9);
        }
    }

    /**
     * isValidHeapChoice checks to make sure that the chosen heap is valid
     * @param heap
     * @return boolean
     */
    public boolean isValidHeapChoice(String heap)
    {
        heap = heap.toUpperCase();
        if (!heaps.containsKey(heap) || heaps.get(heap) <= 0)
        {
            //If the chosen heap does not exist on the board
            //OR the amount of tokens in the chosen heap is 0
            //The chosen heap is not valid and false will be returned
            return false;
        }
        //If the chosen heap exists and contains more than one token, return true
        return true;
    }

    /**
     * isValidTokenChoice checks to make sure that the amount of tokens to be removed is valid
     * @param tokensToRemove
     * @param chosenHeap
     * @return boolean
     */
    public boolean isValidTokenChoice(int tokensToRemove, String chosenHeap)
    {
        chosenHeap = chosenHeap.toUpperCase();
        //Added String chosenHeap to the parameters
        //need the chosen heap to make be able to check if the amount
        //of tokens to remove is a valid input

        int tokensInHeap = getTokensInHeap(chosenHeap);
        //sets tokensInHeap to the amount of tokens in the chosen heap

        if (tokensToRemove < 1 || tokensToRemove > tokensInHeap)
        {
            //if the amount of tokens to remove is less than one
            //OR the amount of tokens to remove is more than the amount of tokens currently in the heap
            //return false
            return false;
        }
        //If the amount of tokens to remove is more than one or less than or equal to the amount of tokens
        //in the chosen heap
        //return true
        return true;
    }

    /**
     * takes in the chosen heap and amount of tokens to be removed and removes them from the hashmap
     * @param heap
     * @param tokensToRemove
     */
    public void removeTokens(String heap, int tokensToRemove)
    {
        //takes in the chosen heap and changes the amount of tokens in the heap
        //to the current amount minus the amount of tokens that are to be removed
        heaps.replace(heap, getTokensInHeap(heap) - tokensToRemove);
    }

    /**
     * checks to see if the game is in a winning (losing?) state
     * @return boolean
     */
    public boolean checkForLoss()
    {
        for (Integer tokens : heaps.values())
        {
            //for each heap on the board
            if (tokens != 0)
            {
                //check to see if the heap is empty
                //if the heap is NOT empty, return false
                return false;
            }
        }
        //if every heap is empty, return true
        return true;
    }

    /**
     * gets the amount of tokens in the specified heap
     * @param key
     * @return
     */
    public int getTokensInHeap(String key)
    {
        return heaps.get(key);
    }

    //Overrides the toString to make a readable format for the board
    @Override
    public String toString()
    {
        String printedBoard = "";
        //The string that will be returned at the end
        for(String heap : heaps.keySet())
        {
            //For each heap in the hashmap, add onto the printedBoard string the heap's name and amount of tokens
            printedBoard += heap + ": " + heaps.get(heap) + "\n";
        }
        //Return the string that shows the current state of the board
        return printedBoard;
    }

}
