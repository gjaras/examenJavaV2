/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.DAO;

import com.javaweb.examenjavav2.POJOS.Estadocivil;
import com.javaweb.examenjavav2.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class estadocivilDAO {

//GET
    public boolean getEstadoCivil(Estadocivil estadocivil){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Estadocivil where estadocivil_id='"+estadocivil.getEstadocivilId()+"' and estadocivil_tipo='"+estadocivil.getEstadocivilTipo()+"'");
        Estadocivil retorno = (Estadocivil)q.uniqueResult();
        s.flush();
        s.close();
        return !(retorno == null);
    }



    
}

