/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;

import cl.model.pojos.Categoria;
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
public class CategoriaDAO {
    public String consultarCategoria(String Nombre){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Categoria c = (Categoria)sesion.get(Categoria.class, Nombre);
        if(c != null){
            return "La categoria: " + c.getNombre() + "existe";
        }
        else{
            return "La categoria de : " + Nombre + "no existe";
        }
    }
    
    public List<Categoria> verCategoria(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Categoria");
        List<Categoria> lista = query.list();
        sesion.close();
        return lista;
    }
}
