package com.terea.jpa.tareajpa.controller;

import com.terea.jpa.tareajpa.entity.Cliente;
import com.terea.jpa.tareajpa.service.ClienteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    @GetMapping({ "/clientes", "/" })
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", servicio.listarTodosLosClientes());
        return "clientes"; // nos retorna al archivo clientes
    }

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeRegistrtarCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        servicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cliente", servicio.obtenerClientePorId(id));
        return "editar_cliente";
    }

    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente,
            Model modelo) {
        Cliente clienteExistente = servicio.obtenerClientePorId(id);
        clienteExistente.setId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setEmail(cliente.getEmail());

        servicio.actualizarCliente(clienteExistente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        servicio.eliminarCliente(id);
        return "redirect:/clientes";
    }

}
