package br.com.codenation;

import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TimeStatisticas {

    private final TimeRepository timeRepository;
    private final JogadorRepository jogadorRepository;

    public TimeStatisticas(TimeRepository timeRepository, JogadorRepository jogadorRepository) {
        this.timeRepository = timeRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public List<Long> buscarTopJogadores(Integer top) {
        return jogadorRepository.todos.values()
                .stream()
                .sorted(comparing(Jogador::getNivelHabilidade).reversed())
                .limit(top)
                .map(Jogador::getId)
                .collect(Collectors.toList());

    }

    public Long buscarJogadorMaisVelho(Long idTime) {
        if (!timeRepository.existe(idTime)) throw new TimeNaoEncontradoException();

        return jogadorRepository.todos.values().stream()
                .filter(o -> o.getIdTime() == idTime)
                .sorted(comparing(Jogador::getDataNascimento))
                .map(Jogador::getId).findFirst().get();
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        if (!timeRepository.existe(idTime)) throw new TimeNaoEncontradoException();

        return jogadorRepository.todos.values().stream()
                .filter(o -> o.getIdTime() == idTime)
                .sorted(comparing(Jogador::getSalario).reversed())
                .map(Jogador::getId).findFirst().get();
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        if (!timeRepository.existe(idTime)) throw new TimeNaoEncontradoException();

        return jogadorRepository.todos.values().stream()
                .filter(o -> o.getIdTime() == idTime)
                .sorted(comparing(Jogador::getNivelHabilidade).reversed())
                .map(Jogador::getId).findFirst().get();
    }
}
