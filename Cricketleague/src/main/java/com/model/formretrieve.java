package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formretrieve
 */
@WebServlet("/formretrieve")
public class formretrieve extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }");
        out.println("h1 { text-align: center; color: #333; }");
        out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
        out.println("table, th, td { border: 1px solid #ccc; }");
        out.println("th, td { padding: 10px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Upcoming Match Information List</h1>");
        out.println("<table>");
        out.println("<tr><th>Title</th><th>Place</th><th>Date</th></tr>");

        ResultSet rs = new form1dataDAO().retrievedata();
        try {
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("Title") + "</td><td>"
                        + rs.getString("Place") + "</td><td>"
                        + rs.getString("Date") + "</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
