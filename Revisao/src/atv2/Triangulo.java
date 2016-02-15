package atv2;

public class Triangulo implements CalculaArea  {

	private int base;
	private int altura;
	
	public Triangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double calculaArea() {
		return base*altura/2;
	}
	
	

	
}
