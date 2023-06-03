<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.models.beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Cancion> lista = (ArrayList<Cancion>) request.getAttribute("lista");%>

<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista De Canciones Recomendadas"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="recomendados"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>ROL</th>
                <th>Ver</th>
            </tr>
            </thead>

            <tbody>
            <%
                for(Cancion k:lista) {
            %>
            <tr>
                <td><%= k.getIdCancion()%> </td>
                <td><%= k.getNombre()%> </td>
                <td><%= k.getBanda()%> </td>
                <td>
                    <a class="btn btn-success" href="… ">Mas de la Banda</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
