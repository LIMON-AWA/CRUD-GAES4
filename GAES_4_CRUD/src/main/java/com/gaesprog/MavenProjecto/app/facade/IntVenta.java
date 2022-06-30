/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Venta;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntVenta {
    
    public List<Venta> findAll();
    public Venta findById(long id);
    public void add(Venta Venta);
    public void update(Venta Venta);
    public void delete(Venta Venta);
    
}
