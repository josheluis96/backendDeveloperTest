package com.example.demo.applications;

import com.example.demo.domain.PtClient;

public interface ServiceClienteInt {
public PtClient saveptcliente(PtClient client);
public PtClient findByCodClient(PtClient client);
public boolean deleteCliente(PtClient client);
}
