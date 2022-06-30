/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Producto;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntProducto;

/**
 *
 * @author Administrator
 */
public class ProductosIMP implements IntProducto {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Producto> ListProducto = new ArrayList<Producto>();
    
    @Override
    public List<Producto> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT P FROM Producto P");
            this.ListProducto = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListProducto;
    }  
    
    
    @Override
    public Producto findById(long id) {
        Producto Producto=new Producto();
        try {
            this.entity.getTransaction().begin();
            Producto=this.entity.find(Producto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Producto;
    }
    
    @Override
    public void add(Producto Producto){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Producto);
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
    public void update(Producto Producto){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Producto);
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
    public void delete(Producto Producto){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Producto);
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
