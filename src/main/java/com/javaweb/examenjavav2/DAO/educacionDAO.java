/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.DAO;

import com.javaweb.examenjavav2.POJOS.Educacion;
import com.javaweb.examenjavav2.util.HibernateUtil;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class educacionDAO {

//GET
    public boolean getEducacion(Educacion educacion){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Educacion where educacion_id='"+educacion.getEducacionId()+"' and educacion_tipo='"+educacion.getEducacionTipo()+"'");
        Educacion retorno = (Educacion)q.uniqueResult();
        s.flush();
        s.close();
        return !(retorno == null);
    }
 public void addEducacion(Educacion educacion){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        s.save(educacion);
        s.getTransaction().commit();
        s.flush();
        s.close();
    }
 //ELIMINAR
    public void deleteEducacion(int EducacionId,String EducacionTipo){
        Educacion p = new Educacion(EducacionId,EducacionTipo) ;
        educacionDAO pd = new educacionDAO();
        pd.deleteEducacion(p.getEducacionId(),p.getEducacionTipo());
    }

 //LISTAR
    public SelectItem[] listEducacion(){
        postulacionDAO pt = new postulacionDAO();
        List<Educacion> ptl = pt.listEducacion();
        SelectItem[] ret = new SelectItem[ptl.size()];
        int index = 0;
        for(Educacion p : ptl){
            SelectItem agregar = new SelectItem();
            String json = "{\"educacion_id\":\""+p.getEducacionId()+"\",\"educacion_nombre\":\""+p.getEducacionTipo()+"\"}";
            agregar.setValue(json);
            agregar.setLabel(p.getEducacionTipo());
            ret[index] = agregar;
            index++;
        }
        return ret;
    }

    
}

