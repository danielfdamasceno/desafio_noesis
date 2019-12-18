package desafioTres;

public class ControleLoja {
	
private final int DESCONTO_EXTRA_ACAO = 5; 
	
	public double calcularPrecoFinal(int[] idsfilmes){
		double valorTotal = 0.00;
		for(int id : idsfilmes){
			Filme filme = new Filme(id);
			valorTotal += filme.getValor();
		} 
		
		boolean existeAcao = isExisteFilmeAcao(idsfilmes);
		return calculaDesconto(valorTotal,existeAcao);
	}
	
	private double calculaDesconto(double valor, boolean existeAcao){
		
		double valorDesconto = 0;
		if(valor > 100 && valor <= 200){
			valorDesconto = 10;
		} else if(valor > 200 && valor <= 300){
			valorDesconto = 20;
		} else if(valor > 300 && valor <= 400){
			valorDesconto = 25;
		} else if(valor > 400){
			valorDesconto = 30;
		} else {
			valorDesconto = 0;
		}
		
		if(existeAcao){
			valorDesconto += DESCONTO_EXTRA_ACAO;
		}
		
		return valorDesconto == 0 ? valor : valor - calculaDesconto(valor,valorDesconto);
	}
	
	private static double calculaDesconto(double valor, double desconto){
		return (valor*desconto)/100;
	}
	
	private boolean isExisteFilmeAcao(int[] idsfilmes){
		for(int idFilme : idsfilmes){
			if(idFilme == 3 || idFilme == 4){
				return true;
			}
		}
		return false;
	}

}
