package com.gj.OpenXava.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicación.
 *
 * Con Facturacion Studio/Eclipse: Botón derecho del ratón > Run As > Java Application
 */

public class Facturacion {

	public static void main(String[] args) throws Exception {
		DBServer.start("Facturacion-db"); // Para usar tu propia base de datos comenta esta línea y configura src/main/webapp/META-INF/context.xml
		AppServer.run("OpenXava");
    }

}
