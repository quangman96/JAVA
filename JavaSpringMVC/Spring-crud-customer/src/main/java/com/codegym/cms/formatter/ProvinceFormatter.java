package com.codegym.cms.formatter;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFormatter implements For {
    private ProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Autowired
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.findById(Long.parseLong(text));
    }

    @Autowired
    public String print(Province object, Locale locale  )
}
