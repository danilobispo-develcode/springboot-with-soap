package com.gabrielguimaraes.springbootwithsoap.service.impl;

import com.gabrielguimaraes.springbootwithsoap.service.outofbounds.CepFeignClient;
import com.gabrielguimaraes.springbootwithsoap.service.CepService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CepServiceImpl implements CepService {

    @Autowired
    private CepFeignClient cepFeignClient;

    @Override
    public String findAddressByCep(String cep) {
        return cepFeignClient.buscaEnderecoPorCep(cep).toString();
    }
}
