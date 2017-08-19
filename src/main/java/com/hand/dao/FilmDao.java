package com.hand.dao;

import com.hand.pojo.Film;
import com.hand.pojo.PageBean;

import java.util.List;

/**
 * Created by 铭刻 on 2017/8/15.
 */
public interface FilmDao {


    List<Film> queryAll();

    int addFilm(Film film);

    int editFilm(Film film);

    int deleFilm(short filmId);

    Film getFilmById(short filmId);

    int getFilmCount();

    List<Film> getPage(PageBean page);

   int getFilmByTitle(String title);
}
