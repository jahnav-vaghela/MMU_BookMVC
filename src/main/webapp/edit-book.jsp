<%--
  Created by IntelliJ IDEA.
  User: jahnav
  Date: 3/10/2024
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- head html --%>
<jsp:include page="templates/head.jsp">
    <jsp:param name="title" value="Edit Book" />
</jsp:include>

<%-- in body start --%>

<div class="ui text container">

    <h1 class="ui dividing header">Edit Book</h1>

    <c:if test="${success > 0}">
        <h2 class="ignored ui warning message"> Book updated Successfully.</h2>
    </c:if>

    <c:if test="${success == 0}">
        <h2 class="ignored ui error message"> Error: Book not updated in database.</h2>
    </c:if>

    <form action="" method="POST" class="ui form">
        <!--book id -->
        <input type="hidden" id="book-id" name="book_id" value="${book.getId()}" >

        <div class="field">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${ book.getTitle() }" required>
        </div>
        <div class="field">
            <label for="author">Author:</label>
            <input type="text" id="author" name="author" value="${ book.getAuthor() }" required>
        </div>
        <div class="field">
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" value="${ book.getDate() }" required>
        </div>
        <div class="field">
            <label for="genres">Genres:</label>
            <input type="text" id="genres" name="genres" value="${ book.getGenres() }">
        </div>
        <div class="field">
            <label for="characters">Characters:</label>
            <input type="text" id="characters" name="characters" value="${ book.getCharacters() }">
        </div>
        <div class="field">
            <label for="synopsis">Synopsis:</label>
            <textarea id="synopsis" name="synopsis" rows="5" required> ${ book.getSynopsis() } </textarea>
        </div>
        <div class="field">
            <button class="ui button" type="submit">Submit</button>
        </div>
    </form>

</div> <!-- container -->

<%-- in body end --%>

<%-- foot html --%>
<jsp:include page="templates/foot.jsp" />
