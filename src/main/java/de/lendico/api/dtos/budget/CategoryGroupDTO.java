package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryGroupDTO {
    private String id;
    private String name;
    private Boolean hidden;
    private Boolean deleted;
}
