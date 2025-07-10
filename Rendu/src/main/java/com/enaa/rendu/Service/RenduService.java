package com.enaa.rendu.Service;

import com.enaa.rendu.Feign.ApprenantClient;
import com.enaa.rendu.Feign.BreifClient;
import com.enaa.rendu.Mappers.RenduMap;
import com.enaa.rendu.Repository.RenduRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RenduService {

    private  ApprenantClient apprenantClient;

    private RenduRepository renduRepository;

    private  RenduMap renduMap;

    private BreifClient breifClient;



}
