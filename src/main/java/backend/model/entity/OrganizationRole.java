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
public class OrganizationRole {

    private Integer id;

    private Integer meetingId;

    private Integer organizationId;

    private String role;

    private String name;

    private Boolean isDeleted;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

}
