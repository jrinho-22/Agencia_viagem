public class Pagamento {
    private double valor_total;
    private String nome_da_bandeira_do_cartao;
    private double numeros_parcelas;
    private String numero_do_cartao;
    private double valor_de_cada_parcela;

    public Pagamento(double valor_total, String nome_da_bandeira_do_cartao, double numeros_parcelas, String numero_do_cartao) {
    
        this.valor_total = valor_total;
        this.nome_da_bandeira_do_cartao = nome_da_bandeira_do_cartao;
        this.numeros_parcelas = numeros_parcelas;
        this.numero_do_cartao = numero_do_cartao;

    }

    public double getValor_total() {
        return valor_total;
    }

    public double getValor_de_cada_parcela() {
        return valor_de_cada_parcela;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public String getMetodo_de_pagamento() {
        return nome_da_bandeira_do_cartao;
    }

    public void setMetodo_de_pagamento(String metodo_de_pagamento) {
        this.nome_da_bandeira_do_cartao = metodo_de_pagamento;
    }

    public double getNumeros_parcelas() {
        return numeros_parcelas;
    }

    public void setNumeros_parcelas(int numeros_parcelas) {
        this.numeros_parcelas = numeros_parcelas;
    }

    public String getNumero_do_cartao() {
        return numero_do_cartao;
    }

    public void setNumero_do_cartao(String numero_do_cartao) {
        this.numero_do_cartao = numero_do_cartao;
    }

    public void Pagamento_sem_parcelas() {
        System.out.println("O valor total:"+valor_total);
    }
    public void Pagamento_com_parcelas() {
        this.valor_de_cada_parcela = valor_total / numeros_parcelas;
        System.out.println("O valor total:"+valor_total);
        System.out.println("O valor de cada parcela é de:"+valor_de_cada_parcela);
        System.out.println("A viagem será em quantidade de vezes:"+numeros_parcelas);
    }


}