package Controlador;

import ControllerJPA.ClienteJpaController;
import ControllerJPA.ComunaJpaController;
import ControllerJPA.LocalComidaJpaController;

import Model.Cliente;
import Model.Comuna;
import Model.LocalComida;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author KevinRoss
 */
@Controller
@RequestMapping("/reglocal.htm")
public class RegistrarLocalControlador {

    @RequestMapping(method = RequestMethod.GET)
    public String otroMetodo(Model model) {
        List<Comuna> comunas = null;

        ComunaJpaController comunasdb = new ComunaJpaController();

        comunas = comunasdb.findComunaEntities();

        model.addAttribute("comunas", comunas);

        List<Cliente> clientes = null;

        ClienteJpaController clientesdb = new ClienteJpaController();
        clientes = clientesdb.findClienteEntities();

        model.addAttribute("clientes", clientes);

        return "registrarLocal";
    }

    public String recibir(@RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("rut") String rut,
            @RequestParam("direccion") String direccion,
            @RequestParam("telefono") String telefono,
            @RequestParam("correo") String correo,
            Model model) {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

            LocalComida l = new LocalComida();
            l.setNombre(nombre);
            l.setDescripcion(nombre);
            l.setRut(nombre);
            l.setDescripcion(nombre);
            l.setTelefono(nombre);
            l.setCorreo(nombre);

            LocalComidaJpaController localcomii = new LocalComidaJpaController();

            localcomii.create(l);

            model.addAttribute("cliente", l);
            return "registroCompleto"; //nombre de la vista 
        }

    }

    //siempre los metodos deben retornar un string en los controladores
    @RequestMapping(value = "/ver_local.htm", method = RequestMethod.POST)
    public String recibir(@RequestParam("nombre") String nombre, @RequestParam("rut") String rut, @RequestParam("direccion") String direccion, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo, Model model) {

        List<Comuna> comunas = null;

        ComunaJpaController comunasdb = new ComunaJpaController();
        comunas = comunasdb.findComunaEntities();

        model.addAttribute("comunas", comunas);
        return "registroCompleto"; //nombre de la vista       
    }

}
