package org.example.mappers;

import org.example.entity.Employee;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeResultSetExtractor implements ResultSetExtractor<Employee> {


    @Override
    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {

        // только первый элемент
        rs.next();

        return new Employee().setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setOccupation(rs.getString("occupation"))
                .setSalary(rs.getInt("salary"))
                .setAge(rs.getInt("age"))
                .setJoinDate(rs.getDate("joinDate"));


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
}
