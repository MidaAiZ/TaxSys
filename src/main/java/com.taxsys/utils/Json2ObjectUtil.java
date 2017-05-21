package com.taxsys.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxsys.model.User;


public class Json2ObjectUtil {
	
	public static User getUser(String json) {
		
		User user = new User();
		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> map = new HashMap<String, String>();
			map = mapper.readValue(json, new TypeReference<Map<String, String>>() {
			});
 			// 生成userID
			String uuid  =  UUIDGeneratorUtil.getUUID();
			user.setId(uuid);

			if(map.containsKey("number")) {
				user.setNumber(map.get("number"));
			}
			if(map.containsKey("gender")) {
				user.setGender(Integer.parseInt(map.get("gender")));
			}
			if(map.containsKey("nickname")) {
				user.setNickname(map.get("nickname"));
			}
			if(map.containsKey("cellphone")) {
				user.setCellphone(map.get("cellphone"));
			}
			if(map.containsKey("password")) {
				user.setPassword(map.get("password"));
			}
			if(map.containsKey("createTime")) {
				user.setCreateTime(map.get("createTime"));
			}
			if(map.containsKey("avatar")) {
				user.setNumber(map.get("avatar"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (user.getId() == null) {
			user.setId(UUIDGeneratorUtil.getUUID());
		}

			return user;
	}
}
