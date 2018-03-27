package com.ht.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.ht.model.User;
import com.ht.service.UserService;

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//用户输入的用户名
		String name = (String)token.getPrincipal();
		//用户输入的密码
		String password = new String((char[])token.getCredentials());
		
		//根据用户名去数据库查询密码
		User u=userService.seluser(name);
	
		if(u==null) {
			return null;
		}else {
			Object principal  = u.getName();//用户名
			Object credentials = u.getPwd();
			AuthenticationInfo  info = new SimpleAuthenticationInfo(u, credentials, ByteSource.Util.bytes(u.getName()), this.getName());
		
			return info;//返回给安全管理器，由安全管理器负责比对数据库中查询出的密码和页面提交的密码
		}
	
	}
}
