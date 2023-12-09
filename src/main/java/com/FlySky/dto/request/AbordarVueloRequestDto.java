package com.FlySky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbordarVueloRequestDto {

    Long idVuelo;

    List<Short> asientosAusentes = new ArrayList<>();

}
