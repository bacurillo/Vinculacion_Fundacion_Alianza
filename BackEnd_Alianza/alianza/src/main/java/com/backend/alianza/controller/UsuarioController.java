package com.backend.alianza.controller;

import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.model.Usuario;
import com.backend.alianza.repository.UsuarioRepository;
import com.backend.alianza.service.UsuarioService;
import com.backend.alianza.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService UsuarioService;
    @Autowired
    UsuarioRepository UserRepository;

    @Autowired
    public UsuarioServiceImpl serviceIpmpl;


    @PostMapping("/signin")
    public Usuario IniciarSesion(@RequestBody Usuario usuario) throws Exception {
        if (UserRepository.existsByUsername(usuario.getUsername())) {
            if (UserRepository.existsByPassword(usuario.getPassword())) {
                return UsuarioService.search(usuario.getUsername());
            } else {
                throw new Exception("Error: Datos Erroneos!");
            }
        } else {
            throw new Exception("Error: Datos Erroneos!");
        }
    }

    @GetMapping("/filtroUser/{busqueda}/{rol}")
    public ResponseEntity<List<Usuario>> filtroUser(@PathVariable String busqueda, @PathVariable long rol) {
        busqueda = busqueda.trim();
        if (busqueda.equalsIgnoreCase("NA")) {
            busqueda = "";
        }
        if (rol > 0) {
            return new ResponseEntity<>(serviceIpmpl.filtroUser(busqueda, rol), HttpStatus.OK);

        } else {

            return new ResponseEntity<>(serviceIpmpl.filtroUserSR(busqueda), HttpStatus.OK);

        }
    }

    @GetMapping("/userXrol/{rol}")
    public ResponseEntity<List<Usuario>> userXrol(@PathVariable long rol) {

        return new ResponseEntity<>(serviceIpmpl.userXrol(rol), HttpStatus.OK);
    }

    @GetMapping("/filtroUserSR/{busqueda}")
    public ResponseEntity<List<Usuario>> filtroUserSR(@PathVariable String busqueda) {
        busqueda = busqueda.trim();
        if (busqueda.equalsIgnoreCase("NA")) {
            busqueda = "";
        }
        return new ResponseEntity<>(serviceIpmpl.filtroUserSR(busqueda), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Usuario>> getUsuariosList() {
        try {
            return new ResponseEntity<>(UsuarioService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario obj) {
        Usuario user = UsuarioService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                user.setUsername(obj.getUsername());
                user.setPassword(obj.getPassword());
                user.setRol(obj.getRol());
                user.setPersona(obj.getPersona());
                user.setFechaRegistro(obj.getFechaRegistro());

                return new ResponseEntity<>(UsuarioService.save(user), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

//    @PutMapping("/delete/{usuarioId}")
//    public ResponseEntity<?> eliminar(@PathVariable Long id) {
//        Usuario usuario = UsuarioService.findById(id);
//        if (usuario == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            try {
//                UsuarioService.delete(id);
//                return new ResponseEntity<>(UsuarioService.save(usuario), HttpStatus.CREATED);
//            } catch (Exception e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<Usuario> delete2(@PathVariable Long id) {
        UsuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{username}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return UsuarioService.findById(id);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) throws Exception {
        return UserRepository.save(usuario);
    }

    @GetMapping("/exists-username/{username}")
    public ResponseEntity<Boolean> checkIfUsernameExists(@PathVariable String username) {
        boolean exists = UserRepository.existsByUsername(username);
        return ResponseEntity.ok(exists);
    }

//    @PostMapping("/signup")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
//        if (!UserRepository.existsByUsername(usuario.getUsername())) {
//            return ResponseEntity.ok(UserRepository.save(usuario));
//        } else {
//            return ResponseEntity.badRequest().body("USERNAME_REPETIDO");
//        }
//    }


}
