package br.gov.caixa.pedes.sistemas.sigde.resources;

import br.gov.caixa.pedes.sistemas.sigde.domain.Categoria;
import br.gov.caixa.pedes.sistemas.sigde.dto.CategoriaDTO;
import br.gov.caixa.pedes.sistemas.sigde.dto.EmailDTO;
import br.gov.caixa.pedes.sistemas.sigde.security.JWTUtil;
import br.gov.caixa.pedes.sistemas.sigde.security.UserSS;
import br.gov.caixa.pedes.sistemas.sigde.services.AuthService;
import br.gov.caixa.pedes.sistemas.sigde.services.CategoriaService;
import br.gov.caixa.pedes.sistemas.sigde.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDTO) {
        service.sendNewPassword(objDTO.getEmail());
        return ResponseEntity.noContent().build();
    }


}
