package com.handao.platform.framework.web.jsp.taglib.grid;

public class AFGridCellCommTag extends AFGridCellBaseTag {

	private static final long serialVersionUID = 1L;
	
	protected String width;
    protected String align = "center";
    protected String property;//属性
    protected String title;//列题头
    protected String dataFormat;//数据格式化

    protected int dataType = AFGridConstants.DATA_TYPE_STRING;//数据类型
    protected int totalType = AFGridConstants.TOTAL_TYPE_NONE;//合计类型

    protected boolean taxisable = true;//是否可排序
    protected boolean mergeable = false;//是否可合并

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getProperty() {
        return property;
    }
    public void setProperty(String property) {
        this.property = property;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = Integer.parseInt(dataType);
    }

    public String getDataFormat() {
        return dataFormat;
    }
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }
    public boolean isTaxisable() {
        return taxisable;
    }
    public void setTaxisable(String taxisable) {
        this.taxisable = "true".equalsIgnoreCase(taxisable);
    }
    public int getTotalType() {
        return totalType;
    }
    public void setTotalType(String totalType) {
        this.totalType = Integer.parseInt(totalType);
    }
    public boolean isMergeable() {
        return mergeable;
    }
    public void setMergeable(String mergeable) {
        this.mergeable = "true".equalsIgnoreCase(mergeable);
    }




    protected AFGridCellBase getCell() {
        AFGridCellComm cell = new AFGridCellComm();
        cell.setId(this.id);
        cell.setWidth(this.width);
        cell.setAlign(this.align);
        cell.setDataFormat(this.dataFormat);
        cell.setProperty(this.property);
        cell.setTitle(this.title);
        cell.setDataType(this.dataType);
        cell.setTotalType(this.totalType);
        cell.setTaxisable(this.taxisable);
        cell.setMergeable(this.mergeable);
        return cell;
    }

    public void release() {
        width = null;
        align = "center";
        property = null;
        title = null;
        dataFormat = null;
        dataType = AFGridConstants.DATA_TYPE_STRING;
        totalType = AFGridConstants.TOTAL_TYPE_NONE;
        taxisable = true;
        mergeable = false;
        super.release();
    }


}

class AFGridCellComm extends AFGridCellBase {

    protected String id;
    protected String align;
    protected String width;
    protected String property;
    protected String title;
    protected String dataFormat;
    protected int dataType;
    protected int totalType;
    protected boolean taxisable;
    protected boolean mergeable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public boolean isTaxisable() {
        return taxisable;
    }

    public void setTaxisable(boolean taxisable) {
        this.taxisable = taxisable;
    }

    public int getTotalType() {
        return totalType;
    }

    public void setTotalType(int totalType) {
        this.totalType = totalType;
    }

    public boolean isMergeable() {
        return mergeable;
    }

    public void setMergeable(boolean mergeable) {
        this.mergeable = mergeable;
    }


}
