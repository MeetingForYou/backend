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
public class UserMeeting {

    private Integer id;

    private Integer userId;

    private Integer meetingId;

    private String role;

    private String status;

    private String paymentStatus;

    private String paymentTime;

    private Boolean checkIn;

    private String checkInTime;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

}
