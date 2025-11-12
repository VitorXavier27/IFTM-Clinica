package com.ClinicaMedica.IFTM.dto;

import java.time.Instant;

public class CustomError {

    private Instant timesstamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timesstamp, Integer status, String error, String path) {
        this.timesstamp = timesstamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimesstamp() {
        return timesstamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
