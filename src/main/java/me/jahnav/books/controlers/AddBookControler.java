package me.jahnav.books.controlers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.jahnav.books.database.BookDAO;
import me.jahnav.books.models.Book;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddBookControler", value = "/add-book")
public class AddBookControler extends HttpServlet {

    /**
     * start
     */
    public void init() {

    }

    /**
     * Get Request
     * Laod page with html form for user input
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        int success = -1;
        if (null != request.getParameter("success") ){
            success = Integer.parseInt( request.getParameter("success") );
        }
        request.setAttribute("success", success);


        // load jsp
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("add-book.jsp");
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
        //if (request.getQueryString() != null) {
            //requestURL.append("?").append(request.getQueryString());
        //}
        String completeURL = requestURL.toString();


        // read post form data
        Book book = new Book();
        //book.setId(Integer.parseInt(request.getParameter("book_id")));
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setDate(request.getParameter("date"));
        book.setGenres(request.getParameter("genres"));
        book.setCharacters(request.getParameter("characters"));
        book.setSynopsis(request.getParameter("synopsis"));

        // update in db
        BookDAO bookdb = new BookDAO();
        int r = bookdb.addBook(book); //updateBook(book);
        if( r == 0 ){
            //response.getWriter().write("Error: Book not added.");
            response.sendRedirect(completeURL + "?success=0" );
        }
        if(r > 0){
            //response.getWriter().write("Book Added");
            response.sendRedirect(completeURL + "?success=1" );
        }

    }



    /**
     * End
     */
    public void destroy() {

    }


}
