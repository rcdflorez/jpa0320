package com.terea.jpa.tareajpa.service;

import java.util.List;

import com.terea.jpa.tareajpa.entity.Cliente;

public interface ClienteServicio {

    public List<Cliente> listarTodosLosClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Cliente cliente);

    public void eliminarCliente(Long id);

}
