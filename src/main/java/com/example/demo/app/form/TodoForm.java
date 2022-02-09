package com.example.demo.app.form;


import lombok.Data;

import java.io.Serializable;

@Data
public class TodoForm implements Serializable {

    private Integer id;
    private String title;
    private String description;
}
