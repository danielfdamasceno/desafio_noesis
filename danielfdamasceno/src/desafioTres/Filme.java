package desafioTres;

public class Filme {

	private int id;
	private String nome;
	private String genero;
	private double valor;
	
	
	public Filme() {
		super();
	}
	
	public Filme(int id) {
		for(Filme film : Filme.getTodosFilmes()){
			if(film.getId() == id){
				this.id = film.getId();
				this.nome = film.getNome();
				this.genero = film.getGenero();
				this.valor = film.getValor();
				break;
			}
		}	
	}

	public Filme(int id, String nome, String genero, double valor) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.valor = valor;
	}
	
	public static Filme[] getTodosFilmes(){
		Filme[] filmes = new Filme[6];
		filmes[0] = new Filme(1,"Senhor dos Aneis","Fantasia",45.00);
		filmes[1] = new Filme(2,"As Branquelas","Comedia",56.00);
		filmes[2] = new Filme(3,"Velozer e Furiosos 7","Acao",100.00);
		filmes[3] = new Filme(4,"Velozer e Furiosos 6","Acao",55.00);
		filmes[4] = new Filme(5,"The Scapegoat","Drama",100.00);
		filmes[5] = new Filme(6,"Meu Malvado Favorito","Animacao",200.00);
		return filmes;
	}
	
 	
	// GETTERS E SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
