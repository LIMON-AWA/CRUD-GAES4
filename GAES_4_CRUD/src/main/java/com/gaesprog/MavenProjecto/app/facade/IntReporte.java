/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Reporte;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntReporte {
    
    public List<Reporte> findAll();
    public Reporte findById(long id);
    public void add(Reporte Reporte);
    public void update(Reporte Reporte);
    public void delete(Reporte Reporte);
    
}
