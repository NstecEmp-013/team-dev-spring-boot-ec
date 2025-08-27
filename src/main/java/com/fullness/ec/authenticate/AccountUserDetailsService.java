package com.fullness.ec.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fullness.ec.entity.EmployeeAccount;
import com.fullness.ec.repository.EmployeeAccountRepository;

/**
 * 認証情報をSpring Securityに提供するサービスインターフェース実装クラス
 */
@Service
public class AccountUserDetailsService implements UserDetailsService{

    @Autowired
    EmployeeAccountRepository employeeAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 画面に入力されたユーザー名でユーザー情報を取得する
        EmployeeAccount employeeAccount =
            employeeAccountRepository.selectByName(username);
        if (employeeAccount == null) {
            throw new UsernameNotFoundException("ユーザー名が見つかりません: " + username);
        }
        return new AccountUserDetails(employeeAccount);
    }
}