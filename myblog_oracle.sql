drop table comments;
drop table articles;
drop table userinfos;

drop sequence seq_userinfo;
drop sequence seq_article;
drop sequence seq_comment;

create sequence seq_userinfo;
create sequence seq_article;
create sequence seq_comment;

CREATE TABLE userinfos(
  userid number NOT NULL primary key,
  loginid varchar2(50) NOT NULL,
  loginpwd varchar2(50) NOT NULL,
  username varchar2(50) NOT NULL,
	qq varchar2(20) NOT NULL,
	mail varchar2(50) NOT NULL,
  adminis number not null
);

CREATE TABLE articles(
	articleid number NOT NULL primary key,
	userid number NOT NULL references userinfos(userid),
	title varchar2(50) NOT NULL,
	articlecontent varchar2(4000) NOT NULL,
	pubdate date NOT NULL,
	clicks number NOT NULL,
	comments number NOT NULL,
  popular number not null
);

CREATE TABLE comments(
	commentid number NOT NULL primary key,
	articleid number NOT NULL references articles(articleid),
	authorname varchar2(50) NOT NULL,
	commentcontent varchar2(512) NOT NULL,
	pubdate date NOT NULL
);

insert into userinfos values (seq_userinfo.nextval,'accp','123','accp','12345678','accp@xzzb.com',0);
insert into userinfos values (seq_userinfo.nextval,'hp','123','����','98765432','hp@hp.com',0);
insert into userinfos values (seq_userinfo.nextval,'admin','123','��ΰ��','98765432','swj@hp.com',1);
insert into userinfos values (seq_userinfo.nextval,'ceshi�û�','123','����1','98765432','swj@hp.com',1);
insert into userinfos values (seq_userinfo.nextval,'ceshi�û�2','123','����2','98765432','swj@hp.com',1);
insert into userinfos values (seq_userinfo.nextval,'ceshi�û�3','123','����1','98765432','swj@hp.com',0);
insert into userinfos values (seq_userinfo.nextval,'ceshi�û�4','123','����2','98765432','swj@hp.com',0);

commit;
insert into articles values (seq_article.nextval,1,'���Ϳ���','�����ǲ��Ϳ�����',to_date('2009-10-09','yyyy-MM-dd'),2,1,0);
insert into articles values (seq_article.nextval,1,'����һƪ','�ڶ�ƪ����',to_date('2009-10-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,2,'hp��˾','̨ʽ�����ʼǱ�������������',to_date('2009-10-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,2,'xiaomi','�ֻ����ʼǱ������ӡ��ľߡ���',to_date('2009-10-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,1,'��Ϊ','�ֻ����ʼǱ������ӡ���',to_date('2020-4-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,1,'vivo','�ֻ����ʼǱ������ӡ���',to_date('2020-4-09','yyyy-MM-dd'),0,0,0);

commit;
insert into comments values (seq_comment.nextval,1,'guoke','�����һ��',to_date('2009-10-09','yyyy-MM-dd')); 
commit;

select * from userinfos;
select * from articles;
select * from comments;
--��ѯ����


--��ѯ���º�����
select a.articlecontent from articles a, comments c where a.comments=c.commentid
and a.articleid=2
select * from comments where articleid=1
--Ȩ��
create sequence seq_j;
drop table Jurisdiction;
create table Jurisdiction
(
       id number primary key,
       Jname varchar2(50) not null,
       urls varchar2(50) not null,
       identity number not null
);
insert into Jurisdiction values(seq_j.nextval,'��������','Release.action',0);
insert into Jurisdiction values(seq_j.nextval,'���¹���','article_ids.action',0);
insert into Jurisdiction values(seq_j.nextval,'�������','browse.action',0);
insert into Jurisdiction values(seq_j.nextval,'�û�����','users.action',0);
insert into Jurisdiction values(seq_j.nextval,'�û�����','userszsgc.action',1);
commit;
update Jurisdiction set identity=0 where id=4
--��¼����ѯadminis�����Ϊ0������������ѯ�����admins=1,��ѯ����
select * from Jurisdiction j,userinfos u where j.identity=u.adminis and u.adminis=3;




/*ģ��Ȩ��*/



select * from Jurisdiction j where j.identity=0

select * from userinfos u,Jurisdiction j  where loginid=#{loginid}
