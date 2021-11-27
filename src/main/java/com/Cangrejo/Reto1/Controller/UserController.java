/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cangrejo.Reto1.Controller;

import com.Cangrejo.Reto1.Model.User;
import com.Cangrejo.Reto1.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesartbossa
 */
/*
*Anotaciones springboot para generar el controlador, 
*el mapeo y evitar los errores de tipo cross
*/
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
/*
*Clase publica del controlador
*/
public class UserController {
    /*
    *Anotacion Sprinboot para implementar e instanciar
    */
    @Autowired
    private UserService userService;
    /*
    *Anotacion Sprinboot para el mapeo de tipo GET
    */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /*
    *Anotacion Sprinboot para el mapeo de tipo POST
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    /*
    *Anotacion Sprinboot para el mapeo de tipo GET
    */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    /*
    *Anotacion Sprinboot para el mapeo de tipo GET
    */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    } 
}
