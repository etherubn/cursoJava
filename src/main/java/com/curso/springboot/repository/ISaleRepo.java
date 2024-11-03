package com.curso.springboot.repository;


import com.curso.springboot.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ISaleRepo extends IGenericRepo<Sale,Long>{



//    CREATE OR REPLACE FUNCTION fn_sales ()
//    RETURNS TABLE (
//            quantityFn INT,
//            datetimeFn TEXT
//    )
//    AS $$
//    DECLARE
//    var_r record;
//    BEGIN
//    FOR var_r IN(
//            select (count(*)::int) as quantity, to_char(s.date_time, 'dd/MM/yyyy') as datetime from sale s
//    group by to_char(s.date_time, 'dd/MM/yyyy') order by to_char(s.date_time, 'dd/MM/yyyy') asc
//	)
//    LOOP
//    quantityFn := var_r.quantity;
//    datetimeFn := var_r.datetime;
//    RETURN NEXT;
//    END LOOP;
//    END; $$
//    LANGUAGE 'plpgsql';
//
//    select * from fn_sales();
    @Query(nativeQuery = true,value = "select * from fn_sales();")
    List<Object[]> callProcedure1();


//    create or replace procedure pr_sales()
//    language plpgsql
//    as $$
//    begin
//    update sale set enabled = true;
//    end;$$
    @Procedure(procedureName = "pr_sales")
    void callProcedure4();
}
