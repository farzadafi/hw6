package Repository;

import Entity.Bank;

import java.sql.SQLException;

public interface Repository<T> {
    public void add(T t)throws SQLException;

}
