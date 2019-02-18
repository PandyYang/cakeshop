package com.xzy.service.imp;

import java.util.Date;

import com.xzy.mapper.LogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzy.mapper.UsersMapper;
import com.xzy.pojo.Logs;
import com.xzy.pojo.Users;
import com.xzy.service.GuestService;
@Service
@Transactional
public class GuestServiceImp implements GuestService {

	@Autowired
   private UsersMapper  usersMapper;
	@Autowired
   private LogsMapper logsMapper;
   
	@Override
	public void registUser(Users u) 
	{
		/*usersMapper.addUser(u);
		Logs l=new Logs();
		l.setMsg("新增了一条日志---"+new Date());
	
		logsMapper.addMsg(l);*/
		 

	}

public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	public LogsMapper getLogsMapper() {
		return logsMapper;
	}

	public void setLogsMapper(LogsMapper logsMapper) {
		this.logsMapper = logsMapper;
	}



}
