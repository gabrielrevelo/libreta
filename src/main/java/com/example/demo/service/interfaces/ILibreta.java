package com.example.demo.service.interfaces;

import com.example.demo.domain.Contacto;
import java.util.List;

public interface ILibreta {

    public List<Contacto> getList();

    public Contacto createContacto(Contacto contacto);

    Contacto updateContacto(Integer id, Contacto contacto);

    Contacto deleteContacto(Integer id);

}
