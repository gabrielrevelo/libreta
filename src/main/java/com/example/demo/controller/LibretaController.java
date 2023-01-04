package com.example.demo.controller;

import com.example.demo.domain.Contacto;
import com.example.demo.domain.Telefono;
import com.example.demo.service.LibretaService;
import com.example.demo.utility.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
public class LibretaController {

    @Autowired
    private LibretaService libretaService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(path = "/")
    public ResponseEntity<String> home(HttpServletResponse httpResponse) {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping(path = "/listar_contactos")
    public ResponseEntity<Response> listarContactos() {
        response.restart();
        response.data = libretaService.getList();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @PostMapping(path = "/crear_contacto")
    public ResponseEntity<Response> crearContacto(@RequestBody Contacto contacto) {
        response.restart();
        log.info("Contacto a crear: {}", contacto);
        response.data = libretaService.createContacto(contacto);
        httpStatus = HttpStatus.CREATED;
        return new ResponseEntity(response, httpStatus);
    }

    @PutMapping(path = "/actualizar_contacto/{id}")
    public ResponseEntity<Response> actualizarContacto(
            @RequestBody Contacto contacto,
            @PathVariable(value="id") Integer id
    ) {
        response.restart();
        response.data = libretaService.updateContacto(id, contacto);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @DeleteMapping(path = "/borrar_contacto/{id}")
    public ResponseEntity<Response> borrarContacto(@PathVariable(value="id") Integer id) {
        response.restart();
        log.info("Id", id);
        response.data = libretaService.deleteContacto(id);
        if (response.data == null) {
            response.message = "El contacto no existe";
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            response.message = "El contacto fue removido exitosamente";
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity(response, httpStatus);
    }

    @PostMapping(path = "/crear_telfono")
    public ResponseEntity<Response> crearTelefono(@RequestBody Telefono telefono) {
        response.restart();
        log.info("Telefono a crear: {}", telefono);
        response.data = libretaService.createTelefono(telefono);
        httpStatus = HttpStatus.CREATED;
        return new ResponseEntity(response, httpStatus);
    }


    @PutMapping(path = "/actualizar_telefono/{id}")
    public ResponseEntity<Response> actualizarTelefono(
            @RequestBody Telefono telefono,
            @PathVariable(value="id") Integer id
    ) {
        response.restart();
        response.data = libretaService.updateTelefono(id, telefono);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @DeleteMapping(path = "/borrar_telefono/{id}")
    public ResponseEntity<Response> borrarTelefono(@PathVariable(value="id") Integer id) {
        response.restart();
        log.info("Id", id);
        response.data = libretaService.deleteTelefono(id);
        if (response.data == null) {
            response.message = "El telefono no existe";
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            response.message = "El telefono fue removido exitosamente";
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity(response, httpStatus);
    }

}
