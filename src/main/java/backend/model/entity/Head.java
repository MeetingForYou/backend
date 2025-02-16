package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Head {

    private Integer id;

    private Integer participantId;

    private Integer level;

    private Integer levelId;

}
