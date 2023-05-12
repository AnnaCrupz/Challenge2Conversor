package modelo;

public interface Conversiones {
	public void Opcion();
	public String Menu();
	public Double ingresaValor(String tipo);
	public void  funcionConvertir(String tipo, Double valor);
	public void ventanaResultado(String tipo, Double valor, String gConvertir, Double resultado, String gConvertido);
}
