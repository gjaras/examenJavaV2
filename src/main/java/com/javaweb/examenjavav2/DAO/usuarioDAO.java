/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.DAO;

import com.javaweb.examenjavav2.POJOS.Usuario;
import com.javaweb.examenjavav2.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class usuarioDAO {

//GET
    public boolean getUsuario(Usuario usuario){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Usuario where usuarioNombre='"+usuario.getUsuarioNombre()+"' and usuarioPass='"+usuario.getUsuarioPass()+"'");
        Usuario retorno = (Usuario)q.uniqueResult();
        s.flush();
        s.close();
        return !(retorno == null);
    }



    
}

