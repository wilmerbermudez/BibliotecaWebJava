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
    public String consultarLibro(String titulo){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Libro l = (Libro)sesion.get(Libro.class, titulo);
        if(l != null){
            return "El libro : " + l.getTitulo() + "se encuentra disponible";
        }
        else{
            return "El libro : " + titulo + "no existe";
        }
    }
    
    public String consultarAutor(String autor){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Libro l = (Libro)sesion.get(Libro.class, autor);
        if(l != null){
            return "El libro : " + l.getAutor() + "existe";
        }
        else{
            return "El autor que busca no existe";
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
