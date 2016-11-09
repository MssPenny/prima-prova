package business.entity;

public class Corso extends BO {
	private String corsoLaurea;

	public Corso(String corsoLaurea) {
		this.corsoLaurea = corsoLaurea;
	}

	public String getCorsoLaurea() {
		return corsoLaurea;
	}

	public void setCorsoLaurea(String corsoLaurea) {
		this.corsoLaurea = corsoLaurea;
	}
	
	@Override
	public String toString() {
		return "Corso [corsoLaurea=" + corsoLaurea + "]";
	}
}
