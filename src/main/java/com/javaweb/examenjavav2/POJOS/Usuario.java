package com.javaweb.examenjavav2.POJOS;
// Generated Jun 26, 2018 12:16:12 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int usuarioId;
     private String usuarioNombre;
     private String usuarioPass;
     private char usuarioRoladm;

    public Usuario() {
    }
    
    public Usuario(String usuarioNombre, String usuarioPass) {
       this.usuarioNombre = usuarioNombre;
       this.usuarioPass = usuarioPass;
    }

    public Usuario(int usuarioId, String usuarioNombre, String usuarioPass, char usuarioRoladm) {
       this.usuarioId = usuarioId;
       this.usuarioNombre = usuarioNombre;
       this.usuarioPass = usuarioPass;
       this.usuarioRoladm = usuarioRoladm;
    }
   
    public int getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getUsuarioNombre() {
        return this.usuarioNombre;
    }
    
    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
    public String getUsuarioPass() {
        return this.usuarioPass;
    }
    
    public void setUsuarioPass(String usuarioPass) {
        this.usuarioPass = usuarioPass;
    }
    public char getUsuarioRoladm() {
        return this.usuarioRoladm;
    }
    
    public void setUsuarioRoladm(char usuarioRoladm) {
        this.usuarioRoladm = usuarioRoladm;
    }




}

