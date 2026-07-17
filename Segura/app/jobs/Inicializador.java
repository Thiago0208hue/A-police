package jobs;

import java.util.Date;

import models.Segurado;
import models.Seguro;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {

		if (Segurado.count() != 0) {
			return;
		}

		Segurado s1 = new Segurado();
		s1.nome = "Joao da Silva";
		s1.cpf = "111.111.111-11";
		s1.email = "joaosilva@gmail.com";
		s1.telefone = "(84) 99999-1111";
		s1.save();

		Segurado s2 = new Segurado();
		s2.nome = "Maria Joaquina";
		s2.cpf = "222.222.222-22";
		s2.email = "mj@gmail.com";
		s2.telefone = "(84) 99999-2222";
		s2.save();

		Seguro seguro1 = new Seguro();
		seguro1.placa = "ABC1234";
		seguro1.modelo = "Gol";
		seguro1.dataContratacao = new Date();
		seguro1.segurado = s1;
		seguro1.save();

		Seguro seguro2 = new Seguro();
		seguro2.placa = "XYZ5678";
		seguro2.modelo = "Onix";
		seguro2.dataContratacao = new Date();
		seguro2.segurado = s2;
		seguro2.save();

		System.out.println("Inicializador executado com sucesso!");
	}

}
