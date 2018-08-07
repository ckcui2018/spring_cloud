package oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        System.out.println("configure-security");
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println("configure-clients");
        /*clients.inMemory() // 使用in-memory存储
                .withClient("webapp") // client_id
                .resourceIds("order")
                .secret("password") // client_secret
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")// 该client允许的授权类型
                .scopes("myapp"); // 允许的授权范围
*/
        //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory().withClient("client_1")
//                .resourceIds("order")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("clientA")
                .secret("12345")
                .and().withClient("client_2")
                .resourceIds("order1")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("clientB")
                .secret("12345");

         /*.and()
                .withClient("webapp")
                .scopes("xx")
                .authorizedGrantTypes("implicit");*/
    }

   /* public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("first").secret("passwordforauthserver")
                .redirectUris("http://localhost:8080/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800)
                .and()
                .withClient("second").secret("passwordforauthserver")
                .redirectUris("http://localhost:8081/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800);
    }*/


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        System.out.println("configure-endpoints");
        // @formatter:off
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        // @formatter:on
    }
}
