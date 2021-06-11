package com.github.firulapp.exceptions;

import com.github.firulapp.dto.PetDto;

import java.util.function.Supplier;

public class PetException extends BusinessException implements Supplier<PetException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "pet.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String USER_PETS_NOT_FOUND = BASE_ERROR + ".user.pet.list.notFound";
    public static final String SAVE_FAILED = BASE_ERROR + ".mapping.failed";
    public static final String DELETE_FAILED = BASE_ERROR + ".sql.delete.failed";
    public static final String ADOPTION_ERROR = BASE_ERROR + ".adoption.request.failed";
    public static final String FOSTER_ERROR = BASE_ERROR +  ".foster.request.failed";

    public PetException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Pet Not Found Exception
     *
     * @param id Pet Id
     * @return PetException
     */
    public static PetException notFound(Long id) {
        return new PetException(NOT_FOUND, "Mascota con id " + id + " no encontrado");
    }

    public static PetException userPetsNotFound(Long userId) {
        return new PetException(USER_PETS_NOT_FOUND, "Mascotas de usuario con id " + userId + " no encontrado");
    }

    public static PetException saveException(){
        return new PetException(SAVE_FAILED, "Error en mapping de datos de mascota");
    }

    public static PetException deleteFailed(PetDto petDto){
        return new PetException(DELETE_FAILED, "No se pudo eliminar el registro de la mascota " + petDto.toString());
    }

    public static PetException notFound() {
        return new PetException(NOT_FOUND, "No se encontraron registros con los parámetros requeridos");
    }

    public static PetException adoptionError(Long requesterId, Long petId, Long userId) {
        return new PetException(ADOPTION_ERROR, "No se pudo realizar la solicitud de adopcion del usuario con id " +
                                                requesterId + " para la mascota con id " + petId +
                                                " con userId " + userId);
    }
    public static PetException fosterError(Long requesterId, Long petId, Long userId) {
        return new PetException(FOSTER_ERROR, "No se pudo realizar la solicitud de apadrinamiento del usuario con id " +
                requesterId + " para la mascota con id " + petId +
                " con userId " + userId);
    }

    public static PetException fosterError(Long requesterId, Long petId) {
        return new PetException(FOSTER_ERROR, "No se pudo realizar la solicitud de apadrinamiento del usuario con id " +
                requesterId + " para la mascota con id " + petId);
    }
    public static PetException adoptionError(String adopterUsername, Long petId) {
        return new PetException(ADOPTION_ERROR, "No se pudo realizar la solicitud de adopcion de la mascota con id "
                + petId + " con el usuario " + adopterUsername);
    }

    @Override
    public PetException get() {
        return null;
    }
}
