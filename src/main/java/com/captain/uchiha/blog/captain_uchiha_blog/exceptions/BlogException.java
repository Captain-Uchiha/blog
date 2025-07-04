package com.captain.uchiha.blog.captain_uchiha_blog.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BlogException extends RuntimeException{

    private final String resouceName;
    private final String uniqueIdName;
    private final String uniqueIdValue;

    public BlogException(String resouceName, String uniqueIdName, String uniqueIdValue,String message) {
        super(message);
        this.resouceName = resouceName;
        this.uniqueIdName = uniqueIdName;
        this.uniqueIdValue = uniqueIdValue;

    }

    public String setErrorMessage(String resouceName, String uniqueIdName, String uniqueIdValue) {
        return String.format(" %s was not found with unique id %s : value : %s", resouceName, uniqueIdName, uniqueIdValue);
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
