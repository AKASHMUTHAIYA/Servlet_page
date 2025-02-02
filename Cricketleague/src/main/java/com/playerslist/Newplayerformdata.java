package com.playerslist;

public class Newplayerformdata {
    private String playername;
    private String teamname;
    private String phonenumber;
    private String playerid;

    // Default constructor
    public Newplayerformdata() {
        // No need for initialization in the default constructor
    }

    // Parameterized constructor
    public Newplayerformdata(String playername, String teamname, String phonenumber, String playerid) {
        this.playername = playername;
        this.teamname = teamname;
        this.phonenumber = phonenumber;
        this.playerid = playerid;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }
}
