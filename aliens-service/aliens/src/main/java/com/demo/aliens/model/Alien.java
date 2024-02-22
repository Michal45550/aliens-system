package com.demo.aliens.model;

import com.demo.aliens.model.enums.Vehicle;
import com.demo.aliens.model.enums.Weapon;
import jakarta.persistence.*;
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

}
