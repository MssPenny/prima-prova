package dao;
import java.util.List;
import business.entity.BO;

public interface DaoInterface {
public List<BO> create();
public BO read(BO o);
public void update(BO o);
public void delete(BO o);

public void search(BO o);

}
