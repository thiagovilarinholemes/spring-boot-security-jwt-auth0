package com.thiago.services.execptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
