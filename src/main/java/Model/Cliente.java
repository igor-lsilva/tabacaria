package Model;

/**
 *
 * @author matheus.eleoterio
 */
public class Cliente {

    private int idCliente;
    private String nomeCliente;
    private String CPF;
    private String dtNascimento;

    public Cliente(String nomeCliente, String CPF, String dtNascimento) {
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.dtNascimento = dtNascimento;
    }

    public Cliente(int idCliente, String nomeCliente, String CPF, String dtNascimento) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.dtNascimento = dtNascimento;
    }
    
    
    
    public Cliente () {
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

}
