package org.example.services;


import org.example.entity.Employee;
import org.example.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //public int update(String query)

    public int saveUsingUpdate(Employee e){
        return employeeRepository.saveUsingUpdate(e);
    }

    public int updateUsingUpdate(Employee e){
        return employeeRepository.updateUsingUpdate(e);
    }

    public int deleteUsingUpdate(Employee e){
        return employeeRepository.deleteUsingUpdate(e);
    }

    // public T execute(String sql,PrepareStatementCallBack<T>);

    public Integer saveByPrepareStatement(Employee e){
        return employeeRepository.saveByPrepareStatement(e);
    }
    public int deleteByPrepareStatement(Employee e){
        return employeeRepository.deleteByPrepareStatement(e);
    }

    public Employee getFirstWithResultSetExtractor(){
    return employeeRepository.getFirstWithResultSetExtractor();

    }

    // public T query(String sql, RowMapper<T> rm);

    public void displayEmployees(){
        employeeRepository.findAll().forEach(System.out::println);
    }

    public void displayEmployeesById(Long id){
        System.out.println(employeeRepository.findById(id));
    }

    // public int update(String sql,@Nullable object...args)

    public void saveEmployee(Employee employee){
        int modifiedRows = employeeRepository.save(employee);
        if(modifiedRows != 0){
            System.out.println("Save operation executed successfully");
        }

    }

    public void deleteEmployeeById(Long id){
        int modifiedRows = employeeRepository.deleteById(id);

        if(modifiedRows != 0){
            System.out.println("Delete operation executed successfully");
        }

    }


}
