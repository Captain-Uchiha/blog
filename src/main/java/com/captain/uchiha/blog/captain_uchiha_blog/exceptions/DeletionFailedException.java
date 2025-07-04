
package com.captain.uchiha.blog.captain_uchiha_blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DeletionFailedException extends BlogException {
    public DeletionFailedException(String resourceName, String fieldName, String fieldValue) {
        super(
            String.format("Failed to update %s with %s: %s", resourceName, fieldName, fieldValue),
            resourceName,
            fieldName,
            fieldValue
        );
    }
}
