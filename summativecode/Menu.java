import java.awt.*; // Used for GUI
import java.awt.event.*; // Used for GUI
import javax.swing.*; // Used for GUI
import java.util.Scanner; // Used for File scanning
import java.io.*; // Used for File I/O
import java.util.ArrayList; // Used for Arraylist creation
import sun.audio.*; // Used for audio
import javax.sound.sampled.AudioInputStream; // Used for audio
import javax.sound.sampled.AudioSystem; // Used for audio
import javax.sound.sampled.Clip; // Used for audio
import javax.sound.sampled.LineUnavailableException; // Used for audio
import javax.sound.sampled.UnsupportedAudioFileException; // Used for audio

/**The frame that displays the main menu and generates the games or leader boards or instructions based on user input*/ 
public class Menu implements ActionListener 
{
 //Components for file reader and writer
 /**File writer that gets the list of accounts file*/static FileWriter listOfAcc;
 /**Print writers that edits related files upon new account creation*/static PrintWriter accntLvlWriter, addAccntToListWriter, numGameModeAccntsWriter;
 // Data fields used in multiple methods of menu 
 /**Integers that store properties of a new account*/int level, numAccounts, death = 0; 
 /**Scanners that reads related files upon account loading*/static Scanner accntLvlScnr, numAccntsFileScnr;
 /**List of accounts of a certain game mode (used in leaderboard)*/static String [] listGameModeAccounts;
 /**Account username, used in Easy, Medium, and Hard classes*/static String username;
 /**Whether account was loaded or not, used in Easy, Medium, and Hard classes*/static boolean isLoad = false;
 /**Whether the game mode is easy, used in Easy, Medium, and Hard classes*/static boolean easy = false;
 /**Whether the game mode is medium, used in Easy, Medium, and Hard classes*/static boolean medium = false;
 /**Whether the game mode is hard, used in Easy, Medium, and Hard classes*/static boolean hard = false;
 /**Whether cheating is enabled, used in Easy, Medium, and Hard classes*/static boolean cheat = false;
 
 // Components for main menu
 /**Main menu GUI Frame*/ JFrame mainMenuFrame = new JFrame ("Title");
 /**Main menu title image*/ ImageIcon imgTitle;
 /**Main menu title image's label*/ JLabel titleLabel = new JLabel ();
 // Main menu panels
 /**Main menu GUI master panel*/ JPanel menuMasterPanel = new JPanel ();
 /**Main menu GUI panel for the title image*/ JPanel titlePanel = new JPanel ();
 /**Main menu GUI panel for the button to play a normal game*/ JPanel btnPanelPlay = new JPanel ();
 /**Main menu GUI panel for the button to play a cheat game*/JPanel btnPanelCheat = new JPanel ();
 /**Main menu GUI panel for the button to display the instructions*/JPanel btnPanelInstruct = new JPanel ();
 /**Main menu GUI panel for the button to choose a leader board*/JPanel btnPanelBoard = new JPanel ();
 // Main menu buttons
 /**Main menu GUI button to play a normal game*/JButton btnPlay = new JButton("Play");
 /**Main menu GUI button to play a cheat game*/JButton btnCheat = new JButton("Cheat Mode");
 /**Main menu GUI button to display the instructions*/JButton btnInstruct = new JButton("Instructions");
 /**Main menu GUI button to choose a leader board*/JButton btnBoard = new JButton("Leaderboard");

 // Buttons to go back to the main menu
 /**Play Game GUI panel for the button to go back to the main menu from the Play Game Frame*/JPanel backBtnPanel = new JPanel ();
 /**Play Game GUI button to go back to the main menu from the Play Game Frame*/JButton backBtn = new JButton("Back to Menu");
 /**Leader board choice GUI panel for the button to go back to the main menu from the choose leaderboard Frame*/JPanel backBtnPanel2 = new JPanel ();
 /**Leader board choice GUI button to go back to the main menu from the choose leaderboard Frame*/JButton backBtn2 = new JButton("Back to Menu");
 /**Instructions GUI panel for the button to go back to the main menu from the instructions Frame*/JPanel backBtnPanel3 = new JPanel ();
 /**Instructions GUI button to go back to the main menu from the instructions Frame*/JButton backBtn3 = new JButton("Back to Menu");

 // Components for game creation (made visible upon clicking play button or cheat mode button)
 /**Play Game GUI Frame*/JFrame PlayGameFrame = new JFrame ("New Game or Load Game?");
 /**Play game GUI master panel*/JPanel playGameMasterPanel = new JPanel ();
 /**Play game GUI panel for the label that prompts for a new or loaded game*/JPanel NewOrLoadGamePromptPanel = new JPanel ();
 /**Play game GUI label that prompts for a new or loaded game*/JLabel NewOrLoadGamePromptLabel = new JLabel ("Would you like to create a new game or load existing one?");
 // Buttons and panels to choose a new game or to load an old game
 /**Play New Game GUI panel for the button to play a new game*/JPanel NewGameBtnPanel = new JPanel ();
 /**Play New Game GUI panel for the button to play a loaded game*/JPanel LoadGameBtnPanel = new JPanel ();
 /**Play New Game GUI button to play a new game*/JButton btnNewGame = new JButton("New Game");
 /**Play New Game GUI button to play a loadedgame*/JButton btnLoadGame = new JButton("Load Game");
 
 // Components for new new user game option frame (made visible upon clicking New Game button)
 /**New User GUI Frame*/JFrame newUserFrame = new JFrame ("Username");
 /**New User GUI master panel*/JPanel newUserMasterPanel = new JPanel ();
 /**New User GUI panel for the label that prompts for a new user name*/JPanel enterNewUserPromptPanel = new JPanel ();
 /**New User GUI label that prompts for a new username*/JLabel enterNewUserPromptLabel = new JLabel ("Please enter your username:");
 /**New User GUI panel for the text field to enter a new username*/JPanel enterNewUserTF_Panel = new JPanel ();
 /**New User GUI text field to enter a new username*/JTextField _enterNewUserTF = new JTextField (12);
 /**New User GUI button to enter a new user*/JButton btnEnter = new JButton("Enter");
 // New game buttons and associated panels for choosing game mode
 /**New User GUI panel for the button to choose an easy game*/JPanel btnPanelEasy = new JPanel ();
 /**New User GUI panel for the button to choose a medium game*/JPanel btnPanelMed = new JPanel ();
 /**New User GUI panel for the button to choose a hard game*/JPanel btnPanelHard = new JPanel ();
 /**New User GUI button to choose an easy game*/JButton btnEasy = new JButton("Easy Mode");
 /**New User GUI button to choose a medium game*/JButton btnMed = new JButton("Intermediate Mode");
 /**New User GUI button to choose a hard game*/JButton btnHard = new JButton("Hard Mode");
 
 // Components for load user game option frame (made visible upon clicking Load Game button)
 /**Load User GUI Frame*/JFrame loadGameFrame = new JFrame ("Load Game");
 /**Load User GUI master panel*/JPanel loadGamePromptPanel = new JPanel ();
 /**Load User GUI panel for the label that prompts for an existing user name*/JPanel enterExistingUserPromptPanel = new JPanel ();
 /**Load User GUI label that prompts for an existing username*/JLabel enterExistingUserPromptLabel = new JLabel ("Please enter your existing username");
 /**Load User GUI panel for the text field to enter an existing username*/JPanel enterExistingUserTF_Panel = new JPanel ();
 /**Load User GUI text field to enter an exisitng username*/JTextField _enterExistingUserTF = new JTextField (12);
 /**Load User GUI button to load a user*/JButton btnLoad = new JButton("Load");

 // Components for choosing leader board (made visible upon clicking leaderboard button)
 /**Leader board choice GUI Frame*/JFrame ldrBrdFrame = new JFrame ("Select Leaderboard");
 /**Leader board choice GUI master panel*/JPanel ldrBrdMasterPanel = new JPanel ();
 /**Leader board choice GUI panel for the label that prompts for the game mode to display on the leaderboard*/JPanel ldrBrdPromptPanel = new JPanel ();
 /**Leader board choice GUI label that prompts for the game mode to display on the leaderboard*/JLabel ldrBrdPromptLabel = new JLabel ("Select leader board mode");
 // Leader board choice buttons and associated panels
 /**Leader board choice GUI panel for the button to load the easy mode leaderboard*/JPanel easyLdrBrdBtnPanel = new JPanel ();
 /**Leader board choice GUI panel for the button to load the medium mode leaderboard*/JPanel mediumLdrBrdBtnPanel = new JPanel ();
 /**Leader board choice GUI panel for the button to load the hard mode leaderboard*/JPanel hardLdrBrdBtnPanel = new JPanel ();
 /**Leader board choice GUI button to load the easy mode leaderboard*/JButton easyLdrBrdBtn = new JButton("Easy Mode");
 /**Leader board choice GUI button to load the medium mode leaderboard*/JButton mediumLdrBrdBtn = new JButton("Medium Mode");
 /**Leader board choice GUI button to load the hard mode leaderboard*/JButton hardLdrBrdBtn = new JButton("Hard Mode");
  
 //Components for instructions frame
 /**Instructions GUI Frame*/JFrame instructionsFrame = new JFrame ("Instructions");
 /**Instructions GUI panel*/JPanel instructionsPanel = new JPanel ();
 /**Instructions GUI label for the first line of text*/JLabel instructionsTexLabel1 = new JLabel ("You are a red square. Your objective for each level is to collect all");
 /**Instructions GUI label for the second line of text*/JLabel instructionsTexLabel2 = new JLabel ("the yellow coins and successfully travel to the final green area.");
 /**Instructions GUI label for the third line of text*/JLabel instructionsTexLabel3 = new JLabel ("But watch out for the blue obstacles that are out to get you!");
 /**Instructions GUI label for the forth line of text*/JLabel instructionsTexLabel4 = new JLabel ("If you are hit by a blue ball, you lose your coins and respawn to");
 /**Instructions GUI label for the fifth line of text*/JLabel instructionsTexLabel5 = new JLabel ("the last green area you touched in the level. Try to complete all the");
 /**Instructions GUI label for the sixth line of text*/JLabel instructionsTexLabel6 = new JLabel ("levels with the least number of account Deaths. Good luck!");
 /**Instructions GUI label for the seventh line of text*/JLabel instructionsTexLabel7 = new JLabel ("Move using WASD");
 
 /**Sets up the GUI for the menu and all corresponding components*/
 public Menu()
 {
  // Set back button
  backBtn.addActionListener (this);
  backBtnPanel.add (backBtn);
  backBtn2.addActionListener (this);
  backBtnPanel2.add (backBtn2);
  backBtn3.addActionListener (this);
  backBtnPanel3.add (backBtn3);

  // Constructing main menu frame
  // Set game title image
  imgTitle = new ImageIcon ("Game Components\\Visual Components\\Title.png");
  titleLabel.setIcon(imgTitle);
  titlePanel.add (titleLabel);
  // Set main menu buttons
  btnPlay.addActionListener (this);
  btnCheat.addActionListener (this);
  btnInstruct.addActionListener (this);
  btnBoard.addActionListener (this);
  btnPanelPlay.add (btnPlay);
  btnPanelCheat.add (btnCheat);
  btnPanelInstruct.add (btnInstruct);
  btnPanelBoard.add (btnBoard);
  // Add components to main panel
  menuMasterPanel.setLayout(new BoxLayout(menuMasterPanel, BoxLayout.Y_AXIS));
  menuMasterPanel.add (titlePanel);
  menuMasterPanel.add (btnPanelPlay);
  menuMasterPanel.add (btnPanelCheat);
  menuMasterPanel.add (btnPanelInstruct);
  menuMasterPanel.add (btnPanelBoard);
  // Add main panel to main frame main frame (main frame is visible)
  mainMenuFrame.add (menuMasterPanel);
  mainMenuFrame.pack ();
  mainMenuFrame.setVisible(true);
  mainMenuFrame.setResizable (false);
  mainMenuFrame.setLocationRelativeTo (null);

  // Constructing play game frame (frame is invisible)
  // Set play game buttons and prompt
  btnNewGame.addActionListener (this);
  btnLoadGame.addActionListener (this);
  NewGameBtnPanel.add (btnNewGame);
  LoadGameBtnPanel.add (btnLoadGame);
  NewOrLoadGamePromptPanel.add (NewOrLoadGamePromptLabel);
  // Add components to play game panel
  playGameMasterPanel.setLayout(new BoxLayout(playGameMasterPanel, BoxLayout.Y_AXIS));
  playGameMasterPanel.add (NewOrLoadGamePromptPanel);
  playGameMasterPanel.add (NewGameBtnPanel);
  playGameMasterPanel.add (LoadGameBtnPanel);
  playGameMasterPanel.add (backBtnPanel);
  // Add play game panel to play game frame  (play game frame is invisible)
  PlayGameFrame.add (playGameMasterPanel);
  PlayGameFrame.pack ();
  PlayGameFrame.setVisible(false);
  PlayGameFrame.setResizable (false);
  PlayGameFrame.setLocationRelativeTo (null);
  
  // Constructing leader board choice frame (frame is invisible)
  // Set leader board buttons and prompt
  easyLdrBrdBtn.addActionListener (this);
  mediumLdrBrdBtn.addActionListener (this);
  hardLdrBrdBtn.addActionListener (this);
  easyLdrBrdBtnPanel.add (easyLdrBrdBtn);
  mediumLdrBrdBtnPanel.add (mediumLdrBrdBtn);
  hardLdrBrdBtnPanel.add (hardLdrBrdBtn);
  ldrBrdPromptPanel.add (ldrBrdPromptLabel);
  // Add components to leader board panel
  ldrBrdMasterPanel.setLayout(new BoxLayout(ldrBrdMasterPanel, BoxLayout.Y_AXIS));
  ldrBrdMasterPanel.add (ldrBrdPromptPanel);
  ldrBrdMasterPanel.add (easyLdrBrdBtnPanel);
  ldrBrdMasterPanel.add (mediumLdrBrdBtnPanel);
  ldrBrdMasterPanel.add (hardLdrBrdBtnPanel);
  ldrBrdMasterPanel.add (backBtnPanel2);
  // Add leader board panel to leader board frame  (leader board frame is invisible)
  ldrBrdFrame.add (ldrBrdMasterPanel);
  ldrBrdFrame.pack ();
  ldrBrdFrame.setVisible(false);
  ldrBrdFrame.setResizable (false);
  ldrBrdFrame.setLocationRelativeTo (null);

  // Constructing new user options frame (frame is invisible)
  // Set new user buttons with text field and prompt
  btnEnter.addActionListener (this);
  btnEasy.addActionListener (this);
  btnMed.addActionListener (this);
  btnHard.addActionListener (this);
  btnEasy.setEnabled (false); // Disable buttons until the user's name is entered
  btnMed.setEnabled (false);
  btnHard.setEnabled (false);
  enterNewUserTF_Panel.add (_enterNewUserTF);
  enterNewUserTF_Panel.add (btnEnter);
  btnPanelEasy.add (btnEasy);
  btnPanelMed.add (btnMed);
  btnPanelHard.add (btnHard);
  enterNewUserPromptPanel.add (enterNewUserPromptLabel);
  // Add components to new user panel
  newUserMasterPanel.setLayout(new BoxLayout(newUserMasterPanel, BoxLayout.Y_AXIS));
  newUserMasterPanel.add (enterNewUserPromptPanel);
  newUserMasterPanel.add (enterNewUserTF_Panel);
  newUserMasterPanel.add (btnPanelEasy);
  newUserMasterPanel.add (btnPanelMed);
  newUserMasterPanel.add (btnPanelHard);
  // Add new user panel to new user frame  (new user frame is invisible)
  newUserFrame.add (newUserMasterPanel);
  newUserFrame.pack ();
  newUserFrame.setVisible(false);
  newUserFrame.setResizable (false);
  newUserFrame.setLocationRelativeTo (null);

  // Constructing instructions frame (frame is invisible)
  // Add components to instructions panel
  instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS));
  instructionsPanel.add (instructionsTexLabel1);
  instructionsPanel.add (instructionsTexLabel2);
  instructionsPanel.add (instructionsTexLabel3);
  instructionsPanel.add (instructionsTexLabel4);
  instructionsPanel.add (instructionsTexLabel5);
  instructionsPanel.add (instructionsTexLabel6);
  instructionsPanel.add (instructionsTexLabel7);
  instructionsPanel.add (backBtnPanel3);
  // Add instructions panel to instructions frame  (instructions frame is invisible)
  instructionsFrame.add (instructionsPanel);
  instructionsFrame.pack ();
  instructionsFrame.setVisible(false);
  instructionsFrame.setResizable (false);
  instructionsFrame.setLocationRelativeTo (null);

  // Constructing load game frame (frame is invisible)
  // Set load button with text field and prompt
  btnLoad.addActionListener (this);
  enterExistingUserTF_Panel.add (_enterExistingUserTF);
  enterExistingUserTF_Panel.add (btnLoad);
  enterExistingUserPromptPanel.add (enterExistingUserPromptLabel);
  // Add components to load game panel
  loadGamePromptPanel.setLayout(new BoxLayout(loadGamePromptPanel, BoxLayout.Y_AXIS));
  loadGamePromptPanel.add (enterExistingUserPromptPanel);
  loadGamePromptPanel.add (enterExistingUserTF_Panel);
  // Add load game panel to load game frame  (load game frame is invisible)
  loadGameFrame.add (loadGamePromptPanel);
  loadGameFrame.pack ();
  loadGameFrame.setVisible(false);
  loadGameFrame.setResizable (false);
  loadGameFrame.setLocationRelativeTo (null);
 } // Menu Constructor

 /**Actions performed when particular buttons are pressed*/
 public void actionPerformed(ActionEvent e)
 {
  if (e.getSource() == backBtn || e.getSource() == backBtn2 || e.getSource() == backBtn3) // If back button is pressed
  {
   instructionsFrame.setVisible(false);
   PlayGameFrame.setVisible (false);
   ldrBrdFrame.setVisible (false);
   mainMenuFrame.setVisible(true);
  } // if based on back button being pressed
  
  else if (e.getSource() == btnPlay) // If play button is pressed
  {
   mainMenuFrame.setVisible(false);
   PlayGameFrame.setVisible(true);
  } // if based on play button being pressed
  
  else if (e.getSource() == btnCheat) // If cheat button is pressed
  {
   mainMenuFrame.setVisible(false);
   PlayGameFrame.setVisible(true);
   cheat = true;
  } // if based on cheat button being pressed
  
  else if (e.getSource() == btnInstruct) // If instructions button is pressed 
  {
   mainMenuFrame.setVisible(false);
   instructionsFrame.setVisible(true);
   instructionsFrame.setLocationRelativeTo (null);
  } // if based on cheat button being pressed
  
  else if (e.getSource() == btnBoard) // If leaderboard button is pressed
  {
   mainMenuFrame.setVisible(false);
   ldrBrdFrame.setVisible(true);
   ldrBrdFrame.setLocationRelativeTo (null);
  } // if based on leader board button being pressed
  
  else if (e.getSource() == easyLdrBrdBtn) // If easy leaderboard button is pressed
  {
   ldrBrdFrame.setVisible(false);
   displayLeaderBoard ("Easy");
  } // if based on easy leaderboard button being pressed
  
  else if (e.getSource() == mediumLdrBrdBtn) // If medium leaderboard button is pressed
  {
   ldrBrdFrame.setVisible(false);
   displayLeaderBoard ("Medium");
  } // if based on medium leaderboard button being pressed
  
  else if (e.getSource() == hardLdrBrdBtn) // If hard leaderboard button is pressed
  {
   ldrBrdFrame.setVisible(false);
   displayLeaderBoard ("Hard");
  } // if based on hard leaderboard button being pressed
  
  else if (e.getSource() == btnEnter) // If enter username button is pressed (for new game)
  {
   username = _enterNewUserTF.getText();
   if (!(username.equals(""))) // if the username isn't empty, try to create associated account files and also enables buttons for further user account creation
   {
    try // Try to create and alter relevant files upon account creation
    {
     if (!cheat) // The account being a cheat or not determines the level file name
      accntLvlWriter = new PrintWriter ("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt");
     else
      accntLvlWriter = new PrintWriter ("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt");
     PrintWriter accntDeathWriter = new PrintWriter ("Game Components\\Player Components\\Player Deaths\\" + username + "-Death.txt");
     accntDeathWriter.println(death);
     accntDeathWriter.close();
     if (!cheat) // if cheat is on or not
     {
      listOfAcc = new FileWriter ("Game Components\\Player Components\\Accounts.txt", true);
      addAccntToListWriter = new PrintWriter (listOfAcc);
      addAccntToListWriter.println(username);
      addAccntToListWriter.close();
     } // if based on cheat being on or not
    } catch (IOException i) {} // try catch based on new account file creation and writing working or not
    // Enables buttons for further new user account creation
    _enterNewUserTF.setEnabled (false);
    btnEnter.setEnabled (false);
    btnHard.setEnabled (true);
    btnMed.setEnabled (true);
    btnEasy.setEnabled (true);
   } // if based on new user's username being empty or not
   else 
   {
    _enterNewUserTF.setText("");
    enterNewUserPromptLabel.setText("Please try again");
   } // else based on username being empty or not
  } // if based on username button for new account creation being pressed
  
  else if (e.getSource() == btnNewGame) // If new game button is pressed
  {
   PlayGameFrame.setVisible(false);
   newUserFrame.setVisible(true);
  } // if based on new game button being pressed
  
  else if (e.getSource() == btnEasy) // If easy mode button is pressed
   setUpNewGame ("Easy");
  
  else if (e.getSource() == btnMed) // If intermediate mode button is pressed
   setUpNewGame ("Medium");
  
  else if (e.getSource() == btnHard) // If hard mode button is pressed
   setUpNewGame ("Hard");
  
  else if (e.getSource() == btnLoadGame) // If load game button is pressed
  {
   PlayGameFrame.setVisible(false);
   loadGameFrame.setVisible(true);
  } // if based on load game button being pressed
  
  else if (e.getSource() == btnLoad) // If load account button is pressed
  {
   username = _enterExistingUserTF.getText();
   try // Tries to load account's level file, if the account doesn't exist, assumes the input is invalid
   {
    if (!cheat) // The account being a cheat or not determines the level file name
     accntLvlScnr = new Scanner (new File ("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt"));
    else
     accntLvlScnr = new Scanner (new File ("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt"));
    loadGameFrame.setVisible(false);
    isLoad = true; // Load property set to true (is used on easy, meidum,nad hard objects
    level = accntLvlScnr.nextInt();
    if (level >= 1 && level <= 5) // If level in easy range
    {
     easy = true;
     new Easy();
    } // if based on level range
    else if (level >= 6 && level <= 10) // If level in medium range
    {
     medium = true;
     new Medium();
    } // if based on level range
    else if (level >= 11 && level <= 15) // If level in hard range 
    {
     hard = true;
     new Hard();
    } // if based on level range
    playSound();
   } // try catch based on whether user's account can be loaded
   catch (FileNotFoundException i)
   {
    _enterExistingUserTF.setText("");
    enterExistingUserPromptLabel.setText("Account does not exist. Try again.");
   } // catch if user's level file can't be loaded
  } // if based on load game button being pressed
 } // ActionPerformed
 
 /** Manipulates associated files and creates the apropriate game mode objects based on the particular game mode chosen for a new account*/
 public void setUpNewGame (String gameMode)
 {
   // Prints first level of associated game mode onto the account's level file
   if (gameMode == "Easy")
    accntLvlWriter.println(1);
   else if (gameMode == "Medium")
    accntLvlWriter.println(6);
   else if (gameMode == "Hard")
    accntLvlWriter.println(11);
   accntLvlWriter.close();
   try // Attempt to increase the associated game mode's account number file by 1 (if the account isn't a cheat account)
   {
    if (!cheat) 
    {
     numAccntsFileScnr = new Scanner (new File ("Game Components\\Player Components\\" + gameMode + "AccountNumber.txt"));
     numAccounts = numAccntsFileScnr.nextInt() + 1;
     numGameModeAccntsWriter = new PrintWriter ("Game Components\\Player Components\\" + gameMode + "AccountNumber.txt");
     numGameModeAccntsWriter.println(numAccounts);
     numGameModeAccntsWriter.close();
    } // if based on he account being a cheat or not
   } catch (IOException ie){} // try catch based on the associated game mode's account number file by 1
   
   // Creates the game object
   if (gameMode == "Easy")
   {
    easy = true;
    new Easy ();
   } // if based on game mode
   else if (gameMode == "Medium")
   {
    medium = true;
    new Medium ();
   } // if based on game mode
   else if (gameMode == "Hard")
   {
    hard = true;
    new Hard ();
   } // if based on game mode
   playSound();
   newUserFrame.setVisible(false);
 } // setUpNewGame
 
 /** Background music when game is played*/
 public void playSound ()
 {
  try // Attempt to load audio file in a loop
  {
   Clip clip = AudioSystem.getClip();
   AudioInputStream inputStream = AudioSystem.getAudioInputStream(Menu.class.getResource("Game Components\\Audio Components\\growing_on_me.wav"));
   clip.open(inputStream);
   clip.loop(Clip.LOOP_CONTINUOUSLY);
   clip.start();
  } catch(IOException | UnsupportedAudioFileException | LineUnavailableException e){} // try catch where audio file as played
 } // playSound
 
 /** Creates leader board of a certain game mode*/
 public void displayLeaderBoard (String gameMode)
 {
  createListOfAccnts (gameMode);
  // Sets formatted GUi objects
  JFrame leaderBoard = new JFrame ("Leader board: " + gameMode + " Mode");
  JPanel ldrBrdMasterPanel = new JPanel ();
  JLabel boardLine1 = new JLabel ();
  JLabel boardLine2 = new JLabel ();
  JLabel boardLine3 = new JLabel ();
  JLabel boardLine4 = new JLabel ();
  JLabel boardLine5 = new JLabel ();
  JLabel boardLine6 = new JLabel ();
  boardLine1.setText("Rank    " + "User    " + "Level    " + "Death ");
  boardLine2.setText("1         " + getLeaderBoardName (0) + "       " + readLevel (getLeaderBoardName (0)) + "       " + readDeath(getLeaderBoardName (0)));
  boardLine3.setText("2         " + getLeaderBoardName (1) + "       " + readLevel (getLeaderBoardName (1)) + "       " + readDeath(getLeaderBoardName (1)));
  boardLine4.setText("3         " + getLeaderBoardName (2) + "       " + readLevel (getLeaderBoardName (2)) + "       " + readDeath(getLeaderBoardName (2)));
  boardLine5.setText("4         " + getLeaderBoardName (3) + "       " + readLevel (getLeaderBoardName (3)) + "       " + readDeath(getLeaderBoardName (3)));
  boardLine6.setText("5         " + getLeaderBoardName (4) + "       " + readLevel (getLeaderBoardName (4)) + "       " + readDeath(getLeaderBoardName (4)));
  // Adds GUI objects to panel then to frame
  ldrBrdMasterPanel.setLayout(new BoxLayout(ldrBrdMasterPanel, BoxLayout.Y_AXIS));
  ldrBrdMasterPanel.add (boardLine1);
  ldrBrdMasterPanel.add (Box.createRigidArea(new Dimension(0, 20)));
  ldrBrdMasterPanel.add (boardLine2);
  ldrBrdMasterPanel.add (Box.createRigidArea(new Dimension(0, 20)));
  ldrBrdMasterPanel.add (boardLine3);
  ldrBrdMasterPanel.add (Box.createRigidArea(new Dimension(0, 20)));
  ldrBrdMasterPanel.add (boardLine4);
  ldrBrdMasterPanel.add (Box.createRigidArea(new Dimension(0, 20)));
  ldrBrdMasterPanel.add (boardLine5);
  ldrBrdMasterPanel.add (Box.createRigidArea(new Dimension(0, 20)));
  ldrBrdMasterPanel.add (boardLine5);
  leaderBoard.add (ldrBrdMasterPanel);
  leaderBoard.pack ();
  leaderBoard.setResizable (false);
  leaderBoard.setLocationRelativeTo (null);
  leaderBoard.setVisible(true);
 } // displayLeaderBoard
 
 /** Assigns all accounts of a certain game mode to a position in a ranked list (stored in a predefined array of strings) (used in the creating the leaderboard)*/
 public void createListOfAccnts (String gameMode)
 {
  Scanner scan; // File scanning and writing componentss
  String user; // Used for populating the array with accounts relevant to the game mode
  int countNumAccnts;
  try // Attempt to scan number of accounts of that game mode
  {
   scan = new Scanner (new File ("Game Components\\Player Components\\" + gameMode + "AccountNumber.txt"));
   countNumAccnts = scan.nextInt();
  } // try where number of accounts registered in a game mode is scanned
  catch (FileNotFoundException it) 
  {
   countNumAccnts = 1;
  } // catch where default list size is set if the file with the number of accounts in a game mode can't be found
  listGameModeAccounts = new String [countNumAccnts];
  
  try // Attempt to check all accounts and add relevent ones to the list array
  {
   scan = new Scanner (new File ("Game Components\\Player Components\\Accounts.txt"));
   for (int counter = 0; scan.hasNextLine() && counter < listGameModeAccounts.length; counter++)
   {
     // Acquires current account level
    user = scan.nextLine();
    Scanner accntLvlScnr = new Scanner (new File ("Game Components\\Player Components\\Player Levels\\" + user + "-Level.txt"));
    level = accntLvlScnr.nextInt();
    // Level corresponds to game mode, if the level matches the given game mode, the name belongs onthe list
    if (level <= 5 && gameMode == "Easy")
     listGameModeAccounts [counter] = user;
    else if (level >= 6 && level <= 10 && gameMode == "Medium")
     listGameModeAccounts [counter] = user;
    else if (level >= 11 && level <= 15 && gameMode == "Hard")
     listGameModeAccounts [counter] = user;
    else // If none match, disregard this counter (so that the current element in the list isn't empty)
     counter--;
   } // end looop that goes thorugh each account and adds relevent ones to the list array
  } catch (FileNotFoundException e) {} // try catch where all accounts levels are scanned and relevent ones are added to the list array 
  SortGameModeAccnts();
 } // createListOfAccnts 
 
 /** Sorts the list that contains the names of accounts of a certain game type (used in creating the leaderboard)*/
 public void SortGameModeAccnts ()
 {
  // Note: Top account is at the 0th element of the list, worsst aaccount at last element
  int SecondAccountLevel = 0, FirstAccountLevel = 0, SecondAccountDeath = 0, FirstAccountDeath = 0, listPos;
  Scanner accntDeathScnr;
  for (int top = 1; top < listGameModeAccounts.length; top++) // Goes through each account in the list and compares it with all accounts before it until it reaches an account it has a higher position over
  {
   listPos = top;   
   String SecondAccount = listGameModeAccounts[top]; // Note that second account is top and first account is top-- in the list and top goes from 1 - list.length
   
   try // Attempts to reads level and death values for the second account being compared using account's text files 
   {
    accntLvlScnr = new Scanner (new File ("Game Components\\Player Components\\Player Levels\\" + SecondAccount + "-Level.txt"));
    SecondAccountLevel = accntLvlScnr.nextInt();
    accntDeathScnr = new Scanner (new File ("Game Components\\Player Components\\Player Deaths\\" + SecondAccount + "-Death.txt"));
    SecondAccountDeath = accntDeathScnr.nextInt();
   } catch (FileNotFoundException e) {} // try catch where account's level and death files are scanned

   while (listPos > 0) // While the listPos is greater than 0, compares the second account to ones before it, continually shifting the names down the list until the second account finds another account that beats it
   {
    try // Attempts to reads level and death values for the first accounts being compared using account's text files 
    {
     accntLvlScnr = new Scanner (new File ("Game Components\\Player Components\\Player Levels\\" + listGameModeAccounts[listPos - 1] + "-Level.txt"));
     FirstAccountLevel = accntLvlScnr.nextInt();
     accntDeathScnr = new Scanner (new File ("Game Components\\Player Components\\Player Deaths\\" + listGameModeAccounts[listPos - 1] + "-Death.txt"));
     FirstAccountDeath = accntDeathScnr.nextInt();
    } catch (FileNotFoundException e) {} // try catch where account's level and death files are scanned
    
    if (FirstAccountLevel > SecondAccountLevel || (SecondAccountLevel == FirstAccountLevel && SecondAccountDeath > FirstAccountDeath)) // If the first account beatss the second account, breaks the loop
      break;
    listGameModeAccounts[listPos] = listGameModeAccounts[listPos - 1]; // Otherwise, shifts the first name down the list
    listPos--;
   } // while based on listPos
   listGameModeAccounts[listPos] = SecondAccount; // The degree of shifting done determines the new positio of the second name (the name it replaces is currently in [listPos + 1]
  } // for counting frojm 0 - listGameModeAccounts length
 } // SortGameModeAccnts
 
 /** Returns the name of an account in a given position of the list that contains the names of accounts of a certain game type (used in displaying the leaderboard)*/
 public String getLeaderBoardName (int pos)
 {
  try // Attempt to return the name assigned to a particular positions
  {
   return (listGameModeAccounts[pos]);
  } // try where a particular element in an array is acquired
  catch (Exception en) 
  {
   return "--------";
  } // catch if the position doesn't exist
 } // getLeaderBoardName
 
 /** Returns a given account's level by scanning that account's level file (used in displaying the leaderboard)*/
 public int readLevel (String account)
 {
  try // Attempt to return a given account's level file's value
  {
   Scanner scan = new Scanner (new File ("Game Components\\Player Components\\Player Levels\\" + account + "-Level.txt"));
   return scan.nextInt();
  } // try where account's file level is scanned
  catch (FileNotFoundException fn) 
  {
   return 0;
  } // catch if account's level doesn't exist
 } // readLevel

 /** Returns a given account's number of deaths by scanning that account's death file (used in displaying the leaderboard)*/
 public int readDeath (String account)
 {
  try // Attempt to return a given account's accountDeath file's value
  {
   Scanner scan = new Scanner (new File ("Game Components\\Player Components\\Player Deaths\\" + account + "-Death.txt"));
   return scan.nextInt();
  } // try where account's accountDeath level is scanned
  catch (FileNotFoundException n) 
  {
   return 0;
  } // account if account's accountDeath doesn't exist
 } // readDeath

 /** Main method*/
 public static void main(String[] args)
 {
  new Menu();
 } // main
} // Menu class