package org.gae.project;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletDeleteBook extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        String id = req.getParameter("id");
        DAO.INSTANCE.removeBook(Long.parseLong(id));
        resp.sendRedirect("/BookApplication.jsp");
    }
}
