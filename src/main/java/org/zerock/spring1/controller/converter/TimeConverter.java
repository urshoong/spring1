package org.zerock.spring1.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter implements Converter<String, Date> {

    private SimpleDateFormat simpleDateFormat;

    public TimeConverter(){
        simpleDateFormat = new SimpleDateFormat("hh:mm");
    }

    @Override
    public Date convert(String source) {

        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace(); //bad code
            return null;
        }
    }
}
