package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {

    private Integer id;

    private Integer forumId;

    private Integer speakerId;

    private String title;

    private Boolean isPrivate;

    private String description;

    private String create_time;

    private String update_time;

}
