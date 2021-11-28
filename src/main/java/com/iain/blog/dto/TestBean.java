package com.iain.blog.dto;

import com.iain.blog.domain.BaseBean;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Classname TestBean
 * @Description TODO
 * @Date 2021/9/8 上午9:44
 * @Created by wht
 */
@Data
public class TestBean extends BaseBean {
    private String wang;
    private String hai;
    public BigDecimal bal;
    private Long aLong;
}
