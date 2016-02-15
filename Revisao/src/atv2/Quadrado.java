package atv2;

public class Quadrado implements CalculaArea {

	private int lado;
	
	public Quadrado(int lado) {
		this.lado = lado;
	}
	
	@Override
	public double calculaArea() {
		return lado * lado;
	}

}
