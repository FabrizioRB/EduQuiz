/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceDao;
import dao.UsuarioDaoBd;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Usuario;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@RequestScoped
public class UsuarioMB {
    
    private Usuario usuario;
    private InterfaceDao usuarioDao;
    private DataModel listaUsuarios;

    public UsuarioMB() {
        this.usuario = new Usuario();
        this.usuarioDao = new UsuarioDaoBd();        
    }
    
    public DataModel retornaListaDeUsuarios() {
        List<Usuario> lista = usuarioDao.listar();
        listaUsuarios = new ListDataModel(lista);
        
         return listaUsuarios;        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void cadastrarUsuario(){
        
        this.usuarioDao.inserir(usuario);
        
    }
}
