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
public class TimeLocation {

    private Integer id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String location;
}
