package com.example.testjavaconcepts.ObjectMapperPOC;

import com.example.testjavaconcepts.Persona;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.core.ParameterizedTypeReference;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectMapperPOC {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        // convertValuePOC();
        mapPOC();
        // mapPOC2();
        DeserializationFeature_ACCEPT_SINGLE_VALUE_AS_ARRAY();
    }

    private static void convertValuePOC(){
        List<Persona> personas = Arrays.asList(new Persona(1, "Esteban"), new Persona(2, "Andres"));
        List<Persona> l = objectMapper.convertValue(personas, objectMapper.getTypeFactory().constructCollectionType(List.class, Persona.class));
    }
    private static void readValuePOC(){

    }

    public static void mapPOC() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();

        map.put("ASD1","111");
        map.put("ASD2","222");

        // Pre - Java 8
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getValue();
            String valor = entry.getValue();
            System.out.println(key + valor);
        }

        // Post - Java 8
        map.forEach((key, valor)-> System.out.println(key + valor));

        // Gson - toJson
        String cadena1 = new Gson().toJson(map);
        System.out.println(cadena1);

        // ObjectMapper - writeValueAsString
        String cadena2 = new ObjectMapper().writeValueAsString(map);
        System.out.println(cadena2);
    }

    public static void mapPOC2() throws JsonProcessingException {
        Map<String, Object> mainNode = new HashMap<>();
        Map<String, Object> recordMap = new HashMap<>();
        Map<String, Object> recordValueMap = new HashMap<>();

        recordValueMap.put("ID",123);
        recordValueMap.put("NOMBRE","ESTEBAN");
        // recordValueMap: {"ID":123,"NOMBRE":"ESTEBAN"}

        recordMap.put("RECORD",recordValueMap);
        // recordMap: {"RECORD":___recordValueMap____}

        mainNode.put("ROOT",recordMap);
        // mainNode: {"ROOT":{__recordMap__}

        // Gson - toJson
        String cadena1 = new Gson().toJson(mainNode);
        System.out.println(cadena1);

        // ObjectMapper - writeValueAsString
        String cadena2 = new ObjectMapper().writeValueAsString(mainNode);
        System.out.println(cadena2);
    }

    public static void ParametrizedTypeVsParametrizedTypeReference() {
        /*
            Ambos cumplen el mismo objetivo, los vas a usar cuando tu clase a pasar como parametro
            sea un parametrized type (generics) como por ej List<T>. Si tu tipo no es parametrizado
            simplemente pasas como argumento -> {className}.class
         */

        // TypeRefence (ObjectMapper) -> Uso frecuente: readValue()
        // readValue(String content, TypeReference valueTypeRef) Ej: readValue(json, new TypeReference<List<Persona>>(){})
        // readValue(String content, Class<T> valueType) Ej: readValue(json, Persona.class)
        TypeReference ref = new TypeReference<List<Integer>>() { };
        System.out.println(ref.getType());

        // ParameterizedTypeReference (Spring Core) -> Uso frecuente: exchange()
        // ResponseEntity<List<T>> exchange = restTemplate.exchange(uri, HttpMethod.GET, null,new ParameterizedTypeReference<List<T>>(){});
        // List<T> entities = exchange.getBody();

        // Api RestTemplate
        // <T> ResponseEntity<T>  exchange(java.net.URI url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType)
        // <T> ResponseEntity<T>  exchange(java.net.URI url, HttpMethod method, HttpEntity<?> requestEntity, java.lang.Class<T> responseType)
        ParameterizedTypeReference<List<Integer>> ref2 = new ParameterizedTypeReference<List<Integer>>() { };
        System.out.println(ref2.getType());
    }

    public static void DeserializationFeature_ACCEPT_SINGLE_VALUE_AS_ARRAY() throws IOException {

        /** DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY permite:
         *  {"id" : 1 ,"nombre" : "Esteban"} --Deserializarlo_asi-->  [Persona{id=1, nombre='Esteban'}]
         */


        final String jsonArray = "[{\"id\" : 1 ,\"nombre\" : \"Esteban\"}," +
                "{\"id\" : 1 ,\"nombre\" : \"Esteban\"}]";

        final String jsonSingleValue = "{\"id\" : 1 ,\"nombre\" : \"Esteban\"}";

        final ObjectMapper mapper = new ObjectMapper()
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        final List<Persona> personas = mapper.readValue(jsonSingleValue,
                new TypeReference<List<Persona>>() {
                });
        System.out.println(personas);
    }
}


