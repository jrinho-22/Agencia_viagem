Pontos de melhorias:

1 - Deve existir apenas uma instância da classe AgenciaViagem. Entretanto, na implementação atual, muitas instâncias dessa classe são permitidas. A solução seria transformar essa classe em um Singleton, que fará com que apenas uma instância de AgenciaViagem seja permitida por toda a aplicação.

Implementação atual:

AgenciaViagem.java

    public class AgenciaViagem {
        private String nome;
        private String enderenco;
        private String CEP;
        private String CNPJ;
        private String telefone;
        private String email;
        private String website;
        private String horario_funcionamento;
        private int numero_funcionarios;


    public AgenciaViagem(String nome, String enderenco, String CEP, String CNPJ, String telefone, String email, String website, String horario_funcionamento) {
        this.nome = nome;
        this.enderenco = enderenco;
        this.CEP = CEP;
        this.CNPJ = CNPJ;
        this.telefone = telefone;
        this.email = email;
        this.website = website;
        this.horario_funcionamento = horario_funcionamento;
    }

Solução:

    AgenciaViagem.java
        public class AgenciaViagem {
            private static AgenciaViagem instance;
            ...
        
        
            public static AgenciaViagem getInstance(String nome, String endereco, String CEP, String CNPJ, String telefone, String email, String website, String horario_funcionamento) {
                if (this.instance == null) {
                    this.instance = new AgenciaViagem(nome, endereco, CEP, CNPJ, telefone, email, website, horario_funcionamento);
                }
                return this.instance;
            }

    App.java
    
        AgenciaViagem agencia = AgenciaViagem.getInstance("nomeAgencia", "Rua Kennedy 232", "8105240", "40.224.145/0001-90", "41 9131-2245", "AgenciaViagem@gmail.com", 
        "AgenciaViagem.com.br", "8:00-5:30");
    

2 - Na atual implementação,  a classe Reserva_passagem_aerea, possui dois métodos(getValor_ticket_adulto e Horariocomescala) que o resultado varia caso a passagem seja de ida ou de volta. O padrão de projeto bridge poderia se encaixar nesse cenário criando abstratas e implementação:

Implementação atual:

    public class Reserva_passagem_aerea extends Reserva {
        private String tipo;
        private int limite_escala_id = 3
        ...
    
Métodos que dependem das propriedades “adulto” e “tipo” para definir seus valores:

    public double ValorTotal() {
            double total_valor = getValor_ticket_adulto()
            System.out.println("O valor total dos tickets: R$" + total_valor );
            return total_valor;
        }


    public double getValor_ticket_adulto() {
        if (!adulto) {
            if (tipo == "ida"){
                return valor_ticket_adulto * .80;
            } else {
                return valor_ticket_adulto * .90;
            }
        } else {
            if (tipo == "ida"){
                return valor_ticket_adulto * .90;
            } else {
                return valor_ticket_adulto;
            }
        }
    }


    public void Horariocomescala() {
        int escalas = 0
        if (tipo == "ida"){
            if(this.escala.size() > limite_escala_ida){
                escalas = limite_escala_ida
            } else {
                escalas = this.escala.size()
            }
        } else {
            escalas = this.escala.size()
        }
        for (int i = 0; i < escalas; i++) {
            String Escala = this.escala.get(i);
            String[] partes = Escala.split(" - ");
            if (partes.length == 2) {
                String horario = partes[0];
                String aeroporto = partes[1];
                System.out.println("No Horário: " + horario + " será realizado uma escala no Aeroporto: " + aeroporto);
            }
        }
    }

    reserva_passagem_aerea_ida = new Reserva_passagem_aerea("ida", escala, cliente.getNome(), cliente.getEmail(),...)                        
    reserva_passagem_aerea_volta = new Reserva_passagem_aerea("volta", escala, cliente.getNome(), cliente.getEmail(), ...)                        

Solução: Criar duas classes que implementam a interface IPassagemAerea, dessa maneira separando abstração e implementação

    public interface IPassagemAerea {
        void Horariocomescala()
        double getValor_ticket_adulto()
    }

Reserva_passagem_aerea.java

    public class Reserva_passagem_aerea extends Reserva {
        private IPassagemAerea PassagemAerea;
        ...
    
    
        public Reserva_passagem_aerea(IPassagemAerea PassagemAerea, ...{
        ...
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
    

Passagem_aerea_ida.java

    public class Passagem_aerea_ida implements IPassagemAerea {
    
    
        private String limite_escala_ida = 3
        private ArrayList<String> escala;
        private int valor_ticket_adulto;
        private boolean adulto;
    
    
        public Reserva_passagem_aerea_ida(ArrayList<String> escala, int valor_ticket_adulto, boolean adulto) {
            this.escala = escala;
        }
    
    
        public double getValor_ticket_adulto() {
            if (!adulto) {
                return valor_ticket_adulto * .80;
            } else {
                return valor_ticket_adulto * .90;
            }
        }
    
    
        public void Horariocomescala() {
            int escalas = 0
            if(this.escala.size() > limite_escala_ida){
                escalas = limite_escala_ida
            } else {
                escalas = this.escala.size()
            }
            for (int i = 0; i < escalas; i++) {
                String Escala = this.escala.get(i);
                String[] partes = Escala.split(" - ");
                if (partes.length == 2) {
                    String horario = partes[0];
                    String aeroporto = partes[1];
                    System.out.println("No Horário: " + horario + " será realizado uma escala no Aeroporto: " + aeroporto);
                }
            }
        }
    }

A classe Passagem_aerea_volta segue o mesmo padrão.

3 - Muitas classes possuem muitos parâmetros necessários para formar seus objetos, um builder poderia ser uma boa opção para deixar o código mais limpo. 

Atual implementação: 

    public class ReservaHospedagem extends Reserva{
    
    
        private String telefone_contato_hospede_responsavel;
        private int precoDiaria;
        private int numQuarto;
        private String endereco;
        private String nome_do_estabelecimento_da_hospedagem;
        private String cidade;
        private String pais;
        private int Numero_de_adultos;
        private int Numero_de_criancas;
        private LocalDate checkin;
        private LocalDate checkout;
    
    
        public ReservaHospedagem(String nome_responsavel, String email_responsavel, int numero_de_adultos, int numero_de_criancas,String telefone_contato_hospede_responsavel, int     
        precoDiaria, int numQuarto, String endereco, String nome_do_estabelecimento_da_hospedagem, String cidade, String pais, LocalDate checkin, LocalDate checkout) {
            super(nome_responsavel, email_responsavel);
            this.telefone_contato_hospede_responsavel = telefone_contato_hospede_responsavel;
            this.precoDiaria = precoDiaria;
            this.numQuarto = numQuarto;
            this.endereco = endereco;
            this.nome_do_estabelecimento_da_hospedagem = nome_do_estabelecimento_da_hospedagem;
            this.cidade = cidade;
            this.pais = pais;
            this.checkin = checkin;
            this.checkout = checkout;
            this.Numero_de_adultos = numero_de_adultos;
            this.Numero_de_criancas = numero_de_criancas;
    
    
        }
    

Solução: O builder passaria esses argumentos de forma dinâmica. Isso permitirá com que argumentos obrigatórios e opcionais sejam separados


    public class ReservaHospedagemBuilder {
        private String nomeResponsavel;
        private String emailResponsavel;
        private int numeroDeAdultos;
        ...
    
    
        public ReservaHospedagemBuilder(String nomeResponsavel, String emailResponsavel, int numeroDeAdultos, int numeroDeCriancas) {
            this.nomeResponsavel = nomeResponsavel;
            this.emailResponsavel = emailResponsavel;
            this.numeroDeAdultos = numeroDeAdultos;
            this.numeroDeCriancas = numeroDeCriancas;
        }
    
    
        public ReservaHospedagemBuilder setPrecoDiaria(int precoDiaria) {
            this.precoDiaria = precoDiaria;
            return this;
        }
    
    
        public ReservaHospedagemBuilder setEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }
    
    
        ...
    

Utilização da classe:

    ReservaHospedagemBuilder builder = new ReservaHospedagemBuilder("John Doe", "john.doe@example.com", 2, 2);
    ReservaHospedagem reservaHospedagem = builder
    .setTelefoneContatoHospedeResponsavel("123456789")
    .setPrecoDiaria(200)
    .setNumQuarto(101)
    .setEndereco("Avenida Manoel Ribas, 123")
    .setNomeEstabelecimento("Ibis Hotel")
    .setCidade("Curitiba")
    .setPais("Brasil")



4 - O padrão de projeto build também pode ser utilizado na classe Cliente, onde nem todos os campos são obrigatórios. 

Atual: 
    
    public class  Cliente  {
        private String nome;
        private String CPF;
        private String enderenco;
        private String pais_nascimento;
        private String genero;
        private String email;
        private String telefone;
        private String cidade;
        private String estado;
        private String pais;
    
    
        public Cliente(String nome,String CPF, String enderenco, String pais_nascimento, String genero, String email, String telefone, String cidade, String estado,String pais) {
            this.nome = nome;
            this.CPF = CPF;
            this.enderenco = enderenco;
            this.pais_nascimento = pais_nascimento;
            this.genero = genero;
            this.email = email;
            this.telefone = telefone;
            this.cidade = cidade;
            this.estado = estado;
            this.pais=pais;
        }
    
    
        public String getNome() {
            return nome;
        }
    
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
    
        public String getCPF() {
            return CPF;
        }
    
    
        public void setCPF(String CPF) {
            this.CPF = CPF;
        }
    
    
        public String getEnderenco() {
            return enderenco;
        }
    
    
        public void setEnderenco(String enderenco) {
            this.enderenco = enderenco;
        }
    
    
        public String getPais_nascimento() {
            return pais_nascimento;
        }
    
    
        public void setPais_nascimento(String pais_nascimento) {
            this.pais_nascimento = pais_nascimento;
        }
    
    
        public String getGenero() {
            return genero;
        }
    
    
        public void setGenero(String genero) {
            this.genero = genero;
        }
    
    
        public String getEmail() {
            return email;
        }
    
    
        public void setEmail(String email) {
            this.email = email;
        }
    
    
        public String getTelefone() {
            return telefone;
        }
    
    
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    
    
        public String getCidade() {
            return cidade;
        }
    
    
        public void setCidade(String cidade) {
            this.cidade = cidade;
        }
    
    
        public String getEstado() {
            return estado;
        }
    
    
        public void setEstado(String estado) {
            this.estado = estado;
        }
         public String getPais() {
            return pais;
        }
    
    
        public void setPais(String pais) {
            this.pais = pais;
        }
    }

modificação 
    
    public class ClienteBuilder {
        private String nome;
        private String CPF;
        
        ...
    
    
        public ClienteBuilder(String nome, String CPF, String enderenco, String email) {
            this.nome = nome;
            this.CPF = CPF;
            this.enderenco = enderenco;
            this.email = email;
        }
    
    
        }
    
    
        public ClienteBuilder setEnderenco(String enderenco) {
            this.enderenco = enderenco;
            return this;
        }
    
    
        public ClienteBuilder setPaisNascimento(String pais_nascimento) {
            this.pais_nascimento = pais_nascimento;
            return this;
        }
    
    
        public ClienteBuilder setGenero(String genero) {
            this.genero = genero;
            return this;
        }
        ...
    }
    


5 - A classe Checar data é usada para checar se uma data é válida ou não, caso não seja ela retorna uma mensagem de erro na aplicação, como não há necessidade de existirem outras instâncias dessa mesma classe, ela também pode ser tornar um singleton.

atual : 

    public class ChecarData {
        static void checkDate (LocalDate date) throws DataInvalida  
        {      
            LocalDate today = LocalDate.now();
            boolean isAfter = today.isAfter(date);
            if(isAfter){    
                throw new DataInvalida("Data invalida, selecione datas futuras");  
            }      
        }  
    }

Modificaçao:

    import java.time.LocalDate;
    
    
    public class ChecarData {
    
    
        private static ChecarData instance;
    
    
        private ChecarData() {
        }
    
    
        public static ChecarData getInstance() {
            if (instance == null) {
                instance = new ChecarData();
            }
            return instance;
        }
    
    
        public void checkDate(LocalDate date) throws DataInvalida {
            LocalDate today = LocalDate.now();
            if (today.isAfter(date)) {
                throw new DataInvalida("Data invalida, selecione datas futuras");
            }
        }
    }
    
    
    
    
    
    
