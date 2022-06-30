/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import java.util.List;
import com.gaesprog.MavenProjecto.app.model.Categoria;

/**
 *
 * @author Administrator
 */
public interface IntCategoria {
    
    public List<Categoria> findAll();
    public Categoria findById(long id);
    public void add(Categoria Categoria);
    public void update(Categoria Categoria);
    public void delete(Categoria Categoria);
    
}

