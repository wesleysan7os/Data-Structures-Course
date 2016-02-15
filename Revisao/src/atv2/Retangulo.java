package atv2;

public class Retangulo implements CalculaArea {

	private int base;
	private int altura;
	
	public Retangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double calculaArea() {
		return base*altura;
	}

}
