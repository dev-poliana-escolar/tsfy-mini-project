package controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;

import java.util.ArrayList;

public class MusicaControlador {

    private ArrayList<Musica> musicas;

    public MusicaControlador() {
        this.musicas = new ArrayList<>();
    }

    public boolean cadastrarMusica(String titulo,String compositor,String interprete,double duracao){

        if (buscarMusica(titulo) != null){
            return false; // Música já existe
        }

        Musica nova = new Musica(titulo,compositor,interprete,duracao);

        this.musicas.add(nova);

        return true;
    }

    public Musica buscarMusica(String titulo){

        for(Musica m : this.musicas){

            if(m.getTitulo().equalsIgnoreCase(titulo)){
                return m;
            }
        }

        return null;
    }

    public ArrayList<Musica> listarMusicas(){
        return this.musicas;
    }
}