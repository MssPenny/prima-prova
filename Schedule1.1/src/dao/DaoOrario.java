package dao;

import business.entity.BO;

public class DaoOrario extends DaoService implements DaoInterface{
	
	String QUERY_INSERIMENTO_ORARIO = "INSERT INTO `schedule_dib`.`orario` (`Giorno1`, `Ora_inizio1`, `Ora_fine1`, `Giorno2`, `Ora_inizio2`, `Ora_fine2`, `Giorno3`, `Ora_inizio3`, `Ora_fine3`, `Nome_insegn`, `Corso_laurea`) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
	String QUERY_ELIMINA_ORARIO = "DELETE FROM `schedule_dib`.`dati_docenti`,`schedule_dib`.`associa_doc` WHERE `Login`=?";
	String QUERY_UPDATE_ORARIO = "UPDATE `schedule_dib`.`dati_docenti`,`schedule_dib`.`associa_doc` SET `Nome`=?, `Cognome`=?, `DNascita`=?, `ResidenzaAb`=?, `IndirizzoAb`=?, `Telefono`=?, `Email`=?, `IndWeb`=?, `Npiano`=?, `UbiUfficio`=?, `Login`=?, `Password`=?, `Corso_laurea`=?, `Nome_insegn`=?  WHERE `Login` = ? ;";
	String SELECT_ORARIO = "Select `Nome`, `Cognome`, `DNascita`, `ResidenzaAb`, `IndirizzoAb`, `Telefono`, `Email`, `IndWeb`, `Npiano`, `UbiUfficio`, `Login`, `Password`,`Corso_laurea`,`Nome_insegn` FROM `schedule_dib`.`dati_docenti`,`schedule_dib`.`associa_doc`  WHERE `Login` = ? ";

	Dao dao;

	public DaoOrario() {
		dao = new Dao();
	}

	@Override
	public boolean create(BO bo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BO read(BO bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BO bo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BO bo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void search(BO bo) {
		// TODO Auto-generated method stub
		
	}

}
