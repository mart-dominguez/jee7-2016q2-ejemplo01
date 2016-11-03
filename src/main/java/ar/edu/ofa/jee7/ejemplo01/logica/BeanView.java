/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.ejemplo01.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

/**
 *
 * @author martdominguez
 */
@ViewScoped
@GenerarTextoVista
public class BeanView implements GenerarTexto, Serializable{
  private String textoGenerado;
  private String fechaBean;

    @PostConstruct
    public void init(){
        fechaBean = "[BeanView: "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS").format(new Date())+"]";        
    }
    
    @Override
    public void setTextoGenerado(String texto) {
        this.textoGenerado = texto;
    }

            
    @Override
    public String getTextoGenerado() {
        return textoGenerado;
    }
    @Override
    public String getFechaCreacionBean() {
        return fechaBean;
    }
}
