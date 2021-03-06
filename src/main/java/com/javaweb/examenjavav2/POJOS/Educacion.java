package com.javaweb.examenjavav2.POJOS;
// Generated Jul 3, 2018 12:12:34 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Educacion generated by hbm2java
 */
public class Educacion  implements java.io.Serializable {


     private int educacionId;
     private String educacionTipo;
     private Set postulantes = new HashSet(0);

    public Educacion() {
    }

	
    public Educacion(int educacionId, String educacionTipo) {
        this.educacionId = educacionId;
        this.educacionTipo = educacionTipo;
    }
    public Educacion(int educacionId, String educacionTipo, Set postulantes) {
       this.educacionId = educacionId;
       this.educacionTipo = educacionTipo;
       this.postulantes = postulantes;
    }
   
    public int getEducacionId() {
        return this.educacionId;
    }
    
    public void setEducacionId(int educacionId) {
        this.educacionId = educacionId;
    }
    public String getEducacionTipo() {
        return this.educacionTipo;
    }
    
    public void setEducacionTipo(String educacionTipo) {
        this.educacionTipo = educacionTipo;
    }
    public Set getPostulantes() {
        return this.postulantes;
    }
    
    public void setPostulantes(Set postulantes) {
        this.postulantes = postulantes;
    }




}


