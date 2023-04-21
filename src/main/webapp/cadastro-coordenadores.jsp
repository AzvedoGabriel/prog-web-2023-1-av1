<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Coordenadores</title>
</head>
<body>
<form id="coordenadoresForm"
      action="<c:url value = "/coordenador/cadastro"/>" method="post">
    <h1>Coordenador</h1>
    <input type="hidden" name="id" value="${coordenador.id}"> <labelfor="name">Nome </label>
    <input id="name" type="text" name="nome"value="${coordenador.nome}"> <br> <label for="cursos">Cursos</label>
    <textarea id="cursos" name="cursos" rows="4" cols="20">${coordenador.cursosComoTexto}</textarea>
    <input type="submit" value="Cadastrar">
</form>
</body>
</html>
