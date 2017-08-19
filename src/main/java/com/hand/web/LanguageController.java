package com.hand.web;

import com.hand.DTO.Msg;
import com.hand.pojo.Language;
import com.hand.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 铭刻 on 2017/8/18.
 */
@Controller
@RequestMapping("language")
public class LanguageController {

    @Autowired
    private LanguageService serivce;

    @RequestMapping("/allLanguage")
    public @ResponseBody Msg language(){

        List<Language> languages =  serivce.queryAll();

        return Msg.success().add("languages",languages);

    }

}
