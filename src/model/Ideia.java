package model;

import static model.CentralDeIdeias.arrayDeIdeia;
import static model.CentralDeIdeias.arrayDeUsuarios;

/**
 * Classe responsavel pelo metodo construtor Funcionario onde seus parametros
 * são herdados Da classe Dados.
 *
 * @author Huilton
 * @version 1.0
 */
public class Ideia {

    private String ideiaFuncionario;
    private String nomeIdeia;
    private String Senha;
    private int pontos;
    private int codigo;
    public static int auxCodigo = 0;
    private String auxFunconario;

    
    public Ideia(int codigo, String Senha, String nomeIdeia, String ideiaFuncionario, int pontos, String auxFunconario) {
        this.Senha = Senha;
        this.nomeIdeia = nomeIdeia;
        this.ideiaFuncionario = ideiaFuncionario;
        this.pontos = 1;
        this.codigo = codigo;
        this.auxFunconario = auxFunconario;

    }

    public Ideia(String Senha, String nomeIdeia, String ideiaFuncionario, int pontos, String auxFunconario) {
        this(auxCodigo, Senha, nomeIdeia, ideiaFuncionario, pontos, auxFunconario);
    }

    public String getIdeiaFuncionario() {
        return ideiaFuncionario;
    }

    public void setIdeiaFuncionario(String ideiaFuncionario) {
        this.ideiaFuncionario = ideiaFuncionario;
    }

    public String getNomeIdeia() {
        return nomeIdeia;
    }

    public void setNomeIdeia(String nomeIdeia) {
        this.nomeIdeia = nomeIdeia;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return this.codigo + ";"
                + this.Senha + ";"
                + this.nomeIdeia + ";"
                + this.ideiaFuncionario + ";"
                + this.pontos + ";"
                + this.auxFunconario + ";" + "\r\n";
    }

    public String getAuxFunconario() {
        return auxFunconario;
    }

    public void setAuxFunconario(String auxFunconario) {
        this.auxFunconario = auxFunconario;
    }

}
