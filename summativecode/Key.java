import java.awt.Image; // Used for creating images
import javax.swing.ImageIcon; // Used for loading images from files

/** Key class (contains the key image and x and y positions for 3 keys used in level 11)*/
public class Key
{
  private Image key; // key image
  private int[] keyLv11Pos = {5,6, 19,10, 19,11}; // x,y positions for 3 keys (used in Hard Level 1 [actually level 11 in the whole game])
  
  /** When the key object is created, acquires the key image*/
  public Key ()
  {
    ImageIcon img = new ImageIcon ("Game Components\\Visual Components\\key.png");
    key = img.getImage ();
  } //Constructor
  
  /** Returns the key image*/
  public Image getKey ()
  {
    return key;
  } //getKey
  
  /** Returns the positions of the keys (for level 11, all other levels either don't use keys or use a 1 or 2 keys, so lvl 11 is the only level where we decided to use a method like this)*/
  public int[] getKeysLvl11Pos ()
  {
    return keyLv11Pos;
  } //getKeys1
} // Key class