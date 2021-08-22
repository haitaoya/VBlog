package com.iain.blog.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Classname ArticleTyp
 * @Description 文章分类实体类
 * @Date 2020/9/13 9:26 下午
 * @Created by wht
 */
@Data
public class ArticleCategory extends BaseBean{
    private String pkId;
    private String typNam;
    private String superTypId;
    private String rejectReason;
    private String chkUsr;
    private Date chkTm;
}
