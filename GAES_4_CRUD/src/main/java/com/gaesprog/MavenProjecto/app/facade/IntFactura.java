/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Factura;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntFactura {
    
    public List<Factura> findAll();
    public Factura findById(long id);
    public void add(Factura Factura);
    public void update(Factura Factura);
    public void delete(Factura Factura);
    
}
