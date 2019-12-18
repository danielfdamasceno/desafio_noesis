package desafioTres;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TesteTdd {
	
//	Id Filme	Nome filme	          Genero	R$
	//	1	        Senhor dos Aneis	  fantasia	45,00
	//	2	        As Branquelas	      comedia	56,00
	//	3	        Velozer e Furiosos 7  Ação	    100
	//	4	        Velozer e Furiosos 6  Ação	    55
	//	5	        The Scapegoat	      Drama     100
	//	6	        Meu Malvado favorito  animação	200 


	@InjectMocks
	ControleLoja controle = new ControleLoja();

	@Before
	public void iniciar() throws Exception {
		controle = new ControleLoja();
	}

	/**
	 * Acima de 100 e abaixo de 200 = > 10%
	 */
	@Test
	public void testeDescontoDez() {
		int[] idsfilmes = { 2, 5 };
		double valorInicial = calculaValorInicial(idsfilmes);
		double valorFinal = controle.calcularPrecoFinal(idsfilmes);
		assertTrue(10 == Math.round(getDescontoAplicado(valorInicial, valorFinal)));
	}

	/**
	 * Acima de 100 e abaixo de 200 = > 10% + 5% (Acao)
	 */
	@Test
	public void testeDescontoQuinze() {
		int[] idsfilmes = { 2, 3 };
		double valorInicial = calculaValorInicial(idsfilmes);
		double valorFinal = controle.calcularPrecoFinal(idsfilmes);
		assertTrue(15 == Math.round(getDescontoAplicado(valorInicial, valorFinal)));
	}

	/**
	 * Acima de 200 e abaixo de 300 = > 20%
	 */
	@Test
	public void testeDescontoVinte() {
		int[] idsfilmes = { 5, 6 };
		double valorInicial = calculaValorInicial(idsfilmes);
		double valorFinal = controle.calcularPrecoFinal(idsfilmes);
		assertTrue(20 == Math.round(getDescontoAplicado(valorInicial, valorFinal)));
	}

	/**
	 * Acima de 300 e abaixo de 400 = > 20% + 5% (Acao)
	 */
	@Test
	public void testeDescontoVinteCinco() {
		int[] idsfilmes = { 4, 6 };
		double valorInicial = calculaValorInicial(idsfilmes);
		double valorFinal = controle.calcularPrecoFinal(idsfilmes);
		assertTrue(25 == Math.round(getDescontoAplicado(valorInicial, valorFinal)));
	}

	/**
	 * Acima de 400 = > 30%
	 */
	@Test
	public void testeDescontoTrinta() {
		int[] idsfilmes = { 1, 2, 5, 6 };
		double valorInicial = calculaValorInicial(idsfilmes);
		double valorFinal = controle.calcularPrecoFinal(idsfilmes);
		assertTrue(30 == Math.round(getDescontoAplicado(valorInicial, valorFinal)));
	}
	
	/**
	 * Acima de 400 = > 30% + 5% (Acao)
	 */
	@Test
	public void testeDescontoTrintaCinco() {
		int[] idsfilmes = { 1, 2, 4, 5, 6};
		double valorInicial = calculaValorInicial(idsfilmes);
		double valorFinal = controle.calcularPrecoFinal(idsfilmes);
		assertTrue(35 == Math.round(getDescontoAplicado(valorInicial, valorFinal)));
	}

	private double getDescontoAplicado(double valorInicial, double valorFinal) {
		double diferenca = valorInicial - valorFinal;
		return (diferenca * 100) / valorInicial;
	}

	private double calculaValorInicial(int[] idsfilmes) {
		double valorTotal = 0;
		for (int id : idsfilmes) {
			Filme filme = new Filme(id);
			valorTotal += filme.getValor();
		}
		return valorTotal;
	}

}
