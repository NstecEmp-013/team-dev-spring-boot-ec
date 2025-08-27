package com.fullness.ec.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fullness.ec.entity.EmployeeAccount;

/**
 * 認証情報クラス
 */
public class AccountUserDetails implements UserDetails{

    private final EmployeeAccount employeeAccount;
    /**
     * コンストラクタ
     * @param employeeAccount
     */
    public AccountUserDetails(EmployeeAccount employeeAccount){
        this.employeeAccount = employeeAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 権限が無いので 空コレクションを返す
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return employeeAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return employeeAccount.getName();
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
