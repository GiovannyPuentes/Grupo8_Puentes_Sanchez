package com.techsolutions.empresa;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // Lista para almacenar todos los empleados
    static ArrayList<Empleado> empleados = new ArrayList<>();

    // Scanner para leer datos del usuario
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║          BIENVENIDO A TECHSOLUTIONS             ║");
        System.out.println("║        Sistema de Gestión de Empleados           ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("\nSelecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarIngeniero();
                    break;
                case 2:
                    registrarContador();
                    break;
                case 3:
                    registrarVendedor();
                    break;
                case 4:
                    mostrarTodosEmpleados();
                    break;
                case 5:
                    buscarEmpleado();
                    break;
                case 6:
                    System.out.println("\n¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("❌ Opción inválida");
            }
        }

        sc.close();
    }

    // Mostrar menú
    static void mostrarMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│            MENÚ PRINCIPAL           │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1) Registrar Ingeniero              │");
        System.out.println("│ 2) Registrar Contador               │");
        System.out.println("│ 3) Registrar Vendedor               │");
        System.out.println("│ 4) Mostrar Todos los Empleados      │");
        System.out.println("│ 5) Buscar Empleado por ID           │");
        System.out.println("│ 6) Salir                            │");
        System.out.println("└─────────────────────────────────────┘");
    }

    // Registrar Ingeniero
    static void registrarIngeniero() {
        System.out.println("\n════════════════════════════════════");
        System.out.println("📝 REGISTRAR NUEVO INGENIERO");
        System.out.println("════════════════════════════════════");

        System.out.print("ID del empleado: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Salario base: $");
        double salario = sc.nextDouble();
        sc.nextLine(); // Limpiar buffer

        System.out.print("Especialidad (ej: Programación, DevOps): ");
        String especialidad = sc.nextLine();

        System.out.print("Años de experiencia: ");
        int experiencia = sc.nextInt();
        sc.nextLine();

        System.out.print("Lenguajes principales (ej: Java, Python, C++): ");
        String lenguajes = sc.nextLine();

        // Crear el ingeniero usando el constructor
        Ingeniero ing = new Ingeniero(id, nombre, salario, especialidad, experiencia, lenguajes);

        // Agregar a la lista
        empleados.add(ing);

        System.out.println("\n✅ Ingeniero registrado exitosamente");
    }

    // Registrar Contador
    static void registrarContador() {
        System.out.println("\n════════════════════════════════════");
        System.out.println("📝 REGISTRAR NUEVO CONTADOR");
        System.out.println("════════════════════════════════════");

        System.out.print("ID del empleado: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Salario base: $");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Cantidad de clientes a cargo: ");
        int clientes = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo de certificación (ej: CPA, Contador Público): ");
        String certificacion = sc.nextLine();

        System.out.print("Auditorías realizadas: ");
        int auditorias = sc.nextInt();
        sc.nextLine();

        // Crear el contador
        Contador contador = new Contador(id, nombre, salario, clientes, certificacion, auditorias);

        // Agregar a la lista
        empleados.add(contador);

        System.out.println("\n✅ Contador registrado exitosamente");
    }

    // Registrar Vendedor
    static void registrarVendedor() {
        System.out.println("\n════════════════════════════════════");
        System.out.println("📝 REGISTRAR NUEVO VENDEDOR");
        System.out.println("════════════════════════════════════");

        System.out.print("ID del empleado: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Salario base: $");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Zona de ventas (ej: Centro, Sur, Norte): ");
        String zona = sc.nextLine();

        System.out.print("Porcentaje de comisión (%): ");
        double comision = sc.nextDouble();
        sc.nextLine();

        System.out.print("Meta mensual: $");
        double meta = sc.nextDouble();
        sc.nextLine();

        // Crear el vendedor
        Vendedor vendedor = new Vendedor(id, nombre, salario, zona, comision, meta);

        // Agregar a la lista
        empleados.add(vendedor);

        System.out.println("\n✅ Vendedor registrado exitosamente");
    }

    // Mostrar todos los empleados
    static void mostrarTodosEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("\n❌ No hay empleados registrados");
            return;
        }

        System.out.println("\n════════════════════════════════════");
        System.out.println("📋 LISTADO DE TODOS LOS EMPLEADOS");
        System.out.println("════════════════════════════════════");

        for (int i = 0; i < empleados.size(); i++) {
            System.out.println("\n[Empleado " + (i + 1) + "]");
            empleados.get(i).mostrarInfo();
        }
    }

    // Buscar empleado por ID
    static void buscarEmpleado() {
        System.out.print("\nIngresa el ID del empleado a buscar: ");
        String idBuscado = sc.nextLine();

        boolean encontrado = false;

        for (Empleado emp : empleados) {
            if (emp.getId().equals(idBuscado)) {
                System.out.println();
                emp.mostrarInfo();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n❌ Empleado con ID '" + idBuscado + "' no encontrado");
        }
    }
}

