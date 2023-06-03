<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.models.beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Cancion> lista1 = (ArrayList<Cancion>) request.getAttribute("lista1");%>

<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista De Canciones Por Banda"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="canciones"/>
    </jsp:include>


    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <div class="d-flex justify-content-lg-end">
                <h1 class='text-light'>Lista de Canciones Por Banda</h1>
                <div class="col-4 col-xl-auto mb-2">
                    <br>
                    <br>
                    <div class="container-xl px-4 mt-4">
                        <div class="col-12 col-xl-auto mb-3 text-end">
                            <a class="btn btn-warning" href="listaCancionesGeneral">Mostrar todas las canciones</a>
                        </div>
                    </div>
                </div>
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
            </tr>
            </thead>
            <tbody>
            <%
                for(Cancion u:lista1){
            %>
            <tr>
                <td><%= u.getIdCancion()%> </td>
                <td><%= u.getNombre()%> </td>
                <td><%= u.getBanda()%> </td>
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
