package com.book.lend.record.model.factory;

import com.book.lend.record.dto.UserInfoDTO;
import com.book.lend.record.model.vo.UserInfo;

public class UserInfoFactory {
	public static UserInfo factory(UserInfoDTO userInfoDTO) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(userInfoDTO.getId());
		userInfo.setRealName(userInfoDTO.getRealName());

		return userInfo;
	}
}
