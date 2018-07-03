/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.DAO;

import com.javaweb.examenjavav2.POJOS.Renta;
import com.javaweb.examenjavav2.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class rentaDAO {

//GET
    public boolean getRenta(Renta renta){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Renta where renta_id='"+renta.getRentaId()+"' and renta_tipo='"+renta.getRentaTipo()+"'");
        Renta retorno = (Renta)q.uniqueResult();
        s.flush();
        s.close();
        return !(retorno == null);
    }



    
}

