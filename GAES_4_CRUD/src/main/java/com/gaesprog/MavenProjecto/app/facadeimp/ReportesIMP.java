/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Reporte;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntReporte;

/**
 *
 * @author Administrator
 */
public class ReportesIMP implements IntReporte {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Reporte> ListReporte = new ArrayList<Reporte>();
    
    @Override
    public List<Reporte> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT R FROM Reporte R");
            this.ListReporte = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListReporte;
    }  
    
    
    @Override
    public Reporte findById(long id) {
        Reporte Reporte=new Reporte();
        try {
            this.entity.getTransaction().begin();
            Reporte=this.entity.find(Reporte.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Reporte;
    }
    
    @Override
    public void add(Reporte Reporte){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Reporte);
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
    public void update(Reporte Reporte){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Reporte);
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
    public void delete(Reporte Reporte){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Reporte);
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
