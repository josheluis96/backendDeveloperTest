package com.example.demo.applications;

import com.example.demo.domain.PtProduct;

public interface ServiceProductInt {
public PtProduct savePtProduct(PtProduct client);
public PtProduct findByCodProduct(PtProduct client);
public boolean deleteProduct(PtProduct client);
}
