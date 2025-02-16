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
public class Privilege {

    private Integer id;

    private Integer participantId;

    private Integer meetingId;

    private Integer topicId;

    private Integer subtopicId;

    private Integer forumId;

    private Integer scheduleId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
