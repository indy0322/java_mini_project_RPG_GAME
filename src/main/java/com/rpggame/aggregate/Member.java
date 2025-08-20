package com.rpggame.aggregate;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private int memNo;
    private String id;
    private String pwd;

    public Member() {
    }

    public Member(int memNo, String id, String pwd) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
