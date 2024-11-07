import java.time.LocalDate;
import java.time.Duration;

public class ReservaHospedagem extends Reserva{

    private String telefone_contato_hospede_responsavel;
    private int precoDiaria;
    private int numQuarto;
    private String endereco;
    private String nome_do_estabelecimento_da_hospedagem;
    private String cidade;
    private String pais;

    private LocalDate checkin;
    private LocalDate checkout;

    public ReservaHospedagem(String nome_responsavel, String email_responsavel, int numero_de_adultos, int numero_de_criancas,String telefone_contato_hospede_responsavel, int precoDiaria, int numQuarto, String endereco, String nome_do_estabelecimento_da_hospedagem, String cidade, String pais, LocalDate checkin, LocalDate checkout) {
        super(nome_responsavel, email_responsavel, numero_de_adultos, numero_de_criancas);
        this.telefone_contato_hospede_responsavel = telefone_contato_hospede_responsavel;
        this.precoDiaria = precoDiaria;
        this.numQuarto = numQuarto;
        this.endereco = endereco;
        this.nome_do_estabelecimento_da_hospedagem = nome_do_estabelecimento_da_hospedagem;
        this.cidade = cidade;
        this.pais = pais;
        this.checkin = checkin;
        this.checkout = checkout;

    }

    public int quantidadeHospedes() {
        return getNumero_de_adultos() + getNumero_de_criancas();
    }

    @Override
    public double ValorTotal() {
        int calculo_inicial = (getNumero_de_adultos() + getNumero_de_criancas()) * getPrecoDiaria();
        int calculo_final = calculo_inicial * Duracao();
        return calculo_final;
    }
    
    public int Duracao(){
        int duration = (int) Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
        return duration;
    }

    public String getTelefone_contato_hospede_responsavel() {
        return telefone_contato_hospede_responsavel;
    }

    public void setTelefone_contato_hospede_responsavel(String telefone_contato_hospede_responsavel) {
        this.telefone_contato_hospede_responsavel = telefone_contato_hospede_responsavel;
    }

    public int getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(int precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome_do_estabelecimento_da_hospedagem() {
        return nome_do_estabelecimento_da_hospedagem;
    }

    public void setNome_do_estabelecimento_da_hospedagem(String nome_do_estabelecimento_da_hospedagem) {
        this.nome_do_estabelecimento_da_hospedagem = nome_do_estabelecimento_da_hospedagem;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

}
