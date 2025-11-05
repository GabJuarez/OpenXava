package com.gj.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.ListProperties;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Embeddable @Getter @Setter
public class Detalle {
    int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Producto producto;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;
}
