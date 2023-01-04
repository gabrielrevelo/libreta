package com.example.demo.service;

import com.example.demo.domain.Contacto;
import com.example.demo.domain.Telefono;
import com.example.demo.repository.ContactoRepository;
import com.example.demo.repository.TelefonoRepository;
import com.example.demo.service.interfaces.ILibreta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.List;

@Service
public class LibretaService implements ILibreta {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getList() {
        return contactoRepository.findAll();
    }


    @Override
    @Transactional
    public Contacto createContacto(Contacto contacto) {
        contacto.setFechaCreacion(Instant.now());
        return contactoRepository.save(contacto);
    }

    @Override
    @Transactional
    public Contacto deleteContacto(Integer id) {
        var contacto = contactoRepository.findById(id);
        if (contacto.isPresent()) {
            contactoRepository.delete(contacto.get());
            return contacto.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Contacto updateContacto(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setFechaActualizacion(Instant.now());
        return contactoRepository.save(contacto);
    }
    @Override
    @Transactional
    public Telefono createTelefono(Telefono telefono) {
        telefono.setFechaCreacion(Instant.now());
        return telefonoRepository.save(telefono);
    }

    @Override
    @Transactional
    public Telefono updateTelefono(Integer id, Telefono telefono){
        telefono.setId(id);
        telefono.setFechaActualizacion(Instant.now());
        return telefonoRepository.save(telefono);
    }

    @Override
    @Transactional
    public Telefono deleteTelefono(Integer id) {
        var telefono = telefonoRepository.findById(id);
        if (telefono.isPresent()) {
            telefonoRepository.delete(telefono.get());
            return telefono.get();
        } else {
            return null;
        }
    }
}
