package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SoapClient;
import com.theprogrammerguide.consumesoap.stub.DetailsType;
import com.theprogrammerguide.consumesoap.stub.GetBankResponseType;
import com.theprogrammerguide.consumesoap.stub.GetBankType;
import com.theprogrammerguide.consumesoap.stub.ObjectFactory;

@RestController
@RequestMapping("/")
public class BlzController {

@Autowired
private SoapClient soapClient;

@GetMapping
public DetailsType sum(@RequestParam String code) {
ObjectFactory objectFactory = new ObjectFactory();
GetBankType type = new GetBankType();
type.setBlz(code);
// BlzServiceAdapter blzServiceAdapter=new BlzServiceAdapter();

GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",objectFactory.createGetBank(type));
return response.getDetails();
}
}