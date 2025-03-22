import java.util.Stack;
import javax.swing.JOptionPane;

public class Banco {
    private Stack<Usuario> pilaUsuarios;

    public Banco() {
        this.pilaUsuarios = new Stack<>();
    }

    // Registrar un usuario nuevo (si no existe)
    public void registrarUsuario(String nombre, String apellido, String cedula, String tipoCredito, double montoCredito) {
        if (buscarUsuario(cedula) != null) {
            JOptionPane.showMessageDialog(null, "El usuario ya está registrado.");
            return;
        }
        pilaUsuarios.push(new Usuario(nombre, apellido, cedula, tipoCredito, montoCredito));
        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
    }

    // Buscar usuario por cédula
    public Usuario buscarUsuario(String cedula) {
        for (Usuario u : pilaUsuarios) {
            if (u.getCedula().equals(cedula)) {
                return u;
            }
        }
        return null;
    }

    // Actualizar datos de un usuario
    public void actualizarUsuario(String cedula, String nuevoTipoCredito, double nuevoMonto) {
        Stack<Usuario> tempStack = new Stack<>();
        boolean encontrado = false;

        while (!pilaUsuarios.isEmpty()) {
            Usuario usuario = pilaUsuarios.pop();
            if (usuario.getCedula().equals(cedula)) {
                usuario.setTipoCredito(nuevoTipoCredito);
                usuario.setMontoCredito(nuevoMonto);
                encontrado = true;
            }
            tempStack.push(usuario);
        }

        while (!tempStack.isEmpty()) {
            pilaUsuarios.push(tempStack.pop());
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }
    }

    // Vender crédito a un usuario registrado
    public void venderCredito(String cedula, String tipoCredito, double monto) {
        Stack<Usuario> tempStack = new Stack<>();
        boolean encontrado = false;

        while (!pilaUsuarios.isEmpty()) {
            Usuario usuario = pilaUsuarios.pop();
            if (usuario.getCedula().equals(cedula)) {
                if (usuario.getTipoCredito().equalsIgnoreCase(tipoCredito)) {
                    usuario.setMontoCredito(usuario.getMontoCredito() + monto);
                    JOptionPane.showMessageDialog(null, "Crédito aprobado. Nuevo saldo: $" + usuario.getMontoCredito());
                } else {
                    JOptionPane.showMessageDialog(null, "El tipo de crédito no coincide. Debe crear un nuevo crédito.");
                }
                encontrado = true;
            }
            tempStack.push(usuario);
        }

        while (!tempStack.isEmpty()) {
            pilaUsuarios.push(tempStack.pop());
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Usuario no registrado. Regístrese primero.");
        }
    }

    // Eliminar un usuario
    public void eliminarUsuario(String cedula) {
        Stack<Usuario> tempStack = new Stack<>();
        boolean eliminado = false;

        while (!pilaUsuarios.isEmpty()) {
            Usuario usuario = pilaUsuarios.pop();
            if (usuario.getCedula().equals(cedula)) {
                eliminado = true;
            } else {
                tempStack.push(usuario);
            }
        }

        while (!tempStack.isEmpty()) {
            pilaUsuarios.push(tempStack.pop());
        }

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }
    }

    // Mostrar todos los usuarios registrados
    public void mostrarUsuarios() {
        if (pilaUsuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
        } else {
            StringBuilder listaUsuarios = new StringBuilder("Usuarios Registrados:\n");
            for (Usuario u : pilaUsuarios) {
                listaUsuarios.append(u.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, listaUsuarios.toString());
        }
    }

    }