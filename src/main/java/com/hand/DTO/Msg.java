package com.hand.DTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 铭刻 on 2017/8/18.
 */
public class Msg {

    //设置状态码，
   private int code;

    //设置状态信息，
   private String msg;

   //扩展信息
   private Map<String,Object> extend = new HashMap<String, Object>();

   //成功时拿到的Msg
   public static Msg success(){
       Msg msg = new Msg();
       msg.setCode(100);
       msg.setMsg("成功");
       return msg;

   }

    //失败时拿到的Msg
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("成功");
        return msg;
    }

    //给Msg添加扩展信息
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
