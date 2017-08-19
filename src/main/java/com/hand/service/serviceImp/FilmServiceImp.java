package com.hand.service.serviceImp;

import com.hand.dao.FilmDao;
import com.hand.pojo.Film;
import com.hand.pojo.PageBean;
import com.hand.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 铭刻 on 2017/8/15.
 */
@Service
public class FilmServiceImp implements FilmService {

    @Autowired
    private FilmDao dao;

    @Override
    public List<Film> queryAll() {
        return dao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    public int addFilm(Film film) {
        return dao.addFilm(film);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    public int editFilm(Film film) {
        return dao.editFilm(film);
    }

    @Override
    public int deleFilm(short filmId) {
        return dao.deleFilm(filmId);
    }

    @Override
    public Film getFilmById(short filmId) {
        return dao.getFilmById(filmId);
    }

    @Override
    public PageBean queryPage(PageBean page) {
        //当当前页为空时，为第一次访问
        if(page.getCurrentPage() == 0){
            page.setCurrentPage(1);
        }
        //得到总电影数
        int totalFilmCount = dao.getFilmCount();

        //默认一页6条数据
        page.setPageSize(6);

        //初始化page值
        page.setTotalCount(totalFilmCount);
        page.setPrePage(page.getPrePage());
        page.setNextPage(page.getNextPage());
        page.setTotalPage(page.getTotalPage());
        page.setStartNum(page.getStartNum());

        System.out.println(page);
        List<Film> list = dao.getPage(page);

        page.setList(list);

        return page;
    }

    @Override
    public boolean nameIsEx(String title) {
        if (dao.getFilmByTitle(title)==0){
            return true;
        }else {
            return false;
        }
    }


}
