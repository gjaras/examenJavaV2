/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.Beans;

import com.javaweb.examenjavav2.DAO.comunaDAO;
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

@Named(value="comunaBean")
@SessionScoped

public class comunaBean implements Serializable {

     private int comunaId;
     private String comunaNombre;
     
    public comunaBean() {
    }
    
    public void addComuna(){
        Comuna comuna=new Comuna(getComunaId(),getComunaNombre());
        comunaDAO comunaDAO=new comunaDAO();
        comunaDAO.addComuna(comuna);
    }
//    
//    public void updateComuna(){
//        Comuna comuna=new Comuna(getComunaId(),getComunaNombre());
//        comunaDAO comunaDAO=new comunaDAO();
//        comunaDAO.;
//    }
    public void deleteComuna(){
        Comuna comuna=new Comuna(getComunaId(),getComunaNombre());
        comunaDAO comunaDAO=new comunaDAO();
        comunaDAO.deleteComuna(comuna.getComunaId(),comuna.getComunaNombre());
        comunaId=0;
        comunaNombre=null;
    }
    public int getComunaId() {
        return comunaId;
    }
    public void setComunaId(int comunaId) {
        this.comunaId = comunaId;
    }
    public String getComunaNombre() {
        return comunaNombre;
    }
    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }
}
