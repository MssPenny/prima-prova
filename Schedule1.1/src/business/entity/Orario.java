package business.entity;

public class Orario extends Insegnamento {

	private String giorno1;
	private String oraInizio1;
	private String oraFine1;
	private String giorno2;
	private String oraInizio2;
	private String oraFine2;
	private String giorno3;
	private String oraInizio3;
	private String oraFine3;

	public Orario(String nome, String corsoLaurea, int nCrediti, String anno, String propedeutico, String laboratorio,
			String valutazione, String giorno1, String oraInizio1, String oraFine1, String giorno2, String oraInizio2,
			String oraFine2, String giorno3, String oraInizio3, String oraFine3) {
		super(nome, corsoLaurea, nCrediti, anno, propedeutico, laboratorio, valutazione);
		// TODO Auto-generated constructor stub

		this.giorno1 = giorno1;
		this.oraInizio1 = oraInizio1;
		this.oraFine1 = oraFine1;
		this.giorno2 = giorno2;
		this.oraInizio2 = oraInizio2;
		this.oraFine2 = oraFine2;
		this.giorno3 = giorno3;
		this.oraInizio3 = oraInizio3;
		this.oraFine3 = oraFine3;
	}

	public String getGiorno1() {
		return giorno1;
	}

	public void setGiorno1(String giorno1) {
		this.giorno1 = giorno1;
	}

	public String getOraInizio1() {
		return oraInizio1;
	}

	public void setOraInizio1(String oraInizio1) {
		this.oraInizio1 = oraInizio1;
	}

	public String getOraFine1() {
		return oraFine1;
	}

	public void setOraFine1(String oraFine1) {
		this.oraFine1 = oraFine1;
	}

	public String getGiorno2() {
		return giorno2;
	}

	public void setGiorno2(String giorno2) {
		this.giorno2 = giorno2;
	}

	public String getOraInizio2() {
		return oraInizio2;
	}

	public void setOraInizio2(String oraInizio2) {
		this.oraInizio2 = oraInizio2;
	}

	public String getOraFine2() {
		return oraFine2;
	}

	public void setOraFine2(String oraFine2) {
		this.oraFine2 = oraFine2;
	}

	public String getGiorno3() {
		return giorno3;
	}

	public void setGiorno3(String giorno3) {
		this.giorno3 = giorno3;
	}

	public String getOraInizio3() {
		return oraInizio3;
	}

	public void setOraInizio3(String oraInizio3) {
		this.oraInizio3 = oraInizio3;
	}

	public String getOraFine3() {
		return oraFine3;
	}

	public void setOraFine3(String oraFine3) {
		this.oraFine3 = oraFine3;
	}

}
