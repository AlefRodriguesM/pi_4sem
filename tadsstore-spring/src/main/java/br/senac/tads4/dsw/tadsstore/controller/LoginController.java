/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Andrey
 */
@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView mostrarTelaLogin() {
    return new ModelAndView("login");
  }

}
