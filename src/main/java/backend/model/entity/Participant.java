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
public class Participants {

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    participant_id BIGINT PRIMARY KEY AUTO_INCREMENT, --唯一标识
    name VARCHAR(255) NOT NULL,                  -- 姓名
    gender ENUM('male', 'female', 'other'),      -- 性别
    phone VARCHAR(20),                           -- 联系电话
    email VARCHAR(255),                          -- 邮箱地址
    category ENUM((医院、企业、高校、协会、研究机构、其他)) NOT NULL, -- 工作机构分类
    is_expert TINYINT(1) DEFAULT 0, -- 是否为专家
    user_id BIGINT UNIQUE, -- 关联的注册用户ID
    avatar_url VARCHAR(255),                     -- 头像地址
    biography TEXT,                              -- 个人简介
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

}
