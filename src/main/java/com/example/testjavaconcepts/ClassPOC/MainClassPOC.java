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

// Nota: The primitive Java types (boolean, byte, char, short, int, long, float, and double), and the keyword void are also represented as Class objects
// ex: int.class, void.class,...
public class MainClassPOC {
    public static void main(String[] args) {

        Persona persona = new Persona(23L, "Auron");

        // three ways equivalentes (ninguna es mejor que otra pero a partir de class literal es mas rapido) to create Class object

        Class<?> clazz = null;

        //
        // compile-time alternative
        //

        /** Opcion 1 (compile-time): 'class literal'
         *   The class name for which Class object is to be created is determined at compile-time
         */
        //clazz = Persona.class;

        //
        // run-time alternatives
        //

        /** Opcion 2 (run-time): Class.forName(String className)
         * Since class Class doesn’t contain any constructor, there is static factory method forName
         * The class name for which Class object is to be created is determined at run-time
         */
        try {
            clazz = Class.forName("com.example.testjavaconcepts.ClassPOC.Persona");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /** Opcion 3 (run-time):  obj.getClass()
         * The class name for which Class object is to be created is determined at run-time
         */
        //clazz = persona.getClass();

        System.out.println("*** extractDataFromClass ***");
        extractDataFromClass(clazz);

        System.out.println();

        System.out.println("*** extractDataFromObject ***");
        extractDataFromObject(clazz, persona);
    }


    private static void extractDataFromClass(Class<?> clazz) {
        Objects.requireNonNull(clazz, "Non null");
        System.out.println("Package: " + clazz.getPackage()); // Package: package com.example.testjavaconcepts.ClassPOC
        System.out.println("SimpleName: " + clazz.getSimpleName()); // Persona
        System.out.println("CanonicalName: " + clazz.getCanonicalName()); // com.example.testjavaconcepts.ClassPOC.Persona
        System.out.println("Name: " + clazz.getName()); // com.example.testjavaconcepts.ClassPOC.Persona
        System.out.println("TypeName: " + clazz.getTypeName()); // com.example.testjavaconcepts.ClassPOC.Persona
        System.out.println("ClassLoader: " + clazz.getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("DeclaredAnnotation: " + clazz.getDeclaredAnnotation(JsonInclude.class)); // @com.fasterxml.jackson.annotation.JsonInclude(valueFilter=class java.lang.Void, value=NON_EMPTY, content=ALWAYS, contentFilter=class java.lang.Void)
        System.out.println("isAnnotationPresent: " + clazz.isAnnotationPresent(JsonInclude.class));
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

    private static void extractDataFromObject(Class<?> clazz, Persona persona) {
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
