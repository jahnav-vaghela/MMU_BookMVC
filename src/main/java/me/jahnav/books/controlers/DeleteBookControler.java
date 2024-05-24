package me.jahnav.books.controlers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.jahnav.books.database.BookDAO;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "DeleteBookControler", value = "/delete-book")
public class DeleteBookControler extends HttpServlet {

    /**
     * start
     */
    public void init() {

    }

    public static String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String host = request.getServerName();
        int port = request.getServerPort();
        String contextPath = request.getContextPath();

        String baseUrl = scheme + "://" + host + ((("http".equals(scheme) && port == 80) || ("https".equals(scheme) && port == 443)) ? "" : ":" + port) + contextPath;
        return baseUrl;
    }

    /**
     * Get Request
     * Laod page with html form for user input
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //
        String baseUrl = getBaseUrl(request);
        request.setAttribute("baseurl", baseUrl);

        // URL With query string
        int success = -1;
        if (null != request.getParameter("success") ){
            success = Integer.parseInt( request.getParameter("success") );
        }
        request.setAttribute("success", success);



        int book_id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("book_id", book_id);

        // load jsp
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("delete-book.jsp");
        dispatcher.include(request,response);

    }

    /**
     * Post Request
     * save data in database and provide responce mssage
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // URL With query string
        StringBuffer requestURL = request.getRequestURL();
        if (request.getQueryString() != null) {
            requestURL.append("?").append(request.getQueryString());
        }
        String completeURL = requestURL.toString();

        int book_id = Integer.parseInt(request.getParameter("id"));

        // update in db
        BookDAO bookdb = new BookDAO();
        int r = bookdb.deleteBook(book_id);
        if( r == 0 ){
            //response.getWriter().write("Error: Book not deleted.");
            response.sendRedirect(completeURL + "&success=0" );
        }
        if(r > 0){
            //response.getWriter().write("Book deleted");
            response.sendRedirect(completeURL + "&success=1" );
        }

    }



    /**
     * End
     */
    public void destroy() {

    }


}
