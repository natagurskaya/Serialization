package ua.com.gurskaya.serialization.companymarshaller.service;

import ua.com.gurskaya.serialization.companymarshaller.entity.Company;

public interface CompanyMarshaller {
    void marshall(Company company);

    Company demarshall();
}
