package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {
    private String id;
    private String name;
    private String lastModifiedOn;
    private String firstMonth;
    private String lastMonth;
    private DateFormatDTO dateFormat;
    private CurrencyFormatDTO currencyFormat;
    private List<Object> accounts;
    private List<PayeeDTO> payees;
    private List<Object> payeeLocations;
    private List<CategoryGroupDTO> categoryGroups;
    private List<CategoryDTO> categories;
    private List<MonthDTO> months;
    private List<Object> transactions;
    private List<Object> subtransactions;
    private List<Object> scheduledTransactions;
    private List<Object> scheduledSubtransactions;
    //TODO add types to parse nested objects
}