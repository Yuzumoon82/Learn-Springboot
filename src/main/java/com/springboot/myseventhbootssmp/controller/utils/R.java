package com.springboot.myseventhbootssmp.controller.utils;

import lombok.Data;

@Data
public class R {
    private boolean flag;
    private Object data;

    public R (){}

    public R (Boolean flag){
        this.flag = flag;
    }

    public R (Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
}
