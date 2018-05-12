package ua.com.gurskaya.serialization.companymarshaller.service;

import ua.com.gurskaya.serialization.companymarshaller.entity.Company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLMarshaller implements CompanyMarshaller {
    private String pathToFile = "src/main/resources/company.xml";
    private File file = new File(pathToFile);

    @Override
    public void marshall(Company company) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(company, file);
        } catch (JAXBException e) {
            throw new RuntimeException("Error when converting object to XML", e);
        }

    }

    @Override
    public Company demarshall() {
        Company company;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            company = (Company) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new RuntimeException("Error when converting XML to object", e);
        }
        return company;
    }
}
