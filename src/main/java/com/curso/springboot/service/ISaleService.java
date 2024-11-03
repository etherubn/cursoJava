package com.curso.springboot.service;

import com.curso.springboot.dto.ProcedureDto;
import com.curso.springboot.model.Sale;

import java.util.List;
import java.util.Map;

public interface ISaleService extends ICRUD<Sale,Long>{
    //Obtener la venta más cara
    // select max(total) from sale
    Sale getSAleMostExpensive();

    //Obtener el nombre del usuario con más ventas
    String getNameBestUser();

    //Contar la cantidad de ventas por vendedor
    Map<String,Long> getSaleCountBySeller();

    Map<String,Double> getMostSellerProduct();

    List<ProcedureDto> callProcedure1();
    void callProcedure4();
}
