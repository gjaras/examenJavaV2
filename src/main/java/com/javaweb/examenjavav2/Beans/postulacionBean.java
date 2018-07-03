/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.Beans;

import com.javaweb.examenjavav2.DAO.postulacionDAO;
import com.javaweb.examenjavav2.DAO.usuarioDAO;
import com.javaweb.examenjavav2.POJOS.Comuna;
import com.javaweb.examenjavav2.POJOS.Educacion;
import com.javaweb.examenjavav2.POJOS.Estadocivil;
import com.javaweb.examenjavav2.POJOS.Postulante;
import com.javaweb.examenjavav2.POJOS.Renta;
import com.javaweb.examenjavav2.POJOS.Usuario;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;


@Named(value="postulacionBean")
@SessionScoped
public class postulacionBean implements Serializable{

   
    
     private String postulanteRut;
     private Comuna comuna;
     private Educacion educacion;
     private Estadocivil estadocivil;
     private Renta renta;
     private char postulanteDv;
     private String postulanteNombre;
     private String postulanteApepa;
     private String postulanteApema;
     private Date postulanteFecnac;
     private char postulanteSexo;
     private int postulanteHijos;
     private int postulanteTelefono;
     private String postulanteEmail;
     private String postulanteDireccion;
     private int postulanteSueldo;
     private boolean postulanteEnfermedad;
     private int usuarioId;
     
    //Agregar Postulante
    public String addPostulante() throws ParseException{
        Usuario  us = new Usuario(getUsuarioId());
        Postulante p = new Postulante (getPostulanteRut(), getComuna(), getEducacion(), getEstadocivil(), getRenta(), us,getPostulanteDv(), getPostulanteNombre(), getPostulanteApepa(), getPostulanteApema(), getPostulanteFecnac(), getPostulanteSexo(), getPostulanteHijos(), getPostulanteTelefono(), getPostulanteEmail(), getPostulanteDireccion(), getPostulanteSueldo(), getPostulanteEnfermedad() ? 's' : 'n');
        postulacionDAO pd = new postulacionDAO();
        pd.addPostulante(p);
        return "ListPostulante";
    }
    //Update Postulante
    public String updatePostulante() throws ParseException {
        Usuario  us = new Usuario(getUsuarioId());
        Postulante p = new Postulante (getPostulanteRut(), getComuna(), getEducacion(), getEstadocivil(), getRenta(), us,getPostulanteDv(), getPostulanteNombre(), getPostulanteApepa(), getPostulanteApema(), getPostulanteFecnac(), getPostulanteSexo(), getPostulanteHijos(), getPostulanteTelefono(), getPostulanteEmail(), getPostulanteDireccion(), getPostulanteSueldo(), getPostulanteEnfermedad() ? 's' : 'n');
        postulacionDAO pd = new postulacionDAO();
        pd.updatePostulante(p);
        return "ListPostulante";
    }
////GET
    
    public String getPostulanteXRut(String rutPostulante){
        postulacionDAO pd = new postulacionDAO();
        Postulante pos = pd.getPostulante(rutPostulante);
        return pos.getPostulanteNombre();
    } 
////GETSAA
    
    public String getPostulante(){
        postulacionDAO pd = new postulacionDAO();
        Postulante pos = pd.getPostulante(getPostulanteRut());
        setPostulanteNombre(pos.getPostulanteNombre());
        setPostulanteRut(pos.getPostulanteRut()); 
        setPostulanteDv(pos.getPostulanteDv());
        setComuna(pos.getComuna());
        setEducacion(pos.getEducacion());
        setEstadocivil(pos.getEstadocivil()); 
        setRenta(pos.getRenta());
        setPostulanteApema(pos.getPostulanteApema());
        setPostulanteApepa(pos.getPostulanteApepa());
        setPostulanteFecnac(pos.getPostulanteFecnac());
        setPostulanteSexo(pos.getPostulanteSexo());
        setPostulanteHijos(pos.getPostulanteHijos());
        setPostulanteTelefono(pos.getPostulanteTelefono());
        setPostulanteDireccion(pos.getPostulanteDireccion());
        setPostulanteEmail(pos.getPostulanteEmail());
        setPostulanteSueldo(pos.getPostulanteSueldo());
        setPostulanteEnfermedad(pos.getPostulanteEnfermedad() == 's');
        
        return "Editar_1.xhtml";
        
    }

//LISTAR
    public SelectItem[] listPostulante(){
        postulacionDAO pt = new postulacionDAO();
        List<Postulante> ptl = pt.listPostulante();
        SelectItem[] ret = new SelectItem[ptl.size()];
        int index = 0;
        for(Postulante p : ptl){
            SelectItem agregar = new SelectItem();
            agregar.setValue(p);
            agregar.setLabel(p.getPostulanteNombre());
            ret[index] = agregar;
            index++;
        }
        
        return ret;
    }
    
    //LISTAR
    public SelectItem[] listComuna(){
        postulacionDAO pt = new postulacionDAO();
        List<Comuna> ptl = pt.listComuna();
        SelectItem[] ret = new SelectItem[ptl.size()];
        int index = 0;
        for(Comuna p : ptl){
            SelectItem agregar = new SelectItem();
            agregar.setValue(p);
            agregar.setLabel(p.getComunaNombre());
            ret[index] = agregar;
            index++;
        }
        
        return ret;
    }
    //LISTAR
    public SelectItem[] listEducacion(){
        postulacionDAO pt = new postulacionDAO();
        List<Educacion> ptl = pt.listEducacion();
        SelectItem[] ret = new SelectItem[ptl.size()];
        int index = 0;
        for(Educacion p : ptl){
            SelectItem agregar = new SelectItem();
            agregar.setValue(p);
            agregar.setLabel(p.getEducacionTipo());
            ret[index] = agregar;
            index++;
        }
        return ret;
    }
     //LISTAR
    public SelectItem[] listEstadoCivil(){
        postulacionDAO pt = new postulacionDAO();
        List<Estadocivil> ptl = pt.listEstadocivil();
        SelectItem[] ret = new SelectItem[ptl.size()];
        int index = 0;
        for(Estadocivil p : ptl){
            SelectItem agregar = new SelectItem();
            agregar.setValue(p);
            agregar.setLabel(p.getEstadocivilTipo());
            ret[index] = agregar;
            index++;
        }
        return ret;
    }
    public SelectItem[] listRenta(){
        postulacionDAO pt = new postulacionDAO();
        List<Renta> ptl = pt.listRenta();
        SelectItem[] ret = new SelectItem[ptl.size()];
        int index = 0;
        for(Renta p : ptl){
            SelectItem agregar = new SelectItem();
            agregar.setValue(p);
            agregar.setLabel(p.getRentaTipo());
            ret[index] = agregar;
            index++;
        }
        return ret;
    }
    
    
    
    public List listPostulantes(){
        postulacionDAO pt = new postulacionDAO();
        List<Postulante> ptl = pt.listPostulante();
        return ptl;
    }
////ELIMINAR
    public void deletePostulante(){
        Postulante p = new Postulante();
        p.setPostulanteRut(getPostulanteRut());
        postulacionDAO pd = new postulacionDAO();
        pd.deletePostulante(p);
    }

   public char getPostulanteDv() {
        return postulanteDv;
    }

    public void setPostulanteDv(char postulanteDv) {
        this.postulanteDv = postulanteDv;
    }

    public String getPostulanteRut() {
        return postulanteRut;
    }

    public void setPostulanteRut(String postulanteRut) {
        this.postulanteRut = postulanteRut;
    }

    public Comuna getComuna() {
        return comuna;
    }
    
    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Educacion getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion educacion) {
        this.educacion = educacion;
    }

    public Estadocivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Estadocivil estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }

    public String getPostulanteApepa() {
        return postulanteApepa;
    }

    public void setPostulanteApepa(String postulanteApepa) {
        this.postulanteApepa = postulanteApepa;
    }

    public String getPostulanteApema() {
        return postulanteApema;
    }

    public void setPostulanteApema(String postulanteApema) {
        this.postulanteApema = postulanteApema;
    }

    public Date getPostulanteFecnac() {
        return postulanteFecnac;
    }

    public void setPostulanteFecnac(Date postulanteFecnac) {
        this.postulanteFecnac = postulanteFecnac;
    }

    public char getPostulanteSexo() {
        return postulanteSexo;
    }

    public void setPostulanteSexo(char postulanteSexo) {
        this.postulanteSexo = postulanteSexo;
    }

    public int getPostulanteHijos() {
        return postulanteHijos;
    }

    public void setPostulanteHijos(int postulanteHijos) {
        this.postulanteHijos = postulanteHijos;
    }

    public int getPostulanteTelefono() {
        return postulanteTelefono;
    }

    public void setPostulanteTelefono(int postulanteTelefono) {
        this.postulanteTelefono = postulanteTelefono;
    }

    public String getPostulanteEmail() {
        return postulanteEmail;
    }

    public void setPostulanteEmail(String postulanteEmail) {
        this.postulanteEmail = postulanteEmail;
    }

    public String getPostulanteDireccion() {
        return postulanteDireccion;
    }

    public void setPostulanteDireccion(String postulanteDireccion) {
        this.postulanteDireccion = postulanteDireccion;
    }

    public int getPostulanteSueldo() {
        return postulanteSueldo;
    }

    public void setPostulanteSueldo(int postulanteSueldo) {
        this.postulanteSueldo = postulanteSueldo;
    }

    public boolean getPostulanteEnfermedad() {
        return postulanteEnfermedad;
    }

    public void setPostulanteEnfermedad(boolean postulanteEnfermedad) {
        this.postulanteEnfermedad = postulanteEnfermedad;
    }

    /**
     * @return the postulanteNombre
     */
    public String getPostulanteNombre() {
        return postulanteNombre;
    }

    /**
     * @param postulanteNombre the postulanteNombre to set
     */
    public void setPostulanteNombre(String postulanteNombre) {
        this.postulanteNombre = postulanteNombre;
    }

    /**
     * @return the usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }


    
}
