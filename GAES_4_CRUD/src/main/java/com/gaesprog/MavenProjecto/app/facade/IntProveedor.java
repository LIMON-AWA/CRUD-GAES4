/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Proveedor;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntProveedor {
    
    public List<Proveedor> findAll();
    public Proveedor findById(long id);
    public void add(Proveedor Proveedore);
    public void update(Proveedor Proveedore);
    public void delete(Proveedor Proveedore);
    
}
