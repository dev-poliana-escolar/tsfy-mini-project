package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.UI.fachada.FachadaFrontend;
import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;


import java.util.ArrayList;
import java.util.Scanner;

public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);

    private FachadaFrontend fachada;

    public TsfyUI() {
        this.fachada = new FachadaFrontend();
    }

    public void rodar() {

        while (true) {

            System.out.println("Bem-vindo ao Tsfy!");

            System.out.println("1 - Criar novo usuário");
            System.out.println("2 - Entrar com usuário existente");
            System.out.println("0 - Sair");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    criarNovoUsuario();
                    break;
                case "2":
                    Usuario usuarioLogado = autenticar();
                    if (usuarioLogado == null) {
                        System.out.println(
                                "Credenciais inválidas."
                        );
                        break;
                    }
                    menuPrincipal(usuarioLogado);
                    break;
                case "0":
                    System.out.println(
                            "Obrigado por usar o Tsfy!"
                    );
                    return;
                default:
                    System.out.println(
                            "Opção inválida."
                    );
                }
        }
    }

    private void menuPrincipal(Usuario usuarioLogado) {

        while (true) {

            System.out.println("\n--- MENU PRINCIPAL ---");

            System.out.println("1 - Criar nova música");
            System.out.println("2 - Listar músicas");
            System.out.println("3 - Editar música");
            System.out.println("4 - Remover música");
            System.out.println("5 - Criar playlist");
            System.out.println("6 - Adicionar música na playlist");
            System.out.println("0 - Sair");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    criarMusica();
                    break;
                case "2":
                    listarMusicas();
                    break;
                case "3":
                    editarMusica();
                    break;
                case "4":
                    removerMusica();
                    break;
                case "5":
                    criarPlaylist(usuarioLogado);
                    break;
                case "6":
                    adicionarMusicaNaPlaylist(usuarioLogado);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
           
        }
    }

    private void criarNovoUsuario() {
        System.out.println("Informe seu nome:");
        String nome = sc.nextLine();

        System.out.println("Informe seu cpf:");
        String cpf = sc.nextLine();

        System.out.println("Informe sua senha:");
        String senha = sc.nextLine();

        boolean cadastrou = fachada.cadastrarUsuario(cpf, nome, senha);

        if(cadastrou){

            System.out.println(
                    "Usuário criado com sucesso."
            );

        } else {

            System.out.println(
                    "Credenciais inválidas."
            );
        }
    }


    // ==== USUARIO
    private Usuario autenticar() {

        System.out.println("Informe seu cpf:");
        String cpf = sc.nextLine();

        System.out.println("Informe sua senha:");
        String senha = sc.nextLine();

        boolean autenticado = fachada.autenticarUsuario(cpf, senha);

        if(!autenticado){
            return null;
        }

        return fachada.buscarUsuarioPorCpf(cpf);
    }

    // ==== MUSICA
    private void criarMusica() {

        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();

        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();

        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();

        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine().replace(",", "."));

        boolean cadastrou =
                fachada.cadastrarMusica(
                        titulo,
                        compositor,
                        interprete,
                        duracao
                );

        if(cadastrou){

            System.out.println("Música cadastrada com sucesso.");

        } else {

            System.out.println(
                    "Já existe uma música com esse título."
            );
        }
    }

    private void listarMusicas() {

        ArrayList<Musica> musicas = fachada.listarMusicas();

        if(musicas.isEmpty()){

            System.out.println(
                    "Não existem músicas cadastradas."
            );

            return;
        }

        for(Musica musica : musicas){

            System.out.println(
                    musica.getTitulo()
                            + " (intérprete: "
                            + musica.getInterprete()
                            + ")"
            );
        }
    }

    private void criarPlaylist(Usuario usuarioLogado){

        System.out.println("Nome da playlist:");
        String nome = sc.nextLine();

        System.out.println("Descrição da playlist:");
        String descricao = sc.nextLine();

        boolean criou =
                fachada.criarPlaylist(
                        usuarioLogado.getCpf(),
                        nome,
                        descricao
                );

        if(criou){

            System.out.println(
                    "Playlist criada com sucesso."
            );

        } else {

            System.out.println(
                    "Você já possui uma playlist com esse nome."
            );
        }
    }

    private void editarMusica(){

        listarMusicas();

        System.out.println("Digite o título da música que deseja editar:");

        String tituloAtual = sc.nextLine();

        System.out.println("Novo título:");

        String novoTitulo = sc.nextLine();

        System.out.println("Novo compositor:");

        String compositor = sc.nextLine();

        System.out.println("Novo intérprete:");

        String interprete = sc.nextLine();

        System.out.println("Nova duração:");

        double duracao = Double.parseDouble(
                sc.nextLine().replace(",", ".")
        );


        boolean editou =
                fachada.editarMusica(
                        tituloAtual,
                        novoTitulo,
                        compositor,
                        interprete,
                        duracao
                );

        if(editou){

            System.out.println("Música editada com sucesso.");

        } else {

            System.out.println("Música não encontrada.");
        }
    }
    
    private void removerMusica(){

        listarMusicas();

        System.out.println("Digite o título da música que deseja remover:");

        String titulo = sc.nextLine();

        boolean removeu =fachada.removerMusica(titulo);

        if(removeu){

            System.out.println("Música removida com sucesso.");

        } else {

            System.out.println("Música não encontrada.");
        }
    }
    
    
    // ===== PLAYLIST
    private void adicionarMusicaNaPlaylist(Usuario usuarioLogado){

        System.out.println("--- Suas playlists ---");

        Playlist[] playlists =fachada.listarPlaylistsDoUsuario(usuarioLogado.getCpf());

        if(playlists == null){
            System.out.println(
                    "Usuário não encontrado."
            );

            return;
        }

        if(usuarioLogado.getQtdPlaylists() == 0){
            System.out.println(
                    "Você não possui playlists."
            );

            return;
        }

        for(int i = 0;i < usuarioLogado.getQtdPlaylists();i++){
            System.out.println(
                playlists[i].getNome()
            );
        }

        System.out.println("Digite o nome da playlist:");

        String nomePlaylist = sc.nextLine();

        System.out.println("--- Músicas ---");

        listarMusicas();

        System.out.println("Digite o título da música:");

        String tituloMusica = sc.nextLine();

        boolean adicionou =
                fachada.adicionarMusicaNaPlaylist(
                        usuarioLogado.getCpf(),
                        nomePlaylist,
                        tituloMusica
                );

        if(adicionou){

            System.out.println("Música adicionada à playlist com sucesso.");

        } else {

            System.out.println(
                    "Não foi possível adicionar a música à playlist."
            );
        }
    }
        
 }