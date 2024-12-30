package com.rrm.module.resource.domain.vo;

import com.rrm.module.resource.domain.model.RrmResource;
import lombok.Getter;
import lombok.Setter;

/**
 * 资源管理
 */
@Getter
@Setter
public class RrmResourceVO extends RrmResource {

    private String resourceTypeName;
    private String environmentName;
    private String authCodeName;

}