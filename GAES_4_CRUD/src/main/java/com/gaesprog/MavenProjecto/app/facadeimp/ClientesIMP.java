/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.facadeimp;

import com.gaesprog.MavenProjecto.app.model.Cliente;
import com.gaesprog.MavenProjecto.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.gaesprog.MavenProjecto.app.facade.IntCliente;

/**
 *
 * @author Administrator
 */
public class ClientesIMP implements IntCliente {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    List<Cliente> ListCliente = new ArrayList<Cliente>();
    
    @Override
    public List<Cliente> findAll() {
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT cl FROM Cliente cl");
            this.ListCliente = q.getResultList();
        } catch(Exception e) {
            JPAUtil.shutdown();
        } finally {
            if (this.entity != null){
                //JPAUtil.shutdown();
            }
        }
        return this.ListCliente;
    }  
    
    
    @Override
    public Cliente findById(long id) {
        Cliente cliente=new Cliente();
        try {
            this.entity.getTransaction().begin();
            cliente=this.entity.find(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    @Override
    public void add(Cliente Cliente){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Cliente);
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
    public void update(Cliente Cliente){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Cliente);
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
    public void delete(Cliente Cliente){
        try{
            this.entity.getTransaction().begin();
            this.entity.persist(Cliente);
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