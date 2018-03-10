package com.muyus.muyucloud.view.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * AccountVO
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Data
public class AccountVO {
    @JsonProperty("author_name")
    private String authorName;
}
