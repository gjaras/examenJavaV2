/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.Beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="postulacionBean")
@SessionScoped
public class postulacionBean implements Serializable{

     private String postulanteRut;
     private String postulanteDv;
     private String nombre;
     private String appPat;
     private String appMat;
     private String fecNac;
     
     public String insertPostulacion(){
         return "";
     }

    /**
     * @return the postulanteRut
     */
    public String getPostulanteRut() {
        return postulanteRut;
    }

    /**
     * @param postulanteRut the postulanteRut to set
     */
    public void setPostulanteRut(String postulanteRut) {
        this.postulanteRut = postulanteRut;
    }

    /**
     * @return the postulanteDv
     */
    public String getPostulanteDv() {
        return postulanteDv;
    }

    /**
     * @param postulanteDv the postulanteDv to set
     */
    public void setPostulanteDv(String postulanteDv) {
        this.postulanteDv = postulanteDv;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the appPat
     */
    public String getAppPat() {
        return appPat;
    }

    /**
     * @param appPat the appPat to set
     */
    public void setAppPat(String appPat) {
        this.appPat = appPat;
    }

    /**
     * @return the appMat
     */
    public String getAppMat() {
        return appMat;
    }

    /**
     * @param appMat the appMat to set
     */
    public void setAppMat(String appMat) {
        this.appMat = appMat;
    }

    /**
     * @return the fecNac
     */
    public String getFecNac() {
        return fecNac;
    }

    /**
     * @param fecNac the fecNac to set
     */
    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }

}
