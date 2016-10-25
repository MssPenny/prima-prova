package pk1;

import java.util.ArrayList;

import javax.swing.table.*;


public class PrenotazioneModel extends AbstractTableModel {
	private ArrayList aula;
	private String[] orario;
	private String[] dati;
	
public PrenotazioneModel(ArrayList aulax, String[] orariox, String[] datix)
{
	super();
	aula=aulax;
	orario=orariox;
	dati=datix;
}	

public int getRowCount()
{ return orario.length;}

public int getColumnCount()
{return aula.size()+1;}


public Object getValueAt(int table_row, int table_column)
{	Object result=null;
	if(table_column==0)
	{
			result=orario[table_row];
			
	}
	else{
		result= dati[table_row];
	} 
return result;
}

public String getColumnName(int column)
{
	String answer="";
	if (column==0) {
		answer=" ";
	}
	else {
		answer=(String) aula.get(column-1);
		
	}
	return answer;
}

}


