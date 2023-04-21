<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Portal</title>
</head>
<body>
<div class="container">
    <h2>Portal de acesso</h2>
    <h3>Coordenador</h3>
    <div class="login">
        <form action="<c:url value = "/coordenador"/>">
            <label for="name">Digite o usuario do sistema: </label>
            <input id="name" type="text" name="user-name">
            <input type="submit" value="Entrar">
        </form>
    </div>
    <h3>Aluno</h3>
    <a href="<c:url value = "/coordenador/consulta"/>">
        Aluno Clique aqui
    </a>
</div>
</body>
</html>