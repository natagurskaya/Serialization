package ua.com.gurskaya.serialization.companymarshaller;

import ua.com.gurskaya.serialization.companymarshaller.service.CompanyMarshaller;
import ua.com.gurskaya.serialization.companymarshaller.service.JSONMarshaller;

public class JSONMarshallerTest extends AbstractCompanyMarshallerTest{
    CompanyMarshaller getCompanyMarshaller() {return new JSONMarshaller();}

}
