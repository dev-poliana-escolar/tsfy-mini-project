/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1071759
 */
public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);
    public ArrayList<Musica> todasAsMusicas = new ArrayList<>();
    private ArrayList<Usuario> todosOsPerfis = new ArrayList<>();

    //// como é global usuario A tem acesso a play B
    //private Playlist minhasPlaylists[] = new Playlist[10];
    //private int limitadorPlaylist = 0;

    /// Execução do projeto
    public void rodar() {

        int op;

        do {

            menuDeLogin();

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    criarNovoUsuario();
                    break;

                case 2:

                    Usuario usuarioLogado = autenticar();

                    if(usuarioLogado != null){

                        System.out.println(
                                "Login realizado com sucesso."
                        );

                        areaUsuario(usuarioLogado);

                    } else {

                        System.out.println(
                                "CPF ou senha inválidos."
                        );
                    }

                    break;

                case 3:
                    listarMusicas();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 0);
    }
    /*public void rodar() {
        
        int op;
        
        do {
            menuDeLogin();
            op = Integer.parseInt(sc.nextLine());
            
            switch (op) {
                case 1:
                    criarNovoUsuario();
                    break;
                case 2:
                    autenticar();
                    break;
                case 3:
                    listarMusicas();
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (op != 0);
        
        
        do {
            menu();
            op = Integer.parseInt(sc.nextLine());
            
            switch (op) {
                case 1:
                    criarMusica();
                    break;
                case 2:
                    editarMusica();
                    break;
                    
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorID();
                    break;   
                case 5:
                    removerMusica();
                    break;  
                default:
                    throw new AssertionError();
            }
            
        } while (op != 0);
        
    }

     */

    //// menu de operação do sistema
    public void menu(){
        //Favoritar Musica
        System.out.println("------ Menu de Operacoes ------");
        System.out.println("1 - Criar musica");
        System.out.println("2 - Editar musica");
        System.out.println("3 - Listar musicas");
        System.out.println("4 - Buscar musica");
        System.out.println("5 - Remover musica");
        System.out.println("0 - Sair");
    }

    /// CRUD Musica
    private void criarMusica() {
        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());
        Musica musica = new Musica(titulo, compositor, interprete, duracao);
        todasAsMusicas.add(musica);
    }

    private void editarMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        for (int i = 0; i < this.todasAsMusicas.size(); i++){
            System.out.println("[" + i + "] " + this.todasAsMusicas.get(i).getTitulo() + "(intérprete: " + this.todasAsMusicas.get(i).getInterprete() + ")");
        }
        
        System.out.println("Informe qual é o ID da música que você deseja editar: ");
        int id = Integer.parseInt(sc.nextLine());
        
        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        this.todasAsMusicas.get(id).setTitulo(titulo);
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        this.todasAsMusicas.get(id).setCompositor(compositor);
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        this.todasAsMusicas.get(id).setInterprete(interprete);
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());
        this.todasAsMusicas.get(id).setDuracao(duracao);
        
        System.out.println("Musica editada com sucesso.");
    }

    private void listarMusicas() {
        for (Musica musica: this.todasAsMusicas) {
            System.out.println(musica.getTitulo() + "(intérprete: " + musica.getInterprete() + ")");
        }
                
    }

    private void buscarMusicaPorID() {
        System.out.println("Informe qual é o ID da música que você deseja buscar: ");
        int id = Integer.parseInt(sc.nextLine());
        
        System.out.println("Título: " + this.todasAsMusicas.get(id).getTitulo());
        System.out.println("Compositor: " + this.todasAsMusicas.get(id).getCompositor());
        System.out.println("Interprete: " + this.todasAsMusicas.get(id).getInterprete());
        System.out.println("Duracao: " + this.todasAsMusicas.get(id).getDuracao());
    }

    private void removerMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        for (int i = 0; i < this.todasAsMusicas.size(); i++){
            System.out.println("[" + i + "] " + this.todasAsMusicas.get(i).getTitulo() + "(intérprete: " + this.todasAsMusicas.get(i).getInterprete() + ")");
        }
        
        System.out.println("Informe qual é o ID da música que você deseja remover: ");
        int id = Integer.parseInt(sc.nextLine());
        
        this.todasAsMusicas.remove(id);
    }
    /////

    //// Criar play antigo
    /*
        private boolean criarPlaylist(Usuario dono, String nome, String descricao){
            Playlist novaPlaylist = new Playlist(dono, nome, descricao);

            if (validarPlaylist(nome)){
                // Solicitar um novo nome de playlist para o usuario
                return false;
            } else {
                this.registrarPlaylist(novaPlaylist);
                return true;
            }
        }


        private void registrarPlaylist(Playlist novaPlaylist){
            if(this.minhasPlaylists.length == this.limitadorPlaylist){
                Playlist playlists[] = new Playlist[this.limitadorPlaylist+10];

                for (int i = 0; i < this.minhasPlaylists.length; i++){
                    playlists[i] = this.minhasPlaylists[i];
                }

                this.minhasPlaylists = playlists;
            }

            this.minhasPlaylists[limitadorPlaylist++] = novaPlaylist;


        }

        private boolean validarPlaylist(String nome) {
            for (int i = 0; i < this.minhasPlaylists.length; i++){
                    if (this.minhasPlaylists[i].getNome().equals(nome))
                        return true;
            }
            return false;
        }
    */
    //// Criar play novo

    private void criarPlaylist(Usuario usuarioLogado){

        System.out.println("Nome da playlist:");
        String nome = sc.nextLine();

        System.out.println("Descrição da playlist:");
        String descricao = sc.nextLine();

        Playlist novaPlaylist = new Playlist(usuarioLogado, nome, descricao);

        usuarioLogado.adicionarPlaylist(novaPlaylist);

        System.out.println("Playlist criada com sucesso.");
    }

    private void listarPlaylists(Usuario usuarioLogado){

        if(usuarioLogado.getQtdPlaylists() == 0){

            System.out.println(
                    "Você não possui playlists."
            );

            return;
        }

        System.out.println("---- MINHAS PLAYLISTS ----");

        for(int i = 0;
            i < usuarioLogado.getQtdPlaylists();
            i++){

            Playlist p =
                    usuarioLogado.getPlaylists()[i];

            System.out.println(
                    "[" + i + "] "
                            + p.getNome()
                            + " - "
                            + p.getDescricao()
            );
        }
    }

    private void adicionarMusicaPlaylist(Usuario usuarioLogado){

        if(usuarioLogado.getQtdPlaylists() == 0){

            System.out.println(
                    "Você não possui playlists."
            );

            return;
        }

        if(this.todasAsMusicas.isEmpty()){

            System.out.println(
                    "Não existem músicas cadastradas."
            );

            return;
        }

        System.out.println("---- PLAYLISTS ----");

        for(int i = 0;
            i < usuarioLogado.getQtdPlaylists();
            i++){

            Playlist p =
                    usuarioLogado.getPlaylists()[i];

            System.out.println(
                    "[" + i + "] "
                            + p.getNome()
            );
        }

        System.out.println(
                "Escolha o ID da playlist:"
        );

        int idPlaylist =
                Integer.parseInt(sc.nextLine());

        Playlist playlistEscolhida =
                usuarioLogado.getPlaylists()[idPlaylist];

        System.out.println("---- MUSICAS ----");

        for(int i = 0;
            i < this.todasAsMusicas.size();
            i++){

            Musica m =
                    this.todasAsMusicas.get(i);

            System.out.println(
                    "[" + i + "] "
                            + m.getTitulo()
            );
        }

        System.out.println(
                "Escolha o ID da música:"
        );

        int idMusica =
                Integer.parseInt(sc.nextLine());

        Musica musicaEscolhida =
                this.todasAsMusicas.get(idMusica);

        playlistEscolhida
                .getMusicas()
                .add(musicaEscolhida);

        System.out.println(
                "Música adicionada na playlist."
        );
    }

    private void listarMusicasDaPlaylist(Usuario usuarioLogado){

        if(usuarioLogado.getQtdPlaylists() == 0){

            System.out.println(
                    "Você não possui playlists."
            );

            return;
        }

        System.out.println(
                "---- SUAS PLAYLISTS ----"
        );

        for(int i = 0; i < usuarioLogado.getQtdPlaylists(); i++){

            Playlist p = usuarioLogado.getPlaylists()[i];

            System.out.println(
                    "[" + i + "] " + p.getNome()
            );
        }

        System.out.println(
                "Escolha o ID da playlist:"
        );

        int idPlaylist = Integer.parseInt(sc.nextLine());

        Playlist playlistEscolhida = usuarioLogado.getPlaylists()[idPlaylist];

        if(playlistEscolhida.getMusicas().isEmpty()){

            System.out.println(
                    "Essa playlist não possui músicas."
            );

            return;
        }

        System.out.println(
                "---- MUSICAS DA PLAYLIST ----"
        );

        for(Musica musica : playlistEscolhida.getMusicas()){

            System.out.println(
                    musica.getTitulo()
                            + " - "
                            + musica.getInterprete()
            );
        }
    }

    private void removerMusicaDaPlaylist(Usuario usuarioLogado){

        if(usuarioLogado.getQtdPlaylists() == 0){

            System.out.println(
                    "Você não possui playlists."
            );

            return;
        }

        System.out.println(
                "---- SUAS PLAYLISTS ----"
        );

        for(int i = 0;
            i < usuarioLogado.getQtdPlaylists();
            i++){

            Playlist p =
                    usuarioLogado.getPlaylists()[i];

            System.out.println(
                    "[" + i + "] "
                            + p.getNome()
            );
        }

        System.out.println(
                "Escolha o ID da playlist:"
        );

        int idPlaylist =
                Integer.parseInt(sc.nextLine());

        Playlist playlistEscolhida =
                usuarioLogado.getPlaylists()[idPlaylist];

        if(playlistEscolhida
                .getMusicas()
                .isEmpty()){

            System.out.println(
                    "Essa playlist não possui músicas."
            );

            return;
        }

        System.out.println(
                "---- MUSICAS DA PLAYLIST ----"
        );

        for(int i = 0;
            i < playlistEscolhida
                    .getMusicas()
                    .size();
            i++){

            Musica musica =
                    playlistEscolhida
                            .getMusicas()
                            .get(i);

            System.out.println(
                    "[" + i + "] "
                            + musica.getTitulo()
                            + " - "
                            + musica.getInterprete()
            );
        }

        System.out.println(
                "Escolha o ID da música para remover:"
        );

        int idMusica =
                Integer.parseInt(sc.nextLine());

        playlistEscolhida
                .getMusicas()
                .remove(idMusica);

        System.out.println(
                "Música removida da playlist."
        );
    }

    //// Login do usuario
    private void menuDeLogin() {

        System.out.println("------ LOGIN ------");
        System.out.println("1 - Criar usuário");
        System.out.println("2 - Fazer login");
        System.out.println("3 - Listar músicas");
        System.out.println("0 - Sair");
    }

    private void menuUsuario(){

        System.out.println("1 - Criar playlist");
        System.out.println("2 - Listar minhas playlists");
        System.out.println("3 - Adicionar música na playlist");
        System.out.println("4 - Listar músicas da playlist");
        System.out.println("5 - Remover música da playlist");
        System.out.println("6 - Criar música");
        System.out.println("7 - Editar música");
        System.out.println("8 - Listar músicas");
        System.out.println("9 - Buscar música");
        System.out.println("10 - Remover música");
        System.out.println("0 - Logout");
    }

    /// recebe o usuario logado
    private void areaUsuario(Usuario usuarioLogado){

        int op;

        do {

            menuUsuario();

            op = Integer.parseInt(sc.nextLine());

            switch (op){

                case 1:
                    criarPlaylist(usuarioLogado);
                    break;

                case 2:
                    listarPlaylists(usuarioLogado);
                    break;

                case 3:
                    adicionarMusicaPlaylist(usuarioLogado);
                    break;
                case 4:
                    listarMusicasDaPlaylist(usuarioLogado);
                    break;

                case 5:
                    removerMusicaDaPlaylist(usuarioLogado);
                    break;

                case 6:
                    criarMusica();
                    break;

                case 7:
                    editarMusica();
                    break;

                case 8:
                    listarMusicas();
                    break;

                case 9:
                    buscarMusicaPorID();
                    break;

                case 10:
                    removerMusica();
                    break;
                case 0:
                    System.out.println("Logout realizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 0);
    }

    private void criarNovoUsuario() {

        System.out.println("Informe seu nome:");
        String nome = sc.nextLine();

        System.out.println("Informe seu cpf:");
        String cpf = sc.nextLine();

        if(validarCpf(cpf)){

            System.out.println(
                    "Já existe um usuário com esse CPF."
            );

            return;
        }

        System.out.println("Informe sua senha:");
        String senha = sc.nextLine();

        Usuario novo =
                new Usuario(cpf, nome, senha);

        this.todosOsPerfis.add(novo);

        System.out.println(
                "Usuário criado com sucesso."
        );
    }

    private Usuario autenticar() {
        System.out.println("Informe seu cpf: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();


        for (int i = 0; i < this.todosOsPerfis.size(); i++){
            if (this.todosOsPerfis.get(i).getCpf().equals(cpf) && this.todosOsPerfis.get(i).getSenha().equals(senha)){
                return this.todosOsPerfis.get(i);
            }
        }
        return null;
    }

    private boolean validarCpf(String cpf){

        for(int i = 0;
            i < this.todosOsPerfis.size();
            i++){

            Usuario usuario =
                    this.todosOsPerfis.get(i);

            if(usuario.getCpf().equals(cpf)){

                return true;
            }
        }

        return false;
    }
    
}
