package com.api.shoesshop.controllers;

import java.util.Map;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.query.Query;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.api.shoesshop.utils.Helper;

@Controller
public class StatisticsController {

    @GetMapping("/statistics/revenue")
    public ResponseEntity<String> getRevenues(@RequestParam Map<String, String> query) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        ProcedureCall call = session.createStoredProcedureCall("revenues_by_months_in_year_procedure");
        call.registerParameter(1, Long.class, ParameterMode.IN).bindValue(Long.valueOf(2022));
        ProcedureOutputs outputs = call.getOutputs();

        return Helper.responseSuccess(null);
    }

}
