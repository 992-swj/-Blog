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
insert into userinfos values (seq_userinfo.nextval,'hp','123','惠普','98765432','hp@hp.com',0);
insert into userinfos values (seq_userinfo.nextval,'admin','123','孙伟杰','98765432','swj@hp.com',1);
insert into userinfos values (seq_userinfo.nextval,'ceshi用户','123','测试1','98765432','swj@hp.com',1);
insert into userinfos values (seq_userinfo.nextval,'ceshi用户2','123','测试2','98765432','swj@hp.com',1);
insert into userinfos values (seq_userinfo.nextval,'ceshi用户3','123','测试1','98765432','swj@hp.com',0);
insert into userinfos values (seq_userinfo.nextval,'ceshi用户4','123','测试2','98765432','swj@hp.com',0);

commit;
insert into articles values (seq_article.nextval,1,'博客开张','北极星博客开张啦',to_date('2009-10-09','yyyy-MM-dd'),2,1,0);
insert into articles values (seq_article.nextval,1,'再来一篇','第二篇博客',to_date('2009-10-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,2,'hp公司','台式机、笔记本、服务器……',to_date('2009-10-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,2,'xiaomi','手机、笔记本、电视、文具……',to_date('2009-10-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,1,'华为','手机、笔记本、电视……',to_date('2020-4-09','yyyy-MM-dd'),0,0,0);
insert into articles values (seq_article.nextval,1,'vivo','手机、笔记本、电视……',to_date('2020-4-09','yyyy-MM-dd'),0,0,0);

commit;
insert into comments values (seq_comment.nextval,1,'guoke','帮你踩一踩',to_date('2009-10-09','yyyy-MM-dd')); 
commit;

select * from userinfos;
select * from articles;
select * from comments;
--查询文章


--查询文章和评论
select a.articlecontent from articles a, comments c where a.comments=c.commentid
and a.articleid=2
select * from comments where articleid=1
--权限
create sequence seq_j;
drop table Jurisdiction;
create table Jurisdiction
(
       id number primary key,
       Jname varchar2(50) not null,
       urls varchar2(50) not null,
       identity number not null
);
insert into Jurisdiction values(seq_j.nextval,'发表文章','Release.action',0);
insert into Jurisdiction values(seq_j.nextval,'文章管理','article_ids.action',0);
insert into Jurisdiction values(seq_j.nextval,'浏览博客','browse.action',0);
insert into Jurisdiction values(seq_j.nextval,'用户博客','users.action',0);
insert into Jurisdiction values(seq_j.nextval,'用户管理','userszsgc.action',1);
commit;
update Jurisdiction set identity=0 where id=4
--登录，查询adminis，如果为0，就是正常查询，如果admins=1,查询所有
select * from Jurisdiction j,userinfos u where j.identity=u.adminis and u.adminis=3;




/*模拟权限*/



select * from Jurisdiction j where j.identity=0

select * from userinfos u,Jurisdiction j  where loginid=#{loginid}
