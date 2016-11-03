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
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

/**
 *
 * @author martdominguez
 */
@ConversationScoped
@GenerarTextoConv
public class BeanConversacion implements Serializable, GenerarTexto{
    @Inject Conversation conv;

 private String textoGenerado;
  private String fechaBean;

    @PostConstruct
    public void init(){        
        fechaBean = "[BeanConversacion: "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS").format(new Date())+"]";        
    }
    @Override
    public void setTextoGenerado(String texto) {
        this.textoGenerado = texto;
    }

            
    @Override
    public String getTextoGenerado() {
        return textoGenerado;
    }
    
    public void iniciarConversacion(){
        fechaBean +="conv iniciada - "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS").format(new Date())+"-";
        conv.begin();        
    }

    public void terminarConversacion(){
        fechaBean +="conv terminada- "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS").format(new Date())+"-";
        conv.end();
    }
    
    @Override
    public String getFechaCreacionBean() {        
        return conv.isTransient()+fechaBean;
    }


}
