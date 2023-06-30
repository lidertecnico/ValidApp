package unal.todosalau.validapp_validaciondedatos.modelos;

import java.util.regex.Pattern;

public class DataValidator {
/**
 * Valida un nombre.
 * @param name El nombre a validar.
 * @return true si el nombre es válido, false de lo contrario.
 */
public boolean validateName(String name) {
    return name != null && !name.isEmpty() && isString(name);
}

/**
 * Valida una dirección de correo electrónico.
 * @param email La dirección de correo electrónico a validar.
 * @return true si el correo electrónico es válido, false de lo contrario.
 */
public boolean validateEmail(String email) {
    return email != null && !email.isEmpty() && isValidEmailFormat(email);
}

/**
 * Valida un número de teléfono.
 * @param phone El número de teléfono a validar.
 * @return true si el número de teléfono es válido, false de lo contrario.
 */
public boolean validatePhone(String phone) {
    return phone != null && !phone.isEmpty() && isValidPhoneFormat(phone);
}

/**
 * Verifica si una cadena contiene solo letras.
 * @param input La cadena a verificar.
 * @return true si la cadena contiene solo letras, false de lo contrario.
 */
private boolean isString(String input) {
    for (char c : input.toCharArray()) {
        if (!Character.isLetter(c)) {
            return false;
        }
    }
    return true;
}

/**
 * Verifica el formato de una dirección de correo electrónico utilizando lógica personalizada.
 * @param email La dirección de correo electrónico a verificar.
 * @return true si la dirección de correo electrónico tiene un formato válido, false de lo contrario.
 */
private boolean isValidEmailFormat(String email) {
    // Verifica el formato de correo electrónico utilizando lógica personalizada
    int atIndex = email.indexOf('@');
    int dotIndex = email.lastIndexOf('.');
    return atIndex > 0 && dotIndex > atIndex && dotIndex < email.length() - 1;
}

/**
 * Verifica el formato de un número de teléfono utilizando lógica personalizada.
 * @param phone El número de teléfono a verificar.
 * @return true si el número de teléfono tiene un formato válido, false de lo contrario.
 */
private boolean isValidPhoneFormat(String phone) {
    // Verifica el formato de número de teléfono utilizando lógica personalizada
    String digitsOnly = phone.replaceAll("[^0-9]", "");
    return digitsOnly.length() == 10; // Verifica si hay exactamente 10 dígitos
}
}
