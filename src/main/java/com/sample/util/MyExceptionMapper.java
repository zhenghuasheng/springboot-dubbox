package com.sample.util;

import com.sample.model.Consumer;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class MyExceptionMapper implements ExceptionMapper<Exception> {

	public Response toResponse(Exception e) {
		Consumer consumer = new Consumer(1,"1111","zhs","localhost");

		return Response.status(Response.Status.OK)

				.entity(consumer)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
