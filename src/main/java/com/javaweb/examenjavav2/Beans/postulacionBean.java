/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.examenjavav2.Beans;

import com.javaweb.examenjavav2.DAO.postulacionDAO;
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
     private char postulanteEnfermedad;
     
    //Agregar Postulante
    public String addPostulante() throws ParseException{
        Postulante p = new Postulante (getPostulanteRut(), getComuna(), getEducacion(), getEstadocivil(), getRenta(),getPostulanteDv(), getPostulanteNombre(), getPostulanteApepa(), getPostulanteApema(), getPostulanteFecnac(), getPostulanteSexo(), getPostulanteHijos(), getPostulanteTelefono(), getPostulanteEmail(), getPostulanteDireccion(), getPostulanteSueldo(), getPostulanteEnfermedad());
        postulacionDAO pd = new postulacionDAO();
        pd.addPostulante(p);
        return "ListPostulante";
    }
    //Update Postulante
    public void updatePostulante() throws ParseException {
        ///////////////////////////////String postulanteRut, Comuna comuna, Educacion educacion, Estadocivil estadocivil, Renta renta, char postulanteDv, String postulanteApepa, String postulanteApema, Date postulanteFecnac, char postulanteSexo, int postulanteHijos, int postulanteTelefono, String postulanteEmail, String postulanteDireccion, int postulanteSueldo, char postulanteEnfermedad
        Postulante p = new Postulante (getPostulanteRut(), getComuna(), getEducacion(), getEstadocivil(), getRenta(),getPostulanteDv(), getPostulanteNombre(), getPostulanteApepa(), getPostulanteApema(), getPostulanteFecnac(), getPostulanteSexo(), getPostulanteHijos(), getPostulanteTelefono(), getPostulanteEmail(), getPostulanteDireccion(), getPostulanteSueldo(), getPostulanteEnfermedad());
        postulacionDAO pd = new postulacionDAO();
        pd.updatePostulante(p);
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
        setPostulanteEnfermedad(pos.getPostulanteEnfermedad());
        
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
            String json = "{\"postulante_rut\":\""+p.getPostulanteRut()+"\",\"postulante_nombre\":\""+p.getPostulanteNombre()+"\",\"postulante_apepa\":\""+p.getPostulanteApepa()+"\",\"postulante_apema\":\""+p.getPostulanteApema()+"\",\"postulante_fecnac\":\""+p.getPostulanteFecnac()+"\",\"postulante_sexo\":\""+p.getPostulanteSexo()+"\",\"postulante_hijos\":\""+p.getPostulanteHijos()+"\",\"postulante_telefono\":\""+p.getPostulanteTelefono()+"\",\"postulante_email\":\""+p.getPostulanteEmail()+"\",\"postulante_direccion\":\""+p.getPostulanteDireccion()+"\",\"postulante_sueldo\":\""+p.getPostulanteSueldo()+"\",\"postulante_enfermedad\":\""+p.getPostulanteEnfermedad()+"\",\"educacion_educacion_id\":\""+p.getEducacion()+"\",\"estadocivil_estadocivil_id\":\""+p.getEstadocivil()+"\",\"comuna_comuna_id\":\""+p.getComuna()+"\",\"renta_renta_id\":\""+p.getRenta()+"\"}";
            agregar.setValue(json);
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
            String json = "{\"comuna_id\":\""+p.getComunaId()+"\",\"comuna_nombre\":\""+p.getComunaNombre()+"\"}";
            agregar.setValue(json);
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
            String json = "{\"educacion_id\":\""+p.getEducacionId()+"\",\"educacion_nombre\":\""+p.getEducacionTipo()+"\"}";
            agregar.setValue(json);
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
            String json = "{\"estadocivil_id\":\""+p.getEstadocivilId()+"\",\"estadocivil_tipo\":\""+p.getEstadocivilTipo()+"\"}";
            agregar.setValue(json);
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
            String json = "{\"renta_id\":\""+p.getRentaId()+"\",\"renta_tipo\":\""+p.getRentaTipo()+"\"}";
            agregar.setValue(json);
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

    public String getPostulanteNombre() {
        return postulanteNombre;
    }

    public void setPostulanteNombre(String postulanteNombre) {
        this.postulanteNombre = postulanteNombre;
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

    public char getPostulanteEnfermedad() {
        return postulanteEnfermedad;
    }

    public void setPostulanteEnfermedad(char postulanteEnfermedad) {
        this.postulanteEnfermedad = postulanteEnfermedad;
    }


    
}
