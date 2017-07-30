package com.handao.platform.framework.bo;

import java.util.ArrayList;

import com.handao.platform.framework.util.AFInstanceFactory;

public class AFBOProvider {
    private AFBOProvider() {
    }

    public static AFBusinessObject getBOByClass(String boClass) {
        return (AFBusinessObject)AFInstanceFactory.createInstance(boClass);
    }

    public static AFBusinessObject[] getBoByName(String[] boNames) {
        if(boNames!=null && boNames.length!=0) {
            ArrayList list = new ArrayList();
            for(int i=0; i<boNames.length; i++) {
                list.add(AFInstanceFactory.createInstance(boNames[i]));
            }
            return (AFBusinessObject[])list.toArray();
        }
        return new AFBusinessObject[0];
    }
}