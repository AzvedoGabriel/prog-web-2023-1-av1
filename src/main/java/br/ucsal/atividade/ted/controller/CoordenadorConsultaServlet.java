package br.ucsal.atividade.ted.controller;

import br.ucsal.atividade.ted.repository.CoordenadorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/coordenador/consulta")
public class CoordenadorConsultaServlet extends HttpServlet {

    private static final long serialVersionUID = 347475018398305791L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var coordenadores = CoordenadorDAO.listarCoordenador();
        request.setAttribute("coordenadores",coordenadores);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/lista-coordenadores-consulta.jsp");
        requestDispatcher.forward(request, response);
    }
}
