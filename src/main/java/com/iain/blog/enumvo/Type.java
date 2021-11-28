package com.iain.blog.enumvo;

public enum Type {
    A("sss"){
        @Override
        public String getType() {
            return "我覆盖了类实例方法";
        }
    }, B, C, D;
    Type(){
    }
    Type(String type){
        this.type = type;
    }
    static int value = 9;
    String type;
    public static int getValue(){
        return value;
    }

    public String getType(){
        return type;
    }

}
