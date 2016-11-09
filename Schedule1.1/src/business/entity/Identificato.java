package business.entity;

public class Identificato extends BO {

	private String login;
	private String password;
	private String corsoLaurea;
	private String nomeInsegnamento;

	public Identificato(String login, String password, String corsoLaurea, String nomeInsegnamento) {
		this.login = login;
		this.password = password;
		this.corsoLaurea = corsoLaurea;
		this.nomeInsegnamento = nomeInsegnamento;
	}

	public String toString() {
		return "Identificato [login=" + login + ", password=" + password + ", corsoLaurea=" + corsoLaurea
				+ ", nomeInsegnamento=" + nomeInsegnamento + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorsoLaurea() {
		return corsoLaurea;
	}

	public void setCorsoLaurea(String corsoLaurea) {
		this.corsoLaurea = corsoLaurea;
	}

	public String getNomeInsegnamento() {
		return nomeInsegnamento;
	}

	public void setNomeInsegnamento(String nomeInsegnamento) {
		this.nomeInsegnamento = nomeInsegnamento;
	}

}
