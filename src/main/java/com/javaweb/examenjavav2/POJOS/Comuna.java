package com.javaweb.examenjavav2.POJOS;
// Generated Jul 3, 2018 12:12:34 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Comuna generated by hbm2java
 */
public class Comuna  implements java.io.Serializable {


     private int comunaId;
     private String comunaNombre;
     private Set postulantes = new HashSet(0);

    public Comuna() {
    }

	
    public Comuna(int comunaId, String comunaNombre) {
        this.comunaId = comunaId;
        this.comunaNombre = comunaNombre;
    }
    public Comuna(int comunaId, String comunaNombre, Set postulantes) {
       this.comunaId = comunaId;
       this.comunaNombre = comunaNombre;
       this.postulantes = postulantes;
    }
   
    public int getComunaId() {
        return this.comunaId;
    }
    
    public void setComunaId(int comunaId) {
        this.comunaId = comunaId;
    }
    public String getComunaNombre() {
        return this.comunaNombre;
    }
    
    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }
    public Set getPostulantes() {
        return this.postulantes;
    }
    
    public void setPostulantes(Set postulantes) {
        this.postulantes = postulantes;
    }




}


