package com.cristian.restaurantegarcia.aspect;

import com.cristian.restaurantegarcia.service.BitacoraService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Aspect
@Component
public class BitacoraAspect {

    @Autowired
    private BitacoraService bitacoraService;
    @AfterReturning("execution(* com.cristian.restaurantegarcia.service.*.guardar(..)) || " +
            "execution(* com.cristian.restaurantegarcia.service.*.eliminar(..)) || " +
            "execution(* com.cristian.restaurantegarcia.service.*.actualizar(..))")
    public void registrarAccion(JoinPoint joinPoint) {
        try {
            String metodo = joinPoint.getSignature().getName();
            String clase = joinPoint.getTarget().getClass().getSimpleName();

            String accion;
            if (metodo.contains("guardar")) accion = "Guardar";
            else if (metodo.contains("eliminar")) accion = "Eliminar";
            else if (metodo.contains("actualizar")) accion = "Actualizar";
            else accion = "Acción";
            String usuario = "Sistema"; // valor por defecto
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof Principal) {
                    usuario = ((Principal) arg).getName();
                    break;
                }
            }

            String detalle = "Método: " + metodo + " - Clase: " + clase;
            bitacoraService.registrar(accion, clase, usuario, detalle);
        } catch (Exception e) {
            System.err.println("Error al registrar en bitácora: " + e.getMessage());
        }
    }
}
