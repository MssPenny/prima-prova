package business.entity;

public class Aula extends BO {
	private String nome;
	private int nPosti;
	private int nPiano;
	private String ubicazione;
	private String tipologia;

	public Aula(String nome, int nPosti, int nPiano, String ubicazione, String tipologia) {
		this.nome = nome;
		this.nPosti = nPosti;
		this.nPiano = nPiano;
		this.ubicazione = ubicazione;
		this.tipologia = tipologia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getnPosti() {
		return nPosti;
	}

	public void setnPosti(int nPosti) {
		this.nPosti = nPosti;
	}

	public int getnPiano() {
		return nPiano;
	}

	public void setnPiano(int nPiano) {
		this.nPiano = nPiano;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}


}
