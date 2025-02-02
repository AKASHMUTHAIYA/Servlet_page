package com.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form1cont")
public class firstformcont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String title=request.getParameter("title");
		String place=request.getParameter("place");
		String date=(String)request.getParameter("date");
		
		ArrayList<String> list=new ArrayList<String>();
		
		if(title.length()==0)
			list.add("Please enter the name of the match");
		if(place.length()==0)
			list.add("Enter the place of the match being occurred");
		if(date.length()==0)
			list.add("Please enter date of the match");
		
		if(!list.isEmpty())
		{
			request.setAttribute("errors", list);
			RequestDispatcher rd=request.getRequestDispatcher("form1");
			rd.forward(request, response);
			return;
		}
		
		
		form1data f1=new form1data(title,place,date);
		form1dataDAO f2=new form1dataDAO();
		f2.saveData(f1);
		
		RequestDispatcher rd=request.getRequestDispatcher("Success.html");
		rd.forward(request, response);
		
	}

}
