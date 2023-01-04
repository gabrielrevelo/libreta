package com.example.demo.service.interfaces;

import com.example.demo.domain.Contacto;
import com.example.demo.domain.Telefono;

import java.util.List;

public interface ILibreta {

    public List<Contacto> getList();

    public Contacto createContacto(Contacto contacto);

    Contacto updateContacto(Integer id, Contacto contacto);

    Contacto deleteContacto(Integer id);
    public Telefono createTelefono(Telefono telefono);
    Telefono updateTelefono(Integer id, Telefono telefono);

    Telefono deleteTelefono(Integer id);
}
