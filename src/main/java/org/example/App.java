package org.example;

import org.example.config.AppConfig;
import org.example.entity.Employee;
import org.example.services.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        //config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");


        //data
        Long id=3338L;
        Employee employee= createEmployee(id);

        //demos
        updateDemo(employeeService,employee);
        //executeWithPrepareStatementDemo(employeeService,employee);


    }


    private static void updateDemo(EmployeeService employeeService, Employee employee) {
        System.out.println("update demo");

        int status = employeeService.saveUsingUpdate(employee);
        System.out.println("Employees were saved by update method: "+ status);

        status=employeeService.updateUsingUpdate(employee);
        System.out.println("Employees were update by update method: "+ status);

       // status=employeeService.deleteUsingUpdate(employee);
        System.out.println("Employees were deleted by update method: "+ status);

        System.out.println();
    }

    private static void executeWithPrepareStatementDemo(EmployeeService employeeService, Employee employee) {
        System.out.println("executePrepareStatementDemo");

        Integer status = employeeService.saveByPrepareStatement(employee);
        System.out.println("Employees were saved by execute with PreparedStatement: " + status);
        //status = employeeService.deleteByPrepareStatement(employee);
        System.out.println("Employees were deleted by execute with PreparedStatement: " + status);

        System.out.println();


    }


    private static Employee createEmployee(Long id) {
        return new Employee()
                .setId(Math.toIntExact(id))
                .setName("Billy")
                .setOccupation("driver")
                .setSalary(1500)
                .setAge(41)
                .setJoinDate(Date.valueOf(LocalDate.now()));

    }


}
