package model;

/**
 * classe responsavel pelo construtor Dados e pelos metodos e gets e sets dos
 * atributos.
 *
 * @author Huilton
 * @version 1.0
 */
public class Usuarios {

    private String nome;
    private int codigo;
    public static int auxCodigo = 0;
    private String Senha;
    private String nomeTipo;

    /**
     * Metodo construtor da Classe com seus atributos obrigatórios para criar um
     * usuario como funcionário ou administrador
     *
     * @param codigo Atributo do tipo int que recebe o codigo no array de busca
     * auxCodigo que gera um codigo diferente cada vez que ocorre um cadastro
     * @param nome Atributo do tipo String Recebe o Nome que sera Cadastrado
     * @param Senha Atributo do tipo String Recebe a Senha que sera Cadastrada
     * @param nomeTipo Atributo do tipo String quando gera um novo cadastro seta
     * administrador ou usuário de acordo com a opção escolhida
     */
    public Usuarios(int codigo, String nome, String Senha, String nomeTipo) {
        this.nome = nome;
        this.Senha = Senha;
        this.codigo = codigo;
        this.nomeTipo = nomeTipo;
    }

    /**
     * Metodo construtor da Classe com seus atributos obrigatórios para criar um
     * usuario como funcionário ou administrador
     *
     * @param nome Atributo do tipo String Recebe o Nome que sera Cadastrado
     * @param Senha Atributo do tipo String Recebe a Senha que sera Cadastrada
     * @param nomeTipo Atributo do tipo String quando gera um novo cadastro seta
     * administrador ou usuário de acordo com a opção escolhida
     */
    public Usuarios(String nome, String Senha, String nomeTipo) {
        
        this(auxCodigo, nome, Senha, nomeTipo);
        
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    @Override
    public String toString() {
        return this.codigo + ";"
                + this.nome + ";"
                + this.Senha + ";"
                + this.nomeTipo + "\r\n";
    }

}
