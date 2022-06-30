/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Venta;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntVenta;

/**
 *
 * @author Administrator
 */
public class VentasIMP implements IntVenta {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Venta> ListVentas = new ArrayList<Venta>();
    
    @Override
    public List<Venta> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT V FROM Ventas V");
            this.ListVentas = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListVentas;
    }  
    
    
    @Override
    public Venta findById(long id) {
        Venta Venta=new Venta();
        try {
            this.entity.getTransaction().begin();
            Venta=this.entity.find(Venta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Venta;
    }
    
    @Override
    public void add(Venta Venta){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Venta);
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
    public void update(Venta Venta){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Venta);
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
    public void delete(Venta Venta){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Venta);
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

