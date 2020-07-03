package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private final TimeRepository timeRepository = new TimeRepository();
    private final JogadorRepository jogadorRepository = new JogadorRepository();
    private final TimeStatisticas estatisticas;

    public DesafioMeuTimeApplication() {
        this.estatisticas = new TimeStatisticas(timeRepository, jogadorRepository);
    }

    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        if (timeRepository.existe(id)) throw new IdentificadorUtilizadoException();
        timeRepository.inserir(
                Time.builder()
                        .withId(id)
                        .withNome(nome)
                        .withData(dataCriacao)
                        .withCorUniformePrincipal(corUniformePrincipal)
                        .withCorUniformeSecundario(corUniformeSecundario).build()
        );
    }

    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        if (!timeRepository.existe(idTime)) throw new TimeNaoEncontradoException();
        if (jogadorRepository.existe(id)) throw new IdentificadorUtilizadoException();

        jogadorRepository.todos.put(id,
                Jogador.builder()
                        .withId(id)
                        .withIdTime(idTime)
                        .withNome(nome)
                        .withDataNascimento(dataNascimento)
                        .withNivelHabilidade(nivelHabilidade)
                        .withSalario(salario)
                        .build()
        );
    }

    public void definirCapitao(Long idJogador) {
        if (!jogadorRepository.existe(idJogador)) throw new JogadorNaoEncontradoException();

        Jogador jogador = jogadorRepository.todos.get(idJogador);

        timeRepository.definirCapitao(jogador);
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        return timeRepository.buscarCapitaoDoTime(idTime);
    }

    public String buscarNomeJogador(Long idJogador) {
        return jogadorRepository.buscarNomeJogador(idJogador);
    }

    public String buscarNomeTime(Long idTime) {
        return timeRepository.buscarNomeTime(idTime);
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        if (!timeRepository.existe(idTime)) throw new TimeNaoEncontradoException();

        return jogadorRepository.buscarJogadoresDoTime(idTime);
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        return estatisticas.buscarMelhorJogadorDoTime(idTime);
    }

    public Long buscarJogadorMaisVelho(Long idTime) {
        return estatisticas.buscarJogadorMaisVelho(idTime);
    }

    public List<Long> buscarTimes() {
        return timeRepository.buscarTimes();
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        return estatisticas.buscarJogadorMaiorSalario(idTime);
    }

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        return jogadorRepository.buscarSalarioDoJogador(idJogador);
    }

    public List<Long> buscarTopJogadores(Integer top) {
        return estatisticas.buscarTopJogadores(top);
    }
}
