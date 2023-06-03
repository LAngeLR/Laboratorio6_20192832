<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.models.beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Cancion> lista2 = (ArrayList<Cancion>) request.getAttribute("lista2");%>

<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista De Canciones General"/>
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
      </tr>
      </thead>
      <tbody>
      <%
        for(Cancion p:lista2){
      %>
      <tr>
        <td><%= p.getIdCancion()%> </td>
        <td><%= p.getNombre()%> </td>
        <td><%= p.getBanda()%> </td>
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
