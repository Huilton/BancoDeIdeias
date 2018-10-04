/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import javax.swing.JOptionPane;
import view.Menu;
import static model.CentralDeIdeias.arrayDeIdeia;
import static model.CentralDeIdeias.arrayDeUsuarios;

/**
 *
 * @author Huilton
 */
public class GerenciadorArquivos {

    public static void gravarArquivosUsuario(Usuarios usuarios) {
        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosFuncionario.csv");

        try {
            Files.write(path, usuarios.toString().getBytes(), StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO CADASTRAR USUÁRIO!! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void buscarArquivosUsuarios() {
        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosFuncionario.csv");
        CentralDeIdeias.arrayDeUsuarios.clear();

        try {
            List<String> linhas = Files.readAllLines(path, Charset.defaultCharset());
            for (int i = 0; i < linhas.size(); i++) {
                String[] arrayTabela = linhas.get(i).split(";");
                CentralDeIdeias.arrayDeUsuarios.add(new Usuarios(
                        Integer.parseInt(arrayTabela[0]),
                        arrayTabela[1],
                        arrayTabela[2],
                        arrayTabela[3]));
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO BUSCAR USUÁRIO !! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void deletarArquivoUsuarios(String nome, String senha) throws IOException {

        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosFuncionario.csv");
        String teste = "";
        for (int i = 0; i < arrayDeUsuarios.size(); i++) {

            if (arrayDeUsuarios.get(i).getNome().equals(nome) && arrayDeUsuarios.get(i).getSenha().equals(senha)) {
                CentralDeIdeias.arrayDeUsuarios.remove(i);
            } else {
                teste
                        += arrayDeUsuarios.get(i).getCodigo() + ";"
                        + arrayDeUsuarios.get(i).getNome() + ";"
                        + arrayDeUsuarios.get(i).getSenha() + ";"
                        + arrayDeUsuarios.get(i).getNomeTipo() + ";" + "\r\n";
            }
        }
        byte[] bytes = teste.getBytes();
        Files.delete(path);
        try {
            Files.write(path, bytes, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO DELETAR USUÁRIO!! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void salvarEAlterarUsuarios() throws Exception {
        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosFuncionario.csv");

        String conteudo = "";

        List<String> linhas = Files.readAllLines(path, Charset.defaultCharset());
        for (int i = 0; i < arrayDeUsuarios.size(); i++) {
            conteudo
                    += arrayDeUsuarios.get(i).getCodigo() + ";"
                    + arrayDeUsuarios.get(i).getNome() + ";"
                    + arrayDeUsuarios.get(i).getSenha() + ";"
                    + arrayDeUsuarios.get(i).getNomeTipo() + ";" + "\r\n";
        }
        byte[] bytes = conteudo.getBytes();

        Files.delete(path);

        try {
            Files.write(path, bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO ALTERAR USUÁRIO!! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void gravarArquivoIdeia(Ideia ideia) throws Exception {

        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosIdeias.csv");
        try {
            Files.write(path, ideia.toString().getBytes(), StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO CADASTRAR IDÉIA!! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void buscarArquivosIdeia() {
        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosIdeias.csv");
        CentralDeIdeias.arrayDeIdeia.clear();
        try {
            List<String> linhas = Files.readAllLines(path, Charset.defaultCharset());
            for (int i = 0; i < linhas.size(); i++) {
                String[] arrayTabela = linhas.get(i).split(";");
                CentralDeIdeias.arrayDeIdeia.add(new Ideia(
                        Integer.parseInt(arrayTabela[0]),
                        arrayTabela[1],
                        arrayTabela[2],
                        arrayTabela[3],
                        Integer.parseInt(arrayTabela[4]),
                        arrayTabela[5]));
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO BUSCAR IDÉIA !! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void deletarArquivoIdeia(String pesquisa) {

        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosIdeias.csv");
        String teste = "";
        for (int i = 0; i < arrayDeIdeia.size(); i++) {

            if (CentralDeIdeias.arrayDeIdeia.get(i).getNomeIdeia().equals(pesquisa)) {
                CentralDeIdeias.arrayDeIdeia.remove(i);
            } else {
                teste += arrayDeIdeia.get(i).getCodigo() + ";"
                        + arrayDeIdeia.get(i).getSenha() + ";"
                        + CentralDeIdeias.arrayDeIdeia.get(i).getNomeIdeia() + ";"
                        + CentralDeIdeias.arrayDeIdeia.get(i).getIdeiaFuncionario() + ";"
                        + CentralDeIdeias.arrayDeIdeia.get(i).getPontos() + ";"
                        + CentralDeIdeias.arrayDeIdeia.get(i).getAuxFunconario() + ";" + "\r\n";
            }
        }

        byte[] bytes = teste.getBytes();

        try {
            Files.write(path, bytes, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO DELETAR IDÉIA !! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void salvarEAlterarIdeia() throws Exception {
        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosIdeias.csv");
        String conteudo = "";

        List<String> linhas = Files.readAllLines(path, Charset.defaultCharset());
        for (int i = 0; i < arrayDeIdeia.size(); i++) {
            if (arrayDeIdeia.get(i).getNomeIdeia().equals("")) {
                throw new Exception("\n Nome da idéia Obrigatoria!");
            } else if (arrayDeIdeia.get(i).getIdeiaFuncionario().equals("")) {
                throw new Exception("\n Idéia Obrigatoria!");
            } else {
                conteudo += arrayDeIdeia.get(i).getCodigo() + ";"
                        + arrayDeIdeia.get(i).getSenha() + ";"
                        + arrayDeIdeia.get(i).getNomeIdeia() + ";"
                        + arrayDeIdeia.get(i).getIdeiaFuncionario() + ";"
                        + arrayDeIdeia.get(i).getPontos() + ";"
                        + arrayDeIdeia.get(i).getAuxFunconario() + ";" + "\r\n";
            }
        }

        //   for (int i = 0; i < linhas.size(); i++) {
        //conteudo += linhas.get(i) + "\r\n";
        //}
        byte[] bytes = conteudo.getBytes();
        Files.delete(path);
        try {
            Files.write(path, bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO ALTERAR IDÉIA !! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void deletarArquivoTodosArrays(String nome, String senha) {

        String raiz = System.getProperty("user.dir");
        Path path = Paths.get(raiz, "ArquivosIdeias.csv");
        String teste = "";
        for (int i = 0; i < arrayDeIdeia.size(); i++) {

            if (arrayDeIdeia.get(i).getAuxFunconario().equals(nome) && arrayDeIdeia.get(i).getSenha().equals(senha)) {
                CentralDeIdeias.arrayDeIdeia.remove(i);

            } else {
                teste += arrayDeIdeia.get(i).getCodigo() + ";"
                        + arrayDeIdeia.get(i).getSenha() + ";"
                        + arrayDeIdeia.get(i).getNomeIdeia() + ";"
                        + arrayDeIdeia.get(i).getIdeiaFuncionario() + ";"
                        + arrayDeIdeia.get(i).getPontos() + ";"
                        + arrayDeIdeia.get(i).getAuxFunconario() + ";" + "\r\n";

            }
        }
        byte[] bytes = teste.getBytes();

        try {
            Files.write(path, bytes, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " ERRO AO DELETAR IDÉIA !! ", "!! ERRO !!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
