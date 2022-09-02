package com.acme.processor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {

    private String id;
    private String timestamp;
    private int temperature;
}
