package com.gj.OpenXava.modelo;
import javax.persistence.*;
import org.openxava.annotations.DescriptionsList;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Files;
import org.openxava.annotations.Money;
import org.openxava.annotations.TextArea;

import java.math.BigDecimal;

@Entity
@Getter @Setter
public class Producto {
    @Id @Column(length=9)
    int numero;

    @Column(length=50)
    String descripcion;

    @Money
    BigDecimal precio;

    @Files
    @Column(length=32)
    String fotos;

    @TextArea
    String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties="descripcion")
    Categoria categoria;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;
}
