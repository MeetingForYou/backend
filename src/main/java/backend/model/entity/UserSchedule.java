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
public class UserSchedule {

    private Integer id;

    private Integer userId;

    private Integer scheduleId;

    private Integer meetingId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String createdTime;

    private String updatedTime;

}
