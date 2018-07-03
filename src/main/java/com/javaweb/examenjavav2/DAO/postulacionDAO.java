/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.DAO;

import com.javaweb.examenjavav2.POJOS.Comuna;
import com.javaweb.examenjavav2.POJOS.Educacion;
import com.javaweb.examenjavav2.POJOS.Estadocivil;
import com.javaweb.examenjavav2.POJOS.Postulante;
import com.javaweb.examenjavav2.POJOS.Usuario;
import com.javaweb.examenjavav2.POJOS.Renta;
import com.javaweb.examenjavav2.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class postulacionDAO {
//Agregar Postulante
    
    public void addPostulante(Postulante postulante){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        s.save(postulante);
        s.getTransaction().commit();
        s.flush();
        s.close();
    }
//Update Producto
    public void updatePostulante(Postulante postulante){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        s.update(postulante);
        s.getTransaction().commit();
        s.flush();
        s.close();
    }
//GET
    public Postulante getPostulante(String rutPostulante){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Postulante where postulante_rut="+rutPostulante);
        Postulante retorno = (Postulante)q.uniqueResult();
        s.flush();
        s.close();
        return retorno;
    }
//LISTAR
    public List<Postulante> listPostulante(){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Postulante");
        List<Postulante> retorno = q.list();
        s.flush();
        s.close();
        return retorno;
    }
    //LISTAR
    public List<Comuna> listComuna(){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Comuna");
        List<Comuna> retorno = q.list();
        s.flush();
        s.close();
        return retorno;
    }
    //LISTAR
    public List<Renta> listRenta(){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Renta");
        List<Renta> retorno = q.list();
        s.flush();
        s.close();
        return retorno;
    }
    //LISTAR
    public List<Estadocivil> listEstadocivil(){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Estadocivil");
        List<Estadocivil> retorno = q.list();
        s.flush();
        s.close();
        return retorno;
    }
    //LISTAR
    public List<Educacion> listEducacion(){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Educacion");
        List<Educacion> retorno = q.list();
        s.flush();
        s.close();
        return retorno;
    }
//ELIMINAR
    public void deletePostulante(Postulante postulante){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        s.delete(postulante);
        s.getTransaction().commit();
        s.flush();
        s.close();
    }


    
}

