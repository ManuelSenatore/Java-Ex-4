package Exercise4;

public class Dipendente {

	private static double stipendioBase = 1000.0;
	private int matricola;
	private String nome;
	private static double stipendio;
	private int importoOrarioStraordinario;
	private static Livello livello;
	private Dipartimento dipartimento;

	public Dipendente(String _nome, int matricola, Dipartimento _dipartimento) {
		this.matricola = matricola;
		nome = _nome;
		dipartimento = _dipartimento;
		setStipendio();
		importoOrarioStraordinario = 30;
		livello = Livello.OPERAIO;

	}

	public Dipendente(String _nome, int _matricola, int _importoOrarioStraordinario,
			Livello _livello, Dipartimento _dipartimento) {

		nome = _nome;
		matricola = _matricola;
		setStipendio();
		importoOrarioStraordinario = _importoOrarioStraordinario;
		livello = _livello;
		dipartimento = _dipartimento;
	}
	
	// CALCOLA LO STIPENDIO
	
	private void setStipendio() {
		
		double newStipendio = 0;

		if (livello == Livello.IMPIEGATO) {
			newStipendio = stipendioBase * 1.2;
		} else if (livello == Livello.QUADRO) {
			newStipendio = stipendioBase * 1.5;
		} else if (livello == Livello.DIRIGENTE) {
			newStipendio = stipendioBase * 2;
		} else {
			newStipendio = stipendioBase;
		}
		stipendio = newStipendio;
	}
	
	public void getStipendio(Dipendente dip, int ore) {
		System.out.printf("Totale più straordinario: ");
		System.out.println( stipendio + (ore * 30) + "\n" );
	}
	// PROMOZIONE
	
		public Livello promotion(){
			
	        if(livello == Livello.DIRIGENTE){
	            System.out.println("Livello massimo");
	        } else if (livello == Livello.QUADRO) {
	            livello = Livello.DIRIGENTE;
	        }else if (livello == Livello.IMPIEGATO) {
	            livello = Livello.QUADRO;
	        }else {livello = Livello.IMPIEGATO;}

	        setStipendio();
	        
	        return livello;
	    }
	
	// STAMPA IL DIPENDENTE
	
	public void stampaDipendente() {
		System.out.println("Nome: " + nome + "\nLivello: " + livello + "\nDipartimento: " + dipartimento + "\nStipendio: "
				+ stipendio);
	}

}
