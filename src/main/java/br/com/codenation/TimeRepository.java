package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeRepository {

    public final Map<Long, Time> todos = new HashMap<>();

    public Boolean existe(Long idTime) {
        return todos.containsKey(idTime);
    }

    public void inserir(Time time) {
        todos.put(time.getId(), time);
    }

    public String buscarNomeTime(Long idTime) {
        if (!existe(idTime)) throw new TimeNaoEncontradoException();

        return todos.get(idTime).getNome();
    }

    public List<Long> buscarTimes() {
        return todos.keySet()
                .stream()
                .collect(Collectors.toList());
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        if (!existe(idTime)) throw new TimeNaoEncontradoException();

        if (todos.get(idTime).getCapitao() == null)
            throw new CapitaoNaoInformadoException();

        return todos.get(idTime).getCapitao().getId();
    }

    public void definirCapitao(Jogador jogador) {
        todos.get(jogador.getIdTime())
                .setCapitao(jogador);
    }
}
