package com.eregistrar.miueregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "block")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blockId")
    private Integer blockId;
    private LocalDate startDate;
    private String blockName;
    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL)
    private List<CourseOffering> courseOffering;
}
