package main;

import javax.swing.JOptionPane;

import modelo.*;


public class MenuOpciones {
	public static void main(String[] args) {
		Seleccion();
		int flujo = continuar();

        if (flujo == 0) {
        	main(args);
        } else {
            Final();
        }
	}

public static void Seleccion(){
	String Opciones=elegirConversor();
	
	switch(Opciones){
		case "Divisas":
			Divisas convDivisas=new Divisas();
			convDivisas.Opcion();
			break;
		case "Longitud":
			Longitud convLongitud=new Longitud();
			convLongitud.Opcion();
			break;
		case "Temperatura":
			Temperatura convTemperatura=new Temperatura();
			convTemperatura.Opcion();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentalo nuevamente!", "Error", JOptionPane.ERROR_MESSAGE);
			Seleccion();
	}
	}
public static String elegirConversor() {
	return JOptionPane.showInputDialog(null, "Seleccione una opcion", "Conversor Alura",
            JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Divisas", "Longitud", "Temperatura"},
            "Divisas").toString();
}
public static int continuar() {
    return JOptionPane.showConfirmDialog(null, "Desea continuar?");
   
}
public static void Final() {

    JOptionPane.showMessageDialog(null, "Programa Finalizado! Gracias por utilizar el conversor. Proyecto creado por Ana Cruz.");
}

}
