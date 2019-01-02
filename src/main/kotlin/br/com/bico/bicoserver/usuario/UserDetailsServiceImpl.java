package br.com.bico.bicoserver.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(login);
        if (usuario != null) {
            return User.withUsername(usuario.getEmail())
                    .password(usuario.getSenha())
                    .roles("CLIENT").build();
        } else {
            throw new UsernameNotFoundException("Não foi possível encontrar o usuário " + login);
        }
    }
}