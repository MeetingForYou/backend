package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {

    private Integer id;

    private Integer orgId;

    private String hospitalType;

    private String hospitalLevel;

    private String specialties;

    private Integer addressId;

    private String contactInfo;

    private String createTime;

    private String updateTime;

//    医院表是单位表中的一种类型，医院表用于记录医院的特有信息。
//    hospital_id INT PRIMARY KEY AUTO_INCREMENT,
//    organization _id：外键，指向单位表的org_id，医院是单位表中的一个类型
//    hospital_type: 医院类型（如“公立医院”、“私立医院”）
//    hospital_level:医院级别，三甲
//    specialties：存储医院的专长科室
//    address_id,  -- 外键，关联Org_Addresses中医院地址
//    contact_info VARCHAR(255),  -- 联系方式
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 创建时间
//            updated_at

}
