package com.cristian.restaurantegarcia.aspect;

import com.cristian.restaurantegarcia.entity.Auditoria;
import com.cristian.restaurantegarcia.repository.AuditoriaRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditoriaAspect {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void auditarCreacion(JoinPoint joinPoint) {
        guardarAuditoria("CREAR", joinPoint);
    }

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void auditarActualizacion(JoinPoint joinPoint) {
        guardarAuditoria("ACTUALIZAR", joinPoint);
    }

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void auditarEliminacion(JoinPoint joinPoint) {
        guardarAuditoria("ELIMINAR", joinPoint);
    }

    private void guardarAuditoria(String accion, JoinPoint joinPoint) {
        String entidad = joinPoint.getSignature().getDeclaringTypeName();
        String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        Auditoria auditoria = new Auditoria();
        auditoria.setAccion(accion);
        auditoria.setEntidad(entidad);
        auditoria.setUsuario(usuario);
        auditoria.setFecha(LocalDateTime.now());
        auditoriaRepository.save(auditoria);
    }
}