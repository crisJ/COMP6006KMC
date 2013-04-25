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

public class DataGather extends AgentImpl {
	
  private static final Logger log =
    Logger.getLogger(DataGather.class.getName());
  private static final boolean DEBUG = false;
  private float[] prices;
  
  private boolean dayChangingAlert;
  private int[] probableNightsIn;
  private int[] probableNightsOut;
  private int[] information;
  private boolean[] hotelPreference;
  private long timeUpdate;
  
 
 public DataGather(){
	 
	 hotelPreference = new boolean[8];
	 probableNightsIn = new int[8];
	 probableNightsOut = new int[8];
	 information = new int[28];
	 dayChangingAlert = false;
	 timeUpdate = 540000L;
	 
	 
	 
 }
  protected void init(ArgEnumerator args) {
    prices = new float[agent.getAuctionNo()];
  }
  
  
//method to edit
  public void quoteUpdated(Quote quote) {
	  String type = "";  
	  String day = "";
	  if(quote.getAuction() == 0 ){
		  type = "inflight";
		  day = "1";
	  }
	  else if(quote.getAuction() == 1 ){
		  type = "inflight";
		  day = "2";
	  }
	  else if(quote.getAuction() == 2 ){
		  type = "inflight";
		  day = "3";
	  }
	  else if(quote.getAuction() == 3 ){
		  type = "inflight";
		  day = "4";
	  }
	  else if(quote.getAuction() == 4 ){
		  type = "outflight";
		  day="2";
	  }
	  else if(quote.getAuction() == 5 ){
		  type = "outflight";
		  day="3";
	  }
	  else if(quote.getAuction() == 6 ){
		  type = "outflight";
		  day="4";
	  }
	  else if(quote.getAuction() == 7 ){
		  type = "outflight";
		  day="5";
	  }
	  else if(quote.getAuction() == 8 ){
		  type = "cheapHotel";
		  day="1";
	  }
	  else if(quote.getAuction() == 9 ){
		  type = "cheapHotel";
		  day="2";
	  }
	  else if(quote.getAuction() == 10 ){
		  type = "cheapHotel";
		  day="3";
	  }
	  else if(quote.getAuction() == 11 ){
		  type = "cheapHotel";
		  day="4";
	  }
	  else if(quote.getAuction() == 12 ){
		  type = "expensiveHotel";
		  day="1";
	  }
	  else if(quote.getAuction() == 13 ){
		  type = "expensiveHotel";
		  day="2";
	  }
	  else if(quote.getAuction() == 14 ){
		  type = "expensiveHotel";
		  day="3";
	  }
	  else if(quote.getAuction() == 15 ){
		  type = "expensiveHotel";
		  day="4";
	  }
	  else if(quote.getAuction() == 16 ){
		  type = "aligator";
		  day="1";
	  }
	  else if(quote.getAuction() == 17 ){
		  type = "aligator";
		  day="2";
	  }
	  else if(quote.getAuction() == 18 ){
		  type = "aligator";
		  day="3";
	  }
	  else if(quote.getAuction() == 19 ){
		  type = "aligator";
		  day="4";
	  }
	  else if(quote.getAuction() == 20 ){
		  type = "amuzement";
		  day="1";
	  }
	  else if(quote.getAuction() == 21 ){
		  type = "amuzement";
		  day="2";
	  }
	  else if(quote.getAuction() == 22 ){
		  type = "amuzement";
		  day="3";
	  }
	  else if(quote.getAuction() == 23 ){
		  type = "amuzement";
		  day="4";
	  }
	  else if(quote.getAuction() == 24 ){
		  type = "museum";
		  day="1";
	  }
	  else if(quote.getAuction() == 25 ){
		  type = "museum";
		  day="2";
	  }
	  else if(quote.getAuction() == 26 ){
		  type = "museum";
		  day="3";
	  }
	  else if(quote.getAuction() == 27 ){
		  type = "museum";
		  day="4";
	  }

	  
	  
	  
	  
	  
	  if(timeUpdate - agent.getGameTimeLeft() >1000) {
		  updatePrices();
		  timeUpdate = agent.getGameTimeLeft();
		  log.fine("MARTINOS " + type + " " + day  + " " + quote.getAskPrice());
		  log.fine("time update minus game left " + (timeUpdate-agent.getGameTimeLeft()) + "game time left is: " +  agent.getGameTimeLeft() );
		  
	  }
	  
	  int auction = quote.getAuction();
	    int auctionCategory = agent.getAuctionCategory(auction);
	    if (auctionCategory == TACAgent.CAT_HOTEL) {
	      int alloc = agent.getAllocation(auction);
	      if (alloc > 0 && quote.hasHQW(agent.getBid(auction)) &&
		  quote.getHQW() < alloc) {
		Bid bid = new Bid(auction);
		// Can not own anything in hotel auctions...
		prices[auction] = quote.getAskPrice() + 50;
		bid.addBidPoint(alloc, prices[auction]);
		if (DEBUG) {
		  log.finest("submitting bid with alloc="
			     + agent.getAllocation(auction)
			     + " own=" + agent.getOwn(auction));
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
		  log.finest("submitting bid with alloc="
			     + agent.getAllocation(auction)
			     + " own=" + agent.getOwn(auction));
		}
		agent.submitBid(bid);
	      }
	    }
  }
  
  
//method to edit
  public void quoteUpdated(int auctionCategory) {
	  //log.fine("All quotes for "
		//	     + agent.auctionCategoryToString(auctionCategory)
			//     + " has been updated");
	  
  }

  public void bidUpdated(Bid bid) {
    //log.fine("Bid Updated: id=" + bid.getID() + " auction="
	  //   + bid.getAuction() + " state="
	    // + bid.getProcessingStateAsString());
   // log.fine("       Hash: " + bid.getBidHash());
  }

  public void bidRejected(Bid bid) {
    //log.warning("Bid Rejected: " + bid.getID());
    //log.warning("      Reason: " + bid.getRejectReason()
		//+ " (" + bid.getRejectReasonAsString() + ')');
  }

  public void bidError(Bid bid, int status) {
    //log.warning("Bid Error in auction " + bid.getAuction() + ": " + status
		//+ " (" + agent.commandStatusToString(status) + ')');
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
    //log.fine("*** Auction " + auction + " closed!");
  }

  //method to edit
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
		  log.finest("submitting bid with alloc=" + agent.getAllocation(i)
			     + " own=" + agent.getOwn(i));
		}
		agent.submitBid(bid);
	      }
	    }
  }

  
  //DEBUG it *new
  private void updatePrices(){
	  for (int i = 0; i < 28; i++) {
		  if(i<4){
		  information[i] = agent.getAuctionFor(TACAgent.CAT_FLIGHT,
					TACAgent.TYPE_INFLIGHT, i+1);
		  } 
		  
		  else if(i<8){
			  information[i] =  agent.getAuctionFor(TACAgent.CAT_FLIGHT,
					    TACAgent.TYPE_OUTFLIGHT, i-2);
		  }
		  else if(i<12){
			  information[i] =  agent.getAuctionFor(TACAgent.CAT_HOTEL,
					  TACAgent.TYPE_CHEAP_HOTEL, i-7);

		  }
		  else if(i<16){
			  information[i] =  agent.getAuctionFor(TACAgent.CAT_HOTEL,
					  TACAgent.TYPE_GOOD_HOTEL, i-11);
		  }
		  else if(i<20){
			  information[i] =  agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT,
					  TACAgent.TYPE_ALLIGATOR_WRESTLING, i-15);
		  }
		  else if(i<24){
			  information[i] =  agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT,
					  TACAgent.TYPE_AMUSEMENT, i-19);
		  }
		  else if(i<28){
			  information[i] =  agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT,
					  TACAgent.TYPE_MUSEUM, i-23);
		  }
	  }
  }
  
  //DEBUG *new
  private void getClientPreferences(){
	  for (int i = 0; i < 8; i++) {
	      int inFlight = agent.getClientPreference(i, TACAgent.ARRIVAL);
	      int outFlight = agent.getClientPreference(i, TACAgent.DEPARTURE);
	      int hotel = agent.getClientPreference(i, TACAgent.HOTEL_VALUE);
	      
	      probableNightsIn[i] = inFlight;
	      probableNightsOut[i] = outFlight;


	      log.fine("MARTINOS TESTING, INFLIGHT: " +  inFlight + " OUTFLIGHT: " + outFlight + " HOTEL: " + hotel + "gameLEngth: "+ agent.getGameTimeLeft());

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
      int auction = agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT,
					type, i);
      if (agent.getAllocation(auction) < agent.getOwn(auction)) {
	return auction;
      }
    }
    // If no left, just take the first...
    return agent.getAuctionFor(TACAgent.CAT_ENTERTAINMENT,
			       type, inFlight);
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

  public static void main (String[] args) {
    TACAgent.main(args);
  }

} // DummyAgent
