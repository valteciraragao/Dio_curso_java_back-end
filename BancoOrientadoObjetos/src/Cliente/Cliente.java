package Cliente;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento; 
    private String endereco;

    public Cliente (String nome, String cpf, LocalDate dataNascimento, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setNome(String newNome){
        this.nome = newNome;
    }

    public void setCpf(String newCpf){
        this.cpf = newCpf;
    }

    public void setDataNascimento(LocalDate newDataNascimento){
        this.dataNascimento = newDataNascimento;
    }

    public void setEndereco(String newEndereco){
        this.endereco = newEndereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
