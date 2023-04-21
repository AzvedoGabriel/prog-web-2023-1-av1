<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coordenadores</title>
</head>
<body>
<h3>Bem vindo</h3>
<a href="<c:url value = "/coordenador/cadastro"/>">Cadastrar</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Cursos</th>
        <th>Periodos</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="coordenador" items="${coordenadores}">
        <tr>
            <td>${coordenador.id}</td>
            <td>${coordenador.nome}</td>
            <td>
                <c:forEach var="curso" items="${coordenador.cursos}">
                    ${curso}
                    <br>
                </c:forEach>
            </td>
            <th>
                <c:forEach var="periodo" items="${coordenador.horarios}">
                    ${periodo.dia}: De ${periodo.horarioInicial} ate ${periodo.horarioFinal}<br>
                </c:forEach>
            </th>
            <td>
                <a href="<c:url value = "/coordenador/cadastro?id=${coordenador.id}"/>">Editar</a>
                <br>
                <a href="<c:url value = "/coordenador/excluir?id=${coordenador.id}"/>">Excluir</a>
                <br>
                <a href="<c:url value = "/coordenador/cadastro/periodo?id=${coordenador.id}"/>">Adiciona horario</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
