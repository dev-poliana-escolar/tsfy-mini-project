package br.edu.ifpar.tsi3.tsfy.UI.fachada;

import controladores.MusicaControlador;
import controladores.PlaylistControlador;
import controladores.UsuarioControlador;

public class FachadaFrontend {
    private MusicaControlador controladorDeMusica;
    private PlaylistControlador controladorDePlaylist;
    private UsuarioControlador controladorDeUsuario;

    public FachadaFrontend(){
        this.controladorDeMusica = new MusicaControlador();
        this.controladorDePlaylist = new PlaylistControlador();
        this.controladorDeUsuario = new UsuarioControlador();
    }

    public MusicaControlador getControladorDeMusica() {
        return controladorDeMusica;
    }

    public void setControladorDeMusica(MusicaControlador controladorDeMusica) {
        this.controladorDeMusica = controladorDeMusica;
    }

    public PlaylistControlador getControladorDePlaylist() {
        return controladorDePlaylist;
    }

    public void setControladorDePlaylist(PlaylistControlador controladorDePlaylist) {
        this.controladorDePlaylist = controladorDePlaylist;
    }

    public UsuarioControlador getControladorDeUsuario() {
        return controladorDeUsuario;
    }

    public void setControladorDeUsuario(UsuarioControlador controladorDeUsuario) {
        this.controladorDeUsuario = controladorDeUsuario;
    }

    public boolean registrarMusica(String titulo, String compositor, String interprete, Double duracao) {
        boolean sucesso = this.controladorDeMusica.registrarMusica(titulo, compositor, interprete, duracao);
        return sucesso;
    }



}



