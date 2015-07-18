package yahtzee;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class Yahtzee {

	/**
	 * A quick container class that holds a dice's value (1-6) and whether or not it is being held or not.
	 */
	public class DiceStatus{
		public int value = 0;
		public boolean toroll = true;
	}
	
	private ArrayList<DiceStatus> dice = new ArrayList<DiceStatus>();
	private ArrayList<Boolean> scored = new ArrayList<Boolean>();
	private Random rand = new Random();
	private int score;
	private boolean yahtzeebonus;
	
	/**
	 * Returns a Yahtzee object that hasn't had any scores added and 5 DiceStatus's initialized to 0
	 */
	public Yahtzee(){
		for(int counter = 0; counter < 5; counter++){
			DiceStatus temp = new DiceStatus();
			dice.add(temp);
		}
		for(int counter2 = 0; counter2 < 13; counter2++){
			scored.add(false);
		}
		
		score = 0;
		yahtzeebonus = false;
	}
	
	/**
	 * A function that randomly returns an integer
	 * @param min The minimum integer to be returned
	 * @param max The maximum integer to be returned
	 * @return The random integer itself
	 */
	public int getRandInt(int min, int max){
		int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	/**
	 * Sets all of the DiceStatus values of a Yahtzee object to random numbers between 1 - 6
	 */
	public void rollDice(){
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).toroll){
				dice.get(counter).value = getRandInt(1, 6);
			}
		}
	}
	
	/**
	 * Sets whether or not a certain DiceStatus will be rolled by rollDice()
	 * @param position Integer that corresponds with the ArrayList position to be modified
	 * @param stat Boolean to set that corresponding DiceStatus to
	 */
	public void setRollStatus(int position, boolean stat){
		dice.get(position).toroll = stat;
	}
	
	/**
	 * Returns the value of a specific DiceStatus
	 * @param position Integer that corresponds with the ArrayList position 
	 * @return Integer that corresponds with DiceStatus
	 */
	public final int getDice(int position){
		return dice.get(position).value;
	}
	
	/**
	 * Returns the score that would be earned by the current die in the ones category.
	 * @param makeitcount Boolean whether or not you want it to "count". Use false when you just want to print, true when user actually chooses it.
	 * @return Integer score earned by ones category
	 */
	public int scoreOnes(boolean makeitcount){
		int tempscore = 0;
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).value == 1){
				tempscore += 1;
			}
		}
		if(makeitcount){
			score += tempscore;
			scored.set(0, true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return tempscore;
	}
	
	public int scoreTwos(boolean makeitcount){
		int tempscore = 0;
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).value == 2){
				tempscore += 2;
			}
		}
		if(makeitcount){
			score += tempscore;
			scored.set(1, true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return tempscore;
	}
	
	public int scoreThrees(boolean makeitcount){
		int tempscore = 0;
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).value == 3){
				tempscore += 3;
			}
		}
		if(makeitcount){
			score += tempscore;
			scored.set(2, true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return tempscore;
	}
	
	public int scoreFours(boolean makeitcount){
		int tempscore = 0;
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).value == 4){
				tempscore += 4;
			}
		}
		if(makeitcount){
			score += tempscore;
			scored.set(3, true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return tempscore;
	}
	
	public int scoreFives(boolean makeitcount){
		int tempscore = 0;
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).value == 5){
				tempscore += 5;
			}
		}
		if(makeitcount){
			score += tempscore;
			scored.set(4, true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return tempscore;
	}
	
	public int scoreSixes(boolean makeitcount){
		int tempscore = 0;
		for(int counter = 0; counter < 5; counter++){
			if(dice.get(counter).value == 6){
				tempscore += 6;
			}
		}
		if(makeitcount){
			score += tempscore;
			scored.set(5, true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return tempscore;
	}
	
	public final int getScore(){
		return score;
	}
	
	public final boolean getScored(int position){
		return scored.get(position);
	}
	
	public int scoreOfAKind(boolean makeitcount, int rank){
		int tempscore = 0;
		ArrayList<Integer> temparraylist = new ArrayList<Integer>();
		for(int counter = 0; counter < 6; counter++){
			temparraylist.add(0);
		}
		for(int counter2 = 0; counter2 < dice.size(); counter2++){
			int tempint = temparraylist.get(dice.get(counter2).value-1);
			tempint++;
			temparraylist.set(dice.get(counter2).value-1, tempint);
			tempscore += dice.get(counter2).value;
		}		
		for(int counter3 = 0; counter3 < temparraylist.size(); counter3++){
			if(temparraylist.get(counter3) >= rank){
				if(rank == 5){
					if(makeitcount){
						score += 50;
						scored.set(11,true);
						yahtzeebonus = true;
					}
					return 50;
				}
				if(makeitcount){
					score += tempscore;
					if(rank == 3){
						scored.set(6,true);
						if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
							score += 100;
						}
						
					}
					else if(rank == 4){
						scored.set(7,true);
						if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
							score += 100;
						}
					}
					else if(rank == 0){
						scored.set(12,true);
						if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
							score += 100;
						}
					}
				}
				return tempscore;
			}
			if(makeitcount){
				if(rank == 5){
					scored.set(11,true);
				}
				else if(rank == 3){
					scored.set(6,true);
				}
				else if(rank == 4){
					scored.set(7,true);
				}
			}

		}
		return 0;
	}
	
	public int scoreFullHouse(boolean makeitcount){
		boolean cond3 = false, cond2 = false;
		ArrayList<Integer> temparraylist = new ArrayList<Integer>();
		for(int counter = 0; counter < 6; counter++){
			temparraylist.add(0);
		}
		for(int counter2 = 0; counter2 < dice.size(); counter2++){
			int tempint = temparraylist.get(dice.get(counter2).value-1);
			tempint++;
			temparraylist.set(dice.get(counter2).value-1, tempint);
		}
		for(int counter3 = 0; counter3 < temparraylist.size(); counter3++){
			if(temparraylist.get(counter3) == 3){
				cond3 = true;
			}
			else if(temparraylist.get(counter3) == 2){
				cond2 = true;
			}
		}
		if(cond3 && cond2){
			if(makeitcount){
				score += 25;
				scored.set(8,true);
				if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
					score += 100;
				}
				
			}
			return 25;
		}
		if(makeitcount){
			scored.set(8,true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return 0;
	}
	
	public int scoreLargeStraight(boolean makeitcount){
		if(dice.get(0).value == dice.get(1).value - 1 && dice.get(1).value == dice.get(2).value - 1 && dice.get(2).value == dice.get(3).value - 1 && dice.get(3).value == dice.get(4).value - 1){
			if(makeitcount){
				score += 40;
				scored.set(10,true);
				if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
					score += 100;
				}
			}
			return 40;
		}
		if(makeitcount){
			scored.set(10,true);
			if(dice.get(0).value == dice.get(4).value && yahtzeebonus){
				score += 100;
			}
		}
		return 0;
	}
	
	public int scoreSmallStraight(boolean makeitcount){
		ArrayList<DiceStatus> temp = new ArrayList<DiceStatus>();
		for(int counter = 1; counter < dice.size(); counter++){				
			if(dice.get(counter).value == dice.get(counter-1).value){
				temp.add(dice.get(counter));
				dice.remove(counter);
			}
		}
		int holdsize = dice.size();
		int goal = 0;
		for(int gothrew = 1; gothrew < holdsize && goal < 3; gothrew++){
			if(dice.get(gothrew).value == dice.get(gothrew-1).value + 1){
				goal++;
			}
			else if(dice.get(gothrew).value == dice.get(gothrew-1).value){
				
			}else{
				gothrew = holdsize;
			}
		}
		if(goal >= 3){
			if(makeitcount){
				score += 30;
				scored.set(9,true);
				if(dice.get(0).value == dice.get(holdsize-1).value && yahtzeebonus){
					score += 100;
				}
			}
			for(int counter2 = 0; counter2 < temp.size(); counter2++){
				dice.add(temp.get(counter2));
			}
			return 30;
		}
		if(makeitcount){
			scored.set(9,true);
			if(dice.get(0).value == dice.get(holdsize-1).value && yahtzeebonus){
				score += 100;
			}
		}
		for(int counter2 = 0; counter2 < temp.size(); counter2++){
			dice.add(temp.get(counter2));
		}
		return 0;
	}
	
	public void sortDice(){
		for(int c1 = 1; c1 < dice.size(); c1++){
			for(int c2 = c1; c2 > 0; c2--){
				if(dice.get(c2).value < dice.get(c2-1).value){
					Collections.swap(dice, c2, c2-1);
				}
			}
		}
	}
	
	public String toString(){
		String returnstring = "";
		for(int counter = 0; counter < dice.size(); counter++){
			returnstring += Integer.toString(dice.get(counter).value) + " ";
		}
		return returnstring;
	}
	
	public final boolean gameIsOver(){
		for(int counter = 0; counter < scored.size(); counter++){
			if(!scored.get(counter)){
				return false;
			}
		}
		return true;
	}
	
	public void restartGame(){
		dice.clear();
		scored.clear();
		for(int counter = 0; counter < 5; counter++){
			DiceStatus temp = new DiceStatus();
			dice.add(temp);
		}
		for(int counter2 = 0; counter2 < 13; counter2++){
			scored.add(false);
		}
		yahtzeebonus = false;
		score = 0;
	}
	
}
