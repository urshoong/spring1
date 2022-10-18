package org.zerock.spring1.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//public class Member extends User {
public class Member implements UserDetails {

    private String mid, mpw, mname;

    private List<String> authList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getAuthList().stream().map(str -> new SimpleGrantedAuthority("ROLE_"+str)).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.getMpw();
    }

    @Override
    public String getUsername() {
        return this.getMid();
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

    /*
    //extends User 사용하는 경우 설정하던 부분
    //Spring Security 에서는 기본 형태가 id, pw, auth 밖에 없기 때문에
    //닉네임을 사용하기 위해서는 커스텀을 해야 한다
    public Member(String mid, String mpw, String mname, List<String> authList) {
        super(mid,
              mpw,
              authList.stream()
                      .map(str -> new SimpleGrantedAuthority(str))
                      .collect(Collectors.toList()) );
        this.mid = mid;
        this.mpw = mpw;
        this.mname = mname;
        this.authList = authList;
    }
    */
}
