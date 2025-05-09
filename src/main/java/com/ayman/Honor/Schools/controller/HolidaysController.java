package com.ayman.Honor.Schools.controller;
import com.ayman.Honor.Schools.model.Holiday;
import com.ayman.Honor.Schools.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidaysController
{
    private HolidaysRepository holidaysRepository;
    @Autowired
    public HolidaysController(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
    }
    @GetMapping("/holidays/{display}")
    public String displayHolidays (@PathVariable String display, Model model)
    {
        if (null != display && display.equals("all"))
        {
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }
        else if (null!=display && display.equals("festival"))
            model.addAttribute("festival",true);
        else if (null!=display && display.equals("federal"))
            model.addAttribute("federal",true);
        Iterable<Holiday> holidays = holidaysRepository.findAll();
        List <Holiday> holidaysList= StreamSupport.stream(holidays.spliterator(), false).collect(Collectors.toList());
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types )
            model.addAttribute(type.toString(),(holidaysList.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        return "holidays.html";
    }
}
