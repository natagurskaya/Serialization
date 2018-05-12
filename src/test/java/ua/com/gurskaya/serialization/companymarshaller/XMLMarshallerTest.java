package ua.com.gurskaya.serialization.companymarshaller;

import ua.com.gurskaya.serialization.companymarshaller.service.CompanyMarshaller;
import ua.com.gurskaya.serialization.companymarshaller.service.XMLMarshaller;

public class XMLMarshallerTest extends AbstractCompanyMarshallerTest {
    CompanyMarshaller getCompanyMarshaller() {return new XMLMarshaller();}
}
