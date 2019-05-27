<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="org.gae.project.Book" %>
<%@ page import="org.gae.project.DAO" %>

<!DOCTYPE html>

<html>

    <head>
        <title>BookApplication</title>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
          <meta charset="utf-8">
    </head>
    <body>

    <%
       DAO dao = DAO.INSTANCE;

       UserService userService = UserServiceFactory.getUserService();
       User user = userService.getCurrentUser();

       String url = userService.createLoginURL(request.getRequestURI());
       String urlLinktext = "Login";
       List<Book> books = new ArrayList<Book>();

       if (user != null){
           url = userService.createLogoutURL(request.getRequestURI());
           urlLinktext = "Logout";
           books = dao.getBook(user.getUserId());
        }
    %>
    
    <div style="width: 100%;">
        <div class="line"></div>
        <div class="topLine">
            <div style="float: left;" class="headline">Books</div>
            <div style="float: right;"><a href="<%=url%>"><%=urlLinktext%></a> <%=(user==null? "" : user.getNickname())%></div>
        </div>
    </div>
    
    <div style="clear: both;"/>
    You have a total number of <%= books.size() %>  Books.
    
    <table>
  <tr>
      <th>Title</th>
      <th>Author</th>
      <th>Description</th>
      <th>Delete</th>
    </tr>

<% for (Book book : books) {%>
<tr>
<td>
<%=book.getTitle()%>
</td>
<td>
<%=book.getAuthor()%>
</td>
<td>
<%=book.getDescription()%>
</td>
<td>
<a class="delete" href="/delete?id=<%=book.getId()%>" >Delete</a>
</td>
</tr>
<%}
%>
</table>
    
    <hr />

<div class="main">

<div class="headline">New Book</div>

<% if (user != null){ %>

<form action="/new" method="post" accept-charset="utf-8">
    <table>
        <tr>
            <td><label for="Title">Title</label></td>
            <td><input type="text" name="Title" id="Title" size="65"/></td>
        </tr>
        <tr>
            <td><label for="Author">Author</label></td>
            <td><input type="text" name="Author" id="Author" size="65"/></td>
        </tr>
        <tr>
            <td valign="description"><label for="description">Description</label></td>
            <td><textarea rows="4" cols="50" name="description" id="description"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form>

<% }else{ %>

Please login with your Google account.

<% } %>
</div>
    
    </body>

</html>