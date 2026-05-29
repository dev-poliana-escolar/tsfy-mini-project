package controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

public class UsuarioControlador {

    private ArrayList<Usuario> usuarios;

    public UsuarioControlador() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario buscarUsuarioPorCpf(String cpf){

        for(Usuario u : this.usuarios){

            if(u.getCpf().equals(cpf)){
                return u;
            }
        }

        return null;
    }

    public boolean cadastrarUsuario(String cpf, String nome, String senha){

        if(buscarUsuarioPorCpf(cpf) != null){
            return false; 
        }

        if (cpf.equals(senha)) {
            return false; 
        }

        Usuario novoUsuario = new Usuario(cpf, nome, senha);

        this.usuarios.add(novoUsuario);

        return true;
    }

   

    public boolean autenticarUsuario(String cpf, String senha){
        
        Usuario usuario =buscarUsuarioPorCpf(cpf);

        if(usuario == null){
            return false;
        }

        return usuario.getSenha().equals(senha);
    }

    public ArrayList<Usuario> listarUsuarios(){
        return this.usuarios;
    }
}