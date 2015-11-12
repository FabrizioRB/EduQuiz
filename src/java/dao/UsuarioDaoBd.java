/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class UsuarioDaoBd implements InterfaceDao<Usuario>{
    
    private Session sessao;
    private Transaction trans;

    @Override
    public void inserir(Usuario bean) {
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                Usuario usuario = new Usuario();
                usuario.setNome(bean.getNome());
                usuario.setTelefone(bean.getTelefone());
                usuario.setEmail(bean.getEmail());
                usuario.setSenha(bean.getSenha());
                
                sessao.save(usuario);
                trans.commit();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            sessao.close();
        }
    }

    public Boolean inserirUsuario(Usuario bean) {
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                Usuario usuario = new Usuario();
                usuario.setNome(bean.getNome());
                usuario.setTelefone(bean.getTelefone());
                usuario.setEmail(bean.getEmail());
                usuario.setSenha(bean.getSenha());
                
                sessao.save(usuario);
                trans.commit();
                return true;
        }
        catch(Exception ex){
                ex.printStackTrace();
                return false;
        }
        finally{
            sessao.close();
        }
    }
    @Override
    public void deletar(Usuario bean) {
    
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                
                sessao.delete(bean);
                trans.commit();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            sessao.close();
        }        
    }

    @Override
    public void atualizar(Usuario bean) {
    
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                                
                sessao.update(bean);
                trans.commit();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            sessao.close();
        }
    }

    @Override
    public List listar() {
        
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                List lista =sessao.createQuery("from Usuario").list();
                //Criteria cri = sessao.createCriteria(Usuario.class);
                lista.size();
                trans.commit();
                return lista;
         }
         catch(Exception ex){
             throw ex;
                
         }
         finally{
             if(sessao!=null){
             sessao.close();}
         }
    }
    
    
    
}
