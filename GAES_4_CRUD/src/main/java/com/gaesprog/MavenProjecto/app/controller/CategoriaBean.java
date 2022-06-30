/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.controller;

import com.gaesprog.MavenProjecto.app.facadeimp.CategoriaIMP;
import com.gaesprog.MavenProjecto.app.model.Categoria;
import com.gaesprog.MavenProjecto.app.utilities.ExportarCategoria;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped

public class CategoriaBean implements Serializable{
    Categoria Categoria=new Categoria();
    
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private List<Categoria> listCategoria=new ArrayList<Categoria>();

    public CategoriaBean() {
    }

    public Categoria getCliente() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Categoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }
    
    public List<Categoria> findAll(){
        try {
            CategoriaIMP CategoriaIMP=new CategoriaIMP();
            this.listCategoria=CategoriaIMP.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCategoria;
    }
    
    public String update(long idCategoria){
        CategoriaIMP CategoriaIMP=new CategoriaIMP();
        Categoria Categoriaupdate=new Categoria();
        Categoriaupdate=CategoriaIMP.findById(idCategoria);
        sessionMap.put("Categoria", Categoriaupdate);
        return "CategoriaUpdate.xhtml?faces-redirect=true";
    }
    
    public String actualizar(Categoria Categoria){
        CategoriaIMP CategoriaIMP=new CategoriaIMP();
        CategoriaIMP.update(Categoria);
        return "CategoriaList.xhtml?faces-redirect=true";
    }
    
    public String delete(Categoria Categoria){
        CategoriaIMP CategoriaIMP=new CategoriaIMP();
        CategoriaIMP.delete(Categoria);
        return "CategoriaList.xhtml?faces-redirect=true";
    }
    
    public String save(){
        CategoriaIMP CategoriaIMP=new CategoriaIMP();
        CategoriaIMP.add(Categoria);
        return "CategoriaList.xhtml?faces-redirect=true";
    }
    
    public void exportar() throws IOException{
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	String currentDateTime = dateFormatter.format(new Date());
	String headerKey = "Content-Disposition";
	String headerValue = "attachment; filename=listaCategoria_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        ExportarCategoria excelExporter = new ExportarCategoria(this.listCategoria);
        excelExporter.export(response);
    }
}