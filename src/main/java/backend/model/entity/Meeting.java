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
public class Meeting {

    private Integer id;

    private String name;

    private String description;

    private String type;

    private Boolean is_private;

    private Integer creator;

    private Integer field_id;

    private String status;

    private LocalDate start_date;

    private LocalDate end_date;

    private String city;

    private String location;

    private Boolean isDeleted;

    private Boolean haveCredits;

    private Boolean isPaid;

    private LocalDate deletedTime;

    private Integer deletedBy;

    private Integer createdBy;

    private LocalDate createTime;

    private LocalDate updateTime;

}
