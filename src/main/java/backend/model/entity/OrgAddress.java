package backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgAddress {

    private Integer id;

    private String city;

    private String province;

    private String district;

    private String address;

    private String addressType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
