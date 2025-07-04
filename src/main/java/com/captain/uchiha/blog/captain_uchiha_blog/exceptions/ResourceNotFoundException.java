package com.captain.uchiha.blog.captain_uchiha_blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BlogException {

    public ResourceNotFoundException(String resourceName, String uniqueIdName, String uniqueIdValue) {
        super(
            String.format("%s was not found with %s: %s", resourceName, uniqueIdName, uniqueIdValue),
            resourceName,
            uniqueIdName,
            uniqueIdValue
        );
    }
}
