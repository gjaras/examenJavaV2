/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.DAO;

import com.javaweb.examenjavav2.POJOS.Comuna;
import com.javaweb.examenjavav2.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class comunaDAO {

    public void addComuna(Comuna comuna){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        s.save(comuna);
        s.getTransaction().commit();
        s.flush();
        s.close();
    }
    
//GET
    public boolean getComuna(Comuna comuna){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Comuna where comuna_id='"+comuna.getComunaId()+"' and comuna_nombre='"+comuna.getComunaNombre()+"'");
        Comuna retorno = (Comuna)q.uniqueResult();
        s.flush();
        s.close();
        return !(retorno == null);
    }
//ELIMINAR
    public void deleteComuna(int ComunaId,String ComunaNombre){
        Comuna p = new Comuna(ComunaId,ComunaNombre) ;
        comunaDAO pd = new comunaDAO();
        pd.deleteComuna(p.getComunaId(),p.getComunaNombre());
    }


    
}

