package modelo;
	import java.text.DecimalFormat;
	import javax.swing.JOptionPane;
public class Longitud implements Conversiones {

	public void Opcion() {
		String tipo=Menu();
		Double valor=ingresaValor(tipo);
		funcionConvertir(tipo,valor);
	}

	public String Menu() {
		return JOptionPane.showInputDialog(null, "Seleccione un tipo de conversion", "Convertir Longitud",
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Centimetros a Metros", 
                		"Centimetros a Kilometros",
                		"Centimetros a Millas",
                		"Metros a Centimetros",
                		"Metros a Kilometros",
                		"Metros a Millas",
                		"Kilometros a Centimetros",
                		"Kilometros a Metros",
                		"Kilometros a Millas",
                		"Millas a Centimetros",
                		"Millas a Metros",
                		"Millas a Kilometros"}, "Centimetros a Metros").toString();
	}

	public Double ingresaValor(String tipo) {
		double valorNumerico=0; 
		boolean retry=true;
		while(retry) {
			String valor=JOptionPane.showInputDialog(null, "Ingresa el valor a convertir (Debe ser un numero)", "Convetir " + tipo, JOptionPane.PLAIN_MESSAGE);
			
		try {	
			double num=Double.parseDouble(valor);
				if (num>=0) {
					valorNumerico = Double.parseDouble(valor);
					retry=false;
				}
	         	
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "El valor ingresado no es valido, intentalo nuevamente!", "Error de conversion", JOptionPane.ERROR_MESSAGE);
	        	retry=true;
	        }
		}
		return valorNumerico;
	}
	

	public void funcionConvertir(String tipo, Double valor) {
		double resultConversion;
		switch(tipo){
		case "Centimetros a Metros":
			resultConversion=valor*0.01;
			ventanaResultado(tipo,valor, "cm", resultConversion,"m");
			break;
		case "Centimetros a Kilometros":
			resultConversion=valor*0.00001;
			ventanaResultado(tipo,valor, "cm", resultConversion,"km");
			break;
		case "Centimetros a Millas":
			resultConversion=valor/160900;
			ventanaResultado(tipo,valor, "cm", resultConversion,"mi");
			break;
		case "Metros a Centimetros":
			resultConversion=valor*100;
			ventanaResultado(tipo,valor, "m", resultConversion,"cm");
			break;
		case "Metros a Kilometros":
			resultConversion=valor*0.001;
			ventanaResultado(tipo,valor, "m", resultConversion,"km");
			break;
		case "Metros a Millas":
			resultConversion=valor/1609;
			ventanaResultado(tipo,valor, "m", resultConversion,"mi");
			break;
		case "Kilometros a Centimetros":
			resultConversion=valor*100000;
			ventanaResultado(tipo,valor, "km", resultConversion,"cm");
			break;
		case "Kilometros a Metros":
			resultConversion=valor*1000;
			ventanaResultado(tipo,valor, "km", resultConversion,"m");
			break;
		case "Kilometros a Millas":
			resultConversion=valor*0.621371192;
			ventanaResultado(tipo,valor, "km", resultConversion,"mi");
			break;
		case "Millas a Centimetros":
			resultConversion=valor*160934.4;
			ventanaResultado(tipo,valor, "mi", resultConversion,"cm");
			break;
		case "Millas a Metros":
			resultConversion=valor*1609.344;
			ventanaResultado(tipo,valor, "mi", resultConversion,"m");
			break;
		case "Millas a Kilometros":
			resultConversion=valor*1.609344;
			ventanaResultado(tipo,valor, "m", resultConversion,"mi");
			break;
		}
		
	}

	@Override
	public void ventanaResultado(String tipo, Double valor, String gConvertir, Double resultado, String gConvertido) {
		DecimalFormat df = new DecimalFormat("#.########");
		 JOptionPane.showMessageDialog(null, "La cantidad de " + valor + " "+gConvertir + " son " + df.format(resultado) +" "+ gConvertido, "Conversión "+tipo, JOptionPane.PLAIN_MESSAGE);

		
	}
    
}