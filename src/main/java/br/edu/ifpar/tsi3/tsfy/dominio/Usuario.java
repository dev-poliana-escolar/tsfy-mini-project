
package br.edu.ifpar.tsi3.tsfy.dominio;



public class Usuario {
    
    private String cpf;
    private String nome;
    private String senha;

    private Playlist[] playlists;
    private int qtdPlaylists;

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public int getQtdPlaylists() {
        return qtdPlaylists;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;

        this.playlists = new Playlist[10];
        this.qtdPlaylists = 0;
    }

    public void adicionarPlaylist(Playlist novaPlaylist){

        if(this.qtdPlaylists == this.playlists.length){

            Playlist[] novoVetor =
                    new Playlist[this.playlists.length + 10];

            for(int i = 0; i < this.playlists.length; i++){
                novoVetor[i] = this.playlists[i];
            }

            this.playlists = novoVetor;
        }

        this.playlists[this.qtdPlaylists] = novaPlaylist;

        this.qtdPlaylists++;
    }

    
}
