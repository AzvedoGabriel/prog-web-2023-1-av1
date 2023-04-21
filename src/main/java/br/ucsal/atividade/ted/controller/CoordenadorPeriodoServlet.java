package br.ucsal.atividade.ted.controller;

import java.io.IOException;

import br.ucsal.atividade.ted.domain.Coordenador;
import br.ucsal.atividade.ted.domain.Periodo;
import br.ucsal.atividade.ted.repository.CoordenadorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coordenador/cadastro/periodo")
public class CoordenadorPeriodoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawId = request.getParameter("id");

        Coordenador coordenador = null;
        if (isEdicao(rawId)) {
            Long id = Long.parseLong(rawId);
            coordenador = CoordenadorDAO.encontrarId(id).orElseThrow();
        } 
        
        request.setAttribute("coordenador", coordenador);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastro-periodo-coordenador.jsp");
        requestDispatcher.forward(request, response);
    }

    private static boolean isEdicao(String rawId) {
        return rawId != null && !rawId.isBlank();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rawId = req.getParameter("id");
        Coordenador coordenador = null;
        
        if (isEdicao(rawId)) {
            Long id = Long.parseLong(rawId);
            coordenador = CoordenadorDAO.encontrarId(id).orElseThrow();
        } 
       
        Periodo periodo = new Periodo();
        
        String dia = req.getParameter("dia");
        String horarioInicial = req.getParameter("horarioInicial");
        String horarioFinal = req.getParameter("horarioFinal");
         periodo.setDia(dia);
         periodo.setHorarioInicial(horarioInicial);
         periodo.setHorarioFinal(horarioFinal);
       

        coordenador.getHorarios().add(periodo);
        
        req.setAttribute("coordenador", coordenador);

        resp.sendRedirect(req.getContextPath() + "/coordenador/cadastro/periodo?id="+rawId);


    }
}
