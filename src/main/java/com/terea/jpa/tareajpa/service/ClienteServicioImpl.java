package com.terea.jpa.tareajpa.service;

import java.util.List;

import com.terea.jpa.tareajpa.entity.Cliente;
import com.terea.jpa.tareajpa.repositorie.ClienteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl implements ClienteServicio {
    @Autowired
    private ClienteRepositorio repositorio;

    @Override
    public List<Cliente> listarTodosLosClientes() {
        return repositorio.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        // TODO Auto-generated method stub

    }

}
