package business.entity;

public class Insegnamento extends BO {
	private String nome;
	private String corsoLaurea;
	private int nCrediti;
	private String anno;
	private String propedeutico;
	private String laboratorio;
	private String valutazione;

	public Insegnamento(String nome, String corsoLaurea, int nCrediti, String anno, String propedeutico,
			String laboratorio, String valutazione) {
		this.nome = nome;
		this.corsoLaurea = corsoLaurea;
		this.nCrediti = nCrediti;
		this.anno = anno;
		this.propedeutico = propedeutico;
		this.laboratorio = laboratorio;
		this.valutazione = valutazione;

	}
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Insegnamento [nome=" + nome + ", corsoLaurea=" + corsoLaurea + ", nCrediti=" + nCrediti + ", anno="
				+ anno + ", propedeutico=" + propedeutico + ", laboratorio=" + laboratorio + ", valutazione="
				+ valutazione + "]";
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCorsoLaurea() {
		return corsoLaurea;
	}

	public void setCorsoLaurea(String corsoLaurea) {
		this.corsoLaurea = corsoLaurea;
	}

	public int getnCrediti() {
		return nCrediti;
	}

	public void setnCrediti(int nCrediti) {
		this.nCrediti = nCrediti;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getPropedeutico() {
		return propedeutico;
	}

	public void setPropedeutico(String propedeutico) {
		this.propedeutico = propedeutico;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getValutazione() {
		return valutazione;
	}

	public void setValutazione(String valutazione) {
		this.valutazione = valutazione;
	}
}
