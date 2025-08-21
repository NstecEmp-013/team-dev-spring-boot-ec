package com.fullness.ec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import jakarta.servlet.DispatcherType;

/**
 * Spring Securityの動作環境設定クラス
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AccountUserDetailsService service;
    @Autowired 
    private PasswordEncoder encoder;

    /**
     * データベースから認証情報を取得するDaoAuthenticationProviderを使う認証マネージャを生成する
     * @param userDetailsService ユーザー名から UserDetails を取得するサービス
     * @param passwordEncoder    平文パスワードとハッシュを照合するエンコーダ
     * @return AuthenticationManager（ProviderManagerの実装）
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(encoder); 
        return new ProviderManager(provider);
    }

    /**
     * 認証対象外のURLを設定とログイン/ログアウト処理制御
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(auth -> auth
              // エラーページや内部フォワード時のリクエストは認証不要にする
              .dispatcherTypeMatchers(DispatcherType.ERROR, DispatcherType.FORWARD).permitAll()
              // 静的リソースは全部許可（/css, /js, /images 等）
              .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
              // 公開ページ
              .requestMatchers("/", "/index.html", "/admin").permitAll()
              // ログイン画面は必ず許可
              .requestMatchers("/login", "/login.html").permitAll()
              // それ以外は認証必須
              .anyRequest().authenticated()
          )
          .formLogin(form -> form
              .loginPage("/admin/login")                 
              .loginProcessingUrl("/auth")
              .usernameParameter("username")
              .passwordParameter("password")
              .defaultSuccessUrl("/admin", true)
              .failureUrl("/login")
              .permitAll()
          )
          .logout(l -> l
              .logoutUrl("/logout")
              .logoutSuccessUrl("/admin")
              .invalidateHttpSession(true)
              .deleteCookies("JSESSIONID")
              .clearAuthentication(true)
              .permitAll()
          )
          // Basic認証を無効化
          .httpBasic(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
