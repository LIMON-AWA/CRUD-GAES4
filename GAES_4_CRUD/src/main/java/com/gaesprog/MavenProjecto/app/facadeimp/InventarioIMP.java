/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Inventario;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntInventario;

/**
 *
 * @author Administrator
 */
public class InventarioIMP implements IntInventario {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Inventario> ListInventario = new ArrayList<Inventario>();
    
    @Override
    public List<Inventario> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT I FROM Inventario I");
            this.ListInventario = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListInventario;
    }  
    
    
    @Override
    public Inventario findById(long id) {
        Inventario Inventario=new Inventario();
        try {
            this.entity.getTransaction().begin();
            Inventario=this.entity.find(Inventario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Inventario;
    }
    
    @Override
    public void add(Inventario Inventario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Inventario);
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
    public void update(Inventario Inventario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Inventario);
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
    public void delete(Inventario Inventario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Inventario);
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