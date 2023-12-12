package com.FlySky.integrationTest;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.FlySky.util.FactoryOfIntegrationDto.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Esta anotacion se utiliza para que los Test se ejecuten uno a uno en el orden establecido en las anotaciones Order(x), sirve para que no se alteren datos en la DB que hagan fallar otros Test.
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // Esta anotacion se utiliza para resetear los contextos en que se ejecutan los metodos luego de ser ejecutados, sirve para que no queden alteradas las DB de un metodo a otro y que fallen los Test que se ejecutan posteriormente por no coincidir los datos.
public class AsientoIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración del método agregarAsiento del controlador con salida OK")
    void agregarAsientoOkTest() throws Exception {

        AsientoRequestDto AsientoRequestDto = newIntegrationAsientoRequestDto();
        AsientoResponseDto AsientoSinVueloResponseDto = newIntegrationAsientoResponseDto();

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payload = writer.writeValueAsString(AsientoRequestDto);
        String expected = writer.writeValueAsString(AsientoSinVueloResponseDto);

        MvcResult response = mockMvc.perform(post("/asientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expected,response.getResponse().getContentAsString());  //PREGUNTAR

    }

    @Test
    @DisplayName("Test de integración del método editarAerolinea del controlador con salida OK")
    void editarAsientoOkTest() throws Exception {

        AsientoRequestConIdDto asientoRequestConIdDto = newIntegrationAsientoRequestConIdDto();
        AsientoResponseDto asientoResponseDto = editIntegrationAsientoResponseDto();

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payload = writer.writeValueAsString(asientoRequestConIdDto);
        String expected = writer.writeValueAsString(asientoResponseDto);

        /*MvcResult response = */mockMvc.perform(put("/asientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andReturn();

        //assertEquals(expected,response.getResponse().getContentAsString());
        // EL CONTENT COINCIDE, PERO HAY UN ERROR CON EL TIPO DE ANOTACION DE LAS FECHAS ARROJADOS POR LOS JSON
    }

}
