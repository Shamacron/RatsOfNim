package edu.neumont.csc130.EMB;

import java.util.HashMap;
import java.util.Map;

public class Board
{
    private Map<String, Integer> heaps = new HashMap<String, Integer>();

    //isValidHeapChoice checks to make sure that the chosen heap is valid
    public boolean isValidHeapChoice(String heap)
    {
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

    //isValidTokenChoice checks to make sure that the amount of tokens to be removed is valid
    public boolean isValidTokenChoice(int tokensToRemove, String chosenHeap)
    {
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

    //takes in the chosen heap and amount of tokens to be removed and removes them from the hashmap
    public void removeTokens(String heap, int tokensToRemove)
    {
        //takes in the chosen heap and changes the amount of tokens in the heap
        //to the current amount minus the amount of tokens that are to be removed
        heaps.replace(heap, getTokensInHeap(heap) - tokensToRemove);
    }

    //checks to see if the game is in a winning (losing?) state
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

    //gets the amount of tokens in the specified heap
    public int getTokensInHeap(String key)
    {
        return heaps.get(key);
    }

}
