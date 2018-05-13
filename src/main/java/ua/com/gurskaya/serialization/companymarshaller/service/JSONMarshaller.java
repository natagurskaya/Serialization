package ua.com.gurskaya.serialization.companymarshaller.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.gurskaya.serialization.companymarshaller.entity.Company;

import java.io.*;

public class JSONMarshaller implements CompanyMarshaller {

    private static final Gson GSON = new Gson();
    private String pathToFile;

    public JSONMarshaller(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void marshall(Company company) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile))) {
            GSON.toJson(company, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException("Error when converting object to JSON", e);
        }

    }

    @Override
    public Company demarshall() {
        Company company = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            company = GSON.fromJson(bufferedReader, Company.class);
        } catch (IOException e) {
            throw new RuntimeException("Error when converting JSON to object", e);
        }
        return company;
    }
}
