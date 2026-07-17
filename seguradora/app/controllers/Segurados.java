package controllers;

import java.util.List;

import models.Segurado;
import play.mvc.Controller;

public class Segurados extends Controller {

	public static void form() {
		Segurado s = new Segurado();
		render(s);
	}

	public static void editar(Long id) {
		Segurado s = Segurado.findById(id);
		renderTemplate("Segurados/form.html", s);
	}

	public static void listar() {
		List<Segurado> segurados = Segurado.findAll();
		render(segurados);
	}

	public static void salvar(Segurado segurado) {
		segurado.nome = segurado.nome.toUpperCase();
		segurado.email = segurado.email.toLowerCase();
		segurado.save();
		flash.success("Segurado cadastrado com sucesso!");
		listar();
	}

}