<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Coordenadores</title>
</head>
<body>
<h3>Bem vindo</h3>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Nome</th>
    <th>Cursos</th>
    <th>Periodos</th>
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
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
