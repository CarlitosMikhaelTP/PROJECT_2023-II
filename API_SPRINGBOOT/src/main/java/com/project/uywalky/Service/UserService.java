package com.project.uywalky.Service;

import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.dto.NuevoUsuarioDTO;
import com.project.uywalky.repository.TipoUsuarioRepository;
import com.project.uywalky.user.User;
import com.project.uywalky.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//////////////////////////////// DESPUES ELIMINAR ///////////////
    private final TipoUsuarioRepository tipoUsuarioRepository;

    private final UserRepository userRepository;
    @Autowired // Para inyectar nuestro repositorio
    //Servicio que será llamado en el controlador para listar los registros
    public UserService (UserRepository userRepository, TipoUsuarioRepository tipoUsuarioRepository){
        this.userRepository = userRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<User> listarUsers(){
        return userRepository.findAll();
    }
    //Servicio que será llamado por el controlador para guardar los nuevos registros
    public void guardarUsers(User user){
        userRepository.save(user);
    }

    //Servicio para obtener un registro por medio del número de su id
    public User obtenerUsers(Integer id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

    //Servicio para eliminar un registro
    public void eliminarUsers(Integer id){
        userRepository.deleteById(id);
    }

    public void saveUserTypeForAuthenticatedUser(Integer id, TipoUsuario tipoUsuario){
        User user= obtenerUsers(id);
        user.setTipoUsuario(tipoUsuario);
        guardarUsers(user);
    }

    public void registrarUsuarioConTipo(NuevoUsuarioDTO nuevoUsuarioDTO){
        Optional<TipoUsuario> tipoUsuarioOptional = tipoUsuarioRepository.findById(nuevoUsuarioDTO.getTipoUsuario());
        tipoUsuarioOptional.ifPresent(tipoUsuario -> {
            User user = new User();
            user.setNombres(nuevoUsuarioDTO.getNombres());
            user.setApellidos(nuevoUsuarioDTO.getApellidos());
            user.setApodo(nuevoUsuarioDTO.getApodo());
            user.setDireccion(nuevoUsuarioDTO.getDireccion());
            user.setEdad(nuevoUsuarioDTO.getEdad());
            user.setCelular(nuevoUsuarioDTO.getCelular());
            user.setDni(nuevoUsuarioDTO.getDni());
            user.setEmail(nuevoUsuarioDTO.getEmail());
            user.setPassword(nuevoUsuarioDTO.getPassword());

            user.setTipoUsuario(tipoUsuario);
            userRepository.save(user);
        });
    }
}
