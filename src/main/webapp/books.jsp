
<%@ page  language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- head html --%>
<jsp:include page="templates/head.jsp">
    <jsp:param name="title" value="Books Listing" />
</jsp:include>

<%-- in body start --%>


<h3 class="ui center aligned header">Books List</h3>

<div class="ui container">
    <div class="ui relaxed divided items books">

        <c:forEach items="${booklist}" var="b">

            <p> id-<c:out value="${b.getId()}" /></p>

        <div class="item book">
            <div class="ui small image">
                <img src="${pageContext.request.contextPath}/assets/img/wireframe-image.png">
            </div>
            <div class="content">
                <div class="header">
                    <c:out value="${b.getTitle()}"  />
                </div>
                <div class="meta">
                    <div class="ui label">
                        <c:out value="${b.getDate()}"   />
                    </div>
                    <div class="ui label">
                        <c:out value="${b.getAuthor()}" />
                    </div>
                </div>
                <div class="description">
                    <p> <c:out value="${b.getGenres()}" /> </p>
                </div>
                <div class="description">
                    <p> <c:out value="${b.getCharacters()}" /> </p>
                </div>
                <div class="description">
                    <p> <c:out value="${b.getSynopsis()}" /> </p>
                </div>
                <div class="extra">
                    <a href="${pageContext.request.contextPath}/delete-book?id=${b.getId()}">
                        <div  class="ui right floated negative button">
                            Delete <i class="right trash icon"></i>
                        </div>
                    </a>
                    <a href="${pageContext.request.contextPath}/edit-book?id=${b.getId()}">
                        <div class="ui right floated primary button">
                            Edit <i class="right edit icon"></i>
                        </div>
                    </a>
                </div>
            </div>
        </div>

        </c:forEach>

    </div>
</div>

<h3 class="ui center aligned header">Responsive Steps</h3>

<div class="ui last container">
    <div class="ui three steps">
        <div class="step">
            <div class="content">
                <div class="title">Shipping</div>
                <div class="description">Choose your shipping options</div>
            </div>
        </div>
        <div class="active step">
            <div class="content">
                <div class="title">Billing</div>
                <div class="description">Enter billing information</div>
            </div>
        </div>
        <div class="disabled step">
            <div class="content">
                <div class="title">Confirm Order</div>
                <div class="description">Review your order details</div>
            </div>
        </div>
    </div>
</div>




<%-- in body end  --%>


<%-- foot html --%>
<jsp:include page="templates/foot.jsp" />