package br.com.codenation;

import java.time.LocalDate;

/**
 * The type Time.
 */
public class Time {
    // * Identificador do time
    private Long id;

    // Nome do Time
    private String nome;

    // Data de criação do time
    private LocalDate dataCriacao;

    // Cor do uniforme principal do time
    private String corUniformePrincipal;

    // Cor do uniforme secundário do time
    private String corUniformeSecundario;

    private Jogador capitao;

    private Time() {
    }

    private Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
                 String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public static TimeBuilder builder() {
        return new TimeBuilder();
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return id.equals(time.id);
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
     * Gets data criacao.
     *
     * @return the data criacao
     */
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Sets data criacao.
     *
     * @param dataCriacao the data criacao
     */
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * Gets cor uniforme principal.
     *
     * @return the cor uniforme principal
     */
    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    /**
     * Sets cor uniforme principal.
     *
     * @param corUniformePrincipal the cor uniforme principal
     */
    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    /**
     * Gets cor uniforme secundario.
     *
     * @return the cor uniforme secundario
     */
    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    /**
     * Sets cor uniforme secundario.
     *
     * @param corUniformeSecundario the cor uniforme secundario
     */
    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public static class TimeBuilder {

        private Long id;
        private String nome;
        private LocalDate dataCriacao;
        private String corUniformePrincipal;
        private String corUniformeSecundario;

        public TimeBuilder() {
        }

        public TimeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TimeBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public TimeBuilder withData(LocalDate data) {
            this.dataCriacao = data;
            return this;
        }

        public TimeBuilder withCorUniformePrincipal(String cor) {
            this.corUniformePrincipal = cor;
            return this;
        }

        public TimeBuilder withCorUniformeSecundario(String cor) {
            this.corUniformeSecundario = cor;
            return this;
        }

        public Time build() {
            return new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        }

    }
}
