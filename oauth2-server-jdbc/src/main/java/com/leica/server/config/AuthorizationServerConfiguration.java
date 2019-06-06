package com.leica.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

/**
 * Oauth2配置
 *
 * @author leica
 * @since 2019/6/6 0:51
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    private final DataSource dataSource;

    public AuthorizationServerConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * {@link ClientDetailsServiceConfigurer}:配置客户端信息
     * <p>
     * 配置JdbcClientDetailsService
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    /**
     * jdbc存储Token
     *
     * @return {@link TokenStore}
     */
    @Bean
    public TokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * {@link AuthorizationServerEndpointsConfigurer}:配置授权Token和Token服务
     * Token管理策略:
     * 1. {@link InMemoryTokenStore}:Token存储在内存中
     * 2. {@link JdbcTokenStore}:Token存储在数据库中
     * 3. {@link JwtTokenStore}:采用JWT形式,这种形式没有任何的存储,因为JWT包含了用户验证的所有信息,不需要存储。采用JWT形式,需要引入spring-jwt依赖。
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jdbcTokenStore());
    }
}
