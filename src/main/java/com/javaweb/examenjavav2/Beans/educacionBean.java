/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.Beans;

import com.javaweb.examenjavav2.DAO.educacionDAO;
import com.javaweb.examenjavav2.POJOS.Comuna;
import com.javaweb.examenjavav2.POJOS.Educacion;
import com.javaweb.examenjavav2.POJOS.Estadocivil;
import com.javaweb.examenjavav2.POJOS.Postulante;
import com.javaweb.examenjavav2.POJOS.Usuario;
import com.javaweb.examenjavav2.POJOS.Renta;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Named(value="educacionBean")
@SessionScoped

public class educacionBean implements Serializable {

     private int educacionId;
     private String educacionTipo;
     
    public educacionBean() {
    }
    
    public void addEducacion(){
        Educacion educacion=new Educacion(getEducacionId(),getEducacionTipo());
        educacionDAO educacionDAO=new educacionDAO();
        educacionDAO.addEducacion(educacion);
    }
//    
//    public void updateComuna(){
//        Comuna comuna=new Comuna(getComunaId(),getComunaNombre());
//        comunaDAO comunaDAO=new comunaDAO();
//        comunaDAO.;
//    }
    public void deleteEducacion(){
        Educacion educacion=new Educacion(getEducacionId(),getEducacionTipo());
        educacionDAO educacionDAO=new educacionDAO();
        educacionDAO.deleteEducacion(getEducacionId(),getEducacionTipo());
        educacionId=0;
        educacionTipo=null;
    }
    
    public int getEducacionId() {
        return educacionId;
    }

    public void setEducacionId(int educacionId) {
        this.educacionId = educacionId;
    }

    public String getEducacionTipo() {
        return educacionTipo;
    }

    public void setEducacionTipo(String educacionTipo) {
        this.educacionTipo = educacionTipo;
    }
    
}
