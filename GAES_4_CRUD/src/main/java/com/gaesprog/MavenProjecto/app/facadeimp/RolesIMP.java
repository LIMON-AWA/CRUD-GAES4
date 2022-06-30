/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Rol;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntRol;

/**
 *
 * @author Administrator
 */
public class RolesIMP implements IntRol {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Rol> ListRoles = new ArrayList<Rol>();
    
    @Override
    public List<Rol> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT RO FROM Rol RO");
            this.ListRoles = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListRoles;
    }  
    
    
    @Override
    public Rol findById(long id) {
        Rol Rol=new Rol();
        try {
            this.entity.getTransaction().begin();
            Rol=this.entity.find(Rol.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Rol;
    }
    
    @Override
    public void add(Rol Rol){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Rol);
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
    public void update(Rol Rol){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Rol);
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
    public void delete(Rol Rol){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Rol);
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

