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
            System.out.println("User Name or Password are Incorrect");
            return "Login";
        }
        
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
    
    
    
}
