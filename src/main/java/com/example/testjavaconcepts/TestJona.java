package com.example.testjavaconcepts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJona {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(new ThirdPartyFeasibilityRequestDTO()));
    }
}
 class ThirdPartyFeasibilityRequestDTO {

    @JsonProperty(value="REQ_User_Name")
    private String username;

    @JsonProperty(value="REQ_Tech_Comments")
    private String techComments;

    @JsonProperty(value="REQ_Quote")
    private String quoteNumber;

    @JsonProperty(value="REQ_FK_Country")
    private String country;

    @JsonProperty(value="REQ_TipoCons")
    private String consultType;

    @JsonProperty(value="REQ_Proto")
    private String protocol;

    @JsonProperty(value="REQ_BW")
    private String bw;

    @JsonProperty(value="REQ_PrePosVenta")
    private String preAfterSales;

    @JsonProperty(value="REQ_LineaProd")
    private String productLine;

    @JsonProperty(value="REQ_Cliente_A")
    private String client;

    @JsonProperty(value="REQ_Cli_Direccion_A")
    private String clientAddress;

    @JsonProperty(value="REQ_Cli_Ciudad_A")
    private String clientCity;

    @JsonProperty(value="REQ_Cli_Estado_A")
    private String clientState;

    @JsonProperty(value="REQ_Cli_Contacto_A")
    private String clientContact;

    @JsonProperty(value="REQ_Cli_Telefono_A")
    private String clientTelephone;

    @JsonProperty(value="REQ_Cli_ZipCode_A")
    private String clientZipCode;

    @JsonProperty(value="REQ_Nodo_ID_B")
    private String nodeId;

    @JsonProperty(value="REQ_Nodo_B")
    private String node;

    @JsonProperty(value="REQ_Nodo_Direccion_B")
    private String nodeAddress;

    @JsonProperty(value="REQ_Nodo_Contacto_B")
    private String nodeContact;

    @JsonProperty(value="REQ_Nodo_Telefono_B")
    private String nodeTelephone;

    @JsonProperty(value="REQ_MTU")
    private String mtu;

    @JsonProperty(value="REQ_Protocol")
    private String protocolEvpl;

    @JsonProperty(value="REQ_VLAN_TAG")
    private String vlanTag;

    @JsonProperty(value="REQ_Negotiation")
    private String negotiation;

    @JsonProperty(value="REQ_Speed")
    private String speed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTechComments() {
        return techComments;
    }

    public void setTechComments(String techComments) {
        this.techComments = techComments;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(String quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConsultType() {
        return consultType;
    }

    public void setConsultType(String consultType) {
        this.consultType = consultType;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getBw() {
        return bw;
    }

    public void setBw(String bw) {
        this.bw = bw;
    }

    public String getPreAfterSales() {
        return preAfterSales;
    }

    public void setPreAfterSales(String preAfterSales) {
        this.preAfterSales = preAfterSales;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    public String getClientZipCode() {
        return clientZipCode;
    }

    public void setClientZipCode(String clientZipCode) {
        this.clientZipCode = clientZipCode;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNodeAddress() {
        return nodeAddress;
    }

    public void setNodeAddress(String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    public String getNodeContact() {
        return nodeContact;
    }

    public void setNodeContact(String nodeContact) {
        this.nodeContact = nodeContact;
    }

    public String getNodeTelephone() {
        return nodeTelephone;
    }

    public void setNodeTelephone(String nodeTelephone) {
        this.nodeTelephone = nodeTelephone;
    }

    public String getMtu() {
        return mtu;
    }

    public void setMtu(String mtu) {
        this.mtu = mtu;
    }

    public String getProtocolEvpl() {
        return protocolEvpl;
    }

    public void setProtocolEvpl(String protocolEvpl) {
        this.protocolEvpl = protocolEvpl;
    }

    public String getVlanTag() {
        return vlanTag;
    }

    public void setVlanTag(String vlanTag) {
        this.vlanTag = vlanTag;
    }

    public String getNegotiation() {
        return negotiation;
    }

    public void setNegotiation(String negotiation) {
        this.negotiation = negotiation;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}