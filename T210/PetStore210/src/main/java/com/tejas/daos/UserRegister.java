package com.tejas.daos;

import com.tejas.enums.Role;

import lombok.Data;

@Data
public class UserRegister {
	private String email;
	private String password;
	private Role role;
}
