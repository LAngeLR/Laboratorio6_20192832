<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.models.beans.CancionFavorita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<CancionFavorita> lista = (ArrayList<CancionFavorita>) request.getAttribute("lista");
%>

<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista De Canciones Favorita"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>


    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <div class="d-flex justify-content-lg-end">
                <h1 class='text-light'>Lista de Canciones</h1>
            </div>
        </div>
    </div>

    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>BANDA</th>
                <th>OPCION</th>
            </tr>
            </thead>
            <tbody>
            <% for (CancionFavorita j : lista) { %>
            <tr>
                <td><%=j.getIdCancion()%>
                </td>
                <td><%=j.getNombre() %>
                </td>
                <td><%=j.getBanda()%>
                </td>
                <td>
                    <div class="col-2">
                        <a class="btn btn-success" href="<%=request.getContextPath()%>/CancionFavoritaServlet?a=crear">Añadir</a>
                    </div>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>