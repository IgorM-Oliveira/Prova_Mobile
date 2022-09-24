package br.unigran.prova.entidades;

public class Consumo {
    private Integer id;
    private Float quiloAtual;
    private Float quantAbast;
    private String dia;
    private Float valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuiloAtual() {
        return quiloAtual;
    }

    public void setQuiloAtual(Float quiloAtual) {
        this.quiloAtual = quiloAtual;
    }

    public Float getQuantAbast() {
        return quantAbast;
    }

    public void setQuantAbast(Float quantAbast) {
        this.quantAbast = quantAbast;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String toString() {
        return (String.format("%s | %s | %s", quiloAtual, quantAbast, dia, valor));
    }
}
