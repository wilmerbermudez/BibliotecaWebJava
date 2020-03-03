/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;

import cl.model.pojos.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.HibernateException;
/**
 *
 * @author willi
 */
public class UsuarioDAO {
    public void ingresarUsuario(Usuario u){
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx=null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.save(u);
            tx.commit();
            sesion.close();
        }
        catch(HibernateException ex){
            tx.rollback();
            throw new RuntimeException("No se pudo guardar usuario");
        }
    }
    
    public String consultarUsuario(int NIP){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
    }
}
