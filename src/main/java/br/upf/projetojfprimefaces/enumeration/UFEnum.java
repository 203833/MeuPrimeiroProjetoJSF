package br.upf.projetojfprimefaces.enumeration;

public enum UFEnum {

    RS("Rio Grande do SUl"),
    SC("Santa Catarina"),
    SP("Sao Paulo");
    private String value;

    private UFEnum(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
}
