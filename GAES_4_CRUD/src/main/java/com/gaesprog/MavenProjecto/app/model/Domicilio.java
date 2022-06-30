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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "domicilios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilios.findAll", query = "SELECT d FROM Domicilios d")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Domicilio")
    private Integer idDomicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Producto")
    private String producto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefono")
    private Set<Domiciliario> domiciliarioSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nOPedido")
    private Set<Pedido> pedidosSet;
    @JoinColumn(name = "NO_Domicilio", referencedColumnName = "id_Reporte")
    @ManyToOne(optional = false)
    private Reporte nODomicilio;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio(Integer idDomicilio, String producto, int cantidad, int precio) {
        this.idDomicilio = idDomicilio;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Set<Domiciliario> getDomiciliarioSet() {
        return domiciliarioSet;
    }

    public void setDomiciliarioSet(Set<Domiciliario> domiciliarioSet) {
        this.domiciliarioSet = domiciliarioSet;
    }

    @XmlTransient
    public Set<Pedido> getPedidosSet() {
        return pedidosSet;
    }

    public void setPedidosSet(Set<Pedido> pedidosSet) {
        this.pedidosSet = pedidosSet;
    }

    public Reporte getNODomicilio() {
        return nODomicilio;
    }

    public void setNODomicilio(Reporte nODomicilio) {
        this.nODomicilio = nODomicilio;
    }

    @Override
    public String toString() {
        return "com.gaesprog.MavenProjecto.app.model.Domicilios[ idDomicilio=" + idDomicilio + " ]";
    }
    
}
