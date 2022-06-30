/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Categoria;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntCategoria;

/**
 *
 * @author Administrator
 */
public class CategoriaIMP implements IntCategoria {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Categoria> ListCategoria = new ArrayList<Categoria>();

    @Override
    public List<Categoria> findAll() {
        try {
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT c FROM Categoria c");
            this.ListCategoria = q.getResultList();
        } catch (Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null) {
                //JPAUtil.shutdown();
            }
        }
        return this.ListCategoria;
    }

    @Override
    public Categoria findById(long id) {
        Categoria Categoria=new Categoria();
        try {
            this.entity.getTransaction().begin();
            Categoria=this.entity.find(Categoria.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Categoria;
    }

    @Override
    public void add(Categoria Categoria) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(Categoria);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null) {
                //JPAUtil.shutdown();
            }
        }
    }

    @Override
    public void update(Categoria Categoria) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(Categoria);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null) {
                //JPAUtil.shutdown();
            }
        }
    }

    @Override
    public void delete(Categoria Categoria) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(Categoria);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null) {
                //JPAUtil.shutdown();
            }
        }
    }
}
