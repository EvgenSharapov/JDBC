package org.example.repositories;

import java.util.List;

public interface CrudRepository <T>{

    // public int update(String query)
    int saveUsingUpdate(T t);

    int updateUsingUpdate(T t);

    int deleteUsingUpdate(T t);

    // public T execute(String sql, PrepareStatementCallBack<T>);

    Integer saveByPrepareStatement(T t);

    Integer deleteByPrepareStatement(T t);

    //public T query(String sql,ResultSetExtractor<T> rse);

    T getFirstWithResultSetExtractor();

    // public T query(String sql, RowMapper<T> rm);
    List<T> findAll();

    T findById(Long id);


    // public int update(String sql,@Nullable object...args)

    int save(T t);

    int deleteById(Long id);
}
