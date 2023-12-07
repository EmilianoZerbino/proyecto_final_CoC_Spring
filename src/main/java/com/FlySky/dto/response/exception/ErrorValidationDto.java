package com.FlySky.dto.response.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorValidationDto {

    private int status;
    private HashMap<String,String> errors;

}
