package org.example.mappers;


import org.example.entity.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee().setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setOccupation(rs.getString("occupation"))
                .setSalary(rs.getInt("salary"))
                .setAge(rs.getInt("age"))
                .setJoinDate(rs.getDate("joinDate"));

    }

    //другой вариант

//        List<Employee> employees1 = new ArrayList<>();
//        while ((rs.next())){
//            Employee employee = new Employee().setId(rs.getInt("id"))
//                    .setName(rs.getString("name"))
//                    .setOccupation(rs.getString("occupation"))
//                    .setSalary(rs.getInt("salary"))
//                    .setAge(rs.getInt("age"))
//                    .setJoinDate(rs.getDate("join_date"));
//            employees1.add(employee);
//        }
//        return employees1;

}
