package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantExperience {

    private Integer id;

    private Integer participantId;

    private Integer organizationId;

    private String department;

    private String jobTitle;

    private Integer isPrimary;

    private LocalDate startDate;

    private LocalDate endDate;

}
