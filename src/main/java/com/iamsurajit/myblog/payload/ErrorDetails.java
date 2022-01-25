package com.iamsurajit.myblog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private Date timeStamp;
    private String msg;
    private String details;

}
