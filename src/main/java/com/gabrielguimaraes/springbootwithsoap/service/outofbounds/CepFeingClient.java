package com.gabrielguimaraes.springbootwithsoap.service.outofbounds;

import com.gabrielguimaraes.springbootwithsoap.datashape.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepFeingClient {

    @GetMapping("{cep}/json")
    Address buscaEnderecoPorCep(@PathVariable("cep") String cep);
}