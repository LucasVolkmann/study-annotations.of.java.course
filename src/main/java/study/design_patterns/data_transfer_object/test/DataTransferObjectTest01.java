package study.design_patterns.data_transfer_object.test;

import study.design_patterns.builder.domain.Person;
import study.design_patterns.data_transfer_object.domain.ReportDTO;
import study.design_patterns.factory.domain.Country;
import study.design_patterns.factory.domain.Currency;
import study.design_patterns.factory.domain.CurrencyFactory;
import study.design_patterns.singleton_eager.domain.Aircraft;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder
                .builder()
                .firstName("Lucas")
                .lastName("Volkmann")
                .build();
        ReportDTO reportDTO = ReportDTO.ReportDTOBuilder
                .builder()
                .aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personFullName(person.getFirstName() + " " + person.getLastName())
                .build();

        System.out.println(reportDTO);
    }
}
