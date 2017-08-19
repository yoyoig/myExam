package com.hand.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by 铭刻 on 2017/8/15.
 */
public class Film {
    /**
     *  film_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
     title VARCHAR(255) NOT NULL,
     description TEXT DEFAULT NULL,
     release_year YEAR DEFAULT NULL,
     language_id TINYINT UNSIGNED NOT NULL,
     original_language_id TINYINT UNSIGNED DEFAULT NULL,
     rental_duration TINYINT UNSIGNED NOT NULL DEFAULT 3,
     rental_rate DECIMAL(4,2) NOT NULL DEFAULT 4.99,
     replacement_cost DECIMAL(5,2) NOT NULL DEFAULT 19.99,
  ast_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     */
    private short filmId;
    //@NotNull无效
    //@NotNull(message = "电影标题不能为空")


    //邮箱验证没有非空验证，需要组合@NotEmpty使用
    //@Email(message = "请输入正确的邮箱")

    @NotEmpty(message = "民称不能为空")
    private String title;

    //可以添加多个验证
    @NotEmpty(message = "描述不能为空")
    @Size(max = 15,min = 5,message = "请输入5-15个字符！")
    private String description;
    private String language;
    private short languageId;

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", languageId=" + languageId +
                '}';
    }
}
