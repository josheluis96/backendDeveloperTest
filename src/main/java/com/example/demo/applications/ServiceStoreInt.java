package com.example.demo.applications;

import com.example.demo.domain.PtStore;

public interface ServiceStoreInt {
public PtStore saveptStore(PtStore client);
public PtStore findByCodStore(PtStore client);
public boolean deleteStore(PtStore client);
}
