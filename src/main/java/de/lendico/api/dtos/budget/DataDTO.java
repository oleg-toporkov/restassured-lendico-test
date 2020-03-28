package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO {
    private BudgetDTO budget;
    private Integer serverKnowledge;
}