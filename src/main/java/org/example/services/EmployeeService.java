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

}
