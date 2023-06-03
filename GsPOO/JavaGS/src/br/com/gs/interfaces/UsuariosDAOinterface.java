package br.com.gs.interfaces;

import br.com.gs.model.Usuario;

import java.util.List;

public interface UsuariosDAOinterface {
    public void insert(Usuario usuario);

    public  abstract  boolean findUser(String user, String senha);
}
