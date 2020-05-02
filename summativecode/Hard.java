import java.awt.*; // Used for GUI
import java.awt.event.*; // Used for GUI
import javax.swing.*; // Used for GUI
import java.util.Scanner; // Used for File scanning
import java.io.*; // Used for File I/O
import sun.audio.*; // Used for Audio
import javax.sound.sampled.AudioInputStream; // Used for Audio
import javax.sound.sampled.AudioSystem; // Used for Audio
import javax.sound.sampled.Clip; // Audio
import javax.sound.sampled.LineUnavailableException; // Used for Audio
import javax.sound.sampled.UnsupportedAudioFileException; // Used for Audio

/** The frame where everything related to the game in Hard mode is contained*/
public class Hard
{
 // Components for file reader and writer
 /**File scanner that gets an account's level and deaths*/Scanner scanFile; 
 /**Print writer that edits an account's death file*/PrintWriter outFile;
 // Data fields used in multiple methods
 /**Account username*/static String username = Menu.username;
 /**Level object*/static Level levi = new Level();
 /**Whether account was loaded or not*/static boolean isLoad = Menu.isLoad;
 /**Account's current number of deaths*/public int death;
 /**Account's current level*/static int level;

 // GUI components
 private JLabel lblDeath;
 private JFrame f;
 
 /** Constructs the gaming frame and inside that is the game UI and the maze inside (the maze and all actions performed in there is done using using DrawMaze)*/
 public Hard() 
 {
  try // Try where account's level and death files are scanned
  {
   if (!Menu.cheat) // The account being a cheat or not determines the level file name
    scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt"));
   else
    scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt"));
   level = scanFile.nextInt();
   Scanner scanFile = new Scanner(new File("Game Components\\Player Components\\Player Deaths\\" + username + "-Death.txt"));
   death = scanFile.nextInt();
  } // Try where account's level and death files are scanned
  catch (FileNotFoundException i) // catch if files can't be scanned
  {
   level = levi.getLevel();
   death = 0;
  } // catch if files can't be scanned

  // Create frame 
  f = new JFrame();
  f.setTitle(username + " 's Maze Game");
  // Create main panel
  JPanel canvas = new JPanel();
  canvas.setLayout(new BoxLayout(canvas, BoxLayout.Y_AXIS));

  // Create top header of game (has game mode, level, and death count)
  JPanel pnl = new JPanel();
  pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
  pnl.setBackground(Color.BLACK);
  // "MODE: HARD" Label
  JLabel lbl = new JLabel();
  lbl.setForeground(Color.WHITE);
  lbl.setText("MODE: HARD");
  lbl.setFont(new Font("Calibri", Font.BOLD, 25));
  // Level Label
  JLabel lblLevel = new JLabel();
  lblLevel.setForeground(Color.WHITE);
  lblLevel.setText((level - 10) + " / 5");
  lblLevel.setFont(new Font("Calibri", Font.BOLD, 25));
  // Death count label
  lblDeath = new JLabel();
  lblDeath.setForeground(Color.WHITE);
  lblDeath.setText("DEATHS: " + death);
  lblDeath.setFont(new Font("Calibri", Font.BOLD, 25));

  switch (level) // Switch case based on level where header and main frame dimensions are set based on the level
  {
   case 11: // Hard  Level 1 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(723, 30));
    lbl.setPreferredSize(new Dimension(200, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(200, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(100, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(100, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(723, 520);
    break;
    
   case 12: // Hard  Level 2 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(525, 30));
    lbl.setPreferredSize(new Dimension(200, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(200, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(85, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(85, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(525, 520);
    break;
    
   case 13: // Hard  Level 3 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(540, 30));
    lbl.setPreferredSize(new Dimension(200, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(200, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(90, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(90, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(540, 450);
    break;
    
   case 14: // Hard  Level 4 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(895, 30));
    lbl.setPreferredSize(new Dimension(200, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(200, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(90, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(90, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(850, 585);
    break;
    
   case 15: // Hard  Level 5 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(895, 30));
    lbl.setPreferredSize(new Dimension(200, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(200, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(90, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(90, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(850, 400);
    break;
  } // Switch case based on level where header and main frame dimensions are based on level

  // Add header to the canvas, add the maze game to the canvas, and add the canvas to the frame, also sets properties
  canvas.add(pnl);
  canvas.setBackground(Color.black);
  canvas.add(new DrawMaze());
  f.add(canvas);
  f.setLocationRelativeTo(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 } // Constructor

 /** Panel that contains the maze and everything going on inside it. Also handles the actions undertaken when certain events take place */
 class DrawMaze extends JPanel implements ActionListener
 {
  // Objects in the maze
  private MazeLayout maze;
  private Player p;
  private Obstacle blueBalls;
  private Key k;
  private Coin c;
  // Maze properties
  private Timer timer, t;
  private int level;
  private int coins, columns;
  private boolean isKeyAcquired = false;
  private boolean isKeyAcquired2 = false;
  private boolean isKeyAcquired3 = false;
  private boolean playerIsHit = false;
  private float playerTransparencyVal = 1f;
  private boolean checkpoint1 = false, checkpoint2 = false;
  private int[] coinsH1, coinsH2, coinsH3, coinsH4, coinsH5;
  // Transparency values
  private int coinTransparencyVal = 1, coinTransparencyVal2 = 1, coinTransparencyVal3 = 1, coinTransparencyVal4 = 1, coinTransparencyVal5 = 1, coinTransparencyVal6 = 1, coinTransparencyVal7 = 1, coinTransparencyVal8 = 1, coinTransparencyVal9 = 1, coinTransparencyVal20 = 1, coinTransparencyVal21 = 1, coinTransparencyVal22 = 1, coinTransparencyVal23 = 1, coinTransparencyVal24 = 1, coinTransparencyVal25 = 1, coinTransparencyVal26 = 1;
  private int keyTransparencyVal = 1, keyTransparencyVal1 = 1, keyTransparencyVal2 = 1;

  // Hard Level 1 balls positions variables and keys positions array
  private int move = -2;
  private int moveSide = -2;
  private int yDoor1 = 96;
  private int yDoor2 = 128;
  private int yDoor3 = 96;
  private int yDoor4 = 64;
  private int yDoor5 = 64;
  private int yDoor = 32;
  private int[] keysPosH1;
  private int xBounceRight = 200;
  private int xBounceLeft = 488;
  private int yBounceDown = 328;
  private int yBounceUp = 392;

  // Hard Level 2 balls positions variables
  private int xSquareRight = 40;
  private int ySquareRight = 296;
  private int xSquareLeft = 136;
  private int ySquareLeft = 392;

  // Hard Level 3 balls positions variables
  private int xSquareDown = 40;
  private int ySquareDown = 136;
  private int xSquareUp = 136;
  private int ySquareUp = 264;
  private int xSquare = 168;
  private int ySquare = 296;

  // Hard Level 4 balls positions variables
  private int yDown = 40;
  private int xSide = 104;

  // Hard Level 5 balls positions variables
  private double angle = Math.PI / -2;
  private double angleDown = Math.PI / 2;
  private int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, x7, y7, x8, y8;
  private double increment = 0.1;
  private int movingX = -8, movingY = -8;
  
  /** Sets up relevant obbjects, gets the player level, and uses a switch case to setup the balls positions, the coins number and positions, the number of columns in the maze, and the timer speed, also sets up the key listener object (ActionListener method is what causes the visual to be displayed)*/
  public DrawMaze()
  {
   if (isLoad) // Attempt to scan account level file
   {
    try 
    {
     if (!Menu.cheat)
      scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt"));
     else
      scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt"));
     level = scanFile.nextInt();
    } catch (FileNotFoundException i) {} // try catch where account level file is scanneds
    isLoad = false;
   } 
   else // If account is new, assings default level
    level = levi.getLevel();

   // Assign objects
   maze = new MazeLayout();
   p = new Player();
   blueBalls = new Obstacle();
   c = new Coin();
   k = new Key ();
   
   switch (level) // Switch case based on level where balls positions, columuns, coin number, coins positions, and timer are setup
   {
    case 11: // Hard Level 1 setup
     columns = 22;
     coins = 6;
     coinsH1 = c.getCoinsH1();
     keysPosH1 = k.getKeysLvl11Pos();
     if (!Menu.cheat)
      timer = new Timer(25, this);
     else
      timer = new Timer(50, this);
     timer.start();
     break;
    
    case 12: // Hard Level 2 setup
     columns = 16;
     coins = 4;
     coinsH2 = c.getCoinsH2();
     if (!Menu.cheat)
      timer = new Timer(25, this);
     else
      timer = new Timer(50, this);
     timer.start();
     break;
    
    case 13: // Hard Level 3 setup
     columns = 16;
     coins = 4;
     coinsH3 = c.getCoinsH3();
     if (!Menu.cheat)
      timer = new Timer(25, this);
     else
      timer = new Timer(50, this);
     timer.start();
     break;
    
    case 14: // Hard Level 4 setup
     columns = 26;
     coins = 12;
     coinsH4 = c.getCoinsH4();
     if (!Menu.cheat)
      timer = new Timer(25, this);
     else
      timer = new Timer(50, this);
     timer.start();
     break;
    
    case 15: // Hard Level 5 setup
     columns = 26;
     coins = 16;
     coinsH5 = c.getCoinsH5();
     if (!Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(100, this);
     timer.start();
     break;
   } // Switch case based on level where balls positions, columuns, coin number, coins positions, and timer are setup

   addKeyListener(new Move());
   setFocusable(true);
  } //end DrawMaze

  /** Audio when player hits a ball*/
  public void playCollide ()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\collide.wav");
    // Create an AudioStream object from the input stream.
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {} // try catch where audio file as played
  } // playCollide

  /** Audio when player hits a coin*/
  public void playCash ()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\cash.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {} // try catch where audio file as played
  } // playCash

  /** Audio when player completes a level*/
  public void playLevel ()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\levelDone.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {} // try catch where audio file as played
  } // playLevel
  
  /** Audio when a key is collected*/
  public void playKey()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\unlock.wav");
    AudioStream as = new AudioStream(in);         
    AudioPlayer.player.start(as);
   } catch(IOException e){} // try catch where audio file as played
  } // playKey
  
  /** Tasks performed as time passes (the timer increment is how long between when the actionEvent takes place)*/
  public void actionPerformed(ActionEvent e)
  {
   switch (level) // Switch case based on level where balls undergo motion and coins that should be collected are collected (and graphics are painted)
   {
    case 11: // Hard Level 1 ball motion change and coin and key collection
     move1(); // Balls' motion
     if (collectCoin(coinsH1[0] * 32 + 8, coinsH1[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsH1[2] * 32 + 8, coinsH1[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsH1[4] * 32 + 8, coinsH1[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsH1[6] * 32 + 8, coinsH1[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     else if (collectCoin(coinsH1[8] * 32 + 8, coinsH1[9] * 32 + 8, coinTransparencyVal5)) 
      coinTransparencyVal5 = 0;
     else if (collectCoin(coinsH1[10] * 32 + 8, coinsH1[11] * 32 + 8, coinTransparencyVal6)) 
      coinTransparencyVal6 = 0;
     if (isKeyAcquired) // Opens door until it has no size
     {
      yDoor3 -= 4;
      if (yDoor3 <= 0)
       yDoor3 = 0;
     } // if based on whether a key has been picked up, where door is opened
     if (isKeyAcquired2) // Opens door until it has no size
     {
      yDoor1 -= 4;
      if (yDoor1 <= 0)
       yDoor1 = 0;
     } // if based on whether a key has been picked up, where door is opened
     if (isKeyAcquired3) // Opens door until it has no size
     {
      yDoor2 -= 4;
      if (yDoor2 <= 0)
       yDoor2 = 0;
     } // if based on whether a key has been picked up, where door is opened
     break;
     
    case 12: // Hard Level 2 ball motion change and coin and key collection
     squaresRight(); // Balls' motion
     squaresLeft();
     if (collectCoin(coinsH2[0] * 32 + 8, coinsH2[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsH2[2] * 32 + 8, coinsH2[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsH2[4] * 32 + 8, coinsH2[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsH2[6] * 32 + 8, coinsH2[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     if (isKeyAcquired) // Opens door until it has no size
     {
      yDoor2 -= 4;
      if (yDoor2 <= 0)
       yDoor2 = 0;
     } // if based on whether a key has been picked up, where door is opened
     break;
     
    case 13: // Hard Level 3 ball motion change and coin and key collection
     squares(); // Balls' motion
     squareDown();
     if (collectCoin(coinsH3[0] * 32 + 8, coinsH3[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsH3[2] * 32 + 8, coinsH3[3] * 32 + 8, coinTransparencyVal2))
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsH3[4] * 32 + 8, coinsH3[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsH3[6] * 32 + 8, coinsH3[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     if (isKeyAcquired) // Opens door until it has no size
     {
      yDoor -= 4;
      if (yDoor <= 0)
       yDoor = 0;
     } // if based on whether a key has been picked up, where door is opened
     break;
     
    case 14: // Hard Level 4 ball motion change and coin and key collection
     move5(); // Balls' motion
     if (collectCoin(coinsH4[0] * 32 + 8, coinsH4[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsH4[2] * 32 + 8, coinsH4[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsH4[4] * 32 + 8, coinsH4[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsH4[6] * 32 + 8, coinsH4[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     else if (collectCoin(coinsH4[8] * 32 + 8, coinsH4[9] * 32 + 8, coinTransparencyVal5)) 
      coinTransparencyVal5 = 0;
     else if (collectCoin(coinsH4[10] * 32 + 8, coinsH4[11] * 32 + 8, coinTransparencyVal6)) 
      coinTransparencyVal6 = 0;
     else if (collectCoin(coinsH4[12] * 32 + 8, coinsH4[13] * 32 + 8, coinTransparencyVal7)) 
      coinTransparencyVal7 = 0;
     else if (collectCoin(coinsH4[14] * 32 + 8, coinsH4[15] * 32 + 8, coinTransparencyVal8)) 
      coinTransparencyVal8 = 0;
     else if (collectCoin(coinsH4[16] * 32 + 8, coinsH4[17] * 32 + 8, coinTransparencyVal9)) 
      coinTransparencyVal9 = 0;
     else if (collectCoin(coinsH4[18] * 32 + 8, coinsH4[19] * 32 + 8, coinTransparencyVal20)) 
      coinTransparencyVal20 = 0;
     else if (collectCoin(coinsH4[20] * 32 + 8, coinsH4[21] * 32 + 8, coinTransparencyVal21)) 
      coinTransparencyVal21 = 0;
     else if (collectCoin(coinsH4[22] * 32 + 8, coinsH4[23] * 32 + 8, coinTransparencyVal22)) 
      coinTransparencyVal22 = 0;
     break;

    case 15: // Hard Level 5 ball motion change and coin and key collection
     angle += 0.1; // Balls' motion
     angleDown += 0.1;
     if (collectCoin(coinsH5[0] * 32 + 8, coinsH5[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsH5[2] * 32 + 8, coinsH5[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsH5[4] * 32 + 8, coinsH5[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsH5[6] * 32 + 8, coinsH5[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     else if (collectCoin(coinsH5[8] * 32 + 8, coinsH5[9] * 32 + 8, coinTransparencyVal5)) 
      coinTransparencyVal5 = 0;
     else if (collectCoin(coinsH5[10] * 32 + 8, coinsH5[11] * 32 + 8, coinTransparencyVal6)) 
      coinTransparencyVal6 = 0;
     else if (collectCoin(coinsH5[12] * 32 + 8, coinsH5[13] * 32 + 8, coinTransparencyVal7)) 
      coinTransparencyVal7 = 0;
     else if (collectCoin(coinsH5[14] * 32 + 8, coinsH5[15] * 32 + 8, coinTransparencyVal8)) 
      coinTransparencyVal8 = 0;
     else if (collectCoin(coinsH5[16] * 32 + 8, coinsH5[17] * 32 + 8, coinTransparencyVal9)) 
      coinTransparencyVal9 = 0;
     else if (collectCoin(coinsH5[18] * 32 + 8, coinsH5[19] * 32 + 8, coinTransparencyVal20))
      coinTransparencyVal20 = 0;
     else if (collectCoin(coinsH5[20] * 32 + 8, coinsH5[21] * 32 + 8, coinTransparencyVal21))
      coinTransparencyVal21 = 0;
     else if (collectCoin(coinsH5[22] * 32 + 8, coinsH5[23] * 32 + 8, coinTransparencyVal22)) 
      coinTransparencyVal22 = 0;
     else if (collectCoin(coinsH5[24] * 32 + 8, coinsH5[25] * 32 + 8, coinTransparencyVal23)) 
      coinTransparencyVal23 = 0;
     else if (collectCoin(coinsH5[26] * 32 + 8, coinsH5[27] * 32 + 8, coinTransparencyVal24)) 
      coinTransparencyVal24 = 0;
     else if (collectCoin(coinsH5[28] * 32 + 8, coinsH5[29] * 32 + 8, coinTransparencyVal25)) 
      coinTransparencyVal25 = 0;
     else if (collectCoin(coinsH5[30] * 32 + 8, coinsH5[31] * 32 + 8, coinTransparencyVal26)) 
      coinTransparencyVal26 = 0;
     if (isKeyAcquired) // Opens door until it has no size
     {
      yDoor4 -= 4;
      if (yDoor4 <= 0)
       yDoor4 = 0;
     } // if based on whether a key has been picked up, where door is opened
     if (isKeyAcquired2) // Opens door until it has no size
     {
      if (yDoor5 <= 0)
       yDoor5 = 0;
     } // if based on whether a key has been picked up, where door is opened
     break;
   }  // Switch case based on level where balls undergo motion and coins that should be collected are collected
   if (playerIsHit)
    regenerate();
   repaint();
  } // actionPerformed

  /** Causes the player image to fade out (this action is performed several times in a second after the player is hit due to the ActionListener and the timer associated), resetting the level once the player completely fades out*/
  public void regenerate()
  {
   playerTransparencyVal += -0.1f;
   if (playerTransparencyVal <= 0) // Resets level
    reset();
  } // regenerate

  /** Resets the level (positions and transparency of the player as well as coins. key collection boolean variables are also reset)*/
  public void reset()
  {
   playerTransparencyVal = 1; // Reset player transparency
   playCollide (); // Play audio   
   death += 1; // Add to death count
   lblDeath.setText("DEATHS:  " + death);
   playerIsHit = false;
   
   try // Attempt to add death count to account's file
   {
    PrintWriter outFile = new PrintWriter("Game Components\\Player Components\\Player Deaths\\" + username + "-Death.txt");
    outFile.println(death);
    outFile.close();
   } catch (IOException e) {} // try catch where account's death file is updated

   if (!Menu.cheat) // If a cheat account is playing, the maze will not be reset
   {
    switch (level) // Switch case based on level where coins and player positions and keys and are reset
    {
     case 11: // Hard level 1 level reset
      if (checkpoint1) // Checkpoint determines respawn location
      {
       p.setTileX(18);
       p.setTileY(10);
       coins = 6;
       coinTransparencyVal = 1;
       coinTransparencyVal2 = 1;
       coinTransparencyVal3 = 1;
       coinTransparencyVal4 = 1;
       coinTransparencyVal5 = 1;
       coinTransparencyVal6 = 1;
      } // if based on checkpoint being reached or not 
      else if (checkpoint2)  // Checkpoint determines respawn location
      {
       p.setTileX(18);
       p.setTileY(2);
       coins = 0;
      } // if based on checkpoint being reached or not
      else // No checkpoint reached
      {
       p.setTileX(1);
       p.setTileY(6);
       coins = 6;
       coinTransparencyVal = 1;
       coinTransparencyVal2 = 1;
       coinTransparencyVal3 = 1;
       coinTransparencyVal4 = 1;
       coinTransparencyVal5 = 1;
       coinTransparencyVal6 = 1;
       maze.setMazeTile(16, 10, "b");
       maze.setMazeTile(16, 11, "b");
       maze.setMazeTile(16, 12, "b");
       maze.setMazeTile(17, 10, "b");
       maze.setMazeTile(17, 11, "b");
       maze.setMazeTile(17, 12, "b");
       keyTransparencyVal = 1;
       keyTransparencyVal1 = 1;
       keyTransparencyVal2 = 1;
       isKeyAcquired = false;
       isKeyAcquired2 = false;
       isKeyAcquired3 = false;
       yDoor1 = 96;
       yDoor2 = 128;
       yDoor3 = 96;
      } // else if no checkpoints are reached
      break;
      
     case 12: // Hard level 2 level reset
      p.setTileX(7);
      p.setTileY(7);
      coins = 4;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      keyTransparencyVal = 1;
      maze.setMazeTile(5, 1, "b");
      maze.setMazeTile(5, 2, "b");
      maze.setMazeTile(5, 3, "b");
      maze.setMazeTile(5, 4, "b");
      maze.setMazeTile(6, 1, "b");
      maze.setMazeTile(6, 2, "b");
      maze.setMazeTile(6, 3, "b");
      maze.setMazeTile(6, 4, "b");
      yDoor2 = 128;
      isKeyAcquired = false;
      break;
      
     case 13: // Hard level 3 level reset
      p.setTileX(1);
      p.setTileY(1);
      coins = 4;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      keyTransparencyVal = 1;
      maze.setMazeTile(2, 8, "b");
      yDoor = 32;
      isKeyAcquired = false;
      break;
      
     case 14: // Hard level 4 level reset
      p.setTileX(1);
      p.setTileY(1);
      coins = 12;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      coinTransparencyVal5 = 1;
      coinTransparencyVal6 = 1;
      coinTransparencyVal7 = 1;
      coinTransparencyVal8 = 1;
      coinTransparencyVal9 = 1;
      coinTransparencyVal20 = 1;
      coinTransparencyVal21 = 1;
      coinTransparencyVal22 = 1;
      break;
      
     case 15: // Hard level 5 level reset
      p.setTileX(1);
      p.setTileY(4);
      coins = 16;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      coinTransparencyVal5 = 1;
      coinTransparencyVal6 = 1;
      coinTransparencyVal7 = 1;
      coinTransparencyVal8 = 1;
      coinTransparencyVal9 = 1;
      coinTransparencyVal20 = 1;
      coinTransparencyVal21 = 1;
      coinTransparencyVal22 = 1;
      coinTransparencyVal23 = 1;
      coinTransparencyVal24 = 1;
      coinTransparencyVal25 = 1;
      keyTransparencyVal = 1;
      keyTransparencyVal1 = 1;
      yDoor4 = 64;
      yDoor5 = 64;
      maze.setMazeTile(12, 4, "b");
      maze.setMazeTile(12, 5, "b");
      maze.setMazeTile(13, 4, "b");
      maze.setMazeTile(13, 5, "b");
      maze.setMazeTile(22, 4, "b");
      maze.setMazeTile(22, 5, "b");
      isKeyAcquired = false;
      isKeyAcquired2 = false;
      coinTransparencyVal26 = 1;
      break;
    } // Switch case based on level where coins and player positions are reset
   } // if statement based on whether cheat is enabled
  } // reset

  /** Performs all necessary procedures to go to the next level (this method is performed in the Move Class when a key is hit that makes the player reach the end of a level)*/
  public void levelComplete() // Performs all neessary procedures to go to the next level (this method is performed at the end of the Move Class when a key is hit)
  {
   switch (level) // Switch case based on level where the previous level frame is disposed and the frame for the next level is created (Creates a new Medium Object)
   {
    case 11: // Hard level 1 level progression
    case 12: // Hard level 2 level progression
    case 13: // Hard level 3 level progression
    case 14: // Hard level 4 level progression
     playLevel ();
     f.setVisible(false);
     f.dispose();
     levelChange();
     new Hard ();
     break;
    case 15: // Easy level 5 level progression
     break;
   } // Switch case based on level where the previous level frame is disposed and the frame for the next level is created (Creates a new Medium Object)
  } // levelComplete

  /** Increases the level by 1 and records the level on the account's file*/
  public void levelChange()
  {
   levi.setLevel(level + 1);
   try // Attempt to rewerite level value in account's level file
   {
    if (!Menu.cheat) // The account being a cheat or not determines the level file name
     outFile = new PrintWriter("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt");
    else
     outFile = new PrintWriter("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt");
    outFile.println(level + 1);
    outFile.close();
   } catch (IOException i) {} // try catch where level file's value was rewritten
  } // levelChange

  /** Checks if a given coin's X and Y positions are in proximity to the player*/
  public boolean collectCoin(int x, int y, int f)
  {
   if (f == 1) // Only checks if the coin hasn't been collected (it's transparency value would be 0 if it was collected, and 1 if it wasn't collected)
   {
    int xDistance = Math.abs(x - (p.getTileX() * 32 + 16)); // Gets absolute distance of the player x and y points to given coin x and y points
    int yDistance = Math.abs(y - (p.getTileY() * 32 + 16));
    
    // Distance determines whether to decide if the coin has been collected
    if (xDistance > 20)
     return false;
    if (yDistance > 20)
     return false;
    if (xDistance <= 10) 
    {
     if (coins > 0)
      coins -= 1;
     playCash();
     return true;
    } // if based on the X and y distance from the player to the given coin
    if (yDistance <= 10) 
    {
     if (coins > 0)
      coins -= 1;
     playCash();
     return true;
    } // if based on the X and y distance from the player to the given coin
   } // if based on whether the coin hasn't been collected
   return false;
  } // collectCoin

  /** Checks if a given ball's X and Y positions are in proximity to the player*/
  public boolean collision(int x, int y)
  {
   int xDistance = Math.abs(x - (p.getTileX() * 32 + 16)); // Gets absolute distance of the player x and y points to given ball x and y points
   int yDistance = Math.abs(y - (p.getTileY() * 32 + 16));
   // Distance determines whether to decide if the coin has been collected
   if (xDistance > 20)
   return false;
   if (yDistance > 20)
    return false;
   if (xDistance <= 10)
    return true;
   if (yDistance <= 10)
     return true;
   double cornerDistance = Math.sqrt (Math.pow(xDistance - 10, 2) + Math.pow(yDistance - 10, 2));
   if (cornerDistance <= 5)
    return true;
   return false;
  } // collision

  /** Hard Level 1 balls motion method*/
  public void move1()
  {
   if (xBounceRight == 200 && xBounceLeft == 488) 
   {
    moveSide *= -1;
    move *= -1;
   } // if based on ball positions
   if (xBounceRight == 328 && xBounceLeft == 360) 
   {
    moveSide *= -1;
    move *= -1;
   } // if based on ball positions
   if (xBounceRight == 264 && xBounceLeft == 424)
    move *= -1;
   xBounceRight += moveSide;
   xBounceLeft -= moveSide;
   yBounceDown += move;
   yBounceUp -= move;
   if ((xBounceRight == 232 || xBounceRight == 296) && (xBounceLeft == 456 || xBounceLeft == 392))
    move *= -1;
  } // move1

  /** Hard Level 2 balls motion method 1*/
  public void squaresRight()
  {
   if (ySquareRight == 296 && xSquareRight < 136)
    xSquareRight += 4;
   if (xSquareRight == 136 && ySquareRight < 392)
    ySquareRight += 4;
   if (ySquareRight == 392 && xSquareRight > 40)
    xSquareRight -= 4;
   if (xSquareRight == 40 && ySquareRight > 296)
    ySquareRight -= 4;
  } // squaresRigh2

  /** Hard Level 2 balls motion method 2*/
  public void squaresLeft()
  {
   if (ySquareLeft == 392 && xSquareLeft > 40)
    xSquareLeft -= 4;
   if (xSquareLeft == 40 && ySquareLeft > 296)
    ySquareLeft -= 4;
   if (ySquareLeft == 296 && xSquareLeft < 136)
    xSquareLeft += 4;
   if (xSquareLeft == 136 && ySquareLeft < 392)
    ySquareLeft += 4;
  } // squaresLeft

  /** Hard Level 3 balls motion method 1*/
  public void squares()
  {
   if (ySquareDown == 136 && xSquareDown < 72)
    xSquareDown += 2;
   if (xSquareDown == 72 && ySquareDown < 168)
    ySquareDown += 2;
   if (ySquareDown == 168 && xSquareDown > 40)
    xSquareDown -= 2;
   if (xSquareDown == 40 && ySquareDown > 72)
    ySquareDown -= 2;
  } // squares

  /** Hard Level 3 balls motion method 2*/
  public void squareDown()
  {
   if (ySquare == 296 && xSquare > 136)
    xSquare -= 2;
   if (xSquare == 136 && ySquare > 264)
    ySquare -= 2;
   if (ySquare == 264 && xSquare < 168)
    xSquare += 2;
   if (xSquare == 168 && ySquare < 296)
    ySquare += 2;
  } // squareDown

  /** Hard Level 4 balls motion method*/
  public void move5()
  {
   if (yDown == 40)
    movingY *= -1;
   if (xSide == 104)
    movingX *= -1;
   yDown += movingY;
   xSide += movingX;
   if (yDown == 456)
    movingY *= -1;
   if (xSide == 712)
    movingX *= -1;
  } // move5

  /** Visually displays the game*/
  public void paint(Graphics g) 
  {
   ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
   super.paint(g);
   Graphics2D g2d = (Graphics2D) g;

   for (int y = 0; y < maze.getRow(); y++) // Loop through each row in the text file
   {
    for (int x = 0; x < columns; x++) // Loop through each letter in a row (each row is a string element in the maze array)
    {
     if (maze.getMazeTile(x, y).equals("f")) // If current maze tile is the floor
      g.drawImage(maze.getFloor(), x * 32, y * 32, null);
     else if (maze.getMazeTile(x, y).equals("w")) // If current maze tile is a wall
      g.drawImage(maze.getWall(), x * 32, y * 32, null);
     else if (maze.getMazeTile(x, y).equals("g")) // If current maze tile is a green space 
      g.drawImage(maze.getZone(), x * 32, y * 32, null);
     else if (maze.getMazeTile(x, y).equals("b")) // If current maze tile is a barrier, checks to see if the tile could be removed
     {
      if (level == 11 && (((x == 16 || x == 17) && (y == 10 || y == 11 || y == 12) && isKeyAcquired) || ((x == 16 || x == 17) && (y == 1 || y == 2 || y == 3) && isKeyAcquired2) || ((x == 16 || x == 17) && (y == 5 || y == 6 || y == 7 || y == 8) && isKeyAcquired3)))
       maze.setMazeTile(x, y, "f");
      if (level ==15 && (((x == 12 || x == 13) && (y == 4 || y == 5) && isKeyAcquired) || (x == 22 && (y == 4 || y == 5) && isKeyAcquired2)))
       maze.setMazeTile(x, y, "f");
      else if (level == 12 && (x == 5 || x == 6) && (y == 1 || y == 2 || y == 3 || y == 4) && isKeyAcquired) 
       maze.setMazeTile(x, y, "f");
      else if (level == 13 && x == 2 && y == 8 && isKeyAcquired) 
       maze.setMazeTile(x, y, "f");
      // Display the aassociated tile
      if (maze.getMazeTile(x, y).equals("f"))
        g.drawImage(maze.getFloor(), x * 32, y * 32, null);
      if (maze.getMazeTile(x, y).equals("b"))
        g.drawImage(maze.getBarrier(), x * 32, y * 32, null);
     } // if based on the maze tile being a barrier ("b")
    } // for checking each letter of a row of the maze 
   } // for checking each row in the maze

   switch (level) // Switch case based on level where obstacles and coin for corresponding levels are visually displayed (and it checks if the player collided with the ball)
   {
    case 11: // Hard level 1 display and checking for collision
     // Display balls (positions already acquired in move1 method)
     g.drawImage(blueBalls.getBall(), xBounceRight, yBounceDown, null);
     g.drawImage(blueBalls.getBall(), xBounceLeft, yBounceDown, null);
     g.drawImage(blueBalls.getBall(), xBounceRight, yBounceUp, null);
     g.drawImage(blueBalls.getBall(), xBounceLeft, yBounceUp, null);
     g.drawImage(blueBalls.getBall(), xBounceRight, yBounceDown - 288, null);
     g.drawImage(blueBalls.getBall(), xBounceLeft, yBounceDown - 288, null);
     g.drawImage(blueBalls.getBall(), xBounceRight, yBounceUp - 288, null);
     g.drawImage(blueBalls.getBall(), xBounceLeft, yBounceUp - 288, null);
     g.drawImage(blueBalls.getBall(), 200, 168, null);
     g.drawImage(blueBalls.getBall(), 200, 200, null);
     g.drawImage(blueBalls.getBall(), 200, 232, null);
     g.drawImage(blueBalls.getBall(), 264, 200, null);
     g.drawImage(blueBalls.getBall(), 264, 232, null);
     g.drawImage(blueBalls.getBall(), 264, 264, null);
     g.drawImage(blueBalls.getBall(), 328, 168, null);
     g.drawImage(blueBalls.getBall(), 328, 200, null);
     g.drawImage(blueBalls.getBall(), 328, 232, null);
     g.drawImage(blueBalls.getBall(), 392, 200, null);
     g.drawImage(blueBalls.getBall(), 392, 232, null);
     g.drawImage(blueBalls.getBall(), 392, 264, null);
     g.drawImage(blueBalls.getBall(), 456, 168, null);
     g.drawImage(blueBalls.getBall(), 456, 200, null);
     g.drawImage(blueBalls.getBall(), 456, 232, null);
     g.drawImage(blueBalls.getBall(), 520, 200, null);
     g.drawImage(blueBalls.getBall(), 520, 232, null);
     g.drawImage(blueBalls.getBall(), 520, 264, null);
     // Check for collision
     if (collision(xBounceRight, yBounceDown) || collision(xBounceLeft, yBounceDown) || collision(xBounceRight, yBounceUp) || collision(xBounceLeft, yBounceUp) || collision(xBounceRight, yBounceDown - 288) || collision(xBounceLeft, yBounceDown - 288) || collision(xBounceRight, yBounceUp - 288) || collision(xBounceLeft, yBounceUp - 288) || collision(200, 168) || collision(200, 200) || collision(200, 232) || collision(264, 200) || collision(264, 232) || collision(264, 264) || collision(328, 168) || collision(328, 200) || collision(328, 232) || collision(392, 200) || collision(392, 232) || collision(392, 264) || collision(456, 168) || collision(456, 200) || collision(456, 232) || collision(520, 200) && isKeyAcquired3 || collision(520, 232) && isKeyAcquired3 || collision(520, 264) && isKeyAcquired3)
      playerIsHit = true;
     
     // Draw barriers (so that their removal is natural, when the key is picked up yDoors decrease gradually, making it seem as if the barrier is moving)
     Color color = new Color(211, 211, 211);
     g.setColor(color);
     g.fillRect(512, 320, 64, yDoor3);
     g.fillRect(512, 160, 64, yDoor2);
     g.fillRect(512, 32, 64, yDoor1);
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsH1[0] * 32 + 8, coinsH1[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsH1[2] * 32 + 8, coinsH1[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsH1[4] * 32 + 8, coinsH1[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsH1[6] * 32 + 8, coinsH1[7] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal5));
     g2d.drawImage(c.getCoin(), coinsH1[8] * 32 + 8, coinsH1[9] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal6));
     g2d.drawImage(c.getCoin(), coinsH1[10] * 32 + 8, coinsH1[11] * 32 + 8, null);
     
     // Display keys based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal));
     g2d.drawImage(k.getKey(), keysPosH1[0] * 32 + 2, keysPosH1[1] * 32 + 2, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal1));
     g2d.drawImage(k.getKey(), keysPosH1[2] * 32 + 2, keysPosH1[3] * 32 + 2, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal2));
     g2d.drawImage(k.getKey(), keysPosH1[4] * 32 + 2, keysPosH1[5] * 32 + 2, null);
     break;
     
    case 12: // Hard level 2 display and checking for collision
     // Display balls (positions already acquired in the squaresRight/Left methods)
     g.drawImage(blueBalls.getBall(), xSquareRight, ySquareRight, null);
     g.drawImage(blueBalls.getBall(), xSquareLeft, ySquareLeft, null);
     g.drawImage(blueBalls.getBall(), xSquareRight, ySquareRight - 128, null);
     g.drawImage(blueBalls.getBall(), xSquareLeft, ySquareLeft - 128, null);
     g.drawImage(blueBalls.getBall(), xSquareLeft, ySquareRight - 256, null);
     g.drawImage(blueBalls.getBall(), xSquareRight, ySquareLeft - 256, null);
     g.drawImage(blueBalls.getBall(), xSquareRight + 128, ySquareRight, null);
     g.drawImage(blueBalls.getBall(), xSquareLeft + 128, ySquareLeft, null);
     g.drawImage(blueBalls.getBall(), xSquareRight + 256, ySquareRight, null);
     g.drawImage(blueBalls.getBall(), xSquareLeft + 256, ySquareLeft, null);
     g.drawImage(blueBalls.getBall(), xSquareRight + 320, ySquareRight - 128, null);
     g.drawImage(blueBalls.getBall(), xSquareLeft + 320, ySquareLeft - 128, null);
     g.drawImage(blueBalls.getBall(), 72, 328, null);
     g.drawImage(blueBalls.getBall(), 72, 360, null);
     g.drawImage(blueBalls.getBall(), 104, 328, null);
     g.drawImage(blueBalls.getBall(), 104, 360, null);
     g.drawImage(blueBalls.getBall(), 200, 328, null);
     g.drawImage(blueBalls.getBall(), 200, 360, null);
     g.drawImage(blueBalls.getBall(), 232, 328, null);
     g.drawImage(blueBalls.getBall(), 232, 360, null);
     g.drawImage(blueBalls.getBall(), 328, 328, null);
     g.drawImage(blueBalls.getBall(), 328, 360, null);
     g.drawImage(blueBalls.getBall(), 360, 328, null);
     g.drawImage(blueBalls.getBall(), 360, 360, null);
     g.drawImage(blueBalls.getBall(), 72, 200, null);
     g.drawImage(blueBalls.getBall(), 72, 232, null);
     g.drawImage(blueBalls.getBall(), 104, 200, null);
     g.drawImage(blueBalls.getBall(), 104, 232, null);
     g.drawImage(blueBalls.getBall(), 392, 200, null);
     g.drawImage(blueBalls.getBall(), 392, 232, null);
     g.drawImage(blueBalls.getBall(), 424, 200, null);
     g.drawImage(blueBalls.getBall(), 424, 232, null);
     g.drawImage(blueBalls.getBall(), 72, 72, null);
     g.drawImage(blueBalls.getBall(), 72, 104, null);
     g.drawImage(blueBalls.getBall(), 104, 72, null);
     g.drawImage(blueBalls.getBall(), 104, 104, null);
     // Check for collision
     if (collision(xSquareRight, ySquareRight) || collision(xSquareLeft, ySquareLeft) || collision(xSquareRight, ySquareRight - 128) || collision(xSquareLeft, ySquareLeft - 128) || collision(xSquareLeft, ySquareRight - 256) || collision(xSquareRight, ySquareLeft - 256) || collision(xSquareRight + 128, ySquareRight) || collision(xSquareLeft + 128, ySquareLeft) || collision(xSquareRight + 256, ySquareRight) || collision(xSquareLeft + 256, ySquareLeft) || collision(xSquareRight + 320, ySquareRight - 128) || collision(xSquareLeft + 320, ySquareLeft - 128) || collision(72, 328) || collision(72, 360) || collision(104, 328) || collision(104, 360) || collision(200, 328) || collision(200, 360) || collision(232, 328) || collision(232, 360) || collision(328, 328) || collision(328, 360) || collision(360, 328) || collision(360, 360) || collision(72, 200) || collision(72, 232) || collision(104, 200) || collision(104, 232) || collision(392, 200) || collision(392, 232) || collision(424, 200) || collision(424, 232) || collision(72, 72) || collision(72, 104) || collision(104, 72) || collision(104, 104))
      playerIsHit = true;

     // Draw barriers (so that their removal is natural, when the key is picked up yDoors decrease gradually, making it seem as if the barrier is moving)
     Color grey = new Color(211, 211, 211);
     g.setColor(grey);
     g.fillRect(160, 32, 64, yDoor2);

     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsH2[0] * 32 + 8, coinsH2[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsH2[2] * 32 + 8, coinsH2[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsH2[4] * 32 + 8, coinsH2[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsH2[6] * 32 + 8, coinsH2[7] * 32 + 8, null);
     
     // Display key based on its transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal));
     g2d.drawImage(k.getKey(), 13 * 32 + 2, 2 * 32 + 2, null);
     break;
     
    case 13: // Hard level 3 display and checking for collision
     // Display balls (positions already acquired in the squares/squaresDown methods)
     g.drawImage(blueBalls.getBall(), xSquareDown, ySquareDown, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 64, ySquareDown, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 128, ySquareDown, null);
     g.drawImage(blueBalls.getBall(), xSquareDown, ySquareDown + 64, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 64, ySquareDown + 64, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 128, ySquareDown + 64, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 256, ySquareDown, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 256, ySquareDown + 64, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 320, ySquareDown, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 320, ySquareDown + 64, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 384, ySquareDown, null);
     g.drawImage(blueBalls.getBall(), xSquareDown + 384, ySquareDown + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 64, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 128, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 192, ySquare, null);
     // Check for collision
     if (collision(xSquareDown, ySquareDown) || collision(xSquareDown + 64, ySquareDown) || collision(xSquareDown + 128, ySquareDown) || collision(xSquareDown, ySquareDown + 64) || collision(xSquareDown + 64, ySquareDown + 64) || collision(xSquareDown + 128, ySquareDown + 64) || collision(xSquareDown + 256, ySquareDown) || collision(xSquareDown + 256, ySquareDown + 64) || collision(xSquareDown + 320, ySquareDown) || collision(xSquareDown + 320, ySquareDown + 64) || collision(xSquareDown + 384, ySquareDown) || collision(xSquareDown + 384, ySquareDown + 64) || collision(xSquare, ySquare) || collision(xSquare + 64, ySquare) || collision(xSquare + 128, ySquare) || collision(xSquare + 192, ySquare))
      playerIsHit = true;

     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsH3[0] * 32 + 8, coinsH3[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsH3[2] * 32 + 8, coinsH3[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsH3[4] * 32 + 8, coinsH3[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsH3[6] * 32 + 8, coinsH3[7] * 32 + 8, null);

     // Draw barriers (so that their removal is natural, when the key is picked up yDoors decrease gradually, making it seem as if the barrier is moving)
     Color gr = new Color(211, 211, 211);
     g.setColor(gr);
     g.fillRect(64, 256, 32, yDoor);
     
     // Display key based on its transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal));
     g2d.drawImage(k.getKey(), 450, 34, null);
     break;
    
    case 14: // Hard level 4 display and checking for collision
     // Display balls (positions already acquired in the move5 methods)
     g.drawImage(blueBalls.getBall(), 104, yDown, null);
     g.drawImage(blueBalls.getBall(), 264, yDown, null);
     g.drawImage(blueBalls.getBall(), 552, yDown, null);
     g.drawImage(blueBalls.getBall(), 712, yDown, null);
     g.drawImage(blueBalls.getBall(), xSide, 40, null);
     g.drawImage(blueBalls.getBall(), xSide, 136, null);
     g.drawImage(blueBalls.getBall(), xSide, 360, null);
     g.drawImage(blueBalls.getBall(), xSide, 456, null);
     // Check for collision
     if (collision(104, yDown) || collision(264, yDown) || collision(552, yDown) || collision(712, yDown) || collision(xSide, 40) || collision(xSide, 136) || collision(xSide, 360) || collision(xSide, 456))
      playerIsHit = true;
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsH4[0] * 32 + 8, coinsH4[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsH4[2] * 32 + 8, coinsH4[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsH4[4] * 32 + 8, coinsH4[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsH4[6] * 32 + 8, coinsH4[7] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal5));
     g2d.drawImage(c.getCoin(), coinsH4[8] * 32 + 8, coinsH4[9] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal6));
     g2d.drawImage(c.getCoin(), coinsH4[10] * 32 + 8, coinsH4[11] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal7));
     g2d.drawImage(c.getCoin(), coinsH4[12] * 32 + 8, coinsH4[13] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal8));
     g2d.drawImage(c.getCoin(), coinsH4[14] * 32 + 8, coinsH4[15] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal9));
     g2d.drawImage(c.getCoin(), coinsH4[16] * 32 + 8, coinsH4[17] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal20));
     g2d.drawImage(c.getCoin(), coinsH4[18] * 32 + 8, coinsH4[19] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal21));
     g2d.drawImage(c.getCoin(), coinsH4[20] * 32 + 8, coinsH4[21] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal22));
     g2d.drawImage(c.getCoin(), coinsH4[22] * 32 + 8, coinsH4[23] * 32 + 8, null);
     break;
    
    case 15: // Hard level 5 display and checking for collision
     // Get positions
     x1 = (int)(Math.cos(angle) * 96 + 248);
     y1 = (int)(Math.sin(angle) * 96 + 160);
     x2 = (int)(Math.cos(angle) * 64 + 248);
     y2 = (int)(Math.sin(angle) * 64 + 160);
     x3 = (int)(Math.cos(angle) * 32 + 248);
     y3 = (int)(Math.sin(angle) * 32 + 160);
     x4 = (int)(Math.cos(angleDown) * 32 + 248);
     y4 = (int)(Math.sin(angleDown) * 32 + 160);
     x5 = (int)(Math.cos(angleDown) * 64 + 248);
     y5 = (int)(Math.sin(angleDown) * 64 + 160);
     x6 = (int)(Math.cos(angleDown) * 96 + 248);
     y6 = (int)(Math.sin(angleDown) * 96 + 160);

     g.drawImage(blueBalls.getBall(), x1, y1 - 8, null);
     g.drawImage(blueBalls.getBall(), x2, y2 - 8, null);
     g.drawImage(blueBalls.getBall(), x3, y3 - 8, null);
     g.drawImage(blueBalls.getBall(), 248, 152, null);
     g.drawImage(blueBalls.getBall(), x4, y4 - 8, null);
     g.drawImage(blueBalls.getBall(), x5, y5 - 8, null);
     g.drawImage(blueBalls.getBall(), x6, y6 - 8, null);
     g.drawImage(blueBalls.getBall(), x1 + 320, y1 - 8, null);
     g.drawImage(blueBalls.getBall(), x2 + 320, y2 - 8, null);
     g.drawImage(blueBalls.getBall(), x3 + 320, y3 - 8, null);
     g.drawImage(blueBalls.getBall(), 568, 152, null);
     g.drawImage(blueBalls.getBall(), x4 + 320, y4 - 8, null);
     g.drawImage(blueBalls.getBall(), x5 + 320, y5 - 8, null);
     g.drawImage(blueBalls.getBall(), x6 + 320, y6 - 8, null);
     g.drawImage(blueBalls.getBall(), 136, 40, null);
     g.drawImage(blueBalls.getBall(), 168, 40, null);
     g.drawImage(blueBalls.getBall(), 200, 40, null);
     g.drawImage(blueBalls.getBall(), 136, 72, null);
     g.drawImage(blueBalls.getBall(), 168, 72, null);
     g.drawImage(blueBalls.getBall(), 136, 104, null);
     g.drawImage(blueBalls.getBall(), 360, 40, null);
     g.drawImage(blueBalls.getBall(), 328, 40, null);
     g.drawImage(blueBalls.getBall(), 296, 40, null);
     g.drawImage(blueBalls.getBall(), 328, 72, null);
     g.drawImage(blueBalls.getBall(), 360, 72, null);
     g.drawImage(blueBalls.getBall(), 360, 104, null);
     g.drawImage(blueBalls.getBall(), 136, 200, null);
     g.drawImage(blueBalls.getBall(), 136, 232, null);
     g.drawImage(blueBalls.getBall(), 168, 232, null);
     g.drawImage(blueBalls.getBall(), 136, 264, null);
     g.drawImage(blueBalls.getBall(), 168, 264, null);
     g.drawImage(blueBalls.getBall(), 200, 264, null);
     g.drawImage(blueBalls.getBall(), 360, 264, null);
     g.drawImage(blueBalls.getBall(), 328, 264, null);
     g.drawImage(blueBalls.getBall(), 296, 264, null);
     g.drawImage(blueBalls.getBall(), 360, 232, null);
     g.drawImage(blueBalls.getBall(), 328, 232, null);
     g.drawImage(blueBalls.getBall(), 456, 40, null);
     g.drawImage(blueBalls.getBall(), 488, 40, null);
     g.drawImage(blueBalls.getBall(), 520, 40, null);
     g.drawImage(blueBalls.getBall(), 456, 72, null);
     g.drawImage(blueBalls.getBall(), 488, 72, null);
     g.drawImage(blueBalls.getBall(), 456, 104, null);
     g.drawImage(blueBalls.getBall(), 456, 200, null);
     g.drawImage(blueBalls.getBall(), 456, 232, null);
     g.drawImage(blueBalls.getBall(), 488, 232, null);
     g.drawImage(blueBalls.getBall(), 456, 264, null);
     g.drawImage(blueBalls.getBall(), 488, 264, null);
     g.drawImage(blueBalls.getBall(), 520, 264, null);
     g.drawImage(blueBalls.getBall(), 680, 40, null);
     g.drawImage(blueBalls.getBall(), 648, 40, null);
     g.drawImage(blueBalls.getBall(), 616, 40, null);
     g.drawImage(blueBalls.getBall(), 680, 72, null);
     g.drawImage(blueBalls.getBall(), 648, 72, null);
     g.drawImage(blueBalls.getBall(), 680, 104, null);
     g.drawImage(blueBalls.getBall(), 680, 200, null);
     g.drawImage(blueBalls.getBall(), 680, 232, null);
     g.drawImage(blueBalls.getBall(), 648, 232, null);
     g.drawImage(blueBalls.getBall(), 680, 264, null);
     g.drawImage(blueBalls.getBall(), 648, 264, null);
     g.drawImage(blueBalls.getBall(), 616, 264, null);
     // Check for collision
     if (collision(x1, y1) || collision(x2, y2) || collision(x3, y3) || collision(248, 152) || collision(x4, y4 - 8) || collision(x5, y5 - 8) || collision(x6, y6 - 8) || collision(x1 + 320, y1) || collision(x2 + 320, y2) || collision(x3 + 320, y3) || collision(568, 152) || collision(x4 + 320, y4) || collision(x5 + 320, y5) || collision(x6 + 320, y6) || collision(136, 40) || collision(168, 40) || collision(200, 40) || collision(136, 72) || collision(168, 72) || collision(136, 104) || collision(360, 40) || collision(328, 40) || collision(296, 40) || collision(328, 72) || collision(360, 72) || collision(360, 104) || collision(136, 200) || collision(136, 232) || collision(168, 232) || collision(136, 264) || collision(168, 264) || collision(200, 264) || collision(360, 264) || collision(328, 264) || collision(296, 264) || collision(360, 232) || collision(328, 232) || collision(360, 200) || collision(456, 40) || collision(488, 40) || collision(520, 40) || collision(456, 72) || collision(488, 72) || collision(456, 104) || collision(456, 200) || collision(456, 232) || collision(488, 232) || collision(456, 264) || collision(488, 264) || collision(520, 264) || collision(680, 40) || collision(648, 40) || collision(616, 40) || collision(680, 72) || collision(648, 72) || collision(680, 104) || collision(680, 200) || collision(680, 232) || collision(648, 232) || collision(680, 264) || collision(648, 264) || collision(616, 264))
      playerIsHit = true;

     // Draw barriers (so that their removal is natural, when the key is picked up yDoors decrease gradually, making it seem as if the barrier is moving)
     Color lightG = new Color(211, 211, 211);
     g.setColor(lightG);
     g.fillRect(384, 128, 64, yDoor4);
     g.fillRect(704, 128, 32, yDoor5);

     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsH5[0] * 32 + 8, coinsH5[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsH5[2] * 32 + 8, coinsH5[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsH5[4] * 32 + 8, coinsH5[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsH5[6] * 32 + 8, coinsH5[7] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal5));
     g2d.drawImage(c.getCoin(), coinsH5[8] * 32 + 8, coinsH5[9] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal6));
     g2d.drawImage(c.getCoin(), coinsH5[10] * 32 + 8, coinsH5[11] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal7));
     g2d.drawImage(c.getCoin(), coinsH5[12] * 32 + 8, coinsH5[13] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal8));
     g2d.drawImage(c.getCoin(), coinsH5[14] * 32 + 8, coinsH5[15] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal9));
     g2d.drawImage(c.getCoin(), coinsH5[16] * 32 + 8, coinsH5[17] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal20));
     g2d.drawImage(c.getCoin(), coinsH5[18] * 32 + 8, coinsH5[19] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal21));
     g2d.drawImage(c.getCoin(), coinsH5[20] * 32 + 8, coinsH5[21] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal22));
     g2d.drawImage(c.getCoin(), coinsH5[22] * 32 + 8, coinsH5[23] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal23));
     g2d.drawImage(c.getCoin(), coinsH5[24] * 32 + 8, coinsH5[25] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal24));
     g2d.drawImage(c.getCoin(), coinsH5[26] * 32 + 8, coinsH5[27] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal25));
     g2d.drawImage(c.getCoin(), coinsH5[28] * 32 + 8, coinsH5[29] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal26));
     g2d.drawImage(c.getCoin(), coinsH5[30] * 32 + 8, coinsH5[31] * 32 + 8, null);
     
     // Display keys based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal));
     g2d.drawImage(k.getKey(), 194, 194, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, keyTransparencyVal1));
     g2d.drawImage(k.getKey(), 514, 66, null);
     break;
   } // Switch case based on level where obstacles and coin for corresponding levels are visually displayed (and it checks if the player collided with the ball)
   
   // Display player based on its transparency
   g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, playerTransparencyVal));
   g2d.drawImage(p.getPlayer(), p.getTileX() * 32 + 6, p.getTileY() * 32 + 6, null);
  } // paint
  
  /** Moves the player by registering certain key events*/
  public class Move extends KeyAdapter
  {
   /** Default Constructor performs nothing*/
   Move () {}
   
   /** Moves player in direction of key pressed*/
   public void keyPressed(KeyEvent e)
   {
    int keycode = e.getKeyCode();
    if (!Menu.cheat) // If cheat is disabled, once the player is hit, the key pressing should not have an effect (since the player would be dead)
    {
     if (keycode == KeyEvent.VK_W && playerTransparencyVal == 1f) // W == Up
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, -1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_S && playerTransparencyVal == 1f) // S == Down
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, 1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_A && playerTransparencyVal == 1f) // A == Left
     {
      if (!maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(-1, 0);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_D && playerTransparencyVal == 1f) // D == Right
     {
      if (!maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(1, 0);
     } // If based on key event and player transparency (player alive is)
    } // if based on wwhether cheat is enabled
    
    else // If cheat is enabled, the user can move regardless of player death
    {
     if (keycode == KeyEvent.VK_W) // W == Up
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, -1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_S) // S == Down
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, 1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_A) // A == Left
     {
      if (!maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(-1, 0);
     } // If based on key event and player transparency (player alive is) 
     else if (keycode == KeyEvent.VK_D) // D == Right
     {
      if (!maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(1, 0);
     } // If based on key event and player transparency (player alive is)
    } // else performed if cheat is enabled

    switch (level) // switch case based on level where level completion if the user reaches a certain tile and if coins are 0 or if a checkpoint locationis reached
    {
     case 11: // Hard level 1 checks based on player position
      if (p.getTileX() == 5 && p.getTileY() == 6 && !isKeyAcquired) // Check if key was taken
      {
       isKeyAcquired = true;
       keyTransparencyVal = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      else if (p.getTileX() == 19 && p.getTileY() == 10 && !isKeyAcquired2) // Check if key was taken
      {
       isKeyAcquired2 = true;
       keyTransparencyVal1 = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      else if (p.getTileX() == 19 && p.getTileY() == 11 && !isKeyAcquired3) // Check if key was taken
      {
       isKeyAcquired3 = true;
       keyTransparencyVal2 = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      if (p.getTileX() == 18 && (p.getTileY() == 10 || p.getTileY() == 11)) // Check if checkpoint reached
       checkpoint1 = true;
      else if (p.getTileX() == 18 && (p.getTileY() == 2 || p.getTileY() == 3)) // Check if checkpoint reached
      {
       checkpoint2 = true;
       checkpoint1 = false;
      } // if based on second checkpoint being reached or not
      if ((coins == 0) && (p.getTileX() == 18 && (p.getTileY() == 6 || p.getTileY() == 7))) // Check if level complete
       levelComplete();
      break;
     
     case 12: // Hard level 2 checks based on player position
      if (p.getTileX() == 13 && p.getTileY() == 2 && !isKeyAcquired) // Check if key was taken
      {
       isKeyAcquired = true;
       keyTransparencyVal = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      if ((coins == 0) && ((p.getTileX() == 7 || p.getTileX() == 8) && (p.getTileY() == 7 || p.getTileY() == 8))) // Check if level complete
       levelComplete();
      break;
     
     case 13: // Hard level 3 checks based on player position
      if (p.getTileX() == 14 && p.getTileY() == 1 && !isKeyAcquired) // Check if key was taken
      {
       isKeyAcquired = true;
       keyTransparencyVal = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      if ((coins == 0) && ((p.getTileX() == 13 || p.getTileX() == 14) && (p.getTileY() == 9 || p.getTileY() == 10))) // Check if level complete
       levelComplete();
      break;
     
     case 14: // Hard level 4 checks based on player position
      if ((coins == 0) && ((p.getTileX() == 23 || p.getTileX() == 24) && (p.getTileY() == 13 || p.getTileY() == 14))) // Check if level complete
       levelComplete();
     
     case 15: // Hard level 5 checks based on player position
      if (p.getTileX() == 6 && p.getTileY() == 6 && !isKeyAcquired) // Check if key was taken
      {
       isKeyAcquired = true;
       keyTransparencyVal = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      else if (p.getTileX() == 16 && p.getTileY() == 2 && !isKeyAcquired2) // Check if key was taken
      {
       isKeyAcquired2 = true;
       keyTransparencyVal1 = 0;
       playKey();
       repaint();
      } // if based on key being taken or not
      break;
    } // switch case based on level where level completion if the user reaches a certain tile and if coins are 0 or if a checkpoint locationis reached
   } // keyPressed
   
   /** If key is released (not used)*/public void keyReleased(KeyEvent e) {}
   /** If key is typed (not used)*/public void keyTyped(KeyEvent e) {}
  } // Move
 } // DrawMaze
} // Hard class