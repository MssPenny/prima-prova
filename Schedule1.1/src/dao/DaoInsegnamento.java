package dao;

import java.util.List;
import java.util.ArrayList;

import business.entity.BO;
import business.entity.Insegnamento;

public class DaoInsegnamento implements DaoInterface {
	
	List<Insegnamento> i;

	
	public DaoInsegnamento() {
		i = new ArrayList<Insegnamento>();
		Insegnamento insegnamento1 = new Insegnamento(null, null, 0, null, null, null, null);
		Insegnamento insegnamento2= new Insegnamento(null, null, 0, null, null, null, null);
		i.add(insegnamento1);
		i.add(insegnamento2);
	}

	@Override
	public void update(BO i) {
		String query_3 = "INSERT INTO `schedule_dib`.`dati_insegnamento` (`Nome_insegn`, `Corso_laurea`, `Ncrediti`, `Anno`, `Propedeutico`, `Laboratorio`, `Valutazione`) VALUES (?, ?, ?, ?, ?, ?,?)",
              i.get, book.getAutore(), book.getTitolo());
		
	}

	@Override
	public void delete(BO o) {
		i.remove(i.));
	}

	@Override
	public void read(BO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void search(BO o) {
		// TODO Auto-generated method stub

	}

}






