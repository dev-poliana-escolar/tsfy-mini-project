package controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;

import java.util.ArrayList;

public class MusicaControlador {

    private ArrayList<Musica> musicas;

    public MusicaControlador() {
        this.musicas = new ArrayList<>();
    }

    public boolean cadastrarMusica(String titulo,String compositor,String interprete,double duracao){

        for(Musica m : this.musicas){

            boolean mesmoTitulo =m.getTitulo().equalsIgnoreCase(titulo);

            boolean mesmoCompositor =m.getCompositor().equalsIgnoreCase(compositor);

            boolean mesmoInterprete =m.getInterprete().equalsIgnoreCase(interprete);

            if(mesmoTitulo && mesmoCompositor && mesmoInterprete){
                return false;
            }
        }

        Musica nova =new Musica(titulo,compositor,interprete,duracao);

        this.musicas.add(nova);

        return true;
    }

    public ArrayList<Musica> buscarMusicaPorTitulo(String titulo){

        ArrayList<Musica> musicasEncontradas =new ArrayList<>();

        for(Musica m : this.musicas){

            if(m.getTitulo().equalsIgnoreCase(titulo)){
                musicasEncontradas.add(m);
            }
        }

        return musicasEncontradas;
    }

    public Musica buscarMusica(String titulo,String interprete){

        for(Musica m : this.musicas){

            boolean mesmoTitulo =m.getTitulo().equalsIgnoreCase(titulo);

            boolean mesmoInterprete = m.getInterprete().equalsIgnoreCase(interprete);

            if(mesmoTitulo && mesmoInterprete){

                return m;
            }
        }

        return null;
    }

    public boolean editarMusica(String tituloAtual,String novoTitulo,String compositor,String interprete,double duracao){

        Musica musica = buscarMusica(tituloAtual,interprete);

        if(musica == null){
            return false; 
        }

        if(!tituloAtual.equalsIgnoreCase(novoTitulo) && buscarMusica(novoTitulo,interprete) != null){
            return false; 
        }

        musica.setTitulo(novoTitulo);
        musica.setCompositor(compositor);
        musica.setInterprete(interprete);
        musica.setDuracao(duracao);

        return true;
    }

    public boolean removerMusica(String titulo,String interprete){

        Musica musica = buscarMusica(titulo,interprete);

        if(musica == null){
            return false;
        }

        this.musicas.remove(musica);

        return true;
    }

    public ArrayList<Musica> listarMusicas(){
        return this.musicas;
    }
}