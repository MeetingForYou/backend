package backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guest {

    private Integer id;

    private Integer meetingId;

    private Integer participantId;

    private Integer schedulesId;
}
