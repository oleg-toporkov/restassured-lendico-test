package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthDTO {
    private String month;
    private String note;
    private Integer income;
    private Integer budgeted;
    private Integer activity;
    private Integer toBeBudgeted;
    private Integer ageOfMoney;
    private Boolean deleted;
    private List<CategoryDTO> categories;
}
