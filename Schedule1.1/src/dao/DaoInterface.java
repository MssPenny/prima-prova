package dao;
import java.util.List;
import business.entity.BO;

public interface DaoInterface {
public boolean create(BO o);
public BO read(BO o);
public boolean update(BO o);
public boolean delete(BO o);

public void search(BO o);


}
