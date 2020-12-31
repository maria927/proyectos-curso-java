package co.com.udem.main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.udem.dto.Empleado;
import co.com.udem.dto.Empresa;

public class Main {

	public static void main(String[] args) {
		
		 
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        Empresa empresa = (Empresa) factory.getBean("empresa");
        System.out.println("******Empresa******");
        System.out.println("Nombre: " + empresa.getNombre());
        System.out.println("Nit: " + empresa.getNit());
        System.out.println("Dirección: " + empresa.getDireccion());
        System.out.println("Teléfono: " + empresa.getTelefono());
        System.out.println("*****Empleado******");
        System.out.println("Nombres y apellidos: " +empresa.getEmpleado().getNombre() +" "+ empresa.getEmpleado().getApellido());
        System.out.println("Salario: " + empresa.getEmpleado().getSalario());
        System.out.println("Departamento: " + empresa.getEmpleado().getDepartamento());

	}

}
