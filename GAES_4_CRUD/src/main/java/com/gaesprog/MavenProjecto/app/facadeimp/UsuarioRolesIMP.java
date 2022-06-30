/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.UsuarioRol;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntUsuarioRol;

/**
 *
 * @author Administrator
 */
public class UsuarioRolesIMP implements IntUsuarioRol {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<UsuarioRol> ListUsuarioRoles = new ArrayList<UsuarioRol>();
    
    @Override
    public List<UsuarioRol> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT UR FROM UsuarioRol UR");
            this.ListUsuarioRoles = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListUsuarioRoles;
    }  
    
    
    @Override
    public UsuarioRol findById(long id) {
        UsuarioRol UsuarioRol=new UsuarioRol();
        try {
            this.entity.getTransaction().begin();
            UsuarioRol=this.entity.find(UsuarioRol.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UsuarioRol;
    }
    
    @Override
    public void add(UsuarioRol UsuarioRol){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(UsuarioRol);
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
    public void update(UsuarioRol UsuarioRol){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(UsuarioRol);
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
    public void delete(UsuarioRol UsuarioRol){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(UsuarioRol);
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

