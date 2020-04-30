package com.swj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.swj.bean.Jurisdiction;
import com.swj.bean.UserInfo;

public interface UserInfoMapper {
	//查询所有用户信息
	List<UserInfo> getUserInfoAll();
	//登录
	UserInfo UserInfoLogin(String loginid);
	//查询权限
	List<Jurisdiction> getidentity(Map<String, Object> map);
	//查询除管理员以外的员工
	List<UserInfo> getUserWhereNoAdmin();
	//删除用户
	int delUser(@Param("userid")int userid);
	//重名验证
	UserInfo DN(@Param("loginid")String loginid);
	//注册
	int register(UserInfo info);
}
