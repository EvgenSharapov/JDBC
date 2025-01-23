package org.example.repositories.statements;

import org.example.entity.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveEmployeePreparedStatementCallBack implements PreparedStatementCallback<Integer> {

    private final Employee employee;

    public SaveEmployeePreparedStatementCallBack(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
        ps.setLong(1, employee.getId());
        ps.setString(2, employee.getName());
        ps.setString(3, employee.getOccupation());
        ps.setFloat(4, employee.getSalary()  );
        ps.setInt(5, employee.getAge());
        ps.setDate(6, employee.getJoinDate());
        ps.execute();

        return ps.getUpdateCount();
    }
}
