package de.lendico.api.properties;

import lombok.Data;

@Data
public class Config {
    private String host;
    private Key key;
    private Budget budget;
}