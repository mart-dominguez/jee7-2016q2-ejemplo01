/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.ejemplo01;

import ar.edu.ofa.jee7.ejemplo01.logica.BeanConversacion;
import ar.edu.ofa.jee7.ejemplo01.logica.GenerarTexto;
import ar.edu.ofa.jee7.ejemplo01.logica.GenerarTextoConv;
import ar.edu.ofa.jee7.ejemplo01.logica.GenerarTextoReq;
import ar.edu.ofa.jee7.ejemplo01.logica.GenerarTextoSes;
import ar.edu.ofa.jee7.ejemplo01.logica.GenerarTextoVista;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mdominguez
 */
@SessionScoped
@Named("ctrlV03")
public class ControllerVista3 implements Serializable{
    private String fechaBean;
    private String fechaOperacionAjax;
    private String fechaOperacionNoAjax;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS");
    
    @Inject 
    private GenerarTexto beanApp;

    @Inject @GenerarTextoSes
    private GenerarTexto beanSes;

    @Inject @GenerarTextoConv
    private GenerarTexto beanConv;

    @Inject @GenerarTextoVista
    private GenerarTexto beanVista;

    @Inject @GenerarTextoReq
    private GenerarTexto beanReq;
    
    @PostConstruct
    public void init(){
        fechaBean = "Bean creado el "+sdf.format(new Date());        
    }

    public String getFechaBean() {
        return fechaBean;
    }

    public void setFechaBean(String fechaBean) {
        this.fechaBean = fechaBean;
    }

    public String getFechaOperacionAjax() {
        return fechaOperacionAjax;
    }

    public void setFechaOperacionAjax(String fechaOperacionAjax) {
        this.fechaOperacionAjax = fechaOperacionAjax;
    }

    public String getFechaOperacionNoAjax() {
        return fechaOperacionNoAjax;
    }

    public void setFechaOperacionNoAjax(String fechaOperacionNoAjax) {
        this.fechaOperacionNoAjax = fechaOperacionNoAjax;
    }
    
    

    public GenerarTexto getBeanApp() {
        return beanApp;
    }

    public void setBeanApp(GenerarTexto beanApp) {
        this.beanApp = beanApp;
    }

    public GenerarTexto getBeanSes() {
        return beanSes;
    }

    public void setBeanSes(GenerarTexto beanSes) {
        this.beanSes = beanSes;
    }

    public GenerarTexto getBeanConv() {
        return beanConv;
    }

    public void setBeanConv(GenerarTexto beanConv) {
        this.beanConv = beanConv;
    }

    public GenerarTexto getBeanVista() {
        return beanVista;
    }

    public void setBeanVista(GenerarTexto beanVista) {
        this.beanVista = beanVista;
    }

    public GenerarTexto getBeanReq() {
        return beanReq;
    }

    public void setBeanReq(GenerarTexto beanReq) {
        this.beanReq = beanReq;
    }
    
    

    public String guardarSinAjax(){
        fechaOperacionNoAjax = "Operacion NO ajax el "+sdf.format(new Date());        
        return null;
    }
    
    public String guardarConAjax(){
        fechaOperacionAjax = "Operacion SI ajax el "+sdf.format(new Date());        
        return null;
    }
    
    public String iniciarConvesacion(){
        ((BeanConversacion) this.beanConv).iniciarConversacion();
        return null;
    }
}
