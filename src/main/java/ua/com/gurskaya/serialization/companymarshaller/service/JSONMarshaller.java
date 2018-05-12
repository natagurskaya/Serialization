package ua.com.gurskaya.serialization.companymarshaller.service;

import com.google.gson.Gson;
import ua.com.gurskaya.serialization.companymarshaller.entity.Company;

public class JSONMarshaller implements CompanyMarshaller {

    private Gson gson = new Gson();
    private String json;

    @Override
    public void marshall(Company company) {
        json = gson.toJson(company);
    }

    @Override
    public Company demarshall() {
        return gson.fromJson(json, Company.class);
    }
}
