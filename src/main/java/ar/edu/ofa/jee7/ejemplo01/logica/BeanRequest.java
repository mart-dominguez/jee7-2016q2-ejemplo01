/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.ejemplo01.logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author martdominguez
 */
@RequestScoped
@GenerarTextoReq
public class BeanRequest implements GenerarTexto{
 private String textoGenerado;
  private String fechaBean;

    @PostConstruct
    public void init(){
        fechaBean = "[BeanRequest: "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS").format(new Date())+"]";        
    }
    @Override
    public void setTextoGenerado(String texto) {
        this.textoGenerado = texto;
    }

            
    @Override
    public String getTextoGenerado() {
        return  textoGenerado;
    }
    
        @Override
    public String getFechaCreacionBean() {
        return fechaBean;
    }

        
}
