/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaesprog.MavenProjecto.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Inventario")
    private Integer idInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_Producto")
    private int nOProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cantidad")
    private Set<Venta> ventasSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria1")
    private Set<Producto> productosSet;

    public Inventario() {
    }

    public Inventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Inventario(Integer idInventario, int nOProducto, Date fecha, int cantidad) {
        this.idInventario = idInventario;
        this.nOProducto = nOProducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public int getNOProducto() {
        return nOProducto;
    }

    public void setNOProducto(int nOProducto) {
        this.nOProducto = nOProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Set<Venta> getVentasSet() {
        return ventasSet;
    }

    public void setVentasSet(Set<Venta> ventasSet) {
        this.ventasSet = ventasSet;
    }

    @XmlTransient
    public Set<Producto> getProductosSet() {
        return productosSet;
    }

    public void setProductosSet(Set<Producto> productosSet) {
        this.productosSet = productosSet;
    }

    @Override
    public String toString() {
        return "com.gaesprog.MavenProjecto.app.model.Inventario[ idInventario=" + idInventario + " ]";
    }
    
}
