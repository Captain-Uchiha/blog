package com.captain.uchiha.blog.captain_uchiha_blog.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceNotFoundException extends RuntimeException{

    private final String resouceName;
    private final String uniqueIdName;
    private final String uniqueIdValue;

    public ResourceNotFoundException(String resouceName, String uniqueIdName, String uniqueIdValue) {
        super(String.format(" %s was not found with unique id %s : value : %s",resouceName,uniqueIdName,uniqueIdValue));
        this.resouceName = resouceName;
        this.uniqueIdName = uniqueIdName;
        this.uniqueIdValue = uniqueIdValue;
    }

    public String getResouceName() {
        return resouceName;
    }

    public String getUniqueIdName() {
        return uniqueIdName;
    }

    public String getUniqueIdValue() {
        return uniqueIdValue;
    }

}
