package backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    private Integer id;

    private String username;

    private String phone;

    private String password;

    private String userOrg;

    private String userDepartment;

    private String userTitle;

    private String userType;

    private String wxOpenId;

    private String wxUnionId;

    private String wechatAvatarUrl;

    private String loginType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String deviceInfo;

    private String deviceToken;

    private String lastLoginDevice;

    private String loginDeviceIds;

    private LocalDateTime lastLoginTime;

    private String lastLoginIp;

    public static User getAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
