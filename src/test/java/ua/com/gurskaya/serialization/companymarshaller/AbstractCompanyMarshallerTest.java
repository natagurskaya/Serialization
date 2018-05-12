package ua.com.gurskaya.serialization.companymarshaller;

import org.junit.Test;
import ua.com.gurskaya.serialization.companymarshaller.entity.Company;
import ua.com.gurskaya.serialization.companymarshaller.entity.Employee;
import ua.com.gurskaya.serialization.companymarshaller.service.CompanyMarshaller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractCompanyMarshallerTest {
    private CompanyMarshaller companyMarshaller = getCompanyMarshaller();
    abstract CompanyMarshaller getCompanyMarshaller();

    @Test
    public void testMarshallDemarshall(){
        //prepare
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nata");
        employee.setSalary(250);
        employee.setBirth(LocalDate.of(1989, Month.NOVEMBER, 9));

        List listEmployees = new ArrayList();
        listEmployees.add(employee);

        Company company = new Company();
        company.setId(1);
        company.setName("Tesla");
        company.setEmployees(listEmployees);

        //when
        companyMarshaller.marshall(company);
        Company demarshalledCompamy = companyMarshaller.demarshall();

        //then
        assertEquals(company.toString(), demarshalledCompamy.toString());
    }
}
