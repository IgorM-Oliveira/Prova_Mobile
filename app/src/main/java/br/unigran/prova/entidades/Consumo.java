package br.unigran.prova.entidades;

public class Consumo {
    private Integer id;
    private String quiloAtual;
    private String quantAbast;
    private String dia;
    private String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuiloAtual() {
        return quiloAtual;
    }

    public void setQuiloAtual(String quiloAtual) {
        this.quiloAtual = quiloAtual;
    }

    public String getQuantAbast() {
        return quantAbast;
    }

    public void setQuantAbast(String quantAbast) {
        this.quantAbast = quantAbast;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String toString() {
        return (String.format("%s | %s | %s", quiloAtual, quantAbast, dia, valor));
    }
}
