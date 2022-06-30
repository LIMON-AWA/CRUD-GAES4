/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "usuario_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRoles.findAll", query = "SELECT u FROM UsuarioRoles u")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "US_Rol")
    private Integer uSRol;
    @JoinColumn(name = "Fk_No_Rol", referencedColumnName = "No_Rol")
    @ManyToOne(optional = false)
    private Rol fkNoRol;
    @JoinColumn(name = "Fk_Usuario", referencedColumnName = "Id")
    @ManyToOne
    private Usuario fkUsuario;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer uSRol) {
        this.uSRol = uSRol;
    }

    public Integer getUSRol() {
        return uSRol;
    }

    public void setUSRol(Integer uSRol) {
        this.uSRol = uSRol;
    }

    public Rol getFkNoRol() {
        return fkNoRol;
    }

    public void setFkNoRol(Rol fkNoRol) {
        this.fkNoRol = fkNoRol;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public String toString() {
        return "com.gaesprog.MavenProjecto.app.model.UsuarioRoles[ uSRol=" + uSRol + " ]";
    }
    
}
