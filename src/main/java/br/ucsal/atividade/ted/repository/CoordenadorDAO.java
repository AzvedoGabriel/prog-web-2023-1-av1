package br.ucsal.atividade.ted.repository;

import br.ucsal.atividade.ted.domain.Coordenador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoordenadorDAO {

    private static final List<Coordenador> coordenadores = new ArrayList<>();

    private static long sequence;
    
    
    public static void incluir(Coordenador coordenador) {
        sequence++;
        coordenador.setId(sequence);
        coordenadores.add(coordenador);

    }

    public static List<Coordenador> listarCoordenador() {
        return coordenadores;
    }

    public static Optional<Coordenador> encontrarId(Long id) {
       return coordenadores.stream()
               .filter(coordenador -> coordenador.getId().equals(id))
               .findFirst();
    }

    public static void editar(Long id, Coordenador coordenador){
        Coordenador encontrado = encontrarId(id).orElseThrow();

        encontrado.setNome(coordenador.getNome());

        encontrado.setCursos(coordenador.getCursos());

        encontrado.setHorarios(coordenador.getHorarios());
    }

    public static void remover(Long id) {
        Coordenador remover = encontrarId(id).orElseThrow();

        coordenadores.remove(remover);
    }

}
