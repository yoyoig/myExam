package com.hand.web;

import com.hand.pojo.Film;
import com.hand.pojo.PageBean;
import com.hand.service.FilmService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 铭刻 on 2017/8/15.
 */
@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService service;


    //主页面
//    @RequestMapping(value = "/queryAll",method = {RequestMethod.POST,RequestMethod.GET})
//    public String queryAll(Model model,PageBean page){
//
//        PageBean pageBean = service.queryPage(page);
//        model.addAttribute("page",pageBean);
//        System.out.println("test");
//        return "/main.jsp";
//
//    }

    /**
     * 使用handlebar
     * @return
     */
    @RequestMapping(value = "/queryAll",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody PageBean queryAll(PageBean page){
        System.out.println(",,,"+page);
        PageBean pageBean = service.queryPage(page);
        System.out.println(",,,"+pageBean);
        return pageBean;

    }


    //添加电影
    @RequestMapping(value = "/addFilm",method = RequestMethod.POST)
    public String addFilm(@Validated Film film, BindingResult result, Model model){

        System.out.println(result);
        if(result.hasErrors()){

            List<FieldError> errorss = result.getFieldErrors();
            for (FieldError error:errorss) {
                model.addAttribute("err_"+error.getField(),error.getDefaultMessage());
            }

            return "/addFilm.jsp";
        }else{
            service.addFilm(film);
            return "redirect:/film/queryAll";

        }
        
        
        
        //非空验证
//        if (film.getTitle()==null ||
//                film.getDescription()==null ||
//                film.getLanguageId()==0||
//                film.getTitle().equals("") ||
//                film.getDescription().equals("") ){
//
//
//            model.addAttribute("msg","以上信息不能为空！");
//            return "/addFilm.jsp";
//
//
//        }else{
//            service.addFilm(film);
//            return "redirect:/film/queryAll";
//
//        }
    }

    //转到更新页面
    @RequestMapping(value = "/toEditFilm",method = RequestMethod.GET)
    public String toEditFilm(@Param("filmId") short filmId, Model model){

        Film film = service.getFilmById(filmId);
        model.addAttribute("film",film);
        System.out.println(film);
        return "/editFilm.jsp";
    }


    //更新电影
    @RequestMapping(value = "/editFilm",method = RequestMethod.POST)
    public String editFilm(Film film,Model model){

        System.out.println(film.getTitle()+","+film.getDescription()+","+film.getLanguageId());
        //非空验证
        if (film.getTitle()==null ||
                film.getDescription()==null ||
                film.getLanguageId()==0 ||
                film.getTitle().equals("") ||
                film.getDescription().equals("") ){


            model.addAttribute("msg","以上信息不能为空！");
            return "/editFilm.jsp";


        }else{

            service.editFilm(film);
            return "redirect:/film/queryAll";

        }
    }

    //删除电影
    @RequestMapping(value = "/deleFilm",method = RequestMethod.GET)
    public String deleFilm(Film film){

        service.deleFilm(film.getFilmId());
        return "redirect:/film/queryAll";

    }

    //得到电影名
    @RequestMapping(value = "/filmName",method = RequestMethod.POST)
    public void filmName(HttpServletRequest req, HttpServletResponse resp){

        String filmName =  req.getParameter("filmName");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }


        boolean isEx = service.nameIsEx(filmName);
        String result = "{isEx:"+isEx+"}";

        out.print(result);


    }

}
