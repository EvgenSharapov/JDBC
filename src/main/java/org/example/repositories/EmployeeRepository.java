package org.example.repositories;

import org.example.entity.Employee;
import org.example.repositories.statements.SaveEmployeePreparedStatementCallBack;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import static org.example.repositories.queries.EmployeeQueries.DELETE_BY_ID;
import static org.example.repositories.queries.EmployeeQueries.SAVE_EMPLOYEE;

@Repository
public class EmployeeRepository implements CrudRepository<Employee>{

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //public int update(String query)
    @Override
    public int saveUsingUpdate(Employee e) {
        String query = "insert into employee (id, name, salary) values('" + e.getId() + "','" + e.getName() + "','"+
                e.getSalary() + "')";
        return jdbcTemplate.update(query);
    }

    @Override
    public int updateUsingUpdate(Employee e) {
        String query = "update employee set  name = '" + e.getName() + "',salary='" + e.getSalary() + "'where id ='"+
                e.getId() + "'";
        return jdbcTemplate.update(query);
    }

    @Override
    public int deleteUsingUpdate(Employee e) {
        String query = "delete from employee where  id = '" + e.getId() + "'";
        return jdbcTemplate.update(query);
    }


    // public T execute(String sql,PrepareStatementCallBack<T>)
    @Override
    public Integer saveByPrepareStatement(Employee e) {
        return jdbcTemplate.execute(SAVE_EMPLOYEE,new SaveEmployeePreparedStatementCallBack(e));
    }

    @Override
    public Integer deleteByPrepareStatement(Employee e) {
        return jdbcTemplate.execute(DELETE_BY_ID, (PreparedStatementCallback<Integer>) ps -> {
            ps.setLong(1,e.getId());


            ps.execute();
            return ps.getUpdateCount();

        });
    }
}
