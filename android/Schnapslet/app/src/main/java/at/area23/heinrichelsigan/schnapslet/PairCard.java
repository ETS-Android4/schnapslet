/*
*
* @author           Heinrich Elsigan
* @version          V 0.2
* @since            JDK 1.2.1
*

*/
/*
   Copyright (C) 2000 - 2002 Heinrich Elsigan

   Schnapslet java applet is free software; you can redistribute it and/or
   modify it under the terms of the GNU Library General Public License as
   published by the Free Software Foundation; either version 2 of the
   License, or (at your option) any later version.
   See the GNU Library General Public License for more details.

*/
package at.area23.heinrichelsigan.schnapslet;

import at.area23.heinrichelsigan.schnapslet.Card;
import java.lang.*;
import java.io.*;
import java.net.*;

public class PairCard {
    
	boolean atou = false;
	CARDCOLOR cardColor = CARDCOLOR.NONE; // Color of Pair
	char color = 'n';   // 4 colors and 'n' for unitialized
    int pairValue = 20;      // 5 values and 0 for unitialized
	Card pairs[] = new Card[2]; // the 2 Cards, that represents the pair

    /**
     * Constructor PairCard()
     */
    public PairCard() {
        super();
        this.color = 'n';
        this.pairValue = 20;
    }

	/**
	 * Constructor PairCard
	 * @param cardColor represents the color of the pair
	 * @param atouColor represents the color of Atou card
	 */
	public PairCard(CARDCOLOR cardColor, CARDCOLOR atouColor) {
		this();
		this.cardColor = cardColor;
		this.color = (char)cardColor.getValue();

		int queenNumValue = 1;
		if (cardColor == CARDCOLOR.PIK) queenNumValue += 5;
		if (cardColor == CARDCOLOR.KARO) queenNumValue += 10;
		if (cardColor == CARDCOLOR.TREFF) queenNumValue += 15;
		int kingNumValue = queenNumValue + 1;

		pairs[0] = new Card(queenNumValue, atouColor.getValue());
		pairs[1] = new Card(kingNumValue, atouColor.getValue());

		this.pairValue = 20;
		if (cardColor.getValue() == atouColor.getValue()) {
			this.atou = true;
			this.pairValue = 40;
		}
	}

	/**
	 * Constructor PairCard
	 * @param queenCard - the Queen in that pair
	 * @param kingCard - the King in that pair
	 */
	public PairCard(Card queenCard, Card kingCard) {
		this();
		this.cardColor = queenCard.cardColor;
		this.color = (char)queenCard.cardColor.getValue();        
		pairs[0] = new Card(queenCard);
		pairs[1] = new Card(kingCard);
		if (queenCard.isAtou()) {
			this.atou = true;
			this.pairValue = 40;
		}
		
        return;
    }

}