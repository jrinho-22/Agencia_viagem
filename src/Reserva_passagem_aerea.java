import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva_passagem_aerea extends Reserva {
    private int numero_voo;
    private String classe;
    private int numero_assento;
    private String companhia;
    private String aeroporto_embarque;
    private LocalDate data_de_embarque;
    private LocalDate data_de_embarque_volta;
    private IPassagemAerea PassagemAerea;

    public Reserva_passagem_aerea(IPassagemAerea PassagemAerea, String nome_responsavel, String email_responsavel, int numero_voo, String classe, int numero_assento, String companhia, String aeroporto_embarque, String aeroporto_desembarque, int duracao_voo_ida, int duracao_voo_volta, String local_desembarque, String local_embarque, LocalDate data_de_embarque, LocalDate data_de_embarque_volta) {
        super(nome_responsavel, email_responsavel);
        this.numero_voo = numero_voo;
        this.classe = classe;
        this.numero_assento = numero_assento;
        this.companhia = companhia;
        this.aeroporto_embarque = aeroporto_embarque;
        this.data_de_embarque = data_de_embarque;
        this.data_de_embarque_volta = data_de_embarque_volta;
    }

    @Override
    public double ValorTotal() {
        double total_valor = this.PassagemAerea.getValor_ticket_adulto()
        System.out.println("O valor total dos tickets: R$" + total_valor );
        return total_valor;
    }

    public void Horariocomescala() {
        this.PassagemAerea.Horariocomescala()
    }

    public void Adiciona_escala(String local_e_data_da_escala){
        escala.add(local_e_data_da_escala);
    }

    public int getNumero_voo() {
        return numero_voo;
    }

    public void setNumero_voo(int numero_voo) {
        this.numero_voo = numero_voo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNumero_assento() {
        return numero_assento;
    }

    public void setNumero_assento(int numero_assento) {
        this.numero_assento = numero_assento;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getAeroporto_embarque() {
        return aeroporto_embarque;
    }

    public void setAeroporto_embarque(String aeroporto_embarque) {
        this.aeroporto_embarque = aeroporto_embarque;
    }

    public void setValor_ticket_adulto(int valor_ticket_adulto) {
        this.valor_ticket_adulto = valor_ticket_adulto;
    }

    public void Adiciona_escala(String local_e_data_da_escala){
        escala.add(local_e_data_da_escala);
    }

    public LocalDate getData_de_embarque() {
        return data_de_embarque;
    }

    public void setData_de_embarque(LocalDate data_de_embarque) {
        this.data_de_embarque = data_de_embarque;
    }

    public LocalDate getData_de_embarque_volta() {
        return data_de_embarque_volta;
    }

    public void setData_de_desembarque(LocalDate data_de_embarque_volta) {
        this.data_de_embarque_volta = data_de_embarque_volta;
    }


}