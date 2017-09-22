package com.book.lend.record.model.assemble;

import com.book.lend.record.dto.UserInfoDTO;
import com.book.lend.record.model.vo.UserInfo;

public class UserInfoAssemble {
	public static UserInfoDTO assemble(UserInfo userInfo) {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setId(userInfo.getId());
		userInfoDTO.setRealName(userInfo.getRealName());

		return userInfoDTO;
	}

}
