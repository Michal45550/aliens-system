package com.demo.aliens.model;

import com.demo.aliens.model.enums.AlienType;
import com.demo.aliens.model.enums.Vehicle;
import com.demo.aliens.model.enums.Weapon;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`aliens`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private long id;

    @NotNull
    @Size(max = 40)
    @Column(name = "`name`", length = 40, nullable = false)
    private String name;

    @Column(name = "`commander id`", length = 40)
    private Long commanderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "`weapon`")
    private Weapon weapon;

    @Column(name = "`vehicle`")
    @Enumerated(EnumType.STRING)
    private Vehicle vehicle;

    @NotNull
    @Column(name = "`type`", nullable = false)
    @Enumerated(EnumType.STRING)
    private AlienType type;

}
