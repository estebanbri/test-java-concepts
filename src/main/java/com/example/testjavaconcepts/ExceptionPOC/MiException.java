package com.example.testjavaconcepts.ExceptionPOC;

public class MiException extends RuntimeException {

    ApiError apiError = new ApiError();

    MiException(ApiError apiError){
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }



}

