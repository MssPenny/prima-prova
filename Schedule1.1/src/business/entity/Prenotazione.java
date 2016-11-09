package business.entity;

public class Prenotazione extends BO {
	private String corsoLaurea;
	private String nomeInsegn;
	private String data;
	private String oraInizio;
	private String oraFine;
	private String aula;
	private int nPiano;
	private String tipologia;
	private String note;

	public Prenotazione(String corsoLaurea, String nomeInsegn, String data, String oraInizio, String oraFine,
			String aula, int nPiano, String tipologia, String note) {
		this.corsoLaurea = corsoLaurea;
		this.nomeInsegn = nomeInsegn;
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.aula = aula;
		this.nPiano = nPiano;
		this.tipologia = tipologia;
		this.note = note;
	}

	public String toString() {
		return "Prenotazione [corsoLaurea=" + corsoLaurea + ", nomeInsegn=" + nomeInsegn + ", data=" + data
				+ ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", aula=" + aula + ", nPiano=" + nPiano
				+ ", tipologia=" + tipologia + ", note=" + note + "]";
	}

	public String getCorsoLaurea() {
		return corsoLaurea;
	}

	public void setCorsoLaurea(String corsoLaurea) {
		this.corsoLaurea = corsoLaurea;
	}

	public String getNomeInsegn() {
		return nomeInsegn;
	}

	public void setNomeInsegn(String nomeInsegn) {
		this.nomeInsegn = nomeInsegn;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}

	public String getOraFine() {
		return oraFine;
	}

	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public int getnPiano() {
		return nPiano;
	}

	public void setnPiano(int nPiano) {
		this.nPiano = nPiano;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
