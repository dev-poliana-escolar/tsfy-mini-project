package br.edu.ifpar.tsi3.tsfy.UI.fachada;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import controladores.MusicaControlador;
import controladores.PlaylistControlador;
import controladores.UsuarioControlador;

import java.util.ArrayList;

public class FachadaFrontend {

    private MusicaControlador controladorDeMusica;
    private PlaylistControlador controladorDePlaylist;
    private UsuarioControlador controladorDeUsuario;

    public FachadaFrontend() {
        this.controladorDeMusica = new MusicaControlador();
        this.controladorDePlaylist = new PlaylistControlador();
        this.controladorDeUsuario = new UsuarioControlador();
    }

    // =========================
    // USUÁRIO
    // =========================

    public boolean cadastrarUsuario(String cpf, String nome, String senha) {
        return controladorDeUsuario.cadastrarUsuario(cpf, nome, senha);
    }

    public boolean autenticarUsuario(String cpf, String senha) {
        return controladorDeUsuario.autenticarUsuario(cpf, senha);
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return controladorDeUsuario.buscarUsuarioPorCpf(cpf);
    }

    public ArrayList<Usuario> listarUsuarios() {
        return controladorDeUsuario.listarUsuarios();
    }

    // =========================
    // MÚSICA
    // =========================

    public boolean cadastrarMusica(String titulo,String compositor,String interprete,double duracao) {
        return controladorDeMusica.cadastrarMusica(titulo,compositor,interprete,duracao);
    }

    public ArrayList<Musica> buscarMusicaPorTitulo(String titulo) {
        return controladorDeMusica.buscarMusicaPorTitulo(titulo);
    }

    public Musica buscarMusica(String titulo,String interprete) {
        return controladorDeMusica.buscarMusica(titulo,interprete);
    }

    public ArrayList<Musica> listarMusicas() {
        return controladorDeMusica.listarMusicas();
    }

    public boolean editarMusica(String tituloAtual,String novoTitulo,String compositor,String interprete,double duracao){
        return controladorDeMusica.editarMusica(
                tituloAtual,
                novoTitulo,
                compositor,
                interprete,
                duracao
        );
    }

    public boolean removerMusica(String titulo,String interprete){

        return controladorDeMusica.removerMusica(titulo,interprete);
    }
    // =========================
    // PLAYLIST
    // =========================

    public boolean criarPlaylist(String cpfUsuario,String nomePlaylist,String descricao) {

        Usuario usuario = controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

        return controladorDePlaylist.criarPlaylist(
                usuario,
                nomePlaylist,
                descricao
        );
    }

    public Playlist buscarPlaylist(String cpfUsuario,String nomePlaylist) {

        Usuario usuario =
                controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

        return controladorDePlaylist.buscarPlaylist(
                usuario,
                nomePlaylist
        );
    }

    public boolean adicionarMusicaNaPlaylist(String cpfUsuario,String nomePlaylist, String tituloMusica, String interpreteMusica){ 

        Usuario usuario = controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

        Playlist playlist =controladorDePlaylist.buscarPlaylist(usuario,nomePlaylist);

        Musica musica = controladorDeMusica.buscarMusica(tituloMusica,interpreteMusica);

        return controladorDePlaylist.adicionarMusicaNaPlaylist(playlist,musica);
        
    }

    public Playlist[] listarPlaylistsDoUsuario(String cpfUsuario){

        Usuario usuario =controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

        if(usuario == null){
            return null;
        }

        return usuario.getPlaylists();
    }


        public boolean removerMusicaDaPlaylist(String cpfUsuario,String nomePlaylist,String tituloMusica,String interpreteMusica){

                Usuario usuario =controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

                Playlist playlist =controladorDePlaylist.buscarPlaylist(usuario,nomePlaylist);

                Musica musica =controladorDeMusica.buscarMusica(
                                        tituloMusica,
                                        interpreteMusica
                                );

                return controladorDePlaylist.removerMusicaDaPlaylist(playlist,musica);
        }

        public boolean excluirPlaylist(String cpfUsuario,String nomePlaylist){

        Usuario usuario =controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

        return controladorDePlaylist.excluirPlaylist(usuario,nomePlaylist);
        }

        public boolean editarPlaylist(String cpfUsuario,String nomeAtual,String novoNome,String novaDescricao){

        Usuario usuario =controladorDeUsuario.buscarUsuarioPorCpf(cpfUsuario);

        return controladorDePlaylist.editarPlaylist(usuario,nomeAtual,novoNome,novaDescricao);
        }

        public ArrayList<Musica> listarMusicasDaPlaylist(String cpfUsuario,String nomePlaylist){

        Usuario usuario =
                controladorDeUsuario
                        .buscarUsuarioPorCpf(cpfUsuario);

        Playlist playlist =
                controladorDePlaylist
                        .buscarPlaylist(
                                usuario,
                                nomePlaylist
                        );

        return controladorDePlaylist
                .listarMusicasDaPlaylist(
                        playlist
                );
        }
}