package com.swj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.swj.bean.Jurisdiction;
import com.swj.bean.UserInfo;

public interface UserInfoMapper {
	//��ѯ�����û���Ϣ
	List<UserInfo> getUserInfoAll();
	//��¼
	UserInfo UserInfoLogin(String loginid);
	//��ѯȨ��
	List<Jurisdiction> getidentity(Map<String, Object> map);
	//��ѯ������Ա�����Ա��
	List<UserInfo> getUserWhereNoAdmin();
	//ɾ���û�
	int delUser(@Param("userid")int userid);
	//������֤
	UserInfo DN(@Param("loginid")String loginid);
	//ע��
	int register(UserInfo info);
}
