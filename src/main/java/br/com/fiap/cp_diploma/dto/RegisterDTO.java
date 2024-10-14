package br.com.fiap.cp_diploma.dto;

import br.com.fiap.cp_diploma.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {}
