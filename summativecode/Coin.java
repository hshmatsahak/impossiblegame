import java.awt.Image; // Used for creating images
import javax.swing.ImageIcon; // Used for loading images from files

/** Coin class (contains the coin image, the x and y position of a coin, and the position of coins on certain levels)*/
public class Coin
{
  private int coinX, coinY; // Positions of a coin (used in Easy)
  private Image coin; // Coin image
  
  // Easy levels x,y positions of coins
  private int[] coin2 = {8,5, 12,8, 8,12};
  private int[] coin3 = {4,8, 8,8, 12,8, 16,8};
  private int[] coin4 = {2,11, 11,2, 11,11};
  
  // Medium levels x,y positions of coins
  private int[] coinM1 = {3,3, 14,3, 14,12, 3,12};
  private int[] coinM2 = {7,2, 10,2, 13,7, 16,7};
  private int[] coinM3 = {21,1, 20,4, 16,2, 16,5, 13,4, 9,2, 9,5}; 
  private int[] coinM4 = {3,1, 18,1, 1,10, 20,10};
  private int[] coinM5 = {5,2, 12,2, 5,13, 12,13};
  
  // Hard levels x,y positions of coins
  private int[] coinH1 = {18,2, 19,2, 20,2, 18,3, 19,3, 20,3};
  private int[] coinH2 = {7,2, 8,2, 7,3, 8,3};
  private int[] coinH3 = {1,9, 2,9, 1,10, 2,10};
  private int[] coinH4 = {3,4, 8,4, 17,4, 22,4, 8,1, 17,1, 3,11, 8,11, 17,11, 22,11, 8,14, 17,14};
  private int[] coinH5 = {5,4, 6,3, 7,2, 8,3, 9,4, 6,5, 7,6, 8,5, 15,4, 16,3, 17,2, 18,3, 19,4, 16,5, 17,6, 18,5};
  
  private int level; // Current level
  
  /** When the coin object is created, acquires the coin image and sets the coin x and y positions depending on the whether the level is level 1 or 4*/
  public Coin () 
  {
    ImageIcon img = new ImageIcon ("Game Components\\Visual Components\\coin.png");
    coin = img.getImage ();
    
    if (Menu.easy) // If the game type is set to easy in the menu (Menu.easy would thus be true), acquires the Easy level and sets the apropriate x and y coin position
    {
      level = Easy.level; // Acquires the Easy level

      switch (level) // Assigns the coin's x and y positions based on the Easy level
      {
        case 1: // Coin positon for level 1
          coinX = 10;
          coinY = 5;
          break;
        case 4: // Coin position for level 4
          coinX = 19;
          coinY = 10;
          break;
      } // Switch case based on level
    } // if statement based on the game type (Menu.easy)
  } // Constructor
  
  /** Returns the coin image*/
  public Image getCoin ()
  {
    return coin;  
  } // getCoin
  
  /** Sets the x position of a coin*/
  public void setCoinX (int x)
  {
    coinX = x;
  } // setCoinX
  
  /** Sets the y position of a coin*/
  public void setCoinY (int y)
  {
    coinY = y;
  } // setCoinY
  
  /** Returns the x position of a coin*/
  public int getCoinX()
  {
    return coinX;
  } // getCoinX
  
  /** Returns the y position of a coin*/
  public int getCoinY()
  {
    return coinY;
  } // getCoinY
  
  /** Returns the Easy Level 2 positions of coins*/
  public int[] getCoins2()
  {
    return coin2;
  } // getCoins2
  
  /** Returns the Easy Level 3 positions of coins*/
  public int[] getCoins3()
  {
    return coin3;
  } // getCoins3
  
  /** Returns the Easy Level 4 positions of coins*/
  public int[] getCoins4()
  {
    return coin4;
  } // getCoins4
  
  /** Returns the Medium Level 1 (actually level 6 in the whole game) positions of coins*/
  public int[] getCoinsM1()
  {
    return coinM1;
  } // getCoinsM1
  
  /** Returns the Medium Level 2 (actually level 7 in the whole game) positions of coins*/
  public int[] getCoinsM2()
  {
    return coinM2;
  } // getCoinsM2
  
  /** Returns the Medium Level 3 (actually level 8 in the whole game) positions of coins*/
  public int[] getCoinsM3()
  {
    return coinM3;
  } // getCoinsM3
  
  /** Returns the Medium Level 4 (actually level 9 in the whole game) positions of coins*/
  public int[] getCoinsM4()
  {
    return coinM4;
  } // getCoinsM4
  
  /** Returns the Medium Level 5 (actually level 10 in the whole game) positions of coins*/
  public int[] getCoinsM5()
  {
    return coinM5;
  } // getCoinsM5
  
  /** Returns the Hard Level 1 (actually level 11 in the whole game) positions of coins*/
  public int[] getCoinsH1()
  {
    return coinH1;
  } // getCoinsH1
  
  /** Returns the Hard Level 2 (actually level 12 in the whole game) positions of coins*/
  public int[] getCoinsH2()
  {
    return coinH2;
  } // getCoinsH2
  
  /** Returns the Hard Level 3 (actually level 13 in the whole game) positions of coins*/
  public int[] getCoinsH3()
  {
    return coinH3;
  } // getCoinsH3
  
  /** Returns the Hard Level 4 (actually level 14 in the whole game) positions of coins*/
  public int[] getCoinsH4()
  {
    return coinH4;
  } // getCoinsH4
  
  /** Returns the Hard Level 5 (actually level 15 in the whole game) positions of coins*/
  public int[] getCoinsH5()
  {
    return coinH5;
  } // getCoinsH5
} // Coin class