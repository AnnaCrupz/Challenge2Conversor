package modelo;
	import java.text.DecimalFormat;
	import javax.swing.JOptionPane;
public class Divisas{
public void Opcion() {
	String mensaje = "Data actualizada al 12/05/2023";
	String tipo=Menu();
	Double valor=ingresaValor(tipo);
	funcionConvertir(tipo,valor,mensaje);
}
    
public String Menu() {
       return JOptionPane.showInputDialog(null, "Seleccione un tipo de conversion", "Convertir Divisas",
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Peso Mexicano a Dolar", 
															"Peso Mexicano a Euros",
                    										"Peso Mexicano a Libras Esterlinas", 
															"Peso Mexicano a Yen Japones", 
															"Peso Mexicano a Won sur-coreano",
															"Peso Mexicano a Peso Argentino",
															"Dolar a Peso Mexicano", 
															"Euro a Peso Mexicano", 
															"Libras Esterlinas a Peso Mexicano",
															"Yen Japones a Peso Mexicano",
															"Won sur-coreano a Peso Mexicano",
															"Peso Argentino a Peso Mexicano"}, "Peso Mexicano a Dolar").toString();
    }
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
	public void funcionConvertir(String tipo, Double valor,String mensaje) {
		double cambio;
		TasaDeCambio tasa=new TasaDeCambio();
		switch(tipo) {
		case "Peso Mexicano a Dolar":
			
			try {
				cambio=tasa.convertirDivisa("MXN", "USD", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
				
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=0.568*valor;
			}
			ventanaResultado(tipo,valor,"MXN",cambio, "USD",mensaje);
			break;
		case "Peso Mexicano a Euros":
			try {
				cambio=tasa.convertirDivisa("MXN", "EUR", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=0.0524*valor;
			}
			ventanaResultado(tipo,valor,"MXN",cambio, "EUR",mensaje);
			break;
		case "Peso Mexicano a Libras Esterlinas":
			try {
				cambio=tasa.convertirDivisa("MXN", "GBP", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=0.0456*valor;
			}
			ventanaResultado(tipo,valor,"MXN",cambio, "GBP",mensaje);
			break;
		case "Peso Mexicano a Yen Japones":
			try {
				cambio=tasa.convertirDivisa("MXN", "JPY", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=7.7026*valor;
			}
			ventanaResultado(tipo,valor,"MXN",cambio, "JPY",mensaje);
			break;
		case "Peso Mexicano a Won sur-coreano":
			try {
				cambio=tasa.convertirDivisa("MXN", "KRW", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=76.2295*valor;
			}
			ventanaResultado(tipo,valor,"MXN",cambio, "KRW",mensaje);
			break;
		case "Peso Mexicano a Peso Argentino":
			try {
				cambio=tasa.convertirDivisa("MXN", "ARS", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=13.0255*valor;
			}
			ventanaResultado(tipo,valor,"MXN",cambio, "ARS",mensaje);
			break;
		case "Dolar a Peso Mexicano":
			try {
				cambio=tasa.convertirDivisa("USD", "MXN", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=17.6083*valor;
			}
			ventanaResultado(tipo,valor,"USD",cambio, "MXN",mensaje);
			break;
		case "Euro a Peso Mexicano":
			try {
				cambio=tasa.convertirDivisa("EUR", "MXN", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=19.1004*valor;
			}
			ventanaResultado(tipo,valor,"EUR",cambio, "MXN",mensaje);
			break;
		case "Libras Esterlinas a Peso Mexicano":
			try {
				cambio=tasa.convertirDivisa("GBP", "MXN", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=21.9454*valor;
			}
			ventanaResultado(tipo,valor,"GBP",cambio, "MXN",mensaje);
			break;
		case "Yen Japones a Peso Mexicano":
			try {
			cambio=tasa.convertirDivisa("JPY", "MXN", valor);
			mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
		} catch (Exception e) {
			System.out.println("Error al leer la ApiCambio "+e);
			cambio=0.1298*valor;
		}
			ventanaResultado(tipo,valor,"JPY",cambio, "MXN",mensaje);
			break;
		case "Won sur-coreano a Peso Mexicano":
			try {
				cambio=tasa.convertirDivisa("KRW", "MXN", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=0.0131*valor;
			}
			ventanaResultado(tipo,valor,"KRW",cambio, "MXN",mensaje);
			break;
		case "Peso Argentino a Peso Mexicano":
			try {
				cambio=tasa.convertirDivisa("ARS", "MXN", valor);
				mensaje="Tasas de cambio proporcionadas por exchangesratesapi.io";
			} catch (Exception e) {
				System.out.println("Error al leer la ApiCambio "+e);
				cambio=0.0768*valor;
				
			}
			ventanaResultado(tipo,valor,"ARS",cambio, "MXN",mensaje);
			break;
		}
	}

	public void ventanaResultado(String tipo, Double valor, String gConvertir, Double resultado, String gConvertido, String mensaje) {
		DecimalFormat df = new DecimalFormat("#.########");
		 JOptionPane.showMessageDialog(null, "La cantidad de " + valor + " "+gConvertir + " son " + df.format(resultado) +" "+ gConvertido+"\n \n"+mensaje, "Conversión "+tipo, JOptionPane.PLAIN_MESSAGE);

		
	}


}	