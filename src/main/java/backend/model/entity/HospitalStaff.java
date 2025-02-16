package backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalStaff {

    private Integer id;

    private Integer participantId;

    private Integer hospitalId;

    private String level;

    private String professionalTitle;

    private String expertise;

    private String biography;

}
