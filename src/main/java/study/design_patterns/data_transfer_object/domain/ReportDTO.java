package study.design_patterns.data_transfer_object.domain;

import study.design_patterns.factory.domain.Country;
import study.design_patterns.factory.domain.Currency;

public class ReportDTO {
    private String aircraftName;
    private Country country;
    private Currency currency;
    private String personFullName;

    public static final class ReportDTOBuilder {
        private String aircraftName;
        private Country country;
        private Currency currency;
        private String personFullName;

        private ReportDTOBuilder() {
        }

        public static ReportDTOBuilder builder() {
            return new ReportDTOBuilder();
        }

        public ReportDTOBuilder aircraftName(String aircraftName) {
            this.aircraftName = aircraftName;
            return this;
        }

        public ReportDTOBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReportDTOBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ReportDTOBuilder personFullName(String personFullName) {
            this.personFullName = personFullName;
            return this;
        }

        public ReportDTO build() {
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.currency = this.currency;
            reportDTO.aircraftName = this.aircraftName;
            reportDTO.personFullName = this.personFullName;
            reportDTO.country = this.country;
            return reportDTO;
        }
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "aircraftName='" + aircraftName + '\'' +
                ", country=" + country +
                ", currency=" + currency.getSymbol() +
                ", personFullName='" + personFullName + '\'' +
                '}';
    }
}
