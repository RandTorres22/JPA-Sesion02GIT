package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println("===JPA CRUD===");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01x");
		EntityManager em = fabrica.createEntityManager();
		
		Query query = em.createNativeQuery("{call usp_validaAcceso(?,?)}", TbUsuario.class);
		query.setParameter(1, "U001@gmail.com");
		query.setParameter(2, "10001");
		TbUsuario u =(TbUsuario) query.getSingleResult();
		if(u == null){
			System.out.println("Usuario no existe ");
		}else{
			System.out.println("Bienvenido " + u.getNomUsua() + " "+u.getApeUsua());
			System.out.println("Tus datos son: " + u);
		}
		System.out.println("---------------------------------");
		
		
	}
		
		
		
		
		/*Query query = em.createNativeQuery("{call findAll_usuarios()}", TbUsuario.class);
		
		
		List<TbUsuario> lstUsuarios = query.getResultList();
		System.out.println("==================================================================================");
		
		//Mostrar cantidad de usuarios
		System.out.println("Nro de Usuarios:" + lstUsuarios.size());*/
		
	}


