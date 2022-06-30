/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Domiciliario;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntDomiciliario {
    
    public List<Domiciliario> findAll();
    public Domiciliario findById(long id);
    public void add(Domiciliario Domiciliario);
    public void update(Domiciliario Domiciliario);
    public void delete(Domiciliario Domiciliario);
}
