/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Pedido;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntPedido;

/**
 *
 * @author Administrator
 */
public class PedidosIMP implements IntPedido {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Pedido> ListPedido = new ArrayList<Pedido>();
    
    @Override
    public List<Pedido> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT P FROM Pedido P");
            this.ListPedido = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListPedido;
    }  
    
    
    @Override
    public Pedido findById(long id) {
        Pedido Pedido=new Pedido();
        try {
            this.entity.getTransaction().begin();
            Pedido=this.entity.find(Pedido.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Pedido;
    }
    
    @Override
    public void add(Pedido Pedido){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Pedido);
            this.entity.getTransaction().commit();
        } catch (Exception e){
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
    }
    
    @Override
    public void update(Pedido Pedido){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Pedido);
            this.entity.getTransaction().commit();
        } catch (Exception e){
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
    }
    
    @Override
    public void delete(Pedido Pedido){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Pedido);
            this.entity.getTransaction().commit();
        } catch (Exception e){
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
    }
    }
