package com.arunesh.DataReader.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class JSONdata {
    @Id
    private String id;
    private String name;
    private String language;
    @Column(length = 8000)
    private String bio;
    private String version;
}
