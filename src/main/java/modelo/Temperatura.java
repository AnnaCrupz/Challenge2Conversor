package modelo;
	import java.text.DecimalFormat;
	import javax.swing.JOptionPane;
public class Temperatura implements Conversiones{

	@Override
	public void Opcion() {
		String tipo=Menu();
		Double valor=ingresaValor(tipo);
		funcionConvertir(tipo,valor);
	}

	@Override
	public String Menu() {
		return JOptionPane.showInputDialog(null, "Seleccione un tipo de conversion", "Convertir Temperatura",
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Grados Celsius a Farenheit", 
                		"Grados Celsius a Kelvin",
                		"Grados Farenheit a Celsius",
                		"Grados Farenheit a Kelvin",
                		"Grados Kelvin a Celsius",
                		"Grados Kelvin a Farenheit"}, "Grados Celsius a Farenheit").toString();
	}

	@Override
	public Double ingresaValor(String tipo) {
		double valorNumerico=0; 
		boolean retry=true;
		while(retry) {
			String valor=JOptionPane.showInputDialog(null, "Ingresa el valor a convertir (Debe ser un numero)", "Convetir " + tipo, JOptionPane.PLAIN_MESSAGE);
			
		try {
	         	valorNumerico = Double.parseDouble(valor);
	         	retry=false;
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "El valor ingresado no es valido, intentalo nuevamente!", "Error de conversion", JOptionPane.ERROR_MESSAGE);
	        	retry=true;
	        }
		}
		return valorNumerico;
	}

	@Override
	public void funcionConvertir(String tipo, Double valor) {
		double conversion;
		switch(tipo) {
		case "Grados Celsius a Farenheit":
			conversion=valor * 9 / 5 + 32;
			ventanaResultado(tipo, valor,"°C",conversion,"°F");
			break;
		case "Grados Celsius a Kelvin":
			conversion=valor + 273.15;
			ventanaResultado(tipo, valor,"°C",conversion," K");
			break;
		case "Grados Farenheit a Celsius":
			conversion=(valor - 32) * 5 / 9;
			ventanaResultado(tipo, valor,"°F",conversion,"°C");
			break;
		case "Grados Farenheit a Kelvin":
			conversion=(valor - 32) * 5 / 9 + 273.15;
			ventanaResultado(tipo, valor,"°F",conversion," K");
			break;
		case "Grados Kelvin a Celsius":
			conversion=valor - 272.15;
			ventanaResultado(tipo, valor," K",conversion,"°C");
			break;
		case "Grados Kelvin a Farenheit":
			conversion=(valor - 273.15) * 9 / 5 + 32;
			ventanaResultado(tipo, valor," K",conversion,"°F");
			break;
		}
		
	}

	@Override
	public void ventanaResultado(String tipo, Double valor, String gConvertir, Double resultado, String gConvertido) {
		 DecimalFormat df = new DecimalFormat("#.####");
		 JOptionPane.showMessageDialog(null, "La cantidad de " + valor + gConvertir + " son " + df.format(resultado) + gConvertido, "Conversión "+tipo, JOptionPane.PLAIN_MESSAGE);

		
	}

	
}