package br.ucsal.atividade.ted.controller;

import br.ucsal.atividade.ted.domain.Coordenador;
import br.ucsal.atividade.ted.repository.CoordenadorDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;


@WebServlet("/coordenador/cadastro")
public class CoordenadorCadastroServlet extends HttpServlet {

    private static final long serialVersionUID = -1281317447121111145L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawId = request.getParameter("id");

        Coordenador coordenador = null;
        if (isEdicao(rawId)) {
            Long id = Long.parseLong(rawId);
            coordenador = CoordenadorDAO.encontrarId(id).orElseThrow();
        } else {
            coordenador = new Coordenador();
        }

        request.setAttribute("coordenador", coordenador);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastro-coordenadores.jsp");
        requestDispatcher.forward(request, response);
    }

    private static boolean isEdicao(String rawId) {
        return rawId != null && !rawId.isBlank();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String rawCursos = req.getParameter("cursos");
        String[] cursos = rawCursos.split("\n");
        
        Coordenador coordenador = new Coordenador();
        
        coordenador.setNome(nome);
        coordenador.setCursos(Arrays.asList(cursos));
        CoordenadorDAO.incluir(coordenador);

        resp.sendRedirect(req.getContextPath() + "/coordenador");


    }
}
