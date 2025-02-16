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
public class OrganizingCommittee {

    private Integer id;

    private Integer meetingId;

    private Integer participantId;

    private Integer levelId;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

}
