package com.example.testjavaconcepts.MockMvcPOC;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * GivenWhenThen:
 *      The essential idea is to break down writing a scenario (or test) into three sections:
 *
 *          The GIVEN part describes the state of the world before you begin the behavior you're specifying in this scenario. You can think of it as the pre-conditions to the test.
 *          The WHEN section is that behavior that you're specifying.
 *          Finally the THEN section describes the changes you expect due to the specified behavior.
 */

@RunWith(SpringRunner.class)
@SpringBootTest // Full Spring Application Context is started
@AutoConfigureMockMvc // Con estas dos anotaciones @SpringBootTest y @AutoConfigureMockMvc ahora vamos a tener acceso a Spring MVC.
//@WebMvcTest // Only the web layer (not the full application context) is started using this annotation.
public class PersonasControllerTest {

    @Autowired
    MockMvc mockMvc; // permite realizar REST API calls

    @Mock
    PersonasService personasService;

    @InjectMocks
    PersonasController personasController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personasController)
                .build();
    }

    @Test
    public void probando_mock() throws Exception {

        // Given (Dado)
        List<Persona> personasMock = Arrays.asList(new Persona("T",1));

        // When (Cuando)
        when(personasService.getPersonas())
                .thenReturn(personasMock);

        // Then (Luego)
        mockMvc.perform(get("/personas"))
                .andExpect(status().isOk())
                .andExpect(content().json("[  \n" +
                        "   {  \n" +
                        "      \"nombre\":\"T\",\n" +
                        "      \"edad\":1\n" +
                        "   }\n" +
                        "]"));




    }


    @Test
    public void get_personas_200_OK() throws Exception {
        mockMvc.perform(get("/personas"))
        .andExpect(status().isOk())
        .andExpect(content().json("[  \n" +
                "   {  \n" +
                "      \"nombre\":\"Jose\",\n" +
                "      \"edad\":15\n" +
                "   },\n" +
                "   {  \n" +
                "      \"nombre\":\"Pedro\",\n" +
                "      \"edad\":20\n" +
                "   }\n" +
                "]"));
    }

    @Test
    public void persona_saludo() throws Exception {
        mockMvc.perform(get("/personas/saludo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Saludo desde el Controller"));
    }
}