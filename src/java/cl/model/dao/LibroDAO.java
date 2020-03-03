/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;

import cl.model.pojos.Libro;
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
public class LibroDAO {
    public String consultarCategoria(String Nombre){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Libro l = (Libro)sesion.get(Libro.class, Nombre);
        if(l != null){
            return "El libro : " + l.getTitulo() + "existe";
        }
        else{
            return "El libro : " + Nombre + "no existe";
        }
    }
    
    public List<Libro> verLibro(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Libro");
        List<Libro> lista = query.list();
        sesion.close();
        return lista;
    }
}
