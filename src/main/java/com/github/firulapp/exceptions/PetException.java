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
        return new PetException(NOT_FOUND, String.format("Mascota con id %n no encontrado" , id));
    }

    public static PetException userPetsNotFound(Long userId) {
        return new PetException(USER_PETS_NOT_FOUND, String.format("Mascotas de usuario con id %n no encontrado" , userId));
    }

    public static PetException saveException(){
        return new PetException(SAVE_FAILED, "Error en mapping de datos de mascota");
    }

    public static PetException deleteFailed(PetDto petDto){
        return new PetException(DELETE_FAILED, String.format("No se pudo eliminar el registro de la mascota %o", petDto));
    }

    @Override
    public PetException get() {
        return null;
    }
}
