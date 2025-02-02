package com.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ticketcont
 */
@WebServlet("/Ticketcont")
public class Ticketcont extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Matchname = request.getParameter("Matchname");
        String place = request.getParameter("place");
        String block = request.getParameter("block");
        String date = request.getParameter("date");

        ArrayList<String> list = new ArrayList<String>();

        if (Matchname == null || Matchname.trim().isEmpty()) {
            list.add("Please enter the name of the match");
        }
        if (place == null || place.trim().isEmpty()) {
            list.add("Enter the place of the match being occurred");
        }
        if (date == null || date.trim().isEmpty()) {
            list.add("Please enter date of the match");
        }
        if (block == null || block.trim().isEmpty()) {
            list.add("Please enter block for the match");
        }
        
        if (!list.isEmpty()) {
            request.setAttribute("errors", list);
            RequestDispatcher rd = request.getRequestDispatcher("Ticketform");
            rd.forward(request, response);
            return;
        }

        Ticketform1 f1 = new Ticketform1(Matchname, place, block, date);
        Ticketformcont f2 = new Ticketformcont();
        f2.storedata(f1);

        RequestDispatcher rd = request.getRequestDispatcher("TicketBook.html");
        rd.forward(request, response);
    }
}
