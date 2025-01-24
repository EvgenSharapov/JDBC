package org.example.repositories;

import org.example.entity.Employee;
import org.example.repositories.statements.SaveEmployeePreparedStatementCallBack;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.example.repositories.queries.EmployeeQueries.*;

@Repository
public class EmployeeRepository implements CrudRepository<Employee>{

    private final JdbcTemplate jdbcTemplate;
    //можно использовать @Qualifier если имя не совпадает с именем бина.
    private final ResultSetExtractor<Employee> employeeResultSetExtractor;
    private final RowMapper<Employee>employeeRowMapper;

    public EmployeeRepository(JdbcTemplate jdbcTemplate, ResultSetExtractor<Employee> employeeResultSetExtractor, RowMapper<Employee> employeeRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeResultSetExtractor = employeeResultSetExtractor;
        this.employeeRowMapper = employeeRowMapper;
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

    @Override
    public Employee getFirstWithResultSetExtractor() {
        return jdbcTemplate.query(FIND_FIRST_EMPLOYEE,employeeResultSetExtractor);
    }


    // public T query(String sql, RowMapper<T> rm);

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(FIND_ALL,employeeRowMapper);
    }

    @Override
    public Employee findById(Long id) {
        List<Employee> queryResult = jdbcTemplate.query(FIND_BY_ID, employeeRowMapper, id);
        return queryResult.getFirst();
    }



    // public int update(String sql,@Nullable object...args)

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update(SAVE_EMPLOYEE,
                employee.getId(),
                employee.getName(),
                employee.getOccupation(),
                employee.getSalary(),
                employee.getAge(),
                employee.getJoinDate()
        );
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(DELETE_BY_ID,id);
    }
}
