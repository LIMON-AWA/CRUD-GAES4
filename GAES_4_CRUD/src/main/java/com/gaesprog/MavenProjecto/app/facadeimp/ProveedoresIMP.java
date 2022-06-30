/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Proveedor;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntProveedor;

/**
 *
 * @author Administrator
 */
public class ProveedoresIMP implements IntProveedor {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Proveedor> ListProveedor = new ArrayList<Proveedor>();
    
    @Override
    public List<Proveedor> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT PR FROM Proveedor PR");
            this.ListProveedor = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListProveedor;
    }  
    
    
    @Override
    public Proveedor findById(long id) {
        Proveedor Proveedor=new Proveedor();
        try {
            this.entity.getTransaction().begin();
            Proveedor=this.entity.find(Proveedor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Proveedor;
    }
    
    @Override
    public void add(Proveedor Proveedor){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Proveedor);
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
    public void update(Proveedor Proveedor){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Proveedor);
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
    public void delete(Proveedor Proveedor){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Proveedor);
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
