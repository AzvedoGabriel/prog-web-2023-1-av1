<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Periodos</title>
</head>
<body>
<h3>Periodos</h3>

<form action="<c:url value="/coordenador/cadastro/periodo"/>" method="post">

    <div id="periodos">
        <input type="hidden" name="id" value="${coordenador.id}">
        <div class="horario-form">
            <br>
            <label>Dia</label>
            <input type="date" name="dia"/>
            <br>
            <label>Horario Inicial</label>
            <input type="time" name="horarioInicial"/>
            <br>
            <label>Horario final</label>
            <input type="time" name="horarioFinal"/>
            <br>
        </div>
        <input type="submit" value="Cadastrar">
        <a href="<c:url value="/coordenador"/>">Voltar</a>
    </div>
</form>

<label>Periodo de Disponibilidade</label>
<c:forEach var="periodo" items="${coordenador.horarios}">
    <table>
        <thead>
        <tr>
            <th>Periodo</th>
            <th>Horario Inicial</th>
            <th>Horario Final</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${periodo.dia}</td>
            <td>${periodo.horarioInicial}</td>
            <td>${periodo.horarioFinal}</td>
        </tr>
        </tbody>
    </table>
</c:forEach>
</body>
</html>