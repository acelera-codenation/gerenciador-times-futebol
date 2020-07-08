package br.com.codenation;

import br.com.codenation.exceptions.JogadorNaoEncontradoException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JogadorRepository {

    public final Map<Long, Jogador> todos = new HashMap<>();

    public String buscarNomeJogador(Long idJogador) {
        if (!existe(idJogador)) throw new JogadorNaoEncontradoException();

        return todos.get(idJogador).getNome();
    }

    public Boolean existe(Long idJogador) {
        return todos.containsKey(idJogador);
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        return todos.values()
                .stream()
                .filter(jogador -> jogador.getIdTime() == idTime)
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        if (!existe(idJogador)) throw new JogadorNaoEncontradoException();
        return todos.get(idJogador).getSalario();
    }

}
