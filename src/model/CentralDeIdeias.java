package model;

import java.util.ArrayList;

/**
 * Central de ideias classe responsavel por executar os metodos de cadastrar,
 * deletar e alterar documentos no sistema.
 *
 * @author Huilton
 * @version 1.0
 */
public class CentralDeIdeias {

    public static ArrayList<Usuarios> arrayDeUsuarios = new ArrayList<>();
    public static ArrayList<Ideia> arrayDeIdeia = new ArrayList<>();
    GerenciadorArquivos gerenciadorArquivos = new GerenciadorArquivos();

   

    public boolean cadastrarFuncionario(Usuarios usuarios) throws Exception {
        if (usuarios.getNome().equals("")) {
            throw new Exception("\n Nome Obrigatorio!");
        } else if (usuarios.getSenha().equals("")) {
            throw new Exception("\n Senha Obrigatoria!");
        } else {
            for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                if (arrayDeUsuarios.get(i).getSenha().equals(usuarios.getSenha())
                        && arrayDeUsuarios.get(i).getNome().equals(usuarios.getNome())) {
                    throw new Exception("\n Senha já cadastrada!");
                }
            }
            arrayDeUsuarios.add(usuarios);
            return true;

        }
    }

    public int validarAcesso(String nome, String senha) {
        gerenciadorArquivos.buscarArquivosUsuarios();
        int aux = -1;
        for (int i = 0; i < arrayDeUsuarios.size(); i++) {
            if (arrayDeUsuarios.get(i).getNome().equals(nome)
                    && arrayDeUsuarios.get(i).getSenha().equals(senha) && arrayDeUsuarios.get(i).getNomeTipo().equals("Administrador")) {
                aux = 0;
            } else if (arrayDeUsuarios.get(i).getNome().equals(nome)
                    && arrayDeUsuarios.get(i).getSenha().equals(senha) && arrayDeUsuarios.get(i).getNomeTipo().equals("Funcionario")) {
                aux = 1;

            }
        }
        return aux;
    }

    public boolean cadastrarIdeia(Ideia ideia) throws Exception {

        if (ideia.getNomeIdeia().equals("")) {
            throw new Exception("\n Nome da idéia Obrigatoria!");
        } else if (ideia.getIdeiaFuncionario().equals("")) {
            throw new Exception("\n Idéia Obrigatoria!");
        } else {
            for (int i = 0; i < arrayDeIdeia.size(); i++) {
                if (arrayDeIdeia.get(i).getNomeIdeia().equals(ideia.getNomeIdeia())) {
                    throw new Exception("\n Nome da Idéia já cadastrada!");
                } else if (arrayDeIdeia.get(i).getIdeiaFuncionario().equals(ideia.getIdeiaFuncionario())) {
                    throw new Exception("\n Idéia já cadastrada!");
                }
            }
            arrayDeIdeia.add(ideia);
            return true;
        }
    }

    public int contagenDePontos(String nome, String senha) {
        int totalPontos = 0;
        for (int i = 0; i < arrayDeIdeia.size(); i++) {

            if (arrayDeIdeia.get(i).getSenha().equals(senha)
                    && arrayDeIdeia.get(i).getAuxFunconario().equals(nome)) {
                totalPontos += arrayDeIdeia.get(i).getPontos();
            }
        }

        return totalPontos;
    }
}
