package com.example.testjavaconcepts;

/**
 * Created by JacksonGenerator on 25/03/19.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class RECORDItem {
    @JsonProperty("TR_MON_ORIG")
    private Integer tRMONORIG;
    @JsonProperty("TR_TOTAL_TRF")
    private String tRTOTALTRF;
    @JsonProperty("TR_FECHA")
    private String tRFECHA;
    @JsonProperty("TR_MON_DES")
    private Integer tRMONDES;
    @JsonProperty("TR_WSERVICIO")
    private String tRWSERVICIO;
    @JsonProperty("TR_MONTO")
    private Integer tRMONTO;
    @JsonProperty("TR_REF1")
    private String tRREF1;
    @JsonProperty("TR_PROD_DES")
    private Integer tRPRODDES;
    @JsonProperty("TR_CTA_ORIG")
    private Long tRCTAORIG;
    @JsonProperty("TR_DESC_ERR")
    private List tRDESCERR;
    @JsonProperty("TR_PROD_ORIG")
    private Integer tRPRODORIG;
    @JsonProperty("TR_CTA_DES")
    private Long tRCTADES;
    @JsonProperty("TR_CBU")
    private String tRCBU;
    @JsonProperty("TR_NUM_ERROR")
    private String tRNUMERROR;
    @JsonProperty("TR_ID_COBIS")
    private Integer tRIDCOBIS;
    @JsonProperty("TR_RECIBO")
    private String tRRECIBO;
    @JsonProperty("TR_REF2")
    private String tRREF2;
    @JsonProperty("TR_TRN_ESTADO")
    private String tRTRNESTADO;
    @JsonProperty("TR_IMPUESTOS")
    private String tRIMPUESTOS;
    @JsonProperty("TR_ID_APP")
    private Integer tRIDAPP;
    @JsonProperty("TR_COMISION")
    private String tRCOMISION;
}