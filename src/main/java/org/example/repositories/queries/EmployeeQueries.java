package org.example.repositories.queries;

public class EmployeeQueries {

    private EmployeeQueries() {
    }

    public static final String SAVE_EMPLOYEE = """
            INSERT INTO employee(id, name, occupation, salary, age, joinDate) 
            VALUES (?,?,?,?,?,?)
            """;
    public static final String DELETE_BY_ID = """
            DELETE FROM employee AS e
                WHERE e.id = ?
            
            """;

    public static final String FIND_FIRST_EMPLOYEE = """
            SELECT *
            FROM employee AS e
                WHERE e.id = 1;
            """;

    public static final String FIND_ALL = """
            SELECT *
            FROM employee;
            """;

    public static final String FIND_BY_ID = """
            SELECT *
            FROM employee AS e
                WHERE e.id = ?;
            """;
}
