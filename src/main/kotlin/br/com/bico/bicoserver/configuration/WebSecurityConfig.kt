package br.com.bico.bicoserver.configuration

import br.com.bico.bicoserver.usuario.UserDetailsServiceImpl
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig(var userDetailsService: UserDetailsServiceImpl) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()

                .and()

                // filtra requisições de login
                .addFilterBefore(JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter::class.java)

                // filtra outras requisições para verificar a presença do JWT no header
                .addFilterBefore(JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        // cria uma conta default

        auth!!.userDetailsService(userDetailsService())
                .passwordEncoder((BCryptPasswordEncoder()))
    }

    override fun userDetailsService(): UserDetailsService {
        return userDetailsService
    }
}