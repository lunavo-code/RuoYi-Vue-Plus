package org.dromara.common.enums.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EnumInfo {
    private String key;
    private String description;
    @JsonIgnore
    private String permission;

    private List<EnumOption> options;
}
