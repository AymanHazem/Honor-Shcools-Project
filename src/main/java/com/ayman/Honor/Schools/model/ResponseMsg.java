package com.ayman.Honor.Schools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMsg
{
    private String statusCode;
    private String statusMsg;
}
