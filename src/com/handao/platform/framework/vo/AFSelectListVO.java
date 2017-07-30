package com.handao.platform.framework.vo;

import com.handao.platform.framework.web.AFForm;

public class AFSelectListVO
    extends AFValueObject {

  private static final long serialVersionUID = 1L;

  private String name;

  private String code;

  private String list_code;

  public String getName() {
    return name;
  }

  public String getList_code() {
    return list_code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setList_code(String list_code) {
    this.list_code = list_code;
  }

  public String getCode() {
    return code;
  }

  public AFSelectListVO() {
  }

  public AFForm transform() {
      return null;
  }
}