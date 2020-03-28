package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyFormatDTO {
    private String isoCode;
    private String exampleFormat;
    private Integer decimalDigits;
    private String decimalSeparator;
    private Boolean symbolFirst;
    private String groupSeparator;
    private String currencySymbol;
    private Boolean displaySymbol;
}