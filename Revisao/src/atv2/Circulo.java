package atv2;

public class Circulo implements CalculaArea {

	private int raio;
	public final double  PI = Math.PI;
	
	public Circulo(int raio) {
		this.raio = raio;
	}

	@Override
	public double calculaArea() {
		return this.raio * PI;
	}

	
	
}
