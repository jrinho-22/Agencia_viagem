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