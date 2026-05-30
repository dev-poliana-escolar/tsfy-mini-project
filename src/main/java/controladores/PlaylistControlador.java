package controladores;

import java.util.ArrayList;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;

public class PlaylistControlador {


    public boolean criarPlaylist(Usuario usuario,String nome,String descricao){

        if(usuario == null){
            return false;    
        }

        if(possuiPlaylist(usuario, nome)){
            return false;
        }

        Playlist novaPlaylist = new Playlist(usuario, nome, descricao);

        usuario.adicionarPlaylist(novaPlaylist);

        return true;
    }

    // Verifica se o usuário já possui uma playlist com o nome dado.
    public boolean possuiPlaylist(Usuario usuario, String nome){

        for(int i = 0; i < usuario.getQtdPlaylists(); i++){

            Playlist p = usuario.getPlaylists()[i];

            if(p.getNome().equalsIgnoreCase(nome)){
                return true;
            }
        }

        return false;
    }

   
    public Playlist buscarPlaylist(Usuario usuario, String nome){

        for(int i = 0; i < usuario.getQtdPlaylists(); i++){

            Playlist p = usuario.getPlaylists()[i];

            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }

        return null;
    }

    public boolean adicionarMusicaNaPlaylist(Playlist playlist,Musica musica){

        if(playlist == null || musica == null){
            return false;
        }

        playlist.getMusicas().add(musica);

        return true;
    }

    public boolean removerMusicaDaPlaylist(Playlist playlist,Musica musica){

        if(playlist == null || musica == null){
            return false;
        }

        return playlist
                .getMusicas()
                .remove(musica);
    }

    public boolean excluirPlaylist(Usuario usuario,String nomePlaylist){

        if(usuario == null){
            return false;
        }

        Playlist[] playlists =usuario.getPlaylists();

        int qtd = usuario.getQtdPlaylists();

        for(int i = 0; i < qtd; i++){

            Playlist p = playlists[i];

            if(p.getNome().equalsIgnoreCase(nomePlaylist)){

                for(int j = i; j < qtd - 1; j++){
                    playlists[j] = playlists[j + 1];
                }

                playlists[qtd - 1] = null;

                usuario.setQtdPlaylists(qtd - 1);

                return true;
            }
        }

        return false;
    }

    public boolean editarPlaylist(Usuario usuario,String nomeAtual,String novoNome,String novaDescricao){

        Playlist playlist =buscarPlaylist(usuario,nomeAtual);

        if(playlist == null){
            return false;
        }

        if(!nomeAtual.equalsIgnoreCase(novoNome) && possuiPlaylist(usuario, novoNome)){
            return false;
        }

        playlist.setNome(novoNome);
        playlist.setDescricao(novaDescricao);

        return true;
    }

    public ArrayList<Musica> listarMusicasDaPlaylist(
        Playlist playlist){

        if(playlist == null){
            return null;
        }

        return playlist.getMusicas();
    }
}