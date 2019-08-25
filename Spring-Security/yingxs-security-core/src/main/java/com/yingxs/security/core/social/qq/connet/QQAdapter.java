package com.yingxs.security.core.social.qq.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.yingxs.security.core.social.qq.api.QQ;
import com.yingxs.security.core.social.qq.api.QQUserInfo;

/**
 * @author yingxs
 *
 */
public class QQAdapter implements ApiAdapter<QQ> {

	// 测试api服务师傅正常
	@Override
	public boolean test(QQ api) {
		return true;
	}

	/**
	 * QQAdapter的目的就是为在api和connection之间做一次适配
	 * 将connection中需要的数据从api中拿出来 设置进去
	 */
	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		values.setProfileUrl(null);// 个人主页
		values.setProviderUserId(userInfo.getOpenId());
		
	}

	@Override
	public UserProfile fetchUserProfile(QQ api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(QQ api, String message) {
		// TODO Auto-generated method stub
		
	}

}
