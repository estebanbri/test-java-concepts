package com.example.testjavaconcepts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.core.Is.is;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestJavaConceptsApplicationTests {

	private MockMvc mockMvc;

	@Mock // we can return mocked data when we call a method from this service (creating a mock. This can also be achieved by using org.mockito.mock(..) method)
	PersonaService personaService;

	@InjectMocks // we can inject the mocked service inside our PersonaController (injects mock or spy fields into tested objects automatically.)
	PersonaController personaController;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this); // Before each test, we must initialize these mocks (initializes fields annotated with Mockito annotations.)
		mockMvc = MockMvcBuilders
				   .standaloneSetup(personaController)
				   .build();   // The MockMvc is initialized using the
	}

	//@Test
	public void contextLoads() {
	}

	//@Test
	public void asd() throws Exception{
		List<Persona> personas = Arrays.asList(
				new Persona(101, "Esteban"),
				new Persona(102, "Jose"));

		when(personaService.getPersonas()).thenReturn(personas);

		mockMvc.perform(get("/personas1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2)))    // JsonPath es XPATH para JSON. ( en JsonPath el root element es $ ) (en XPATH el root element es / )
				.andExpect(jsonPath("$[0].id", is(101)))
				.andExpect(jsonPath("$[0].nombre", is("Esteban")));
	}

}
