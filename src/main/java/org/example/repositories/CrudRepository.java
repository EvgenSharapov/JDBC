package org.example.repositories;

public interface CrudRepository <T>{

    // public int update(String query)
    int saveUsingUpdate(T t);

    int updateUsingUpdate(T t);

    int deleteUsingUpdate(T t);

    // public T execute(String sql, PrepareStatementCallBack<T>);

    Integer saveByPrepareStatement(T t);

    Integer deleteByPrepareStatement(T t);
}
