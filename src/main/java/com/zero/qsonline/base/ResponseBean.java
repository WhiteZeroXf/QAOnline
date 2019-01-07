package com.zero.qsonline.base;

import java.io.Serializable;

/**
 * ResponseBean.OK：200, 请求成功，返回对应数据
 * ResponseBean.FAIL：300, 请求成功，但入参等有问题
 * ResponseBean.ERROR：500, 服务器内部运行错误
 *
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @Title: 后台返回 Bean
 * @Description: 简单使用方法：直接 ResponseBean.builder().build();
 * @date 创建时间：2018/10/16 11:19
 */

public class ResponseBean implements Serializable {

    public static ResponseBean OK = new ResponseBean(200, "Success");
    public static ResponseBean OK(){
        return new ResponseBean(200, "Success");
    }
    public static ResponseBean FAIL = new ResponseBean(400, "Request Success, But With Some Error");
    public static ResponseBean FAIL(){
        return new ResponseBean(400, "Request Success, But With Some Error");
    }
    public static ResponseBean ERROR = new ResponseBean(500, "Server Internal Error");
    public static ResponseBean ERROR(){
        return  new ResponseBean(500, "Server Internal Error");
    }

    private static final long serialVersionUID = -4064552268999978914L;

    private static int defaultCode = 200;
    private static String defaultMsg = "Success";
    private static Object defaultData = "";

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    private ResponseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = "";
    }

    public static ResponseBean getNew(Object data) {
        return new ResponseBean(ResponseBean.defaultCode, ResponseBean.defaultMsg, data);
    }

    public ResponseBean() {
    }

    public static ResponseBeanBuilder builder() {
        return new ResponseBeanBuilder();
    }

    public static class ResponseBeanBuilder {

        private int code;
        private boolean codeSet;
        private String msg;
        private boolean msgSet;
        private Object data;
        private boolean dataSet;

        ResponseBeanBuilder() {
        }

        public ResponseBeanBuilder code(Integer code) {
            this.code = code;
            this.codeSet = true;
            return this;
        }

        public ResponseBeanBuilder msg(String msg) {
            this.msg = msg;
            this.msgSet = true;
            return this;
        }

        public ResponseBeanBuilder data(Object data) {
            this.data = data;
            this.dataSet = true;
            return this;
        }

        public ResponseBean build() {

            int code = this.code;
            if (!this.codeSet) {
                code = ResponseBean.defaultCode;
            }

            String msg = this.msg;
            if (!this.msgSet) {
                msg = ResponseBean.defaultMsg;
            }
            Object data = this.data;
            if (!this.dataSet) {
                data = ResponseBean.defaultData;
            }

            return new ResponseBean(code, msg, data);
        }

        @Override
        public String toString() {
            return "ResponseBean.ResponseBeanBuilder(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
        }
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public ResponseBean msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseBean code(int code) {
        this.code = code;
        return this;
    }

    public ResponseBean data(Object data) {
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
