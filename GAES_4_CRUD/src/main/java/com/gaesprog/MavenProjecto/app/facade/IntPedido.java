/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facade;

import com.gaesprog.MavenProjecto.app.model.Pedido;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IntPedido {
    
    public List<Pedido> findAll();
    public Pedido findById(long id);
    public void add(Pedido Pedido);
    public void update(Pedido Pedido);
    public void delete(Pedido Pedido);
    
}
