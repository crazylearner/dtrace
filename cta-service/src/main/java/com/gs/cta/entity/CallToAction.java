package com.gs.cta.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by schellamuthu on 12/10/18.
 */
@Entity(name = "call_to_action")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallToAction {
    @Id
    private Long id;
    private String name;
    private String actionItem;
    private boolean type;
}
