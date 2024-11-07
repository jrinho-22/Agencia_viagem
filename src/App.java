import javax.swing.JFrame;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) throws Exception {
        AgenciaViagem agenciaViagem1 = new AgenciaViagem("nomeAgencia", "Rua Kennedy 232", "8105240", "40.224.145/0001-90", "41 9131-2245", "AgenciaViagem@gmail.com", "AgenciaViagem.com.br", "8:00-5:30");
        System.out.println("Nome da Agência de Viagem:"+agenciaViagem1.getNome());
        System.out.println("Enderenço da Agência de Viagem:"+agenciaViagem1.getEnderenco());
        System.out.println("CEP da Agência de Viagem:"+agenciaViagem1.getCEP());
        System.out.println("CNPJ da Agência de Viagem:"+agenciaViagem1.getCNPJ());
        System.out.println("Telefone da Agência de Viagem:"+agenciaViagem1.getTelefone());
        System.out.println("Email da Agência de Viagem:"+agenciaViagem1.getEmail());
        System.out.println("Website da Agência de Viagem:"+agenciaViagem1.getWebsite());
        System.out.println("Horário de Funcionamento da Agencia de Viagem:"+agenciaViagem1.getHorario_funcionamento());
        System.out.println("");
        
        JFrame janela = new JFrame();
        Tela tela = new Tela();

        janela.add(tela);

        janela.setBounds(300,300,700,800);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setVisible(true);
        LocalDate dataCheckIn = LocalDate.of(2023, 8, 23);
        LocalDate dataCheckOut = LocalDate.of(2023, 8, 25);
        ReservaHospedagem reservaHospedagem =new ReservaHospedagem("Micael","micaelfone0@gmail.com",2,4,0,"413040-3920",2050,333,"Avenida das Nações","Hilton Lisboa","Lisboa","Portugal",dataCheckIn,dataCheckIn);
        System.out.println("O Nome do responsavél pela reserva da Hospedagem:"+reservaHospedagem.getNome_responsavel());
        System.out.println("O email do responsavél pela reserva da Hospedagem:"+reservaHospedagem.getEmail_responsavel());
        System.out.println("Numero do quarto:"+reservaHospedagem.getNumQuarto());
        System.out.println("O número de adultos:"+reservaHospedagem.getNumero_de_adultos());
        System.out.println("O número de crianças:"+reservaHospedagem.getNumero_de_criancas());
        System.out.println("O valor da diária:"+reservaHospedagem.getPrecoDiaria());
        System.out.println("Telefone da hospede:"+reservaHospedagem.getTelefone_contato_hospede_responsavel());
        System.out.println("Enderenço da hospede:"+reservaHospedagem.getEndereco());
        System.out.println("Nome do estabelecimento:"+reservaHospedagem.getNome_do_estabelecimento_da_hospedagem());
        System.out.println("Cidade do estabelecimento:"+reservaHospedagem.getCidade());
        System.out.println("Pais do estabelecimento:"+reservaHospedagem.getPais());
        System.out.println("Data do check-in:"+reservaHospedagem.getCheckin());
        System.out.println("Data do check-out:"+reservaHospedagem.getCheckout());





    }
}
