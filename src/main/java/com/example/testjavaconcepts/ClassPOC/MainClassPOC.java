package com.example.testjavaconcepts.ClassPOC;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClassPOC {
    public static void main(String[] args) {

        Persona persona = new Persona(23L, "Auron");

        // three ways to create Class object

        Class clazz = null;

        try {
            clazz = Class.forName("com.example.testjavaconcepts.ClassPOC.Persona"); // Class.forName(String className)
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //clazz = Persona.class; // a partir de un 'class literal'

        //clazz = persona.getClass(); // creando un objeto Class a partir de una instancia viva usando getClass()

        System.out.println("*** extractDataFromClass ***");
        extractDataFromClass(clazz);

        System.out.println();

        System.out.println("*** extractDataFromObject ***");
        extractDataFromObject(clazz, persona);
    }


    private static void extractDataFromClass(Class clazz) {
        Objects.requireNonNull(clazz, "Non null");
        System.out.println("Package: " + clazz.getPackage()); // Package: package com.example.testjavaconcepts.ClassPOC
        System.out.println("SimpleName: " + clazz.getSimpleName()); // Persona
        System.out.println("CanonicalName: " + clazz.getCanonicalName()); // com.example.testjavaconcepts.ClassPOC.Persona
        System.out.println("Name: " + clazz.getName()); // com.example.testjavaconcepts.ClassPOC.Persona
        System.out.println("TypeName: " + clazz.getTypeName()); // com.example.testjavaconcepts.ClassPOC.Persona
        System.out.println("ClassLoader: " + clazz.getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("DeclaredAnnotation: " + clazz.getDeclaredAnnotation(JsonInclude.class)); // @com.fasterxml.jackson.annotation.JsonInclude(valueFilter=class java.lang.Void, value=NON_EMPTY, content=ALWAYS, contentFilter=class java.lang.Void)
        System.out.println("Annotation: " + clazz.getAnnotation(JsonInclude.class)); // @com.fasterxml.jackson.annotation.JsonInclude(valueFilter=class java.lang.Void, value=NON_EMPTY, content=ALWAYS, contentFilter=class java.lang.Void)
        System.out.println("Constructors: " +  buildStringFromArray(clazz.getConstructors())); // public com.example.testjavaconcepts.ClassPOC.Persona(),public com.example.testjavaconcepts.ClassPOC.Persona(java.lang.Long,java.lang.String)
        try {
            System.out.println("Constructor: " +  clazz.getConstructor()); // public com.example.testjavaconcepts.ClassPOC.Persona()
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("DeclaredMethods: " + buildStringFromArray(clazz.getDeclaredMethods())); // DeclaredMethods: public java.lang.String com.example.testjavaconcepts.ClassPOC.Persona.toString(),public java.lang.Long com.example.testjavaconcepts.ClassPOC.Persona.getId(),public void com.example.testjavaconcepts.ClassPOC.Persona.setId(java.lang.Long),public java.lang.String com.example.testjavaconcepts.ClassPOC.Persona.getNombre(),public void com.example.testjavaconcepts.ClassPOC.Persona.setNombre(java.lang.String)

        try {
            System.out.println("Field: " + clazz.getField("nombre")); // Field: public java.lang.String com.example.testjavaconcepts.ClassPOC.Persona.nombre
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("Fields: " +  buildStringFromArray(clazz.getFields())); // Fields: public java.lang.Long com.example.testjavaconcepts.ClassPOC.Persona.id,public java.lang.String com.example.testjavaconcepts.ClassPOC.Persona.nombre
        System.out.println("Modifiers: " + clazz.getModifiers()); // Modifiers: 1 Significa que la clase esta con public
        InputStream inputStream = clazz.getResourceAsStream("/json/data.json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            System.out.println("json id: " + jsonNode.get("id")); // 1
            System.out.println("json nombre: " + jsonNode.get("nombre")); // "Jose"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractDataFromObject(Class clazz, Persona persona) {
        Objects.requireNonNull(clazz, "Non null");
        try {
            Field field = clazz.getField("nombre");
            System.out.println("Field " + field.getName() + " value: " + field.get(persona)); // Field nombre value: Auron
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static <T> String buildStringFromArray(T[] arr) {
        return Stream.of(arr)
                .map(T::toString)
                .collect(Collectors.joining(", "));
    }
}
