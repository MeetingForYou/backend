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
public class Participant {

private Long participantsId;

    private Integer id;

    private String name;

    private Integer gender;

    private String phone;

    private String email;

    private String category;

    private Integer isExpert;

    private Integer userId;

    private String avatarUrl;

    private String biography;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
