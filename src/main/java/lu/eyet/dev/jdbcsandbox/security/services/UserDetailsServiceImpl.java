package lu.eyet.dev.jdbcsandbox.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lu.eyet.dev.jdbcsandbox.model.Role;
import lu.eyet.dev.jdbcsandbox.model.User;
import lu.eyet.dev.jdbcsandbox.repository.RoleRepository;
import lu.eyet.dev.jdbcsandbox.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByMail(email);
        List<Role> roles = new ArrayList<>();
        user.getUserRoles().forEach(role -> roles.add(roleRepository.findById(role.getRole()).get()));

        return UserDetailsImpl.build(user, roles);
    }
}