package atv2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public Main() {
		
	}
	
	public static void main(String[] args) {
		
		List<CalculaArea> formas = new ArrayList<CalculaArea>();
				
		CalculaArea forma1 = new Triangulo(2, 2);
		CalculaArea forma2 = new Circulo(2);
		CalculaArea forma3 = new Quadrado(2);
		CalculaArea forma4 = new Retangulo(2, 2);
		
		formas.add(forma1);
		formas.add(forma2);
		formas.add(forma3);
		formas.add(forma4);
		
		for (CalculaArea forma : formas) {
			System.out.println(forma.calculaArea());
		}
	}
	
}
