package com.gj.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter @Setter
@View(members =
"anyo, numero, fecha;" +
"cliente;" +
"detalles;" +
"observaciones")

@View(name="Simple",
        members="numero, nombre")
public class Factura {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;

    @Column(length = 6)
    @DefaultValueCalculator(value = CurrentYearCalculator.class, properties=@PropertyValue(name="anyo"))
    int numero;

    @Column(length = 4)
    @DefaultValueCalculator(CurrentDateCalculator.class)
    LocalDate fecha;

    @TextArea
    String observaciones;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @ReferenceView("Simple")
    Cliente cliente;
}
