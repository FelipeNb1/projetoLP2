package entidades;
import estoque.Produto;
import pagamento.Pagamento;
import java.util.List;

public abstract class Pessoa implements ServicoUsuario{
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean login;

    public Pessoa(){

    }
    public Pessoa(String nome, String email, String senha) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    //métodos
    @Override
    public void fazerLogin() {
        setLogin(true);
    }
    @Override
    public void fazerLogout() {
        setLogin(false);
    }
    @Override
    public abstract boolean autenticacao(String email, String senha);
    @Override
    public abstract Produto fazerCompra(int categoria);
    @Override
    public abstract void finalizarCompra(List<Produto> carrinho);

    
   
    
}



