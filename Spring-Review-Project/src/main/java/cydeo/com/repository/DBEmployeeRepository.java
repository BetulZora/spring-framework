package cydeo.com.repository;

import cydeo.com.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{
    // Assuming this data will be received from the database


    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Harold Finch", "IT", 65);

        return employee.getHourlyRate(); // assuming that we're getting the rate from an object in the database
    }
}
