package com.learn.algos.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeSearchNotFoundErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
