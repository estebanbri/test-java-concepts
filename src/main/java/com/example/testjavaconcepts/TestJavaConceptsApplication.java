package com.example.testjavaconcepts;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Stream;

@SpringBootApplication
public class TestJavaConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJavaConceptsApplication.class, args);

		// \u000d System.out.println("Hola Mundo!");

		//node(new Persona(123,"Esteban"));

		//fibonacciStream();
	}

	public static void fibonacciStream(){
		// Fibonacci using Stream
		// Stream.iterate(initial value, next value)
		Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]}) // : Stream<Integer[]>
				.limit(10)                                                // : Stream<Integer[]>
				.map(x -> x[0])                                           // : Stream<Integer>
				.forEach( x -> System.out.println(x));
	}



	public static void fibonacciLoop(){
		// Fibonacci using for loop
		int hasta = 10, num = 0, numSiguiente = 1;
		System.out.print("First " + hasta + " terms: ");

		for (int i = 1; i <= hasta; ++i)
		{
			System.out.print(num + " + ");

			int sum      = num + numSiguiente; // sumas los dos numeros
			numSiguiente = sum;                // numSiguiente tiene la suma de ambos
			num          = numSiguiente;       // numSiguiente pasa a ser tu num

		}
	}

	public static void node(Persona persona){
		ObjectMapper objectMapper = new ObjectMapper();

		/*
		 *  valueToTree()
		 */

		//{"dni":123,"nombre":"Esteban"} <- Obj Persona
		JsonNode json_node = objectMapper.valueToTree(persona);

		int dni_var = json_node.get("dni").intValue();
		String nombre_var = json_node.get("nombre").textValue();

		System.out.println(dni_var +" "+ nombre_var);
	}

	static class Persona{
		int dni;
		String nombre;
		Persona(int dni, String nombre){ this.dni = dni; this.nombre = nombre;}

		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}








}
