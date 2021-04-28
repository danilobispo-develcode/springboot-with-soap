package com.gabrielguimaraes.springbootwithsoap.datashape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(logradouro);
        sb.append(", ");
        sb.append(complemento);
        sb.append(", ");
        sb.append(bairro);
        sb.append(", ");
        sb.append(localidade);
        sb.append("-");
        sb.append(uf);
        sb.append(".");
        return sb.toString();
    }
}
