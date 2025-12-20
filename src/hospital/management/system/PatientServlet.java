package hospital.management.system.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple servlet to demonstrate HTTP handling.
 */
public class PatientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Patient Servlet Working Successfully</h2>");
    }
}
