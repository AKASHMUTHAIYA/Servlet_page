package com.playerslist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Newplayerform
 */
@WebServlet("/Newplayerform")
public class Newplayerform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        @SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("errors");
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("form { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); width: 300px; margin: 20px auto; }");
        out.println("input[type='text'], input[type='datetime'], select { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; }");
        out.println("input[type='submit'] { background: #28a745; color: #fff; padding: 10px; border: none; border-radius: 4px; cursor: pointer; width: 100%; }");
        out.println("input[type='submit']:hover { background: #218838; }");
        out.println("ul { list-style-type: none; padding: 0; }");
        out.println("li { background: #ffdddd; margin: 5px 0; padding: 10px; border-left: 5px solid #f44336; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        if (list != null) {
            Iterator<String> itr = list.iterator();
            out.println("<ul>");
            while (itr.hasNext()) {
                out.println("<li>" + itr.next() + "</li>");
            }
            out.println("</ul>");
        }
        
        out.println("<form action='Playerformcon' method='post'>");
        out.println("<h2>Add Player Details Form</h2>");
        out.println("<label for='name'>Player Name</label>");
        out.println("<input type='text' id='name' name='name'>");
        out.println("<label for='teamname'>Team Name</label>");
        out.println("<input type='text' id='teamname' name='teamname'>");
        out.println("<label for='phonenumber'>Phone Number</label>");
        out.println("<input type='text' id='phonenumber' name='phonenumber'>");
        out.println("<label for='playerid'>Player ID</label>");
        out.println("<input type='text' id='playerid' name='playerid'>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
