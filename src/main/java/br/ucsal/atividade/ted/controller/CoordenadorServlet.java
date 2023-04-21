package br.ucsal.atividade.ted.controller;


import br.ucsal.atividade.ted.repository.CoordenadorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/coordenador")
public class CoordenadorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        var coordenadores = CoordenadorDAO.listarCoordenador();
        request.setAttribute("coordenadores",coordenadores);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/lista-coordenadores.jsp");
        requestDispatcher.forward(request, response);
    }
}
