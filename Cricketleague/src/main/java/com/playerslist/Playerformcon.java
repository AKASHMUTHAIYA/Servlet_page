package com.playerslist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Playerformcon
 */
@WebServlet("/Playerformcon")
public class Playerformcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		String playername = request.getParameter("name");
		String teamname = request.getParameter("teamname");
		String phonenumber = request.getParameter("phonenumber");
		String playerId = request.getParameter("playerid");
		
		ArrayList<String> list = new ArrayList<>();
		
		if (playername == null || playername.isEmpty()) {
			list.add("Please enter the player's name");
		}
		if (teamname == null || teamname.isEmpty()) {
			list.add("Enter the team name");
		}
		if (phonenumber == null || phonenumber.isEmpty()) {
			list.add("Please enter the phone number");
		}
		if (playerId == null || playerId.isEmpty()) {
			list.add("Please enter the player ID");
		}
		
		if (!list.isEmpty()) {
			request.setAttribute("errors", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Newplayerform");
			rd.forward(request, response);
			return;
		}
		
		Newplayerformdata n1 = new Newplayerformdata(playername, teamname, phonenumber, playerId);
		NewPlayerDao n2 = new NewPlayerDao();
		n2.saveData(n1);

		RequestDispatcher rd = request.getRequestDispatcher("Success.html");
		rd.forward(request, response);
	}
}
