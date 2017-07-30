package com.handao.platform.framework.web;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.util.AFInstanceFactory;
import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFCompositeForm extends AFForm {

    protected String detailExtendSize = "1";

    public String getDetailExtendSize() {
        return detailExtendSize;
    }

    public void setDetailExtendSize(String detailExtendSize) {
        this.detailExtendSize = detailExtendSize;
    }

    public void addDetailSize(List detailList, int size, String detailFormClass) {
        initFormList(detailList, (detailList.size()-1+size), detailFormClass);
    }

    public void cleanDetailList() {
        List[] dList = getDetailList();
        if(dList != null) {
            for(int i=0; i<dList.length; i++) {
                if(dList[i] == null)
                    dList[i] = new ArrayList();
                else
                    dList[i].clear();
            }
        }
    }
    
    protected int getDetailSize(List detailList) {
        if(detailList == null)
            return 0;
        return detailList.size();
    }


    protected AFForm getDetailForm(List detailList, int index, String detailFormClass) {
        detailList = initFormList(detailList, index, detailFormClass);
        return (AFForm)detailList.get(index);
    }

    private List initFormList(List detailList, int index, String detailFormClass) {
        if(detailList == null)
            detailList = new ArrayList();

        int oldSize = detailList.size();
        if(oldSize < index+1) {
            for(int i=oldSize; i<=index; i++) {
                AFForm form = (AFForm)AFInstanceFactory.createInstance(detailFormClass);
                form.initialize();
                detailList.add(form);
            }
        }

        return detailList;
    }

    protected List transformDetail(List detailFormList) {
        List detailVOList = new ArrayList();
        if(detailFormList!=null && detailFormList.size()!=0) {
            for(int i=0; i<detailFormList.size(); i++) {
                AFForm form = (AFForm)detailFormList.get(i);
                if(form.isValidate())
                    detailVOList.add(form.transform());
            }
        }
        return detailVOList;
    }


    protected List transformDetail(List detailVOList, String detailFormClass) {
        List detailFormList = new ArrayList();
        if(detailVOList!=null && detailVOList.size()!=0) {
            for(int i=0; i<detailVOList.size(); i++) {
                AFValueObject vo = (AFValueObject)detailVOList.get(i);
                AFForm form = (AFForm)AFInstanceFactory.createInstance(detailFormClass);
                form.transform(vo);
                detailFormList.add(form);
            }
        }
        return detailFormList;
    }

    public abstract List[] getDetailList();
}