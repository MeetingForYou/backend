package backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentTimeLocation {

    private Integer id;

    private Integer timeLocationId;

    private String contentType;

    private Integer schedulesId;

    private String createdTime;

    private String updatedTime;

}
