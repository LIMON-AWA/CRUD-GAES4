/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "domiciliario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domiciliario.findAll", query = "SELECT d FROM Domiciliario d")})
public class Domiciliario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_domiciliario")
    private Integer iddomiciliario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo")
    private String correo;
    @JoinColumn(name = "Telefono", referencedColumnName = "Id_Domicilio")
    @ManyToOne(optional = false)
    private Domicilio telefono;

    public Domiciliario() {
    }

    public Domiciliario(Integer iddomiciliario) {
        this.iddomiciliario = iddomiciliario;
    }

    public Domiciliario(Integer iddomiciliario, String nombre, String apellido, String correo) {
        this.iddomiciliario = iddomiciliario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Integer getIddomiciliario() {
        return iddomiciliario;
    }

    public void setIddomiciliario(Integer iddomiciliario) {
        this.iddomiciliario = iddomiciliario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Domicilio getTelefono() {
        return telefono;
    }

    public void setTelefono(Domicilio telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "com.gaesprog.MavenProjecto.app.model.Domiciliario[ iddomiciliario=" + iddomiciliario + " ]";
    }
    
}
