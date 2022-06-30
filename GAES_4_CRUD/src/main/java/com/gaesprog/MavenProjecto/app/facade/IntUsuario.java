/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Usuario;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntUsuario {
    
    public List<Usuario> findAll();
    public Usuario findById(long id);
    public void add(Usuario Usuario);
    public void update(Usuario Usuario);
    public void delete(Usuario Usuario);
    
}
