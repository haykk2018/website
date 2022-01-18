package com.example.byGutierrez.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Data
@NoArgsConstructor //Она создает конструктор класса без аргументов
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Size(min = 2, max = 30)
    private String menuName;

    private Integer menuSequence;

    @Lob
    private String content;

    private boolean hidden;

    @NotNull
    private Lang lang;

    @NotNull
    private Integer langId;

    @Column(name = "begin_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date beginDate;

    @Column(name = "edit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date editDate;

    private String keywords;

    private String description;
    
    public enum Lang {
        arm, rus, eng;
    }
}