package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 //creating ArrayLists cards for each suit
        List<String> ArrayH = Arrays.asList("H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13", "H14");
        List<String> ArrayS = Arrays.asList("S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13", "S14");
        List<String> ArrayC = Arrays.asList("C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14");
        List<String> ArrayD = Arrays.asList("D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13", "D14");
        //creating deck with all suits/cards combined
        ArrayList<String> deck = new ArrayList<>();
    deck.addAll(ArrayH);
    deck.addAll(ArrayS);
    deck.addAll(ArrayC);
    deck.addAll(ArrayD);

        //shuffle cards
    Collections.shuffle(deck);
        //dividing deck into two parts
        int divide = deck.size();
        ArrayList<String> cardsC = new ArrayList<>();
        ArrayList<String> cardsP = new ArrayList<>();
        //deck for Computer
    for(
        int i = 0;
        i<divide/2;i++)
                cardsC.add(deck.get(i));
        //deck for Player1
    for(
        int i = divide / 2;
        i<divide;i++)
                cardsP.add(deck.get(i));
    //setting up values needed for below if statements
    ArrayList<String> cardsWon = new ArrayList<>();
    ArrayList<String> cardsWComp = new ArrayList<>();
    ArrayList<String> cardsWPlayer = new ArrayList<>();
    int scoreComputer=0;
    int scorePlayer=0;
    int totalGames=0;
    //this allows for the game to be ran several times or stopped
    	int continueRunning = 1;
    	while(continueRunning!=0) {
    	if(!cardsC.isEmpty() && !cardsP.isEmpty()) {
		//removes the first letter in string so the card value can be used for comparing who won
        String cc;
        cc = cardsC.remove(0);
        System.out.println(cc);
        String ccs = cc.substring(1);
        int cC = Integer.parseInt(ccs);
        String cp;
        cp = cardsP.remove(0);
        System.out.println(cp);
        String cps = cp.substring(1);
        int cP = Integer.parseInt(cps);
        //if statements for who won, if war occurs, and adds wins and # of games so far to totals.
        if (cC > cP) {
        	System.out.println("Computer won");
        	scoreComputer ++;
        	totalGames++;
        	cardsWon.add(cc);
        	cardsWon.add(cp);
        	cardsC.addAll(cardsWon);
        	
        }
        else if(cC < cP) {
        	System.out.println("Player won");
        	scorePlayer ++;
        	totalGames++;
        	cardsWon.add(cc);
        	cardsWon.add(cp);
        	cardsP.addAll(cardsWon);
        }
        else if(cC == cP) {
        	System.out.println("War");
        	//removes 4 cards for each player and stores into array for later use in adding to the deck of whoever won
        	String cc1 = cardsC.remove(0);
        	String cc2 = cardsC.remove(1);
        	String cc3 = cardsC.remove(2);
        	String cc4 = cardsC.remove(3);
        	cardsWComp.add(cc1);
        	cardsWComp.add(cc2);
        	cardsWComp.add(cc3);
        	cardsWComp.add(cc4);
        	System.out.println(cc1+", "+cc2+", "+cc3+", "+cc4);
        	String cp1 = cardsP.remove(0);
        	String cp2 = cardsP.remove(1);
        	String cp3 = cardsP.remove(2);
        	String cp4 = cardsP.remove(3);
        	cardsWPlayer.add(cp1);
        	cardsWPlayer.add(cp2);
        	cardsWPlayer.add(cp3);
        	cardsWPlayer.add(cp4);
        	System.out.println(cp1+", "+cp2+", "+cp3+", "+cp4);
            cc4 = cc4.substring(1);
            int cC4 = Integer.parseInt(cc4);
            cp4 = cp4.substring(1);
            int cP4 = Integer.parseInt(cp4);
            //only last card used for determining winner
            if (cC4 > cP4) {
            	System.out.println("Computer won");
            	scoreComputer ++;
            	totalGames++;
            	cardsC.addAll(cardsWPlayer);
            	cardsC.addAll(cardsWComp);
            	int percentage = scoreComputer /totalGames;
            	if(percentage < .25) {
            		Collections.shuffle(cardsC);
            		//there are no set rules with War on how it's played.  
            		//my siblings and I played a version of where any won cards from War could be added randomly into a deck
            		System.out.println("Computer shuffled hand - decision factor wins of 25% or less");
            	}
            }
            else if(cC4 < cP4) {
            	System.out.println("Player won");
            	scorePlayer ++;
            	totalGames++;
            	cardsP.addAll(cardsWPlayer);
            	cardsP.addAll(cardsWComp);
        	}
            else if(cC4 == cP4) {
            	//odds of this happening are low, but still adding code in
            	System.out.println("War");
            	//removes 4 cards for each player and stores into array for later use in adding to the deck of whoever won
            	cc1 = cardsC.remove(0);
            	cc2 = cardsC.remove(1);
            	cc3 = cardsC.remove(2);
            	cc4 = cardsC.remove(3);
            	cardsWComp.add(cc1);
            	cardsWComp.add(cc2);
            	cardsWComp.add(cc3);
            	cardsWComp.add(cc4);
            	System.out.println(cc1+", "+cc2+", "+cc3+", "+cc4);
            	cp1 = cardsP.remove(0);
            	cp2 = cardsP.remove(1);
            	cp3 = cardsP.remove(2);
            	cp4 = cardsP.remove(3);
            	cardsWPlayer.add(cp1);
            	cardsWPlayer.add(cp2);
            	cardsWPlayer.add(cp3);
            	cardsWPlayer.add(cp4);
            	System.out.println(cp1+", "+cp2+", "+cp3+", "+cp4);
                cc4 = cc4.substring(1);
                cC4 = Integer.parseInt(cc4);
                cp4 = cp4.substring(1);
                cP4 = Integer.parseInt(cp4);
                if (cC4 > cP4) {
                	System.out.println("Computer won");
                	scoreComputer ++;
                	totalGames++;
                	cardsC.addAll(cardsWPlayer);
                	cardsC.addAll(cardsWComp);
                	int percentage = scoreComputer /totalGames;
                	if(percentage < .25) {
                		Collections.shuffle(cardsC);
                		//there are no set rules with War on how it's played.  
                		//my siblings and I played a version of where any won cards from War could be added randomly into a deck
                		System.out.println("Computer shuffled hand - decision factor wins of 25% or less");
                	}
                }
                else if(cC4 < cP4) {
                	System.out.println("Player won");
                	scorePlayer ++;
                	totalGames++;
                	cardsP.addAll(cardsWPlayer);
                	cardsP.addAll(cardsWComp);
            	}}
            System.out.println("Computer Wins:  "+scoreComputer);
            System.out.println("Player Wins:  "+scorePlayer);
            System.out.println("Total Plays: "+ totalGames);
        }
        }
        else if (cardsC.isEmpty() || cardsP.isEmpty()) {
            if (scoreComputer > scorePlayer) {
                System.out.println("Computer Won");
            }
            else if (scoreComputer < scorePlayer) {
                System.out.println("Player Won");
            }
            else if (scoreComputer == scorePlayer) {
            	System.out.println("Tie");
            }
        }
    	System.out.println("Continue playing? 1=yes, 0=no");
    	continueRunning = in.nextInt();
    	}
    	}}
    
	


