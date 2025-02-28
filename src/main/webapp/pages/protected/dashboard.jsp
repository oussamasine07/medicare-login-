<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="com.medicare.model.User" %>
<jsp:include page="/pages/partials/header.jsp" />

    <%
        User user = (User) session.getAttribute("user");
    %>

    <div class="container mx-auto">
        <h1 class="my-6">You are logged in as <%= user.getFullName() %></h1>
    </div>


<jsp:include page="/pages/partials/footer.jsp" />
