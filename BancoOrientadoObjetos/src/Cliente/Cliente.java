package Cliente;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento; 
    private String endereco;

    protected Cliente (String nome, String cpf, String dataNascimento, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    protected String getNome(){
        return nome;
    }

    protected String getCpf(){
        return cpf;
    }

    protected String getDataNascimento(){
        return dataNascimento;
    }

    protected String getEndereco(){
        return endereco;
    }

    protected void setNome(String newNome){
        this.nome = newNome;
    }

    protected void setCpf(String newCpf){
        this.cpf = newCpf;
    }

    protected void setDataNascimento(String newDataNascimento){
        this.dataNascimento = newDataNascimento;
    }

    protected void setEndereco(String newEndereco){
        this.endereco = newEndereco;
    }
}
