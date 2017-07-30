package com.handao.platform.framework.dao;

import com.handao.platform.framework.util.AFInstanceFactory;

public class AFDAOProvider {
    private AFDAOProvider() {
    }

    public static AFDAOBase getDAOByClass(String boClass) {
        return (AFDAOBase)AFInstanceFactory.createInstance(boClass);
    }
}