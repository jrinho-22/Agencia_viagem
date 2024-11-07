import java.util.ArrayList;

public abstract class Reserva implements Detalhes_da_viagem {
    private String nome_responsavel;
    private String email_responsavel;
    private ArrayList<Object> Lista_de_nomes_dos_passageiros;

    private int Numero_de_adultos;
    private int Numero_de_criancas;

    public Reserva(String nome_responsavel, String email_responsavel, int numero_de_adultos, int numero_de_criancas) {
        this.nome_responsavel = nome_responsavel;
        this.email_responsavel = email_responsavel;
    }
    public void Duracao(int dias) {
        System.out.println("Duracao da reserva: " + dias + " dias");
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getEmail_responsavel() {
        return email_responsavel;
    }

    public void setEmail_responsavel(String email_responsavel) {
        this.email_responsavel = email_responsavel;
    }

    @Override
    public abstract double ValorTotal();

}