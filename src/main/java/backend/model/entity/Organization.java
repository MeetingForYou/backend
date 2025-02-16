package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization {

    private Integer id;

    private String logoUrl;

    private String orgName;

    private String orgType;

    private String orgInfo;

    private Integer parentUnit;

    private Integer createdBy;

    private Integer updatedBy;

    private String createTime;

    private String updateTime;

}
