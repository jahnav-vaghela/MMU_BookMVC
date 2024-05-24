package me.jahnav.books.controlers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Null;
import me.jahnav.books.models.Book;
import me.jahnav.books.database.BookDAO;

import java.io.IOException;
import java.util.ArrayList;

//import static java.lang.System.*;

@WebServlet(name = "BooksControler", value = "/")
public class BooksControler extends HttpServlet {

    /**
     * start
     */

    public void init() {

    }

    /**
     * Get Request
     * Laod page with html
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }



        // get books from db
        BookDAO bookdb = new BookDAO();
        ArrayList<Book> booklist = new ArrayList<Book>();

        if(search.trim().isEmpty()){
            booklist = bookdb.getAllBooks();
        }else{
            booklist = bookdb.getAllBooksSearch(search);
        }

        // set attributes
        request.setAttribute("booklist", booklist);

        // load jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("books.jsp");
        dispatcher.include(request,response);

    }

    /**
     * End
     */
    public void destroy() {

    }


}
