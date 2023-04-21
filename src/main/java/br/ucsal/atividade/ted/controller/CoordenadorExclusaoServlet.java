package br.ucsal.atividade.ted.controller;

import br.ucsal.atividade.ted.repository.CoordenadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/coordenador/excluir")
public class CoordenadorExclusaoServlet extends HttpServlet {

    private static final long serialVersionUID = 4410569567970281179L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rawId = req.getParameter("id");
        Long id = Long.parseLong(rawId);

        CoordenadorDAO.remover(id);

        resp.sendRedirect(req.getContextPath() + "/coordenador");

    }
}
