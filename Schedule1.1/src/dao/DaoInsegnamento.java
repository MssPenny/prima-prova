package dao;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entity.BO;
import business.entity.Insegnamento;

public class DaoInsegnamento extends DaoService implements DaoInterface {
	String QUERY_INSERIMENTO_INSEGNAMENTO = "INSERT INTO `schedule_dib`.`dati_insegnamento` (`Nome_insegn`, `Corso_laurea`, `Ncrediti`, `Anno`, `Propedeutico`, `Laboratorio`, `Valutazione`) VALUES (?, ?, ?, ?, ?, ?,?)";
	String QUERY_ELIMINA_INSEGNAMENTO = "DELETE FROM `schedule_dib`.`dati_insegnamento` WHERE `Nome_insegn`=?";
	String QUERY_UPDATE_INSEGNAMENTO = "UPDATE `schedule_dib`.`dati_insegnamento` SET `Nome_insegn`=?, `Corso_laurea`=?, `Ncrediti`=?, `Anno`=?, `Propedeutico`=?, `Laboratorio`=?, `Valutazione`=?  WHERE `Nome_insegn` = ? ;";
	String SELECT_INSEGNAMENTO = "SELECT `Nome_insegn`, `Corso_laurea`, `Ncrediti`, `Anno`, `Propedeutico`, `Laboratorio`, `Valutazione` FROM `schedule_dib`.`dati_insegnamento`  WHERE `Nome_insegn` = ? ";

	Dao dao;

	public DaoInsegnamento() {
		dao = new Dao();
	}

	@Override
	public boolean update(BO bo) {

		PreparedStatement updateInsegnamento = null;
		Insegnamento insegnamento = (Insegnamento) bo;

		try {

			updateInsegnamento = dao.getInstance().prepareStatement(QUERY_UPDATE_INSEGNAMENTO);

			int index = 1;

			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getNome(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getCorsoLaurea(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getnCrediti(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getAnno(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getPropedeutico(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getLaboratorio(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getValutazione(), index++);
			updateInsegnamento = setParameter(updateInsegnamento, insegnamento.getNome(), index++);

			updateDeleteQuery(updateInsegnamento);

		} catch (SQLException e) {

			return false;
		}
		return true;

	}

	
	@Override
	public void search(BO o) {
		// TODO Auto-generated method stub

	}

	public boolean create(BO bo) {

		Insegnamento insegnamento = (Insegnamento) bo;

		PreparedStatement inserimentoInsegnamento = null;

		try {
			int index = 1;
			inserimentoInsegnamento = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_INSEGNAMENTO);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getNome(), index++);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getCorsoLaurea(), index++);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getnCrediti(), index++);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getAnno(), index++);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getPropedeutico(), index++);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getLaboratorio(), index++);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getValutazione(), index++);

			insertQuery(inserimentoInsegnamento);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;

	}

	@Override
	public BO read(BO bo) {

		String nomeIns = "";
		String corsoLaurea = "";
		int nCrediti;
		String anno = "";
		String propedeutico = "";
		String laboratorio = "";
		String valutazione = "";
		Insegnamento i = null;
		Insegnamento insegnamento = (Insegnamento) bo;
		PreparedStatement ricercaIns = null;

		try {
			ricercaIns = dao.getInstance().prepareStatement(SELECT_INSEGNAMENTO);
			setParameter(ricercaIns, insegnamento.getNome(), 1);

			ResultSet resultsRicercaIns = selectQuery(ricercaIns);

			if (resultsRicercaIns.next()) {

				nomeIns = resultsRicercaIns.getString("Nome_insegn");
				corsoLaurea = resultsRicercaIns.getString("Corso_laurea");
				nCrediti = resultsRicercaIns.getInt("Ncrediti");
				anno = resultsRicercaIns.getString("Anno");
				propedeutico = resultsRicercaIns.getString("Propedeutico");
				laboratorio = resultsRicercaIns.getString("Laboratorio");
				valutazione = resultsRicercaIns.getString("Valutazione");

			} else {
				throw new SQLException();
			}

			i = new Insegnamento(nomeIns, corsoLaurea, nCrediti, anno, propedeutico, laboratorio, valutazione);

		} catch (SQLException e) {
			return null;
		}
		return i;
	}

	@Override
	public boolean delete(BO bo) {
		Insegnamento insegnamento = (Insegnamento) bo;

		PreparedStatement inserimentoInsegnamento = null;

		try {
			int index = 1;
			inserimentoInsegnamento = dao.getInstance().prepareStatement(QUERY_ELIMINA_INSEGNAMENTO);
			inserimentoInsegnamento = setParameter(inserimentoInsegnamento, insegnamento.getNome(), index++);

			insertQuery(inserimentoInsegnamento);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println("sono nel main");

		Insegnamento inse = new Insegnamento("OS", "ITPS", 6, "2011", "si", "si", "30");
		DaoInsegnamento d = new DaoInsegnamento();

		System.out.println("create: " + d.create(inse));
		System.err.println("vuoi prenderlo?");
		Scanner s = new Scanner(System.in);
		int conferma = s.nextInt();
		if (conferma == 1) {
			System.out.println("read: " + ((Insegnamento) d.read(inse)).toString());

		}
	}
}
