package org.dromara.common.enums.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnumOption {
    private Integer value;
    private String label;
    private Integer order;
}
