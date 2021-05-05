package com.enomoso.openapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pokemon {

    private String id;
    private String name;
    private String type;
    private String comment;
    
}
