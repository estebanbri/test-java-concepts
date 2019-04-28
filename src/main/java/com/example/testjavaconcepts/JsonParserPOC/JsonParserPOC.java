package com.example.testjavaconcepts.JsonParserPOC;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public class JsonParserPOC {

    void m() throws IOException {

        String carJson =
                "{ \"key1\" : \"Soy El Value\", \"key2\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser  parser  = factory.createParser(carJson);

//        while(!parser.isClosed()) {
//            JsonToken jsonToken = parser.nextToken();
//
//            System.out.println(jsonToken);
//        }
        //        START_OBJECT
        //        FIELD_NAME
        //        VALUE_STRING
        //        FIELD_NAME
        //        VALUE_NUMBER_INT
        //        END_OBJECT
        //        null

//        while( !parser.isClosed() ) {
//            JsonToken jsonToken = parser.nextToken(); // KEY
//
//            if( JsonToken.FIELD_NAME.equals(jsonToken)) {
//                String key = parser.getCurrentName();
//                System.out.print(key);
//                parser.nextToken(); // VALUE
//                String value = parser.getValueAsString();
//                System.out.println(value);
//            }
//        }
//        brandMercedes
//        doors5

        MiObjeto obj = new MiObjeto();

        while( !parser.isClosed() ) {

            JsonToken jsonToken = parser.nextToken(); // KEY

            if( JsonToken.FIELD_NAME.equals(jsonToken)) {
                String key = parser.getCurrentName();
                parser.nextToken(); // VALUE;
                switch(key){
                    case "key1": obj.setField1(parser.getValueAsString()); break;
                    case "key2": obj.setField2(parser.getValueAsInt()); break;
                }
            }
        }
        System.out.println(obj);

 }
}
class MiObjeto {

    private String field1;

    private Integer field2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "MiObjeto{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }


}
