package com.jchj.jwt;

public class PermissionBaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public PermissionBaseException(String msg) {
        super(msg);
    }
}
