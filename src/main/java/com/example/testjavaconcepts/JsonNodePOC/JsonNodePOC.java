package com.example.testjavaconcepts.JsonNodePOC;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JsonNodePOC {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = "[{\"RECORD\":{ \"id\": 1  }}]";
        String json2 = "[\n" +
                "  {\n" +
                "  \"RECORD1\":{ \n" +
                "  \"id\": 1, \n" +
                "  \"nombre\": \"Esteban\" \n" +
                "  },\n" +
                "  \"RECORD2\":{ \n" +
                "    \"id2\": 1, \n" +
                "    \"nombre2\": \"Esteba\"\n" +
                "  }\n" +
                "}\n" +
                "]";

        String json3 = "{\n" +
                "    \"TABLE\": [\n" +
                "      {   \n" +
                "        \"RECORD\": [\n" +
                "          {     \n" +
                "            \"TR_MON_ORIG\": 80,\n" +
                "            \"TR_TOTAL_TRF\": \"\",\n" +
                "            \"TR_FECHA\": \"2019/03/14\",\n" +
                "            \"TR_MON_DES\": 80,\n" +
                "            \"TR_WSERVICIO\": \"ACTUALIZA_TARJETA_DEBITO\",\n" +
                "            \"TR_MONTO\": 0,\n" +
                "            \"TR_REF1\": \"\",\n" +
                "            \"TR_PROD_DES\": 16,\n" +
                "            \"TR_CTA_ORIG\": 4998590033943503,\n" +
                "            \"TR_DESC_ERR\": [],\n" +
                "            \"TR_PROD_ORIG\": 16,\n" +
                "            \"TR_CTA_DES\": 4998590033943503,\n" +
                "            \"TR_CBU\": \"\",\n" +
                "            \"TR_NUM_ERROR\": \"\",\n" +
                "            \"TR_ID_COBIS\": 821835,\n" +
                "            \"TR_RECIBO\": \"\",\n" +
                "            \"TR_REF2\": \"\",\n" +
                "            \"TR_TRN_ESTADO\": \"P\",\n" +
                "            \"TR_IMPUESTOS\": \"\",\n" +
                "            \"TR_ID_APP\": 8999025,\n" +
                "            \"TR_COMISION\": \"\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },  \n" +
                "      {   \n" +
                "        \"RECORD\": [\n" +
                "          {\n" +
                "            \"NUM_SOLICITUD\": 821835,\n" +
                "            \"TIPO_SOLICITUD\": \"ADA\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"TYPE\": \"OUTPUT\"\n" +
                "      }   \n" +
                "    ],\n" +
                "    \"service_name\": \"ACTUALIZA_TARJETA_DEBITO\",\n" +
                "    \"resultCode\": 0,\n" +
                "    \"ret_status\": 0\n" +
                "  }";

        JsonNode node = objectMapper.readTree(json3);

        JsonNode node2 = node.path("TABLE").path("RECORD").path("TR_MON_ORIG");

        Map<?,?> map = objectMapper.readValue(json3, Map.class);

        for( Map.Entry<?,?> entrySet : map.entrySet()) {
            if( entrySet.getKey() == "TABLE") {

            }
        }
    }
}
