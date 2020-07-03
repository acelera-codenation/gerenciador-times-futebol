package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Jogador.
 */
public class Jogador {
    // Identificador do Jogador
    private Long id;
    // Identificador do time
    private Long idTime;

    // Nome do Jogador
    private String nome;

    // Data de nascimento do Jogador
    private LocalDate dataNascimento;

    // Nível de habilidade do jogador (0 a 100)
    private Integer nivelHabilidade;

    // Salário do jogador
    private BigDecimal salario;

    /**
     * Instantiates a new Jogador.
     *
     * @param id              the id
     * @param idTime          the id time
     * @param nome            the nome
     * @param dataNascimento  the data nascimento
     * @param nivelHabilidade the nivel habilidade
     * @param salario         the salario
     */
    private Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
                    BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    /**
     * Instantiates a new Jogador.
     */
    private Jogador() {
    }

    public static JogadorBuilder builder() {
        return new JogadorBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        return id.equals(jogador.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets id time.
     *
     * @return the id time
     */
    public Long getIdTime() {
        return idTime;
    }

    /**
     * Sets id time.
     *
     * @param idTime the id time
     */
    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets data nascimento.
     *
     * @return the data nascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets data nascimento.
     *
     * @param dataNascimento the data nascimento
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Gets nivel habilidade.
     *
     * @return the nivel habilidade
     */
    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    /**
     * Sets nivel habilidade.
     *
     * @param nivelHabilidade the nivel habilidade
     */
    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    /**
     * Gets salario.
     *
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * Sets salario.
     *
     * @param salario the salario
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public static class JogadorBuilder {
        private Long id;
        private Long idTime;
        private String nome;
        private LocalDate dataNascimento;
        private Integer nivelHabilidade;
        private BigDecimal salario;

        public JogadorBuilder() {
        }

        public JogadorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public JogadorBuilder withIdTime(Long idTime) {
            this.idTime = idTime;
            return this;
        }

        public JogadorBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public JogadorBuilder withDataNascimento(LocalDate data) {
            this.dataNascimento = data;
            return this;
        }

        public JogadorBuilder withNivelHabilidade(Integer nivel) {
            this.nivelHabilidade = nivel;
            return this;
        }

        public JogadorBuilder withSalario(BigDecimal salario) {
            this.salario = salario;
            return this;
        }

        public Jogador build() {
            return new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        }

    }
}
