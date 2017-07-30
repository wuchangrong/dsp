package com.handao.platform.sm.login.vo;

import com.handao.platform.framework.vo.AFValueObject;

public class UserPrivilegeVO extends AFValueObject{	
	private static final long serialVersionUID = 1L;
    
	private long row_id;  //ROW_ID
    private String program_code;  //程序代码
    private String program_name;  //程序名称
    private int inner_code;  //级次内码
    private long subsystem_id;  //所属模块ID
    private String subsystem_name;//所属模块
    private String menu_name;  //菜单名
    private String default_yn; //默认选中标志,[Y]-是;[N]-否
    private String file_name;  //文件名
    private String picture;  //图片
    private String target;  //目标帧
    private String start_program;  //运行路径
    private String leaf_yn;  //末级标志
    private int level_num;  //级次
    private long parent_module_id;  //上级程序ID
    private String parent_module_name;  //上级程序
    private String desc;  //功能描述
    private String using_flag;  //启用标志
    private String visible_flag;  //可见标志
    private long application_id;
    
	public long getRow_id() {
		return row_id;
	}
	public void setRow_id(long row_id) {
		this.row_id = row_id;
	}
	public String getProgram_code() {
		return program_code;
	}
	public void setProgram_code(String program_code) {
		this.program_code = program_code;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public int getInner_code() {
		return inner_code;
	}
	public void setInner_code(int inner_code) {
		this.inner_code = inner_code;
	}
	public long getSubsystem_id() {
		return subsystem_id;
	}
	public void setSubsystem_id(long subsystem_id) {
		this.subsystem_id = subsystem_id;
	}
	public String getSubsystem_name() {
		return subsystem_name;
	}
	public void setSubsystem_name(String subsystem_name) {
		this.subsystem_name = subsystem_name;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getDefault_yn() {
		return default_yn;
	}
	public void setDefault_yn(String default_yn) {
		this.default_yn = default_yn;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getStart_program() {
		return start_program;
	}
	public void setStart_program(String start_program) {
		this.start_program = start_program;
	}
	public String getLeaf_yn() {
		return leaf_yn;
	}
	public void setLeaf_yn(String leaf_yn) {
		this.leaf_yn = leaf_yn;
	}
	public int getLevel_num() {
		return level_num;
	}
	public void setLevel_num(int level_num) {
		this.level_num = level_num;
	}
	public long getParent_module_id() {
		return parent_module_id;
	}
	public void setParent_module_id(long parent_module_id) {
		this.parent_module_id = parent_module_id;
	}
	public String getParent_module_name() {
		return parent_module_name;
	}
	public void setParent_module_name(String parent_module_name) {
		this.parent_module_name = parent_module_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUsing_flag() {
		return using_flag;
	}
	public void setUsing_flag(String using_flag) {
		this.using_flag = using_flag;
	}
	public String getVisible_flag() {
		return visible_flag;
	}
	public void setVisible_flag(String visible_flag) {
		this.visible_flag = visible_flag;
	}
	public long getApplication_id() {
		return application_id;
	}
	public void setApplication_id(long application_id) {
		this.application_id = application_id;
	}	
}