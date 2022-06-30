/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Domicilio;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntDomicilio;

/**
 *
 * @author Administrator
 */
public class DomiciliosIMP implements IntDomicilio {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Domicilio> ListDomicilio = new ArrayList<Domicilio>();
    
    @Override
    public List<Domicilio> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT DO FROM Domicilio DO");
            this.ListDomicilio = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListDomicilio;
    }  
    
    
    @Override
    public Domicilio findById(long id) {
        Domicilio Domicilio=new Domicilio();
        try {
            this.entity.getTransaction().begin();
            Domicilio=this.entity.find(Domicilio.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Domicilio;
    }
    
    @Override
    public void add(Domicilio Domicilio){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Domicilio);
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
    public void update(Domicilio Domicilio){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Domicilio);
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
    public void delete(Domicilio Domicilio){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Domicilio);
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