package com.view;

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
 * Servlet implementation class Ticketform
 */
@WebServlet("/Ticketform")
public class Ticketform extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
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

        out.println("<h2>Book your Tickets Now</h2><br><br>");
        out.println("<form action='Ticketcont' method='post'>"); // Corrected form action to 'Ticketcont'
        out.println("Match Name<input type='text' name='Matchname'><br><br>");
        out.println("Place<input type='text' name='place'><br><br>");
        out.println("Date<input type='datetime' name='date'><br><br>"); // Changed to 'datetime-local' for better datetime input
        out.println("<label>Block of Selection</label>");
        out.println("<select name='block'>"); // Corrected select name to 'block'
        out.println("<option>A-block-100rs</option>");
        out.println("<option>B-block-120rs</option>");
        out.println("<option>C-block-150rs</option>");
        out.println("<option>D-block-200rs</option>");
        out.println("</select><br><br>");
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
