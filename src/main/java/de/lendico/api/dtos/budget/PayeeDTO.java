package de.lendico.api.dtos.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayeeDTO {
    private String id;
    private String name;
    private String transferAccountId;
    private Boolean deleted;
}
