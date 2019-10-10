package com.it.webui.model;

import javax.persistence.*;

@Table(name = "sys_config")
public class SysConfig {
    private String param;

    private String value;

    /**
     * @return param
     */
    public String getParam() {
        return param;
    }

    /**
     * @param param
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
}