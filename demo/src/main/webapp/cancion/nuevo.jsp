<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nueva Favorita</title>
</head>
<body>
<div class="container">
    <h1 class='mb-3'>Añadir Nueva Cancion Favorita</h1>
    <form method="POST" action="<%=request.getContextPath()%>/CancionFavoritaServlet">
        <div class="mb-3">
            <label for="cancionId">ID CANCION</label>
            <input type="text" class="form-control" name="cancionId" id="cancionId">
        </div>
        <div class="mb-3">
            <label for="nombre">NOMBRE</label>
            <input type="text" class="form-control" name="nombre" id="nombre">
        </div>
        <div class="mb-3">
            <label for="banda">BANDA</label>
            <input type="text" class="form-control" name="banda" id="banda">
        </div>
        <div hidden class="mb-3">
            <label for="estado">ESTADO</label>
            <input type="text" class="form-control" name="estado" id="estado">
        </div>
        <a class="btn btn-danger" href="<%=request.getContextPath()%>/CancionFavoritaServlet">Cancelar</a>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>

</body>
</html>
