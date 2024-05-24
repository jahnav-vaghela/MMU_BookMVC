package me.jahnav.books.database;

import me.jahnav.books.models.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookDAO {

	private Connection connection;
	private String username = "root";
	//private String username = "admin";
	private String password = "";
    //private String password = "admin123";
	private String dbname  = "sam2proj";
	// Note none default port used, 6306 not 3306
	private String url = "jdbc:mysql://localhost:3306/" + dbname;
	//private String url = "jdbc:mysql://database-1.chc40u0mq5pf.eu-north-1.rds.amazonaws.com:3306/" + dbname;


	// Constructor to initialize the database connection
	public BookDAO() {}

	// open connection class
	public void openConnection() {

		// loading jdbc driver for mysql
		try{
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch(  Exception e) { e.printStackTrace(); }

		// connecting to database
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}

	public Book fetchBook( ResultSet resultSet ) throws SQLException {

		Book book = new Book();
		book.setId(resultSet.getInt("id"));
		book.setTitle(resultSet.getString("title"));
		book.setAuthor(resultSet.getString("author"));
		book.setDate(resultSet.getString("date"));
		book.setGenres(resultSet.getString("genres"));
		book.setCharacters(resultSet.getString("characters"));
		book.setSynopsis(resultSet.getString("synopsis"));

		return book;
	}

	// Method to retrieve all books from the database
	public Book getBookById(int book_id) {

		Book book = null;
		openConnection();

		String sql_qry = "SELECT * FROM books WHERE id=?";

		try ( PreparedStatement statement = connection.prepareStatement(sql_qry) ) {

			statement.setInt(1, book_id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				book = fetchBook(resultSet);
			}
			statement.close();
			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

        return book;
    }

	// Method to retrieve all books from the database
	public ArrayList<Book> getAllBooksSearch(String search) {

		ArrayList<Book> books = new ArrayList<>();
		openConnection();

		String sql_qry = "SELECT * FROM books WHERE title LIKE ? order by id DESC limit 10";

		try (PreparedStatement statement = connection.prepareStatement(sql_qry)) {

			statement.setString(1, "%"+search+"%");

			System.out.println("After : " + statement.toString());

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = fetchBook(resultSet);
				books.add(book);
			}
			statement.close();
			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}


	// Method to retrieve all books from the database
	public ArrayList<Book> getAllBooks() {

		ArrayList<Book> books = new ArrayList<>();
		openConnection();

        String sql_qry = "SELECT * FROM books order by id DESC limit 10";

        try (PreparedStatement statement = connection.prepareStatement(sql_qry);
			 ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Book book = fetchBook(resultSet);
				books.add(book);
			}
			statement.close();
			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	// Method to insert a new book into the database
	public int addBook(Book book) {

		int r = 0;
		openConnection();
		String sql_str = "INSERT INTO books (title, author, date, genres, characters, synopsis) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement( sql_str )) {

			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getDate());
			statement.setString(4, book.getGenres());
			statement.setString(5, book.getCharacters());
			statement.setString(6, book.getSynopsis());

			r = statement.executeUpdate();

			statement.close();
			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return  r;
	}

	// Method to update an existing book in the database
	public int updateBook(Book book) {

		int r = 0; // updated rows
		openConnection();
		String sql_str = "UPDATE books SET title=?, author=?, date=?, genres=?, characters=?, synopsis=? WHERE id=?";

		try (PreparedStatement statement = connection.prepareStatement( sql_str )) {

			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getDate());
			statement.setString(4, book.getGenres());
			statement.setString(5, book.getCharacters());
			statement.setString(6, book.getSynopsis());
			statement.setInt(7, book.getId());

			r = statement.executeUpdate();

			statement.close();
			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	// Method to delete a book from the database
	public int deleteBook(int id) {

		int r = 0;
		openConnection();

		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id=?")) {
			statement.setInt(1, id);
			r = statement.executeUpdate();

			statement.close();
			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	// Method to close the database connection
	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
