package controladores;

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
}