package com.view;

public class Ticketform1 {
String Matchname,place,date,block;

public Ticketform1(String matchname, String place, String date, String block) {
	super();
	Matchname = matchname;
	this.place = place;
	this.date = date;
	this.block=block;
}

public String getMatchname() {
	return Matchname;
}

public String getPlace() {
	return place;
}

public String getDate() {
	return date;
}


public String getBlock() {
	// TODO Auto-generated method stub
	return block;
}

}
