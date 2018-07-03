/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.Beans;

import com.javaweb.examenjavav2.DAO.usuarioDAO;
import com.javaweb.examenjavav2.POJOS.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author tetsu
 */
@Named(value="loginBean")
@SessionScoped

public class loginBean implements Serializable{
    private String nombre ;
    private String password;
    private String message;
    private String isAdmin;
    private boolean doAdmin;

    public String Login(){
        Usuario usu = new Usuario(getNombre(),getPassword());
        usuarioDAO dausu= new usuarioDAO();
        if(dausu.getUsuario(usu)){
            setPassword("");
            System.out.println("User Identified");
            return "Inicio";
        }else{
            setNombre("");
            setPassword("");
            setMessage("User Name or Password are Incorrect");
            return "Login";
        }
        
    }
    
    public String createUsuario(){
        usuarioDAO usd = new usuarioDAO();
        Usuario u = new Usuario(getNombre(), getPassword(), isDoAdmin());
        if(usd.createUsuario(u)){
            setMessage("Usuario fue creado");
        }else{
            setMessage("Usuario no fue creado");
        }
        
        return "Login";
    }
 
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the isAdmin
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the doAdmin
     */
    public boolean isDoAdmin() {
        return doAdmin;
    }

    /**
     * @param doAdmin the doAdmin to set
     */
    public void setDoAdmin(boolean doAdmin) {
        this.doAdmin = doAdmin;
    }
    
    
    
}
