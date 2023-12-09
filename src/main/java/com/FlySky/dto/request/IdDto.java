package com.FlySky.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdDto {

    @NotNull(message = "El campo Id no debe ser nulo")
    private Long id;

}
