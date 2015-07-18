package yahtzee;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import yahtzee.Yahtzee;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell a;
	private Text number0;
	private Button number0k;
	private Button number1k;
	private Text number1;
	private Button number2k;
	private Text number2;
	private Button number3k;
	private Text number3;
	private Button number4k;
	private Text number4;
	private Label lblNewLabel;
	private Text ones_score;
	private Label lblTwos;
	private Text twos_score;
	private Label lblThrees;
	private Text threes_score;
	private Label lblFours;
	private Text fours_score;
	private Label lblFives;
	private Text fives_score;
	private Label lblSixes;
	private Text sixes_score;
	private Label lblThreeofakind;
	private Text threeoak_score;
	private Label lblFourofakind;
	private Text fouroak_score;
	private Label lblChance;
	private Text chance_score;
	private Label lblYahtzee;
	private Text yahtzee_score;
	private Label lblFullHouse;
	private Text fullhouse_score;
	private Label lblSmallStraight;
	private Text sstraight_score;
	private Label lblLargeStraight;
	private Text lstraight_score;
	private Label ones_final;
	private Label twos_final;
	private Label threes_final;
	private Label fours_final;
	private Label fives_final;
	private Label sixes_final;
	private Label threeoak_final;
	private Label fouroak_final;
	private Label fullhouse_final;
	private Label sstraight_final;
	private Label lstraight_final;
	private Label yahtzee_final;
	private Label chance_final;
	private Button ones_button;
	private Button twos_button;
	private Button threes_button;
	private Button fours_button;
	private Button fives_button;
	private Button sixes_button;
	private Button threeoak_button;
	private Button fouroak_button;
	private Button fullhouse_button;
	private Button sstraight_button;
	private Button lstraight_button;
	private Button yahtzee_button;
	private Button chance_button;
	private Text score_final;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		a.open();
		a.layout();
		while (!a.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

		public Yahtzee gamestate = new Yahtzee();

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		a = new Shell();
		a.setTouchEnabled(true);
		a.setSize(262, 478);
		a.setText("Yahtzee");
		final Button rollbutton = new Button(a, SWT.NONE);
		
		number0 = new Text(a, SWT.BORDER);
		number0.setEditable(false);
		number0.setBounds(37, 10, 21, 21);
		
		number0k = new Button(a, SWT.CHECK);
		number0k.setEnabled(false);
		number0k.setBounds(41, 35, 13, 16);
		
		number1k = new Button(a, SWT.CHECK);
		number1k.setEnabled(false);
		number1k.setBounds(68, 35, 13, 16);
		
		number1 = new Text(a, SWT.BORDER);
		number1.setEditable(false);
		number1.setBounds(64, 10, 21, 21);
		
		number2k = new Button(a, SWT.CHECK);
		number2k.setEnabled(false);
		number2k.setBounds(95, 35, 13, 16);
		
		number2 = new Text(a, SWT.BORDER);
		number2.setEditable(false);
		number2.setBounds(91, 10, 21, 21);
		
		number3k = new Button(a, SWT.CHECK);
		number3k.setEnabled(false);
		number3k.setBounds(122, 35, 13, 16);
		
		number3 = new Text(a, SWT.BORDER);
		number3.setEditable(false);
		number3.setBounds(118, 10, 21, 21);
		
		number4k = new Button(a, SWT.CHECK);
		number4k.setEnabled(false);
		number4k.setBounds(149, 35, 13, 16);
		
		number4 = new Text(a, SWT.BORDER);
		number4.setEditable(false);
		number4.setBounds(145, 10, 21, 21);
		
		Label lblKeep = new Label(a, SWT.NONE);
		lblKeep.setBounds(10, 34, 26, 15);
		lblKeep.setText("Keep");
		
		rollbutton.addMouseListener(new MouseAdapter() {
			int ayy;
			@Override
			public void mouseDown(MouseEvent e) {
				if(ayy < 3){
					if(ayy == 0){
						number0k.setEnabled(true);
						number1k.setEnabled(true);
						number2k.setEnabled(true);
						number3k.setEnabled(true);
						number4k.setEnabled(true);
					}
					ayy++;
					gamestate.setRollStatus(0, !number0k.getSelection());
					gamestate.setRollStatus(1, !number1k.getSelection());
					gamestate.setRollStatus(2, !number2k.getSelection());
					gamestate.setRollStatus(3, !number3k.getSelection());
					gamestate.setRollStatus(4, !number4k.getSelection());
					gamestate.rollDice();
					number0.setText(Integer.toString(gamestate.getDice(0)));
					number1.setText(Integer.toString(gamestate.getDice(1)));
					number2.setText(Integer.toString(gamestate.getDice(2)));
					number3.setText(Integer.toString(gamestate.getDice(3)));
					number4.setText(Integer.toString(gamestate.getDice(4)));
				}
				if(ayy == 3){
					ayy = 0;
					number0k.setSelection(false);
					number1k.setSelection(false);
					number2k.setSelection(false);
					number3k.setSelection(false);
					number4k.setSelection(false);
					
					rollbutton.setEnabled(false);
					
					number0k.setEnabled(false);
					number1k.setEnabled(false);
					number2k.setEnabled(false);
					number3k.setEnabled(false);
					number4k.setEnabled(false);
					
					gamestate.sortDice();
					
					if(!gamestate.getScored(0)){ones_score.setText(Integer.toString(gamestate.scoreOnes(false)));}
					if(!gamestate.getScored(1)){twos_score.setText(Integer.toString(gamestate.scoreTwos(false)));}
					if(!gamestate.getScored(2)){threes_score.setText(Integer.toString(gamestate.scoreThrees(false)));}
					if(!gamestate.getScored(3)){fours_score.setText(Integer.toString(gamestate.scoreFours(false)));}
					if(!gamestate.getScored(4)){fives_score.setText(Integer.toString(gamestate.scoreFives(false)));}
					if(!gamestate.getScored(5)){sixes_score.setText(Integer.toString(gamestate.scoreSixes(false)));}
					if(!gamestate.getScored(6)){threeoak_score.setText(Integer.toString(gamestate.scoreOfAKind(false, 3)));}
					if(!gamestate.getScored(7)){fouroak_score.setText(Integer.toString(gamestate.scoreOfAKind(false, 4)));}
					if(!gamestate.getScored(8)){fullhouse_score.setText(Integer.toString(gamestate.scoreFullHouse(false)));}
					if(!gamestate.getScored(9)){sstraight_score.setText(Integer.toString(gamestate.scoreSmallStraight(false)));}
					if(!gamestate.getScored(10)){lstraight_score.setText(Integer.toString(gamestate.scoreLargeStraight(false)));}
					if(!gamestate.getScored(11)){yahtzee_score.setText(Integer.toString(gamestate.scoreOfAKind(false, 5)));}
					if(!gamestate.getScored(12)){chance_score.setText(Integer.toString(gamestate.scoreOfAKind(false, 0)));}
					
					if(!gamestate.getScored(0)){ones_button.setEnabled(true);}
					if(!gamestate.getScored(1)){twos_button.setEnabled(true);}
					if(!gamestate.getScored(2)){threes_button.setEnabled(true);}
					if(!gamestate.getScored(3)){fours_button.setEnabled(true);}
					if(!gamestate.getScored(4)){fives_button.setEnabled(true);}
					if(!gamestate.getScored(5)){sixes_button.setEnabled(true);}
					if(!gamestate.getScored(6)){threeoak_button.setEnabled(true);}
					if(!gamestate.getScored(7)){fouroak_button.setEnabled(true);}
					if(!gamestate.getScored(8)){fullhouse_button.setEnabled(true);}
					if(!gamestate.getScored(9)){sstraight_button.setEnabled(true);}
					if(!gamestate.getScored(10)){lstraight_button.setEnabled(true);}
					if(!gamestate.getScored(11)){yahtzee_button.setEnabled(true);}
					if(!gamestate.getScored(12)){chance_button.setEnabled(true);}
				}
			}
		});
		rollbutton.setBounds(65, 55, 75, 25);
		rollbutton.setText("Roll");
		
		lblNewLabel = new Label(a, SWT.NONE);
		lblNewLabel.setBounds(88, 91, 29, 15);
		lblNewLabel.setText("Ones");
		
		ones_score = new Text(a, SWT.BORDER | SWT.CENTER);
		ones_score.setEditable(false);
		ones_score.setBounds(155, 87, 21, 21);
		
		lblTwos = new Label(a, SWT.NONE);
		lblTwos.setText("Twos");
		lblTwos.setBounds(88, 115, 29, 15);
		
		twos_score = new Text(a, SWT.BORDER | SWT.CENTER);
		twos_score.setEditable(false);
		twos_score.setBounds(155, 111, 21, 21);
		
		lblThrees = new Label(a, SWT.NONE);
		lblThrees.setText("Threes");
		lblThrees.setBounds(88, 139, 35, 15);
		
		threes_score = new Text(a, SWT.BORDER | SWT.CENTER);
		threes_score.setEditable(false);
		threes_score.setBounds(155, 135, 21, 21);
		
		lblFours = new Label(a, SWT.NONE);
		lblFours.setText("Fours");
		lblFours.setBounds(88, 163, 29, 15);
		
		fours_score = new Text(a, SWT.BORDER | SWT.CENTER);
		fours_score.setEditable(false);
		fours_score.setBounds(155, 159, 21, 21);
		
		lblFives = new Label(a, SWT.NONE);
		lblFives.setText("Fives");
		lblFives.setBounds(88, 187, 29, 15);
		
		fives_score = new Text(a, SWT.BORDER | SWT.CENTER);
		fives_score.setEditable(false);
		fives_score.setBounds(155, 183, 21, 21);
		
		lblSixes = new Label(a, SWT.NONE);
		lblSixes.setText("Sixes");
		lblSixes.setBounds(88, 211, 29, 15);
		
		sixes_score = new Text(a, SWT.BORDER | SWT.CENTER);
		sixes_score.setEditable(false);
		sixes_score.setBounds(155, 207, 21, 21);
		
		lblThreeofakind = new Label(a, SWT.NONE);
		lblThreeofakind.setText("Three-Of-A-Kind");
		lblThreeofakind.setBounds(55, 234, 95, 15);
		
		threeoak_score = new Text(a, SWT.BORDER | SWT.CENTER);
		threeoak_score.setEditable(false);
		threeoak_score.setBounds(155, 231, 21, 21);
		
		lblFourofakind = new Label(a, SWT.NONE);
		lblFourofakind.setText("Four-Of-A-Kind");
		lblFourofakind.setBounds(60, 258, 93, 15);
		
		fouroak_score = new Text(a, SWT.BORDER | SWT.CENTER);
		fouroak_score.setEditable(false);
		fouroak_score.setBounds(155, 255, 21, 21);
		
		lblChance = new Label(a, SWT.NONE);
		lblChance.setText("Chance");
		lblChance.setBounds(82, 383, 44, 15);
		
		chance_score = new Text(a, SWT.BORDER | SWT.CENTER);
		chance_score.setEditable(false);
		chance_score.setBounds(155, 379, 21, 21);
		
		lblYahtzee = new Label(a, SWT.NONE);
		lblYahtzee.setText("Yahtzee");
		lblYahtzee.setBounds(82, 358, 44, 15);
		
		yahtzee_score = new Text(a, SWT.BORDER | SWT.CENTER);
		yahtzee_score.setEditable(false);
		yahtzee_score.setBounds(155, 354, 21, 21);
		
		lblFullHouse = new Label(a, SWT.NONE);
		lblFullHouse.setText("Full House");
		lblFullHouse.setBounds(70, 283, 56, 15);
		
		fullhouse_score = new Text(a, SWT.BORDER | SWT.CENTER);
		fullhouse_score.setEditable(false);
		fullhouse_score.setBounds(155, 279, 21, 21);
		
		lblSmallStraight = new Label(a, SWT.NONE);
		lblSmallStraight.setText("Small Straight");
		lblSmallStraight.setBounds(60, 308, 78, 15);
		
		sstraight_score = new Text(a, SWT.BORDER | SWT.CENTER);
		sstraight_score.setEditable(false);
		sstraight_score.setBounds(155, 304, 21, 21);
		
		lblLargeStraight = new Label(a, SWT.NONE);
		lblLargeStraight.setText("Large Straight");
		lblLargeStraight.setBounds(63, 333, 76, 15);
		
		lstraight_score = new Text(a, SWT.BORDER | SWT.CENTER);
		lstraight_score.setEditable(false);
		lstraight_score.setBounds(155, 329, 21, 21);
		
		ones_final = new Label(a, SWT.CENTER);
		ones_final.setBounds(182, 91, 55, 15);
		
		twos_final = new Label(a, SWT.CENTER);
		twos_final.setBounds(182, 115, 55, 15);
		
		threes_final = new Label(a, SWT.CENTER);
		threes_final.setBounds(182, 139, 55, 15);
		
		fours_final = new Label(a, SWT.CENTER);
		fours_final.setBounds(182, 163, 55, 15);
		
		fives_final = new Label(a, SWT.CENTER);
		fives_final.setBounds(182, 187, 55, 15);
		
		sixes_final = new Label(a, SWT.CENTER);
		sixes_final.setBounds(182, 211, 55, 15);
		
		threeoak_final = new Label(a, SWT.CENTER);
		threeoak_final.setBounds(182, 234, 55, 15);
		
		fouroak_final = new Label(a, SWT.CENTER);
		fouroak_final.setBounds(182, 258, 55, 15);
		
		fullhouse_final = new Label(a, SWT.CENTER);
		fullhouse_final.setBounds(182, 283, 55, 15);
		
		sstraight_final = new Label(a, SWT.CENTER);
		sstraight_final.setBounds(182, 308, 55, 15);
		
		lstraight_final = new Label(a, SWT.CENTER);
		lstraight_final.setBounds(182, 333, 55, 15);
		
		yahtzee_final = new Label(a, SWT.CENTER);
		yahtzee_final.setBounds(182, 358, 55, 15);
		
		chance_final = new Label(a, SWT.CENTER);
		chance_final.setBounds(182, 383, 55, 15);
		
		ones_button = new Button(a, SWT.NONE);
		ones_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ones_final.setText(Integer.toString(gamestate.scoreOnes(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}			
				rollbutton.setEnabled(true);				
			}
		});
		ones_button.setEnabled(false);
		ones_button.setBounds(10, 88, 21, 21);
		
		twos_button = new Button(a, SWT.NONE);
		twos_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				twos_final.setText(Integer.toString(gamestate.scoreTwos(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);				
			}
		});
		twos_button.setEnabled(false);
		twos_button.setBounds(10, 111, 21, 21);
		
		threes_button = new Button(a, SWT.NONE);
		threes_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				threes_final.setText(Integer.toString(gamestate.scoreThrees(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		threes_button.setEnabled(false);
		threes_button.setBounds(10, 135, 21, 21);
		
		fours_button = new Button(a, SWT.NONE);
		fours_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				fours_final.setText(Integer.toString(gamestate.scoreFours(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		fours_button.setEnabled(false);
		fours_button.setBounds(10, 159, 21, 21);
		
		fives_button = new Button(a, SWT.NONE);
		fives_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				fives_final.setText(Integer.toString(gamestate.scoreFives(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		fives_button.setEnabled(false);
		fives_button.setBounds(10, 183, 21, 21);
		
		sixes_button = new Button(a, SWT.NONE);
		sixes_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				sixes_final.setText(Integer.toString(gamestate.scoreSixes(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		sixes_button.setEnabled(false);
		sixes_button.setBounds(10, 207, 21, 21);
		
		threeoak_button = new Button(a, SWT.NONE);
		threeoak_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				threeoak_final.setText(Integer.toString(gamestate.scoreOfAKind(true, 3)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		threeoak_button.setEnabled(false);
		threeoak_button.setBounds(10, 231, 21, 21);
		
		fouroak_button = new Button(a, SWT.NONE);
		fouroak_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				fouroak_final.setText(Integer.toString(gamestate.scoreOfAKind(true, 4)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		fouroak_button.setEnabled(false);
		fouroak_button.setBounds(10, 255, 21, 21);
		
		fullhouse_button = new Button(a, SWT.NONE);
		fullhouse_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				fullhouse_final.setText(Integer.toString(gamestate.scoreFullHouse(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		fullhouse_button.setEnabled(false);
		fullhouse_button.setBounds(10, 279, 21, 21);
		
		sstraight_button = new Button(a, SWT.NONE);
		sstraight_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				sstraight_final.setText(Integer.toString(gamestate.scoreSmallStraight(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		sstraight_button.setEnabled(false);
		sstraight_button.setBounds(10, 304, 21, 21);
		
		lstraight_button = new Button(a, SWT.NONE);
		lstraight_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lstraight_final.setText(Integer.toString(gamestate.scoreLargeStraight(true)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		lstraight_button.setEnabled(false);
		lstraight_button.setBounds(10, 329, 21, 21);
		
		yahtzee_button = new Button(a, SWT.NONE);
		yahtzee_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				yahtzee_final.setText(Integer.toString(gamestate.scoreOfAKind(true, 5)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		yahtzee_button.setEnabled(false);
		yahtzee_button.setBounds(10, 354, 21, 21);
		
		chance_button = new Button(a, SWT.NONE);
		chance_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				chance_final.setText(Integer.toString(gamestate.scoreOfAKind(true, 0)));
				score_final.setText(Integer.toString(gamestate.getScore()));
				
				ones_score.setText("");
				twos_score.setText("");
				threes_score.setText("");
				fours_score.setText("");
				fives_score.setText("");
				sixes_score.setText("");
				threeoak_score.setText("");
				fouroak_score.setText("");
				fullhouse_score.setText("");
				sstraight_score.setText("");
				lstraight_score.setText("");
				chance_score.setText("");
				yahtzee_score.setText("");
				
				ones_button.setEnabled(false);
				twos_button.setEnabled(false);
				threes_button.setEnabled(false);
				fours_button.setEnabled(false);
				fives_button.setEnabled(false);
				sixes_button.setEnabled(false);
				threeoak_button.setEnabled(false);
				fouroak_button.setEnabled(false);
				fullhouse_button.setEnabled(false);
				sstraight_button.setEnabled(false);
				lstraight_button.setEnabled(false);
				yahtzee_button.setEnabled(false);
				chance_button.setEnabled(false);
				
				number0.setText("");
				number1.setText("");
				number2.setText("");
				number3.setText("");
				number4.setText("");
				
				if(gamestate.gameIsOver()){
					MessageBox messagebox = new MessageBox(a, SWT.ICON_INFORMATION);
					messagebox.setText("Game Finished!");
					messagebox.setMessage("Your score was " + gamestate.getScore() + ".");
					messagebox.open();
					gamestate.restartGame();
					score_final.setText(Integer.toString(gamestate.getScore()));
					ones_final.setText("");
					twos_final.setText("");
					threes_final.setText("");
					fours_final.setText("");
					fives_final.setText("");
					sixes_final.setText("");
					threeoak_final.setText("");
					fouroak_final.setText("");
					fullhouse_final.setText("");
					sstraight_final.setText("");
					lstraight_final.setText("");
					yahtzee_final.setText("");
					chance_final.setText("");
				}	
				
				rollbutton.setEnabled(true);
			}
		});
		chance_button.setEnabled(false);
		chance_button.setBounds(10, 379, 21, 21);
		
		score_final = new Text(a, SWT.BORDER | SWT.CENTER);
		score_final.setText("0");
		score_final.setEditable(false);
		score_final.setBounds(68, 404, 76, 21);

	}
}
