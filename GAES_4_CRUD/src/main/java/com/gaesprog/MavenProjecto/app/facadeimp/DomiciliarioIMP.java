/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Domiciliario;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntDomiciliario;

/**
 *
 * @author Administrator
 */
public class DomiciliarioIMP implements IntDomiciliario {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Domiciliario> ListDomiciliario = new ArrayList<Domiciliario>();
    
    @Override
    public List<Domiciliario> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT D FROM Domiciliario D");
            this.ListDomiciliario = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListDomiciliario;
    }  
    
    
    @Override
    public Domiciliario findById(long id) {
        Domiciliario Domiciliario=new Domiciliario();
        try {
            this.entity.getTransaction().begin();
            Domiciliario=this.entity.find(Domiciliario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Domiciliario;
    }
    
    @Override
    public void add(Domiciliario Domiciliario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Domiciliario);
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
    public void update(Domiciliario Domiciliario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Domiciliario);
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
    public void delete(Domiciliario Domiciliario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Domiciliario);
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
