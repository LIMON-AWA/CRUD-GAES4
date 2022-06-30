/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.UsuarioRol;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntUsuarioRol {
    public List<UsuarioRol> findAll();
    public UsuarioRol findById(long id);
    public void add(UsuarioRol UsuarioRol);
    public void update(UsuarioRol UsuarioRol);
    public void delete(UsuarioRol UsuarioRol);
}
