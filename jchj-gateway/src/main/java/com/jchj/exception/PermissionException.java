package com.jchj.exception;

import com.jchj.jwt.PermissionBaseException;

public class PermissionException extends PermissionBaseException {
	private static final long serialVersionUID = 1L;
	public PermissionException(String msg) {
        super(msg);
    }
}
