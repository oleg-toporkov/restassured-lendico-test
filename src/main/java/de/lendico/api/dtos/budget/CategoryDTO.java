package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String id;
    private String categoryGroupId;
    private String name;
    private Boolean hidden;
    private String originalCategoryGroupId;
    private String note;
    private Integer budgeted;
    private Integer activity;
    private Integer balance;
    private String goalType;
    private String goalCreationMonth;
    private Integer goalTarget;
    private String goalTargetMonth;
    private Integer goalPercentageComplete;
    private Boolean deleted;
}
