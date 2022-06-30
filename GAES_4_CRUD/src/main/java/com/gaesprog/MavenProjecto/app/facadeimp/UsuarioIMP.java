/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Usuario;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntUsuario;

/**
 *
 * @author Administrator
 */
public class UsuarioIMP implements IntUsuario {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Usuario> ListUsuario = new ArrayList<Usuario>();
    
    @Override
    public List<Usuario> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT U FROM Usuario U");
            this.ListUsuario = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListUsuario;
    }  
    
    
    @Override
    public Usuario findById(long id) {
        Usuario Usuario=new Usuario();
        try {
            this.entity.getTransaction().begin();
            Usuario=this.entity.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Usuario;
    }
    
    @Override
    public void add(Usuario Usuario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Usuario);
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
    public void update(Usuario Usuario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Usuario);
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
    public void delete(Usuario Usuario){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Usuario);
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

