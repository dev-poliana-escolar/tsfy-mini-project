package controladores;


import br.edu.ifpar.tsi3.tsfy.dominio.Musica;

import java.util.ArrayList;

public class MusicaControlador {

    public ArrayList<Musica> todasAsMusicas = new ArrayList<>();


    // Como sei que a música ja não existe?
    public boolean registrarMusica(String titulo, String compositor, String interprete, Double duracao) {
        Musica novaMusica = new Musica(titulo, compositor, interprete, duracao);
        this.todasAsMusicas.add(novaMusica);
        return true;
    }


}
