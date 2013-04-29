/**
 * TAC AgentWare
 * http://www.sics.se/tac        tac-dev@sics.se
 *
 * Copyright (c) 2001-2005 SICS AB. All rights reserved.
 *
 * SICS grants you the right to use, modify, and redistribute this
 * software for noncommercial purposes, on the conditions that you:
 * (1) retain the original headers, including the copyright notice and
 * this text, (2) clearly document the difference between any derived
 * software and the original, and (3) acknowledge your use of this
 * software in pertaining publications and reports.  SICS provides
 * this software "as is", without any warranty of any kind.  IN NO
 * EVENT SHALL SICS BE LIABLE FOR ANY DIRECT, SPECIAL OR INDIRECT,
 * PUNITIVE, INCIDENTAL OR CONSEQUENTIAL LOSSES OR DAMAGES ARISING OUT
 * OF THE USE OF THE SOFTWARE.
 *
 * -----------------------------------------------------------------
 *
 * Author  : Joakim Eriksson, Niclas Finne, Sverker Janson
 * Created : 23 April, 2002
 * Updated : $Date: 2005/06/07 19:06:16 $
 *	     $Revision: 1.1 $
 * ---------------------------------------------------------
 * DummyAgent is a simplest possible agent for TAC. It uses
 * the TACAgent agent ware to interact with the TAC server.
 *
 * Important methods in TACAgent:
 *
 * Retrieving information about the current Game
 * ---------------------------------------------
 * int getGameID()
 *  - returns the id of current game or -1 if no game is currently plaing
 *
 * getServerTime()
 *  - returns the current server time in milliseconds
 *
 * getGameTime()
 *  - returns the time from start of game in milliseconds
 *
 * getGameTimeLeft()
 *  - returns the time left in the game in milliseconds
 *
 * getGameLength()
 *  - returns the game length in milliseconds
 *
 * int getAuctionNo()
 *  - returns the number of auctions in TAC
 *
 * int getClientPreference(int client, int type)
 *  - returns the clients preference for the specified type
 *   (types are TACAgent.{ARRIVAL, DEPARTURE, HOTEL_VALUE, E1, E2, E3}
 *
 * int getAuctionFor(int category, int type, int day)
 *  - returns the auction-id for the requested resource
 *   (categories are TACAgent.{CAT_FLIGHT, CAT_HOTEL, CAT_ENTERTAINMENT
 *    and types are TACAgent.TYPE_INFLIGHT, TACAgent.TYPE_OUTFLIGHT, etc)
 *
 * int getAuctionCategory(int auction)
 *  - returns the category for this auction (CAT_FLIGHT, CAT_HOTEL,
 *    CAT_ENTERTAINMENT)
 *
 * int getAuctionDay(int auction)
 *  - returns the day for this auction.
 *
 * int getAuctionType(int auction)
 *  - returns the type for this auction (TYPE_INFLIGHT, TYPE_OUTFLIGHT, etc).
 *
 * int getOwn(int auction)
 *  - returns the number of items that the agent own for this
 *    auction
 *
 * Submitting Bids
 * ---------------------------------------------
 * void submitBid(Bid)
 *  - submits a bid to the tac server
 *
 * void replaceBid(OldBid, Bid)
 *  - replaces the old bid (the current active bid) in the tac server
 *
 *   Bids have the following important methods:
 *    - create a bid with new Bid(AuctionID)
 *
 *   void addBidPoint(int quantity, float price)
 *    - adds a bid point in the bid
 *
 * Help methods for remembering what to buy for each auction:
 * ----------------------------------------------------------
 * int getAllocation(int auctionID)
 *   - returns the allocation set for this auction
 * void setAllocation(int auctionID, int quantity)
 *   - set the allocation for this auction
 *
 *
 * Callbacks from the TACAgent (caused via interaction with server)
 *
 * bidUpdated(Bid bid)
 *  - there are TACAgent have received an answer on a bid query/submission
 *   (new information about the bid is available)
 * bidRejected(Bid bid)
 *  - the bid has been rejected (reason is bid.getRejectReason())
 * bidError(Bid bid, int error)
 *  - the bid contained errors (error represent error status - commandStatus)
 *
 * quoteUpdated(Quote quote)
 *  - new information about the quotes on the auction (quote.getAuction())
 *    has arrived
 * quoteUpdated(int category)
 *  - new information about the quotes on all auctions for the auction
 *    category has arrived (quotes for a specific type of auctions are
 *    often requested at once).

 * auctionClosed(int auction)
 *  - the auction with id "auction" has closed
 *
 * transaction(Transaction transaction)
 *  - there has been a transaction
 *
 * gameStarted()
 *  - a TAC game has started, and all information about the
 *    game is available (preferences etc).
 *
 * gameStopped()
 *  - the current game has ended
 *
 */

/**
 * 24/04 14:05:52 FINE aw.DummyAgent|price number 0 : 0 
 24/04 14:05:52 FINE aw.DummyAgent|price number 1 : 1 
 24/04 14:05:52 FINE aw.DummyAgent|price number 2 : 2 
 24/04 14:05:52 FINE aw.DummyAgent|price number 3 : 3 

 24/04 14:05:52 FINE aw.DummyAgent|price number 4 : 4 
 24/04 14:05:52 FINE aw.DummyAgent|price number 5 : 5 
 24/04 14:05:52 FINE aw.DummyAgent|price number 6 : 6 
 24/04 14:05:52 FINE aw.DummyAgent|price number 7 : 7 

 24/04 14:05:52 FINE aw.DummyAgent|price number 8 : 8 
 24/04 14:05:52 FINE aw.DummyAgent|price number 9 : 9 
 24/04 14:05:52 FINE aw.DummyAgent|price number 10 : 10 
 24/04 14:05:52 FINE aw.DummyAgent|price number 11 : 11 

 24/04 14:05:52 FINE aw.DummyAgent|price number 12 : 12
 24/04 14:05:52 FINE aw.DummyAgent|price number 13 : 13
 24/04 14:05:52 FINE aw.DummyAgent|price number 14 : 14 
 24/04 14:05:52 FINE aw.DummyAgent|price number 15 : 15 

 24/04 14:05:52 FINE aw.DummyAgent|price number 16 : 16 
 24/04 14:05:52 FINE aw.DummyAgent|price number 17 : 17 
 24/04 14:05:52 FINE aw.DummyAgent|price number 18 : 18 
 24/04 14:05:52 FINE aw.DummyAgent|price number 19 : 19 

 24/04 14:05:52 FINE aw.DummyAgent|price number 20 : 20 
 24/04 14:05:52 FINE aw.DummyAgent|price number 21 : 21 
 24/04 14:05:52 FINE aw.DummyAgent|price number 22 : 22 
 24/04 14:05:52 FINE aw.DummyAgent|price number 23 : 23 

 24/04 14:05:52 FINE aw.DummyAgent|price number 24 : 24 
 24/04 14:05:52 FINE aw.DummyAgent|price number 25 : 25 
 24/04 14:05:52 FINE aw.DummyAgent|price number 26 : 26 
 24/04 14:05:52 FINE aw.DummyAgent|price number 27 : 27 
 */

package se.sics.tac.aw;

import se.sics.tac.util.ArgEnumerator;
import java.util.logging.*;
import java.util.*;

public class DummyAgent extends AgentImpl {

	private static final Logger log = Logger.getLogger(DummyAgent.class.getName());
	private static final boolean DEBUG = false;
	private float[] prices;

	private boolean dayChangingAlert;
	//the preference of customer 1-8 in of the day they want to fly in
	private int[] customerInPreference;
	//the preference of customer 1-8 in of the day they want to fly out
	private int[] customerOutPreference;
	//the most probable day that the customer will fly in. This is initialized to the customerInPreference
	//and it changes if the hotels cannot be secured.
	private int[] probableNightIn;
	//the most probable day that the customer will fly out. This is initialized to the customerOutPreference
	//and it changes if the hotels cannot be secured.
	private int[] probableNightOut;
	
	
	
	//NOT CURRENTLY BEING USED VARIABLES
	//this variable is not used at the moment.
	private int[] information;
	//variable not used at the moment.
	private long timeUpdate;
	
	//this is a variable that stores the hotel preferences for customer 0-8 respectively.True are the expensive
	//hotels and false otherwise.
	private boolean[] hotelPreference;
	

	
	
	
	// FLIGHT SPECIFIC VARIABLES INCOMING.
	
	
	
	

	// a variable that contains the probability of that biases -10 to 30. initially it has value 1/40 but
	// gradually
	// it is updated with the bayesian probabilities of perturbation.
	double[][] flight_hiddenxf = new double[8][40];
	// the difference between flight x and flight x-1. It is initially zero, and it is also zero for the 1st
	// update.
	// it is only updated for the 2nd update (20 seconds in the game onwards).
	double[] delta = new double[8];
	// the price of the previous flight. This is updated on every quote update to contain the prices of the
	// previous
	// flight. It is useful since to compute the difference between flight prices we need the current update
	// of the
	// price with the .getAskPrice method as well as the previous value that will be used to compute the delta
	// value.
	double[] previousFlightPrice = new double[8];
	///this will be a variable that will signify the updates of the flights. if all the variables are true then
	//all quotes are updated and we calculate the baysian  projection.
	boolean[] flight_updates = new boolean[8];

	public DummyAgent() {

		hotelPreference = new boolean[8];
		customerInPreference = new int[8];
		customerOutPreference = new int[8];
		probableNightOut = new int[8];
		probableNightIn = new int [8];
		information = new int[28];
		dayChangingAlert = false;
		timeUpdate = 540000L;

		// flight variable initializations
		for (int i = 0; i < 8; i++) {
			// initially delta and previousFlight is 0 value.
			delta[i] = 0;
			previousFlightPrice[i] = 0;
			flight_updates[i] = false;
			for (int j = 0; j < 40; i++) {
				// the chance for the hidden variable at start of the game is equal.
				flight_hiddenxf[i][j] = 0.025d;

			}
		}

	}

	protected void init(ArgEnumerator args) {
		prices = new float[agent.getAuctionNo()];
	}

	public void quoteUpdated(Quote quote) {
		// will hold the type of the auction
		String type = "";
		// will hold the day that the specified auction is for
		String day = "";

		//the following code is used for debugging purposes to log details in logger.
		//auctions with id 0-4 are for inflights on days 1-4 .
		if (quote.getAuction() == 0) {
			type = "inflight";
			day = "1";
		} else if (quote.getAuction() == 1) {
			type = "inflight";
			day = "2";
		} else if (quote.getAuction() == 2) {
			type = "inflight";
			day = "3";
		} else if (quote.getAuction() == 3) {
			type = "inflight";
			day = "4";
		} 
		//auctions with id 4-7 are for outflights with days 2-5 respectively
		else if (quote.getAuction() == 4) {
			type = "outflight";
			day = "2";
		} else if (quote.getAuction() == 5) {
			type = "outflight";
			day = "3";
		} else if (quote.getAuction() == 6) {
			type = "outflight";
			day = "4";
		} else if (quote.getAuction() == 7) {
			type = "outflight";
			day = "5";
		} 
		//auctions with id 8-11 are for cheap hotels with days 1-4 respectively
		else if (quote.getAuction() == 8) {
			type = "cheapHotel";
			day = "1";
		} else if (quote.getAuction() == 9) {
			type = "cheapHotel";
			day = "2";
		} else if (quote.getAuction() == 10) {
			type = "cheapHotel";
			day = "3";
		} else if (quote.getAuction() == 11) {
			type = "cheapHotel";
			day = "4";
		} 
		//auctions with id 12-15 are for expensive hotels and days 1-4 respectively.
		else if (quote.getAuction() == 12) {
			type = "expensiveHotel";
			day = "1";
		} else if (quote.getAuction() == 13) {
			type = "expensiveHotel";
			day = "2";
		} else if (quote.getAuction() == 14) {
			type = "expensiveHotel";
			day = "3";
		} else if (quote.getAuction() == 15) {
			type = "expensiveHotel";
			day = "4";
		}
		//auctions with id 16-19 are for entertainemnt -> ALIGATOR for days 1-4 respectively
		else if (quote.getAuction() == 16) {
			type = "aligator";
			day = "1";
		} else if (quote.getAuction() == 17) {
			type = "aligator";
			day = "2";
		} else if (quote.getAuction() == 18) {
			type = "aligator";
			day = "3";
		} else if (quote.getAuction() == 19) {
			type = "aligator";
			day = "4";
		} 
		//auctions with id 20-24 are for entertainement -> AMUZEMENT days 1-4 respectively
		else if (quote.getAuction() == 20) {
			type = "amuzement";
			day = "1";
		} else if (quote.getAuction() == 21) {
			type = "amuzement";
			day = "2";
		} else if (quote.getAuction() == 22) {
			type = "amuzement";
			day = "3";
		} else if (quote.getAuction() == 23) {
			type = "amuzement";
			day = "4";
		} 
		//auctions with id 20-24 are for entertainement -> MUSEUM days 1-4 respectively.
		else if (quote.getAuction() == 24) {
			type = "museum";
			day = "1";
		} else if (quote.getAuction() == 25) {
			type = "museum";
			day = "2";
		} else if (quote.getAuction() == 26) {
			type = "museum";
			day = "3";
		} else if (quote.getAuction() == 27) {
			type = "museum";
			day = "4";
		}

		//if the auctions are for flights then:
		if (quote.getAuction() < 8) {
			int auctionID = quote.getAuction();
			// if this is the 1st 10 seconds of the game.
			if (previousFlightPrice[auctionID] == 0) {
				// update the previous price
				previousFlightPrice[auctionID] = quote.getAskPrice();
			}
			// if there is a previous price, hence the game is >10s life.
			else {
				// update the difference in value for flight 1 with the previous flight at x-1.
				delta[auctionID] = quote.getAskPrice() - previousFlightPrice[auctionID];
				// update the current "old" price of the flight
				previousFlightPrice[auctionID] = quote.getAskPrice();
				//if all the flight prices have been updated and the deltas have been computed then
				//set a flag to true that will be used to run bayesian probability update.
				flight_updates[auctionID] = true;
			}
			boolean update = true;
			int counter = 0; 
			//a check to all 8 spots in the array
			while (counter<8 && update){
				update = flight_updates[counter];
				counter++;
			}
			//if all 8 flights are updated (true in all 8 spots in the array) then we calculate the
			//updated bayesian variables:
			if(update == true){
				for(int i =0;i<8;i++){
					baysianProb(delta[i], i);
				}
				
			}
			
		}
		
		
		//this is most probably depriciated by now as i figure that each part will use his own variables.
		updatePrices();
		
		if (timeUpdate - agent.getGameTimeLeft() > 10000) {
			timeUpdate = agent.getGameTimeLeft(); // updates the time till the next 10 seconds in our game.
		}

		//if the ask price of the updated quote is not zero then log the update.
		if (!(quote.getAskPrice() == 0f)) {
			log.fine("MARTINOS " + type + " " + day + " ASKPRICE: " + quote.getAskPrice() + " TIME: "
					+ agent.getGameTimeLeft());
		}
		//if the auction has bid price and it is not zero then log the update.
		if (!(quote.getBidPrice() == 0f)) {
			log.fine("MARTINOS " + type + " " + day + " BIDPRICE: " + quote.getBidPrice() + " TIME: "
					+ agent.getGameTimeLeft());
		}

		int auction = quote.getAuction();
		int auctionCategory = agent.getAuctionCategory(auction);
		if (auctionCategory == TACAgent.CAT_HOTEL) {
			int alloc = agent.getAllocation(auction);
			if (alloc > 0 && quote.hasHQW(agent.getBid(auction)) && quote.getHQW() < alloc) {
				Bid bid = new Bid(auction);
				// Can not own anything in hotel auctions...
				prices[auction] = quote.getAskPrice() + 50;
				bid.addBidPoint(alloc, prices[auction]);
				if (DEBUG) {
					log.finest("submitting bid with alloc=" + agent.getAllocation(auction) + " own="
							+ agent.getOwn(auction));
				}
				agent.submitBid(bid);
			}
		} else if (auctionCategory == TACAgent.CAT_ENTERTAINMENT) {
			int alloc = agent.getAllocation(auction) - agent.getOwn(auction);
			if (alloc != 0) {
				Bid bid = new Bid(auction);
				if (alloc < 0)
					prices[auction] = 200f - (agent.getGameTime() * 120f) / 720000;
				else
					prices[auction] = 50f + (agent.getGameTime() * 100f) / 720000;
				bid.addBidPoint(alloc, prices[auction]);
				if (DEBUG) {
					log.finest("submitting bid with alloc=" + agent.getAllocation(auction) + " own="
							+ agent.getOwn(auction));
				}
				agent.submitBid(bid);
			}
		}
	}

	/**
	 * 
	 * @param delta the difference in price between a flight and the previous one
	 * @param flightNumber numbers 1-4 mark the inflights days 1-4. numbers 5-8 marks ouflights on day 2-5.
	 */
	public void baysianProb(double delta, int flightNumber) {
		long time = agent.getGameTimeLeft() / 540000;

		double addition = 0f;

		for (int i = 0; i < flight_hiddenxf[flightNumber].length; i++) {
			double xf = i - 10;
			if (i < 10) {
				double xft = ((xf - 10) * time) + 10; // -10 till -1
				double centre = (xft + 10) / 2; // 0 till 4.5
				double intermediate = Math.abs(delta - centre);
				intermediate = intermediate / (Math.abs(xft - 10d));
				intermediate = 1d - intermediate;

				// if the delta is greater than 10 or less than xft then it is certain that
				// a hidden variable of less than 0 was not selected hence we penalize with 0,6 the bias for
				// that hidden variable
				// by 0.45.
				if (delta < xft || delta > 10) {
					intermediate = 0.45;
				}
				intermediate = intermediate * flight_hiddenxf[flightNumber][i];
				flight_hiddenxf[flightNumber][i] = intermediate;
				addition += intermediate;
			} else if (i == 10) {
				double intermediate = Math.abs(delta);
				intermediate = intermediate / (20d);
				intermediate = 1d - intermediate;
				if (delta < -10 || delta > 10) {
					intermediate = 0.45; // penalization factor of0.45.
				}
				intermediate = intermediate * flight_hiddenxf[flightNumber][i];
				flight_hiddenxf[flightNumber][i] = intermediate;
				addition += intermediate;

			} else {
				if (i == 15) {
					System.out.println("a");

				}
				double xft = (((i - 10) - 10) * time) + 10;
				if (xft < 1) {
					System.err.println("SHOULD NOT BE");
				}
				double centre = (-10 + xft) / 2;
				double intermediate = Math.abs(delta - centre);
				intermediate = intermediate / (Math.abs((-10d - xft)));
				intermediate = 1d - intermediate;

				if (delta < -10 || delta > xft) {
					intermediate = 0.45; // the penalizing factor for not picking values in XF is 0.45.
				}
				intermediate = intermediate * flight_hiddenxf[flightNumber][i];
				flight_hiddenxf[flightNumber][i] = intermediate;
				addition += intermediate;
			}
		}
		addition = 1 / addition;
		for (int i = 0; i < flight_hiddenxf[flightNumber][i]; i++) {
			flight_hiddenxf[flightNumber][i] = flight_hiddenxf[flightNumber][i] * addition;
		}
	}
	
	
	

	// method to edit
	public void quoteUpdated(int auctionCategory) {
		// log.fine("All quotes for "
		// + agent.auctionCategoryToString(auctionCategory)
		// + " has been updated");

	}

	public void bidUpdated(Bid bid) {
		// log.fine("Bid Updated: id=" + bid.getID() + " auction="
		// + bid.getAuction() + " state="
		// + bid.getProcessingStateAsString());
		// log.fine("       Hash: " + bid.getBidHash());
	}

	public void bidRejected(Bid bid) {
		// log.warning("Bid Rejected: " + bid.getID());
		// log.warning("      Reason: " + bid.getRejectReason()
		// + " (" + bid.getRejectReasonAsString() + ')');
	}

	public void bidError(Bid bid, int status) {
		// log.warning("Bid Error in auction " + bid.getAuction() + ": " + status
		// + " (" + agent.commandStatusToString(status) + ')');
	}

	public void gameStarted() {
		// log.fine("Game " + agent.getGameID() + " started!");

		calculateAllocation();
		sendBids();
	}

	public void gameStopped() {
		// log.fine("Game Stopped!");
	}

	public void auctionClosed(int auction) {
		// log.fine("*** Auction " + auction + " closed!");
	}

	// method to edit
	private void sendBids() {
		for (int i = 0, n = agent.getAuctionNo(); i < n; i++) {
			int alloc = agent.getAllocation(i) - agent.getOwn(i);
			float price = -1f;
			switch (agent.getAuctionCategory(i)) {
			case TACAgent.CAT_FLIGHT:
				if (alloc > 0) {
					price = 1000;
				}
				break;
			case TACAgent.CAT_HOTEL:
				if (alloc > 0) {
					price = 200;
					prices[i] = 200f;
				}
				break;
			case TACAgent.CAT_ENTERTAINMENT:
				if (alloc < 0) {
					price = 200;
					prices[i] = 200f;
				} else if (alloc > 0) {
					price = 50;
					prices[i] = 50f;
				}
				break;
			default:
				break;
			}
			if (price > 0) {
				Bid bid = new Bid(i);
				bid.addBidPoint(alloc, price);
				if (DEBUG) {
					log.finest("submitting bid with alloc=" + agent.getAllocation(i) + " own="
							+ agent.getOwn(i));
				}
				agent.submitBid(bid);
			}
		}
	}

	// DEBUG it *new
	private void updatePrices() {
		for (int i = 0; i < 28; i++) {
			if (i < 4) {
				information[i] = agent.getAuctionFor(TACAgent.CAT_FLIGHT, TACAgent.TYPE_INFLIGHT, i + 1);
			}

			else if (i < 8) {
				information[i] = agent.getAuctionFor(TACAgent.CAT_FLIGHT, TACAgent.TYPE_OUTFLIGHT, i - 2);
			} else if (i < 12) {
				information[i] = agent.getAuctionFor(TACAgent.CAT_HOTEL, TACAgent.TYPE_CHEAP_HOTEL, i - 7);

			} else if (i < 16) {
				information[i] = agent.getAuctionFor(TACAgent.CAT_HOTEL, TACAgent.TYPE_GOOD_HOTEL, i - 11);
			} else if (i < 20) {
				information[i] = agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT,
						TACAgent.TYPE_ALLIGATOR_WRESTLING, i - 15);
			} else if (i < 24) {
				information[i] = agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT, TACAgent.TYPE_AMUSEMENT,
						i - 19);
			} else if (i < 28) {
				information[i] = agent
						.getAuctionFor(TACAgent.CAT_ENTERTAINMENT, TACAgent.TYPE_MUSEUM, i - 23);
			}
		}
	}

	// DEBUG *new
	private void getClientPreferences() {
		for (int i = 0; i < 8; i++) {
			int inFlight = agent.getClientPreference(i, TACAgent.ARRIVAL);
			int outFlight = agent.getClientPreference(i, TACAgent.DEPARTURE);
			int hotel = agent.getClientPreference(i, TACAgent.HOTEL_VALUE);
			
			//initialize client preferences and probable flights.
			probableNightIn[i] = inFlight;
			probableNightOut[i] = outFlight;
			customerOutPreference[i] = outFlight;
			customerInPreference[i] = inFlight;

			log.fine("MARTINOS TESTING, INFLIGHT: " + inFlight + " OUTFLIGHT: " + outFlight + " HOTEL: "
					+ hotel + "gameLEngth: " + agent.getGameTimeLeft());

			// if the hotel value is greater than 70 we will select the
			// expensive hotel (type = 1)
			if (hotel > 70) {
				hotelPreference[i] = true;
			} else {
				hotelPreference[i] = false;
			}
		}
	}

	private void calculateAllocation() {
		getClientPreferences();
		updatePrices();

	}

	private int bestEntDay(int inFlight, int outFlight, int type) {
		for (int i = inFlight; i < outFlight; i++) {
			int auction = agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT, type, i);
			if (agent.getAllocation(auction) < agent.getOwn(auction)) {
				return auction;
			}
		}
		// If no left, just take the first...
		return agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT, type, inFlight);
	}

	private int nextEntType(int client, int lastType) {
		int e1 = agent.getClientPreference(client, TACAgent.E1);
		int e2 = agent.getClientPreference(client, TACAgent.E2);
		int e3 = agent.getClientPreference(client, TACAgent.E3);

		// At least buy what each agent wants the most!!!
		if ((e1 > e2) && (e1 > e3) && lastType == -1)
			return TACAgent.TYPE_ALLIGATOR_WRESTLING;
		if ((e2 > e1) && (e2 > e3) && lastType == -1)
			return TACAgent.TYPE_AMUSEMENT;
		if ((e3 > e1) && (e3 > e2) && lastType == -1)
			return TACAgent.TYPE_MUSEUM;
		return -1;
	}

	// -------------------------------------------------------------------
	// Only for backward compability
	// -------------------------------------------------------------------

	public static void main(String[] args) {
		TACAgent.main(args);
	}

} // DummyAgent