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

    <h1 class="ui dividing header">Delete Book</h1>
    <h2>Are you sure you want to delete this book?</h2>



    <c:if test="${success > 0}">
        <h2 class="ignored ui warning message"> Book deleted Successfully.</h2>
    </c:if>

    <c:if test="${success == 0}">
        <h2 class="ignored ui error message"> Error: Book not deleted from database.</h2>
    </c:if>

    <c:if test="${success <= 0}">
    <form action="" method="POST" class="ui form">
        <!--book id -->
        <input type="hidden" id="book-id" name="book_id" value="${book_id}" >

        <div class="field">
            <button class="ui massive negative button" type="submit">Delete</button>
            <a href="${baseurl}" class="ui massive positive button">Cancel</a>
        </div>
    </form>
    </c:if>

</div> <!-- container -->

<%-- in body end --%>

<%-- foot html --%>
<jsp:include page="templates/foot.jsp" />
