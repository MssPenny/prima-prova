package business.entity;

public class Docente extends Identificato {

	private String nome;
	private String cognome;
	private String dataNascita;
	private String residenzaAb;
	private String indirizzoAb;
	private String telefono;
	private String email;
	private String indWeb;
	private int nPiano;
	private String ubiUfficio;

	public Docente(String login, String password, String corsoLaurea, String nomeInsegnamento, String nome,
			String cognome, String dataNascita, String residenzaAb, int nPiano, String telefono, String email,
			String indWeb, String indirizzoAb, String ubiUfficio) {
		super(login, password, corsoLaurea, nomeInsegnamento);
		// TODO Auto-generated constructor stub

		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.residenzaAb = residenzaAb;
		this.indirizzoAb = indirizzoAb;
		this.telefono = telefono;
		this.email = email;
		this.indWeb = indWeb;
		this.nPiano = nPiano;
		this.ubiUfficio = ubiUfficio;
	}

	public String toString() {
		return "Docente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", residenzaAb=" + residenzaAb
				+ ", indirizzoAb=" + indirizzoAb + ", telefono=" + telefono + ", email=" + email + ", indWeb=" + indWeb + ", nPiano=" + nPiano + ", ubiUfficio=" + ubiUfficio + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getResidenzaAb() {
		return residenzaAb;
	}

	public void setResidenzaAb(String residenzaAb) {
		this.residenzaAb = residenzaAb;
	}

	public String getIndirizzoAb() {
		return indirizzoAb;
	}

	public void setIndirizzoAb(String indirizzoAb) {
		this.indirizzoAb = indirizzoAb;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndWeb() {
		return indWeb;
	}

	public void setIndWeb(String indWeb) {
		this.indWeb = indWeb;
	}

	public int getnPiano() {
		return nPiano;
	}

	public void setnPiano(int nPiano) {
		this.nPiano = nPiano;
	}

	public String getUbiUfficio() {
		return ubiUfficio;
	}

	public void setUbiUfficio(String ubiUfficio) {
		this.ubiUfficio = ubiUfficio;
	}

}
