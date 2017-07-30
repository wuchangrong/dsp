package com.handao.platform.framework.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AFAjax {

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}