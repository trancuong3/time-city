package com.example.demo10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model,
                                    @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();

        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();

        // Lấy ra time zone của thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);

        // Tính thời gian hiện tại của thành phố cụ thể
        long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());

        // Cài đặt lại thời gian cho biến date
        date.setTime(localeTime);

        // Thêm dữ liệu vào model để chuyển tới view
        model.addAttribute("city", city);
        model.addAttribute("date", date);

        return "index";
    }
}
