/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "No_Rol")
    private Integer noRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Rol")
    private String nombreRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkNoRol")
    private Set<UsuarioRol> usuarioRolesSet;

    public Rol() {
    }

    public Rol(Integer noRol) {
        this.noRol = noRol;
    }

    public Rol(Integer noRol, String nombreRol) {
        this.noRol = noRol;
        this.nombreRol = nombreRol;
    }

    public Integer getNoRol() {
        return noRol;
    }

    public void setNoRol(Integer noRol) {
        this.noRol = noRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @XmlTransient
    public Set<UsuarioRol> getUsuarioRolesSet() {
        return usuarioRolesSet;
    }

    public void setUsuarioRolesSet(Set<UsuarioRol> usuarioRolesSet) {
        this.usuarioRolesSet = usuarioRolesSet;
    }
    
    @Override
    public String toString() {
        return "com.gaesprog.MavenProjecto.app.model.Roles[ noRol=" + noRol + " ]";
    }
    
}
