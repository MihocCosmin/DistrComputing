package org.gae.project;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ServletCreateBook extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("Adding new book... ");
        User user = (User) req.getAttribute("user");
        if (user == null) {
            UserService userService = UserServiceFactory.getUserService();
            user = userService.getCurrentUser();
        }

        String title = checkNull(req.getParameter("title"));
        String author = checkNull(req.getParameter("author"));
        String description = checkNull(req.getParameter("description"));

        DAO.INSTANCE.addBook(user.getUserId(), title, author, description);

        resp.sendRedirect("/BookApplication.jsp");
    }

    private String checkNull(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}
