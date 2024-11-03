package com.curso.springboot.service.impl;

import com.curso.springboot.dto.ProcedureDto;
import com.curso.springboot.dto.ProductDto;
import com.curso.springboot.model.Sale;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.repository.ISaleRepo;
import com.curso.springboot.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SaleServiceImpl extends CRUDImpl<Sale,Long> implements ISaleService {

    private final ISaleRepo iSaleRepo;

    @Override
    protected IGenericRepo<Sale, Long> getRepo() {
        return iSaleRepo;
    }

    //Obtener la venta más cara
    // select max(total) from sale
    @Override
    public Sale getSAleMostExpensive() {
        return iSaleRepo.findAll()
                .stream()
                .max(Comparator.comparing(Sale::getTotal))
                .orElse(null)
                ;
    }


    //Obtener el usuario con mayor venta
    //select sum(s.total), ud.username from sale s inner join user_data ud on s.id_user=ud.id=user group by ud.username;
    @Override
    public String getNameBestUser() {
        Map<String,Double> byUser =  iSaleRepo.findAll().stream()
                .collect(Collectors.groupingBy(s->s.getUser().getUsername(),Collectors.summingDouble(t->t.getTotal())));
        
        return Collections.max(byUser.entrySet(),Comparator.comparingDouble(entry-> entry.getValue())).getKey();
    }

    //obtener la cantida de ventas por usuario
    //select count(s.total), ud.username from sale s inner join user_data ud on s.id_user=ud.id=user group by ud.username;
    @Override
    public Map<String, Long> getSaleCountBySeller() {

        return iSaleRepo.findAll().stream()
                .collect(Collectors.groupingBy(s->s.getUser().getUsername(),Collectors.counting()));
    }


    //obtener el producto más vendido
    //select p.name, sum(sd.quantity)
    //from sale_detail sd inner join product p on sd.id_product=p.id_product
    //group by p.name order by 2 desc;
    @Override
    public Map<String, Double> getMostSellerProduct() {
        Map<String,Double> doubleMap = iSaleRepo.findAll().stream()
                .flatMap(sale->sale.getSaleDetails().stream())
                . collect(Collectors.groupingBy(d->d.getProduct().getName(),Collectors.summingDouble(de->de.getQuantity())));
        return doubleMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldvalue,neewvalue)-> oldvalue, ()-> new LinkedHashMap<>()
                ));
    }

    @Override
    public List<ProcedureDto> callProcedure1() {
        List<ProcedureDto> procedureDtos = new ArrayList<>();
        iSaleRepo.callProcedure1().forEach(e->{
            ProcedureDto procedureDto = new ProcedureDto();
            procedureDto.setQuantityfn(Integer.parseInt(String.valueOf(e[0])) );
            procedureDto.setDatetimefn(String.valueOf(e[1]));
            procedureDtos.add(procedureDto);
        });


        return procedureDtos;
    }

    @Override
    public void callProcedure4() {
        iSaleRepo.callProcedure4();
    }


}
