package Repository;

import Entity.Bank;

import java.sql.SQLException;

public interface Repository<T> {
    void add(T t);

    int find(String input);

}
