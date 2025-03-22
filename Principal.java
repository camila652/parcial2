//una banco requiere un sistema que le permita registrar, actualizar,vender  y  eliminar créditos de los usuarios 
//por los cuales requiere que el departamento de ti el apoye con este tema
//para vender créditos se deben tener en cuenta lo siguiente:
//1)	que el usuario ya este registrado en caso que No. que no muestre la opción de registrar, sino que muestre la opción del ingreso de registros es decir un enlace directo
//2)	al vender o solicitar crédito se debe validar el tipo de crédito si no son iguales debe hacerse otro crédito diferente//

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco();
        int opcion;

        do {
            String menu = "1. Registrar Usuario\n" +
                          "2. Actualizar Usuario\n" +
                          "3. Vender Crédito\n" +
                          "4. Eliminar crédito\n" +
                          "5. Mostrar Usuarios\n" +
                          "0. Salir\n" +
                          "Seleccione una opción:";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
                    String cedula = JOptionPane.showInputDialog("Ingrese la cédula:");
                    String tipoCredito = JOptionPane.showInputDialog("Ingrese el tipo de crédito:");
                    double montoCredito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del crédito:"));

                    banco.registrarUsuario(nombre, apellido, cedula, tipoCredito, montoCredito);
                    break;

                case 2:
                    String idActualizar = JOptionPane.showInputDialog("Ingrese la cédula del usuario:");
                    String nuevoCredito = JOptionPane.showInputDialog("Ingrese el nuevo tipo de crédito:");
                    double nuevoMonto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo monto del crédito:"));

                    banco.actualizarUsuario(idActualizar, nuevoCredito, nuevoMonto);
                    break;

                case 3:
                    String idCredito = JOptionPane.showInputDialog("Ingrese la cédula del usuario:");
                    String tipoCreditoVenta = JOptionPane.showInputDialog("Ingrese el tipo de crédito a vender:");
                    double montoVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del crédito:"));

                    banco.venderCredito(idCredito, tipoCreditoVenta, montoVenta);
                    break;

                case 4:
                    String idEliminar = JOptionPane.showInputDialog("Ingrese la cédula del usuario:");
                    banco.eliminarUsuario(idEliminar);
                    break;

                case 5:
                    banco.mostrarUsuarios();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 0);
    }
}

