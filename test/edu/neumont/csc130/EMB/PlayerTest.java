package edu.neumont.csc130.EMB;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
  @Test
  public void getName() throws Exception {
      Player p2 = new Player();
	  Player p = new Player();
	  p.setName("Bill");
	  assertTrue(p.getName().equals("Bill"));
  }
  
  @Test
  public void isValidName() {
	  Player p = new Player();
	  assertTrue(p.isValidName("harry")); 
	  assertFalse(p.isValidName(" Rhonda"));
	  assertTrue(p.isValidName("888"));
	  assertFalse(p.isValidName("jo%n"));
	  assertFalse(p.isValidName("sd 8"));
  }

  @Test
  public void setName() throws Exception {
	  Player p = new Player(); 
	  p.setName("Ron");
	  assertTrue(p.getName().equals("Ron"));
  }

  @Test
  public void takeTurn() throws Exception {
	  // I don't know how to test for this besides running it? 
  }

}