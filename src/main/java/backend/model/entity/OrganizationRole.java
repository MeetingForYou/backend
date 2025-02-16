package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationRoles {

    private Integer id;

    private Integer meetingId;

    private Integer organizationId;

    private String role;

    private String name;

    private Boolean isDeleted;

    private String createdTime;

    private String updatedTime;

}
