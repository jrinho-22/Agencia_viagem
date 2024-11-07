public class AgenciaViagem {
    private static AgenciaViagem instance;
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

    public static AgenciaViagem getInstance(String nome, String endereco, String CEP, String CNPJ, String telefone, String email, String website, String horario_funcionamento) {
        if (this.instance == null) {
            this.instance = new AgenciaViagem(nome, endereco, CEP, CNPJ, telefone, email, website, horario_funcionamento);
        }
        return this.instance;
    }
    

    public String getNome() {
        return this.nome;
    }

    public String getEnderenco() {
        return this.enderenco;
    }

    public void setEnderenco(String enderenco) {
        this.enderenco = enderenco;
    }

    public String getCEP() {
        return this.CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getHorario_funcionamento() {
        return this.horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public int getNumero_funcionarios() {
        return this.numero_funcionarios;
    }

    public void setNumero_funcionarios(int numero_funcionarios) {
        this.numero_funcionarios = numero_funcionarios;
    }
    
}